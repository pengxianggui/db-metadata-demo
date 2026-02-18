package com.hthjsj.md.demo.pointcut;

import com.github.md.analysis.AnalysisSpringUtil;
import com.github.md.analysis.SpringAnalysisManager;
import com.github.md.analysis.meta.MetaData;
import com.github.md.analysis.meta.aop.*;
import com.github.md.web.controller.TableQueryInvocation;
import com.hthjsj.md.demo.service.StockLogService;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

import java.math.BigDecimal;

/**
 * 账务记录
 * @author pengxg
 * @date 2024/8/5 21:37
 */
public class FinanceLogPointCut implements AddPointCut, UpdatePointCut, TableQueryPointCut {
    @Override
    public boolean addBefore(FormInvocation invocation) {
        Long stockLogId = invocation.getFormData().getLong("stock_log_id");
        Record stockLog = SpringAnalysisManager.me().dbMain().findById("t_stock_log", stockLogId);
        BigDecimal purchasePrice = stockLog.getBigDecimal("purchase_price");
        Integer qty = stockLog.getInt("qty");
        BigDecimal totalPurchase = purchasePrice.multiply(new BigDecimal(qty));
        MetaData formData = invocation.getFormData();
        BigDecimal paymentPrice = new BigDecimal(formData.getStr("payment_price"));
        formData.set("profit", (paymentPrice.subtract(totalPurchase)));
        return AddPointCut.super.addBefore(invocation);
    }

    /**
     * 列表查询后干预返回结果。将关联的出入库记录附带进来
     *
     * @param queryInvocation
     */
    @Override
    public boolean queryAfter(QueryInvocation queryInvocation) {
        Page<Record> result = ((TableQueryInvocation) queryInvocation).getData();
        result.getList().forEach(r -> {
            Long stockLogId = r.getLong("stock_log_id");
            Record record = AnalysisSpringUtil.getBean(StockLogService.class).getStockLog(stockLogId);
            r.set("stock_log", record);
        });
        return true;
    }
}
