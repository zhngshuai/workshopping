package com.shop.controller;

import com.shop.entity.Order;
import com.shop.entity.OrderItem;
import com.shop.service.AdminOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Controller
public class AdminOrderController {

    @Resource
    private AdminOrderService adminOrderService;

    @RequestMapping(value = "/findOrderItem/{oid}/{time}")
    public String findOrderItem(@PathVariable("oid") Integer oid, Map<String, Object> map,
                                HttpServletResponse response) throws IOException {
        Order order = adminOrderService.findOrder(oid);
        Set<OrderItem> orderItem = order.getOrderItems();
        map.put("orderItem", orderItem);
        return "admin/order/orderItem";
    }

    //��������
    @RequestMapping(value = "/updateStateOrder/{oid}/{page}")
    public ModelAndView updateStateOrder(@PathVariable("oid") Integer oid, @PathVariable("page") Integer page) {
        ModelAndView modelAndView = new ModelAndView("redirect:/listOrder/" + page);
        Order order = adminOrderService.findOrder(oid);
        order.setState(3);
        adminOrderService.saveOrUpdateOrder(order);
        return modelAndView;
    }

    //��ѯ����
    @RequestMapping(value = "/listOrder/{page}")
    public ModelAndView listOrder(@PathVariable("page") Integer page) {
        ModelAndView modelAndView = new ModelAndView("admin/order/list");
        //��ҳ�������еĶ���
        List<Order> orders = adminOrderService.listOrder(page, 5);
        modelAndView.addObject("orders", orders);
        //���浱ǰ��ҳ��
        modelAndView.addObject("page", page);
        //��ѯ�ܹ��ж���ҳ������
        Integer count = adminOrderService.countOrder();
        modelAndView.addObject("count", count);
        return modelAndView;
    }

    //ɾ����Ʒ
    @RequestMapping(value = "/deleteOrder/{oid}")
    public ModelAndView deleteProduct(@PathVariable("oid") Integer oid, HttpServletRequest request) {
        //��ȡ�ö����Ķ���
        Order order = adminOrderService.findOrder(oid);
        //��ȡ�ļ�����Ŀ¼
        //ɾ����Ʒ�����ݿ��еļ�¼
        adminOrderService.deleteOrder(order);
        ModelAndView modelAndView = new ModelAndView("redirect:/listOrder/1");
        return modelAndView;
    }
}
