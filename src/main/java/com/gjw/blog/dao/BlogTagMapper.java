package com.gjw.blog.dao;

import com.gjw.blog.entity.BlogTag;
import com.gjw.blog.utils.PageQueryUtil;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author gjw19
 * @since 2019/10/8.
 */
@Component
public interface BlogTagMapper {
    int deleteByPrimaryKey(Integer tagId);

    int insert(BlogTag record);

    int insertSelective(BlogTag record);

    BlogTag selectByPrimaryKey(Integer tagId);

    BlogTag selectByTagName(String tagName);

    int updateByPrimaryKeySelective(BlogTag record);

    int updateByPrimaryKey(BlogTag record);

    List<BlogTag> findTagList(PageQueryUtil pageUtil);

    int getTotalTags(PageQueryUtil pageUtil);

    int deleteBatch(Integer[] ids);
}
