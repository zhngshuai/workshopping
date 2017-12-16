package com.shop.service;

import com.shop.entity.Product;

import java.util.List;

public interface ProductService {

    // ���ݶ��������ѯ��Ʒ
    public List<Product> findByCsid(Integer csid, Integer page);

    // ����һ�������ѯ��Ʒ
    public List<Product> findByCid(Integer cid, Integer page);

    // �������ȵ���Ʒ10��
    public List<Product> findHot();

    // �������µ���Ʒ10��
    public List<Product> findNew();

    // ������Ʒ��pid��ֵ��ѯ��Ʒ
    public Product findByPid(Integer pid);

    // ����һ���ж���ҳ������
    public Integer CountPageProductFromCategory(Integer cid);

    // ���ض����������ζ��ٵ�����
    public Integer CountPageProductFromCategorySecond(Integer csid);

    // ������Ʒ����Ϣ
    public void update(Product product);

    // ������Ʒ��Ϣ
    public void save(Product save);
}