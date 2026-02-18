package com.hthjsj.md.demo.pointcut;

import cn.hutool.core.lang.Assert;
import com.github.md.analysis.AnalysisSpringUtil;
import com.github.md.analysis.meta.aop.*;
import com.github.md.web.ex.WebException;
import com.hthjsj.md.demo.service.StockService;

/**
 * 库存AOP
 * @author pengxg
 * @date 2024/8/5 22:25
 */
public class StockLogPointCut implements AddPointCut, UpdatePointCut, DeletePointCut {
    @Override
    public boolean addAfter(FormInvocation invocation) {
        // 更新库存
        Long warehouseId = invocation.getFormData().getLong("warehouse_id");
        Long prodId = invocation.getFormData().getLong("prod_id");
        String type = invocation.getFormData().getStr("type");
        Integer qty = invocation.getFormData().getInt("qty");
        boolean flag = AnalysisSpringUtil.getBean(StockService.class).updateStock(warehouseId, prodId, type, qty);
        Assert.isTrue(flag, "库存更新失败!");
        return true;
    }

    @Override
    public boolean updateBefore(FormInvocation invocation) {
        throw new WebException("库存记录不允许编辑！如果记录错误，请删除后重新记录");
    }

    @Override
    public boolean deleteBefore(DeleteInvocation invocation) {
        throw new WebException("出入库记录不允许删除，如填写错误，请通过创建相应单据冲销");
//        Object[] ids = invocation.getIds();
//        List<Record> deleteRecords = new ArrayList<>(ids.length);
//        for (Object id : ids) {
//            Record record = ServiceManager.businessService().findDataByIds(invocation.getMetaObject(), id);
//            AssertKit.isTrue(record != null, new WebException("出入库记录(id:%s)不存在，请刷新页面后重试", String.valueOf(id)));
//            deleteRecords.add(record);
//        }
//        boolean flag = AnalysisSpringUtil.getBean(StockService.class).rollback(deleteRecords);
//        Assert.isTrue(flag, "回滚库存失败!");
//        return true;
    }
}
