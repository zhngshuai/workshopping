package com.shop.service;

import com.shop.entity.Order;
import com.shop.entity.OrderItem;

import java.util.List;

public interface OrderService {

    // ҵ��㱣�涩���ķ���
    public void save(Order order);

    // ҵ�������û�id��ѯ����,����ҳ��ѯ.
    public List<Order> findByUid(Integer uid, Integer page);

    // ���ݶ���id��ѯ����
    public Order findByOid(Integer oid);

    // ҵ����޸Ķ����ķ���:
    public void update(Order currOrder);

    // ҵ����ѯ���ж�������
    public List<Order> findAll(Integer page);

    // ҵ����ѯ������ķ���
    public List<OrderItem> findOrderItem(Integer oid);

    public Integer findCountByUid(Integer uid);

}