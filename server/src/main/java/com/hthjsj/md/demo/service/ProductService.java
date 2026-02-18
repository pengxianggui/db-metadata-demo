package com.hthjsj.md.demo.service;

import com.github.md.analysis.SpringAnalysisManager;
import com.hthjsj.md.demo.controller.vo.ProductVO;
import com.jfinal.plugin.activerecord.Record;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pengxg
 * @date 2026/2/18 14:52
 */
@Service
public class ProductService {

    public List<ProductVO> list(String brand) {
        String sql = "select * from t_product where 1=1 and invalid=false order by name asc";
        List<Record> list = SpringAnalysisManager.me().dbMain().find(sql);
        return list.stream().map(r -> new ProductVO(
                        r.getLong("id"),
                        r.getStr("brand"),
                        r.getStr("name"),
                        r.getBigDecimal("purchase_price"),
                        r.getBigDecimal("selling_price")))
                .collect(Collectors.toList());
    }
}
