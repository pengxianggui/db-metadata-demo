package com.hthjsj.md.demo.controller;

import com.github.md.analysis.kit.Ret;
import com.google.common.collect.Lists;
import com.jfinal.kit.Kv;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author pengxg
 * @date 2022/5/11 3:26 下午
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @GetMapping("options")
    public Ret departmentOptions() {
        List<Map> options = Lists.newArrayList();
        Map option1 = Kv.by("key", "产品研发部").set("value", "1");
        Map option2 = Kv.by("key", "项目履约部").set("value", "2");
        Map option3 = Kv.by("key", "综合管理部").set("value", "3");
        options.add(option1);
        options.add(option2);
        options.add(option3);
        return Ret.ok("data", options);
    }
}
