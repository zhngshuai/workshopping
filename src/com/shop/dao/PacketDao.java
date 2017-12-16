package com.shop.dao;

import com.shop.entity.Packet;

public interface PacketDao extends BaseDao<Packet> {

    /**
     * 根据uid查询packet对象
     *
     * @param uid
     * @return
     */
    public Integer findByUid(Integer uid);
}
