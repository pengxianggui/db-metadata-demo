package com.hthjsj.md.demo.login;

import com.github.md.web.user.LoginService;
import com.github.md.web.user.LoginVO;
import com.hthjsj.md.demo.user.MyUser;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 不使用dbmeta提供的登录服务时，需要提供一个，必须实现{@link LoginService}
 * @author pengxg
 * @date 2022/4/25 5:21 下午
 */
@Service
public class MyLoginService implements LoginService<MyUser> {
    @Override
    public MyUser getUser(HttpServletRequest request) {
        return null;
    }

    @Override
    public MyUser login(String username, String password) {
        return null;
    }

    @Override
    public LoginVO getInfo(HttpServletRequest request) {
        return null;
    }

    @Override
    public LoginVO setLogged(MyUser user) {
        return null;
    }

    @Override
    public boolean logout(MyUser user) {
        return false;
    }

    @Override
    public boolean logout(HttpServletRequest request) {
        return false;
    }

    @Override
    public Map<String, MyUser> getAllLoggedUsers() {
        return new HashMap<>();
    }

    @Override
    public boolean logged(MyUser user) {
        return false;
    }

    @Override
    public boolean isExpired(MyUser user) {
        return false;
    }
}
