package com.hthjsj.md.demo.service;

import com.github.md.analysis.meta.IMetaField;
import com.github.md.web.upload.UploadFileResolve;
import com.github.md.web.upload.UploadService;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

/**
 * @author pengxg
 * @date 2022/4/25 5:18 下午
 */
@Component
public class OssUploadService implements UploadService {
    @Override
    public String upload(IMetaField metaField, File file) {
        return null;
    }

    @Override
    public String upload(File file) {
        return null;
    }

    @Override
    public File getFile(String filePath) {
        return null;
    }

    @Override
    public List<File> getFile(IMetaField metaField, String primaryValue, String fieldValue) {
        return null;
    }

    @Override
    public String getBasePath() {
        return null;
    }

    @Override
    public UploadFileResolve getFileResovler(IMetaField metaField, String fieldValue) {
        return null;
    }
}
