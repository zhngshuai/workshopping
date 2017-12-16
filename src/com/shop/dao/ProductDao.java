package com.shop.dao;

import com.shop.entity.CategorySecond;
import com.shop.entity.Product;

import java.util.List;

public interface ProductDao extends BaseDao<Product> {

    /**
     * �������ȵ�ʮ����Ʒ
     *
     * @return
     */
    public List<Product> findHot();

    /**
     * �������µ�ʮ����Ʒ
     *
     * @return
     */
    public List<Product> findNew();

    /**
     * ���ݶ��������ѯ��Ʒ
     *
     * @param csid
     * @param page
     * @return
     */
    public List<Product> findByCategorySecondCsid(Integer csid, Integer page);

    /**
     * ����һ�������ѯ��Ʒ
     *
     * @param cid
     * @param page
     * @return
     */
    public List<Product> findByCategorySecondCategoryCid(Integer cid, Integer page);

    public Integer CountPageProductFromCategory(Integer cid);

    public Integer CountPageProductFromCategorySecond(Integer csid);

    public Integer CountProduct();

    public Product findOne(Integer pid);

    public CategorySecond findOneSecond(Integer csid);

    public List<Product> findAll(Integer page);
}
