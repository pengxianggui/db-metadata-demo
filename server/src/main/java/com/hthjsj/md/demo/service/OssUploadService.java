package com.hthjsj.md.demo.service;

import com.github.md.web.file.DownloadService;
import com.github.md.web.file.UploadService;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author pengxg
 * @date 2022/4/25 5:18 下午
 */
@Component
public class OssUploadService implements UploadService, DownloadService {

    @Override
    public String upload(MultipartFile file, String... splitMarkers) {
        throw new RuntimeException("未实现！");
    }

    @Override
    public File getFile(String filePath) {
        throw new RuntimeException("未实现！");
    }
}
