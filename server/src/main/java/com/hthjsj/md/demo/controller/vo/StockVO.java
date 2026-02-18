package com.hthjsj.md.demo.controller.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.jfinal.plugin.activerecord.Record;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pengxg
 * @date 2026/2/18 16:00
 */
@NoArgsConstructor
@Data
public class StockVO {
    private Long id;
    @JSONField(name = "prod_id")
    private Long prodId;
    @JSONField(name = "prod_name")
    private String prodName;
    private Integer qty;

    public StockVO(Long id, Long prodId, String prodName, Integer qty) {
        this.id = id;
        this.prodId = prodId;
        this.prodName = prodName;
        this.qty = qty;
    }
}
