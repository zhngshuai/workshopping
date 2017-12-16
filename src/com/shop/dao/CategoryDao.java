package com.shop.dao;

import com.shop.entity.Category;

import java.util.Date;
import java.util.List;

public interface CategoryDao extends BaseDao<Category> {

    /**
     * ��ѯһ��������ܵĸ���
     *
     * @return
     */
    public Integer countCategory();

    /**
     * ��ҳ���������û�
     *
     * @param page
     * @return
     */
    public List<Category> findAll(Integer page);

    public List<Category> findAll();

    public Category findOne(Integer cid);

    /**
     * ��ѯ�Ż�ʱ��
     *
     * @param cid
     * @return
     */
    public Date queryPrivilegeTime(Integer cid);
}
