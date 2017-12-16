package com.shop.service;

import com.shop.entity.Product;

import java.util.List;

public interface AdminProductService {
    //��ҳ��ѯ��Ʒ
    public List<Product> listProduct(Integer page);

    //��ѯ��Ʒ��ҳ��
    public Integer countProduct();

    //������Ʒ
    public void saveProduct(Product product);

    //����ĳ���������Ʒ
    public Product findProduct(Integer pid);

    //ɾ����Ʒ
    public void deleteProduct(Product product);

    //�޸���Ʒ
    public void updateProduct(Product product);
}
