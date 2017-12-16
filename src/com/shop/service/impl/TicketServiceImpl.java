package com.shop.service.impl;


import com.shop.dao.TicketDao;
import com.shop.service.TicketService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Transactional
@Service("ticketService")
public class TicketServiceImpl implements TicketService {

    @Resource
    private TicketDao ticketDao;


    public Integer findTicketByCid(Integer cid) {
        return ticketDao.findTicketByCid(cid);
//        return ticketDao.get(cid);
    }

}
