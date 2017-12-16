package com.shop.service;

import com.shop.entity.CategorySecond;

import java.util.List;


public interface AdminCategorySecondService {

    public List<CategorySecond> listCategorySecond(Integer page);

    //ͳ�ƶ�������ĸ���
    public Integer countCategorySecond();

    //�����������
    public void addCategorySecond(CategorySecond categorySecond);

    //ɾ����������
    public void deleteCategorySecond(Integer csid);

    //���Ҿ���ĳ����������
    public CategorySecond findCategorySecond(Integer csid);

    //���¶�������
    public void updateCategorySecond(CategorySecond categorySecond);

    //�������еĶ�������
    public List<CategorySecond> listCategorySecond();
}
