package com.gjw.blog.service.impl;

import com.gjw.blog.dao.BlogCategoryMapper;
import com.gjw.blog.dao.BlogMapper;
import com.gjw.blog.dao.BlogTagMapper;
import com.gjw.blog.dao.BlogTagRelationMapper;
import com.gjw.blog.entity.Blog;
import com.gjw.blog.entity.BlogCategory;
import com.gjw.blog.entity.BlogTag;
import com.gjw.blog.entity.BlogTagRelation;
import com.gjw.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gjw19
 * @since 2019/10/9.
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private BlogCategoryMapper categoryMapper;
    @Autowired
    private BlogTagMapper blogTagMapper;
    @Autowired
    private BlogTagRelationMapper blogTagRelationMapper;

    @Override
    public String saveBlog(Blog blog) {
        BlogCategory blogCategory = categoryMapper.selectByPrimaryKey(blog.getBlogCategoryId());
        if (blogCategory == null) {
            blog.setBlogCategoryId(0);
            blog.setBlogCategoryName("默认分类");
        } else {
            // 设置博客分类名称
            blog.setBlogCategoryName(blogCategory.getCategoryName());
            // 分类的排序值加1
            blogCategory.setCategoryRank(blogCategory.getCategoryRank() + 1);
        }
        // 处理标签数据
        String[] tags = blog.getBlogTags().split(",");
        if (tags.length > 6) {
            return "标签数量限制为6";
        }
        // 保存文章
        if (blogMapper.insertSelective(blog) > 0) {
            // 新增的tag对象
            List<BlogTag> tagListForInsert = new ArrayList<>();
            // 所有的tag对象，用于建立关系数据
            List<BlogTag> allTagsList = new ArrayList<>();
            for (int i = 0; i < tags.length; i++) {
                BlogTag tag = blogTagMapper.selectByTagName(tags[i]);
                if (tag == null) {
                    // 不存在就新增
                    BlogTag tempTag = new BlogTag();
                    tempTag.setTagName(tags[i]);
                    tagListForInsert.add(tempTag);
                } else {
                    allTagsList.add(tag);
                }
            }
            // 新增标签数据并修改分类排序值
            if (!CollectionUtils.isEmpty(tagListForInsert)) {
                blogTagMapper.batchInsertBlogTag(tagListForInsert);
            }
            categoryMapper.updateByPrimaryKeySelective(blogCategory);
            List<BlogTagRelation> blogTagRelations = new ArrayList<>();
            // 新增关系数据
            allTagsList.addAll(tagListForInsert);
            for (BlogTag blogTag : allTagsList) {
                BlogTagRelation blogTagRelation = new BlogTagRelation();
                blogTagRelation.setBlogId(blog.getBlogId());
                blogTagRelation.setTagId(blogTag.getTagId());
                blogTagRelations.add(blogTagRelation);
            }
            if (blogTagRelationMapper.batchInsert(blogTagRelations) > 0) {
                return "success";
            }
        }
        return "保存失败";
    }
}
