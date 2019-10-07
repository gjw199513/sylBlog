package com.gjw.blog.service;

import com.gjw.blog.entity.BlogCategory;
import com.gjw.blog.utils.PageQueryUtil;
import com.gjw.blog.utils.PageResult;

import java.util.List;

/**
 * @author gjw19
 * @date 2019/10/7
 */
public interface CategoryService {
    /**
     * 查询分类的分页数据
     *
     * @param pageUtil
     * @return
     */
    PageResult getBlogCategoryPage(PageQueryUtil pageUtil);

    int getTotalCategories();

    /**
     * 添加分类数据
     *
     * @param categoryName
     * @param categoryIcon
     * @return
     */
    Boolean saveCategory(String categoryName, String categoryIcon);

    Boolean updateCategory(Integer categoryId, String categoryName, String categoryIcon);

    Boolean deleteBatch(Integer[] ids);

    List<BlogCategory> getAllCategories();

    BlogCategory selectById(Integer id);
}
