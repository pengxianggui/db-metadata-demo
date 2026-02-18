package com.hthjsj.md.demo.controller;

import com.github.md.web.res.Res;
import com.hthjsj.md.demo.controller.vo.StockVO;
import com.hthjsj.md.demo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author pengxg
 * @date 2026/2/18 15:59
 */
@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("list")
    public Res<List<StockVO>> getStockList() {
        return Res.ok(stockService.getList());
    }
}
