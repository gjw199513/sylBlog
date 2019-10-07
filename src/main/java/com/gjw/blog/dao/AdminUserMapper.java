package com.gjw.blog.dao;

import com.gjw.blog.entity.AdminUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author gjw19
 * @date 2019/10/6
 */
public interface AdminUserMapper {

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    /**
     * 登陆方法
     *
     * @param userName
     * @param password
     * @return
     */
    AdminUser login(@Param("userName") String userName, @Param("password") String password);

    AdminUser selectByPrimaryKey(Integer adminUserId);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);
}
