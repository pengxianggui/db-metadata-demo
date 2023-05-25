package com.hthjsj.md.demo.config;

import com.github.md.web.DbMetaConfigurer;
import com.github.md.web.file.FileRegistry;
import com.github.md.web.user.AuthenticationRegistry;
import com.hthjsj.md.demo.service.MyLoginService;
import com.hthjsj.md.demo.service.MyUserService;
import com.hthjsj.md.demo.service.AliyunOssUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author pengxg
 * @date 2022/4/25 5:16 下午
 */
@Configuration
public class MyDbMetaConfigurer extends DbMetaConfigurer {

    @Autowired
    private AliyunOssUploadService aliyunOssUploadService;
    @Autowired
    private MyUserService userService;
    @Autowired
    private MyLoginService loginService;

    /**
     * 通过重写此方法，你可以向dbmeta注册上传服务，内置的上传服务为local: LocalUploadService
     *
     * @param fileRegistry
     */
    @Override
    public void configFileService(FileRegistry fileRegistry) {
        fileRegistry.config(aliyunOssUploadService.getMode(), aliyunOssUploadService, aliyunOssUploadService);
    }

    /**
     * 通过重写方法，你可以自定义: 用户服务、角色服务、权限服务、登录服务、用户预识别拦截执行器
     * <p>
     * 扩展：权限拦截执行器、资源判定策略
     * <p>
     * 等和用户、认证鉴权相关的内容。<b>同样，相关自定义类也必须实现对应的接口。</b>
     *
     * @param registry
     */
    @Override
    public void configAuthentication(AuthenticationRegistry registry) {
//        registry.setUserService(userService)
//                .setLoginService(loginService); // 更多配置见AuthenticationRegistry中的配置项
    }
}
