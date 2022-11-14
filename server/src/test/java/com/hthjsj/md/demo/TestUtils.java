package com.hthjsj.md.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author pengxg
 * @date 2022/10/9 5:15 下午
 */
@Slf4j
public class TestUtils {

    @Test
    public void testReplace() {
        String v = "{'key': 1, \\'key1\\': 2}";
        String v0 = v.replace("\\", "\\\\");
        log.info("{}", v0);
        String v1 = v0.replace("'", "\\'");
        log.info("{}", v1);
    }

    @Test
    public void testEscape() {
        log.info("{}", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
    }
}
