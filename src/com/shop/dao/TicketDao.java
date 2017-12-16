package com.shop.dao;

import com.shop.entity.Ticket;

public interface TicketDao extends BaseDao<Ticket> {

    public Integer findTicketByCid(Integer cid);
}
