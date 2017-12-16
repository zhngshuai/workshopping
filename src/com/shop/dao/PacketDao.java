package com.shop.dao;

import com.shop.entity.Packet;

public interface PacketDao extends BaseDao<Packet> {

    /**
     * ����uid��ѯpacket����
     *
     * @param uid
     * @return
     */
    public Integer findByUid(Integer uid);
}
