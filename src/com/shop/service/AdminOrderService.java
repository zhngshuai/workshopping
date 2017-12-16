package com.shop.service;

import com.shop.entity.Order;

import java.util.List;

public interface AdminOrderService {

    //��ѯĳ������Ķ���
    public Order findOrder(Integer oid);

    //����͸��¶���
    public void saveOrUpdateOrder(Order order);

    //ɾ���ö���
    public void deleteOrder(Order order);

    //��ҳ��ѯ���еĶ���
    public List<Order> listOrder(Integer page, Integer rows);

    //��ѯ�ܹ��ж���ҳ�Ķ���
    public Integer countOrder();

}
