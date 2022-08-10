package com.hthjsj.md.demo.domain;

import com.github.md.analysis.kit.Kv;
import com.github.md.web.user.role.MRRole;
import com.github.md.web.user.role.UserWithRolesWrapper;

import java.util.Map;

/**
 * @author pengxg
 * @date 2022/4/25 5:20 下午
 */
public class MyUser implements UserWithRolesWrapper {
    @Override
    public String userId() {
        return null;
    }

    @Override
    public String userName() {
        return null;
    }

    @Override
    public String avatar() {
        return null;
    }

    @Override
    public String phone() {
        return null;
    }

    @Override
    public String email() {
        return null;
    }

    @Override
    public MRRole[] roles() {
        return new MRRole[0];
    }

    @Override
    public Kv attrs() {
        return null;
    }

    @Override
    public Kv attrs(Map attrs) {
        return null;
    }
}
