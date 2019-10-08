package com.gjw.blog.service.impl;

import com.gjw.blog.dao.BlogTagMapper;
import com.gjw.blog.dao.BlogTagRelationMapper;
import com.gjw.blog.entity.BlogTag;
import com.gjw.blog.service.TagService;
import com.gjw.blog.utils.PageQueryUtil;
import com.gjw.blog.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author gjw19
 * @since 2019/10/8.
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private BlogTagMapper blogTagMapper;
    @Autowired
    private BlogTagRelationMapper blogTagRelationMapper;

    @Override
    public PageResult getBlogTagPage(PageQueryUtil pageUtil) {
        List<BlogTag> tags = blogTagMapper.findTagList(pageUtil);
        int total = blogTagMapper.getTotalTags(pageUtil);
        PageResult pageResult = new PageResult(tags, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public Boolean saveTag(String tagName) {
        BlogTag temp = blogTagMapper.selectByTagName(tagName);
        if (temp == null) {
            BlogTag blogTag = new BlogTag();
            blogTag.setTagName(tagName);
            return blogTagMapper.insertSelective(blogTag) > 0;
        }
        return false;
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        // 已存在关联关系不删除
        List<Long> relations = blogTagRelationMapper.selectDistinctTagIds(ids);
        if (!CollectionUtils.isEmpty(relations)) {
            return false;
        }
        // 删除tag
        return blogTagMapper.deleteBatch(ids) > 0;
    }
}
