package com.hthjsj.md.demo.controller;

import com.github.md.web.res.Res;
import com.hthjsj.md.demo.controller.vo.ProductVO;
import com.hthjsj.md.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author pengxg
 * @date 2026/2/18 14:44
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public Res<List<ProductVO>> getList(@RequestParam(required = false) String brand) {
        return Res.ok(productService.list(brand));
    }
}
