package com.hthjsj.md.demo.user;

import com.github.md.web.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 不使用dbmeta提供的用户服务时，需要提供一个，必须实现{@link UserService}
 * @author pengxg
 * @date 2022/4/25 5:20 下午
 */
@Service
public class MyUserService implements UserService<MyUser> {
    @Override
    public List<MyUser> findAll() {
        return null;
    }

    @Override
    public MyUser findById(Object idValue) {
        return null;
    }

    @Override
    public boolean updateById(Object idValue, Map data) {
        return false;
    }

    @Override
    public boolean updateById(MyUser user) {
        return false;
    }

    @Override
    public boolean bindRolesForUser(String userId, String... roleIds) {
        return false;
    }

    @Override
    public boolean resetPass(Object userId) {
        return false;
    }

    @Override
    public String userObjectCode() {
        return null;
    }

    @Override
    public boolean setPass(Object userId, String password) {
        return false;
    }
}
