package com.hthjsj.md.demo.pointcut;

import com.github.md.analysis.SpringAnalysisManager;
import com.github.md.analysis.meta.MetaData;
import com.github.md.analysis.meta.aop.AddPointCut;
import com.github.md.analysis.meta.aop.FormInvocation;
import com.github.md.analysis.meta.aop.UpdatePointCut;
import com.jfinal.plugin.activerecord.Record;

import java.math.BigDecimal;

/**
 * 出入库记录
 * @author pengxg
 * @date 2024/8/5 21:37
 */
public class FinanceLogPointCut implements AddPointCut, UpdatePointCut {
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

}
