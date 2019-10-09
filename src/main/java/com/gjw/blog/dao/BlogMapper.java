package com.gjw.blog.dao;

import com.gjw.blog.entity.Blog;
import org.springframework.stereotype.Component;

/**
 * @author gjw19
 * @since 2019/10/9.
 */
@Component
public interface BlogMapper {
    int deleteByPrimaryKey(Long blogId);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Long blogId);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKeyWithBLOBs(Blog record);

    int updateByPrimaryKey(Blog record);
}
