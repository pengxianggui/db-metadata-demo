package com.hthjsj.md.demo.pointcut;

import com.github.md.analysis.AnalysisSpringUtil;
import com.github.md.analysis.meta.aop.*;
import com.github.md.web.controller.TableQueryInvocation;
import com.hthjsj.md.demo.service.AliyunOssUploadService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author pengxg
 * @date 2022/7/28 10:20 上午
 */
@Slf4j
public class EmployeePointCut implements TableQueryPointCut, DeletePointCut, AddPointCut, UpdatePointCut, ViewPointCut {

    private final AliyunOssUploadService aliyunOssUploadService = AnalysisSpringUtil.getBean(AliyunOssUploadService.class);

    @Override
    public boolean addBefore(FormInvocation invocation) {
        return true;
    }

    @Override
    public boolean addAfter(FormInvocation invocation) {
        return true;
    }

    @Override
    public boolean deleteBefore(DeleteInvocation invocation) {
        return true;
    }

    @Override
    public boolean deleteAfter(DeleteInvocation invocation) {
        return true;
    }

    @Override
    public boolean queryBefore(QueryInvocation queryInvocation) {
        log.info("这里可以做一些前置操作");
        return true;
    }

    @Override
    public boolean queryAfter(QueryInvocation queryInvocation) {
        log.info("这里可以对列表查询结果进行干预, page: {}", ((TableQueryInvocation) queryInvocation).getData());
        return true;
    }

    @Override
    public boolean updateBefore(FormInvocation invocation) {
        return true;
    }

    @Override
    public boolean updateAfter(FormInvocation invocation) {
        return true;
    }

    @Override
    public boolean viewBefore(AopInvocation invocation) {
        return true;
    }

    @Override
    public boolean viewAfter(AopInvocation invocation) {
        return true;
    }
}
