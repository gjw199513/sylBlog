package com.gjw.blog.service;

import com.gjw.blog.utils.PageQueryUtil;
import com.gjw.blog.utils.PageResult;

/**
 * @author gjw19
 * @since 2019/10/8.
 */
public interface TagService {

    /**
     * 查询标签的分页数据
     *
     * @param pageUtil
     * @return
     */
    PageResult getBlogTagPage(PageQueryUtil pageUtil);

    Boolean saveTag(String tagName);

    Boolean deleteBatch(Integer[] ids);
}
