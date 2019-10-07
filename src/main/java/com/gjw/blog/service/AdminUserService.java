package com.gjw.blog.service;

import com.gjw.blog.entity.AdminUser;

/**
 * @author gjw19
 * @date 2019/10/6
 */
public interface AdminUserService {

    AdminUser login(String username, String password);
}
