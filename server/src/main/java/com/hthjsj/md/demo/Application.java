package com.hthjsj.md.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author pengxg
 * @date 2022/4/25 1:35 下午
 */
@SpringBootApplication(scanBasePackages = {"com.github.md.*", "com.hthjsj.md.demo"}) // 非常重要, 将com.github.md.*添加扫描包, 目前是有必要的，dbmeta暂时没有提供starter
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
