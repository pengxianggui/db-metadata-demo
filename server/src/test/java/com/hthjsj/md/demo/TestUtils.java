package com.hthjsj.md.demo;

import com.alibaba.fastjson.JSONObject;
import com.github.md.analysis.SpringAnalysisManager;
import com.jfinal.plugin.activerecord.Record;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.StringEscapeUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author pengxg
 * @date 2022/10/9 5:15 下午
 */
@Slf4j
public class TestUtils {

    @Test
    public void test() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key1", "1");
        jsonObject.put("key2", 2);

        JSONObject value3 = new JSONObject();
        value3.put("key3-1", new Date());
        value3.put("key3-2", "jlsjdljs");

        JSONObject value33 = new JSONObject();
        value33.put("key3-3-1", "hello world");
        value3.put("key3-2", value33);
        jsonObject.put("key3", value3);

        log.info("json: {}", jsonObject.toJSONString());
        log.info("json: {}", jsonObject);

        log.info("json: {}", StringEscapeUtils.escapeJson(jsonObject.toJSONString()));
        log.info("json: {}", jsonObject.toString());
    }

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
