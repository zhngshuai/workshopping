package com.shop.dao;

import com.shop.entity.CategorySecond;

import java.util.List;

public interface CategorySecondDao extends BaseDao<CategorySecond> {

    /**
     * ��ѯ����������ܵĸ���
     *
     * @return
     */
    public Integer countCategorySecond();

    /**
     * ��ҳ���������û�
     *
     * @param page
     * @return
     */
    public List<CategorySecond> findAll(Integer page);

    public List<CategorySecond> findAll();

    public CategorySecond findOne(Integer cid);

}
