package com.shop.dao;

import com.shop.entity.Order;
import com.shop.entity.OrderItem;

import java.util.List;

public interface OrderDao extends BaseDao<Order> {

    /**
     * Dao���ѯ�ҵĶ�����ҳ��ѯ:ͳ�Ƹ���
     *
     * @param uid
     * @return
     */
    public int findCountByUid(Integer uid);

    /**
     * Dao���ѯ�ҵĶ�����ҳ��ѯ:��ѯ����
     *
     * @param uid
     * @param begin
     * @param limit
     * @return
     */
    public List<Order> findPageByUid(Integer uid, int begin, int limit);

    /**
     * DAO����ݶ���id��ѯ����
     *
     * @param oid
     * @return
     */
    public Order findByOid(Integer oid);

    /**
     * DAO��ͳ�ƶ��������ķ���
     *
     * @return
     */
    public int findCount();

    /**
     * DAO�з�ҳ��ѯ�����ķ���
     *
     * @param begin
     * @param limit
     * @return
     */
    public List<Order> findByPage(int begin, int limit);

    /**
     * DAo�и��ݶ���id��ѯ������
     *
     * @param oid
     * @return
     */
    public List<OrderItem> findOrderItem(Integer oid);

}
