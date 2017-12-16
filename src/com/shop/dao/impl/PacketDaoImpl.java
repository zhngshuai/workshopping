package com.shop.dao.impl;


import com.shop.dao.PacketDao;
import com.shop.entity.Packet;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository("packetDao")
@SuppressWarnings("all")

public class PacketDaoImpl extends BaseDaoImpl<Packet> implements PacketDao {

    @Override
    public Integer findByUid(Integer uid) {
//        String hql = "from Packet p where p.uid = ?";
        String hql = "select pacid from Packet p where p.uid = ?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, uid);
        return (Integer) query.uniqueResult();
    }
}
