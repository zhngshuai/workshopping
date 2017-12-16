package com.shop.controller;

import com.shop.service.CategoryService;
import com.shop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class IndexController {
    @Resource
    private CategoryService categoryService;

    @Resource
    private ProductService productService;

    //��Ʒ��ҳ��action
    @RequestMapping(value = "/index")
    public String showIndex(Map<String, Object> map, HttpSession session) {
        //�����е�һ�����඼���뵽session��
        session.setAttribute("cList", categoryService.getCategory());

        //�����µ�10����Ʒ��ŵ�map������
        map.put("nList", productService.findNew());
        //�����ȵ�10����Ʒ��ӵ�map������
        map.put("hList", productService.findHot());

        return "index";
    }
}
