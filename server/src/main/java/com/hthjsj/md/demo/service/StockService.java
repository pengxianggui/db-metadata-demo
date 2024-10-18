package com.hthjsj.md.demo.service;

import cn.hutool.core.lang.Assert;
import com.github.md.analysis.SpringAnalysisManager;
import com.github.md.web.ex.WebException;
import com.github.md.web.user.UserThreadLocal;
import com.jfinal.plugin.activerecord.Record;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author pengxg
 * @date 2024/8/8 21:47
 */
@Slf4j
@Service
public class StockService {

    /**
     * 更新库存， 若为入库同时此仓库无此物料则会初始化库存。若为出库，同时仓库无此物料则会抛出异常。
     * 其他情况会更新库存数量。
     * @param warehouseId
     * @param prodId
     * @param type
     * @param qty
     * @return
     */
    public boolean updateStock(Long warehouseId, Long prodId, String type, Integer qty) {
        Assert.notNull(warehouseId, "请选择仓库");
        Assert.notNull(prodId, "请选择物料");
        Assert.isTrue(qty != null && qty > 0, "出入库数量必须大于0");

        Record stock = getStock(warehouseId, prodId);
        if (stock == null) {
            // 初始化库存
            if ("出库".equals(type)) {
                throw new WebException("此物料在当前仓库中无库存, 请先做入库!");
            }
            stock = new Record();
            stock.set("warehouse_id", warehouseId);
            stock.set("prod_id", prodId);
            stock.set("qty", qty);
            stock.set("created_time", new Date());
            stock.set("created_by", UserThreadLocal.getUser().userId());
            return SpringAnalysisManager.me().dbMain().save("t_stock", stock);
        } else {
            int stockQty = stock.getInt("qty");
            // 更新库存
            if ("出库".equals(type) && stockQty < qty) {
                throw new WebException("此物料库存不足! 当前库存为:%d", stockQty);
            }
            switch (type) {
                case "出库":
                    stockQty -= qty;
                    break;
                case "入库":
                    stockQty += qty;
                    break;
                default:
                    throw new WebException("出入库类型不正确!");
            }
            Assert.isTrue("入库".equals(type), () -> new WebException("此仓库无此物料库存, 请先入库此物料!"));
            stock.set("qty", stockQty);
            stock.set("updated_time", new Date());
            stock.set("updated_by", UserThreadLocal.getUser().userId());
            return SpringAnalysisManager.me().dbMain().update("t_stock", stock);
        }
    }

    public Record getStock(Long warehouseId, Long prodId) {
        return SpringAnalysisManager.me().dbMain().findFirst(
                "select * from t_stock where warehouse_id = ? and prod_id = ?", warehouseId, prodId);
    }

    /**
     * 回滚库存
     * @param stockLogs 需要回滚的库存记录
     * @return 返回成功与否
     */
    public boolean rollback(List<Record> stockLogs) {
        if (CollectionUtils.isEmpty(stockLogs)) {
            log.warn("没有要回滚的库存记录!");
            return true;
        }
        // 按 warehouse_id + prod_id 分组
        Map<String, List<Record>> group = stockLogs.stream()
                .collect(Collectors.groupingBy(log -> log.getLong("warehouse_id") + "_" + log.getLong("prod_id")));
        for (Map.Entry<String, List<Record>> entry : group.entrySet()) {
            String[] arr = entry.getKey().split("_");
            Long warehouseId = Long.parseLong(arr[0]);
            Long prodId = Long.parseLong(arr[1]);
            // 统计总的变动值
            List<Record> itemStockLogs = entry.getValue();
            // 倒序
            itemStockLogs.sort(Comparator.comparing(log -> ((Record) log).getDate("created_time")).reversed());
            Integer totalQty = itemStockLogs.stream().map(log -> {
                Integer qty = log.getInt("qty"); // 始终是正数
                String type = log.getStr("type");
                switch (type) {
                    case "入库":
                        return -qty; // 入库的记录回滚，就是取负值
                    case "出库":
                        return qty; // 出库的记录回滚，就是取正值
                    default:
                        throw new WebException("出入库类型不正确!");
                }
            }).mapToInt(Integer::intValue).sum();

            Record record = getStock(warehouseId, prodId);
            Assert.isTrue(record != null, () -> new WebException("库存无法回滚, 因为在仓库下(id:%s)找不到此物料(id:%s)的库存记录",
                    String.valueOf(warehouseId), String.valueOf(prodId)));
            Long stockId = record.getLong("id");
            int finalQty = record.getInt("qty") + totalQty;
            Assert.isTrue(finalQty >= 0, () -> new WebException("库存(id:%s)无法回滚, 因为回滚后数量将小于0!", String.valueOf(stockId)));
            record.set("qty", finalQty);
            record.set("updated_by", UserThreadLocal.getUser().userId());
            record.set("updated_time", new Date());
            boolean flag = SpringAnalysisManager.me().dbMain().update("t_stock", record);
            Assert.isTrue(flag, () -> new WebException("库存(id:%s)回滚失败!", String.valueOf(stockId)));
        }
        return true;
    }
}
