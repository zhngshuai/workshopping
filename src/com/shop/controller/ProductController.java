package com.shop.controller;

import com.shop.entity.Category;
import com.shop.entity.CategorySecond;
import com.shop.entity.Product;
import com.shop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    @Resource
    private ProductService productService;

    //���ݶ��������ѯ��Ʒ
    @RequestMapping(value = "findByCsid/{csid}/{page}")
    public String findByCsid(@PathVariable("csid") Integer csid, @PathVariable("page") Integer page
            , Map<String, Object> map) {
        Integer count = productService.CountPageProductFromCategorySecond(csid);
        if (page > count) {
            page = 1;
        }
        List<Product> products = productService.findByCsid(csid, page);
        map.put("products", products);
        //�ѵ�ǰ��ҳ����ŵ�map��
        map.put("page", page);
        //�ܹ��ж���ҳ
        map.put("count", count);
        map.put("csid", csid);
        return "productList";
    }

    //��ҳ�е��һ�������ѯ��Ʒ
    @RequestMapping(value = "/findByCid/{cid}/{page}")
    public String findByCid(@PathVariable("cid") Integer cid, @PathVariable("page") Integer page
            , Map<String, Object> map) {

        List<Product> products = productService.findByCid(cid, page);
        Integer count = productService.CountPageProductFromCategory(cid);
        if (page > count) {
            page = 1;
        }
        map.put("products", products);
        //�ѵ�ǰ��ҳ����ŵ�map��
        map.put("page", page);
        //�ܹ��ж���ҳ
        map.put("count", count);
        map.put("cid", cid);
        return "productList";
    }

    //������Ʒ��pid��ѯ��Ʒ
    @RequestMapping(value = "findByPid/{pid}", method = RequestMethod.GET)
    public String findByPid(@PathVariable("pid") Integer pid, Map<String, Object> map) {

//		map.put("product", productService.findByPid(pid));
        Product products = productService.findByPid(pid);
        map.put("product", products);    //put product

        CategorySecond categorySecond = products.getCategorySecond();
//		map.put("categorySecond", categorySecond);

        Category category = categorySecond.getCategory();
//		map.put("category", category);

        Date privilege = category.getPrivilegeTime();
        String privilegeTime = privilege.toString().substring(0, 10);    //��ȡcategory����privilegeTime�ֶε�������
//		int length = privilegeTime.length();

        map.put("privilegeTime", privilegeTime);    //put privilegeTime

        return "product";
    }
}
