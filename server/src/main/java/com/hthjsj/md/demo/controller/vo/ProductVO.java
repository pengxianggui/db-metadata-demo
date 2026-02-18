package com.hthjsj.md.demo.controller.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author pengxg
 * @date 2026/2/18 14:53
 */
@NoArgsConstructor
@Data
public class ProductVO {
    private Long id;
    private String brand;
    private String name;
    @JSONField(name = "purchase_price")
    private BigDecimal purchasePrice;
    @JSONField(name = "selling_price")
    private BigDecimal sellingPrice;

    public ProductVO(Long id, String brand, String name, BigDecimal purchasePrice, BigDecimal sellingPrice) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
    }
}
