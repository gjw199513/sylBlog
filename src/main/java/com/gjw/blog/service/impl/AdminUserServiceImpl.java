package com.gjw.blog.service.impl;

import com.gjw.blog.dao.AdminUserMapper;
import com.gjw.blog.entity.AdminUser;
import com.gjw.blog.service.AdminUserService;
import com.gjw.blog.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gjw19
 * @date 2019/10/6
 */
@Service("adminUserService")
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminUserMapper adminUserMapper;


    @Override
    public AdminUser login(String username, String password) {
        String passwordMd5 = MD5Util.MD5Encode(password, "UTF-8");
        return adminUserMapper.login(username, passwordMd5);
    }
}
