package com.shop.controller;

import com.shop.entity.Category;
import com.shop.entity.CategorySecond;
import com.shop.service.AdminCategorySecondService;
import com.shop.service.AdminCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class AdminCategorySecondController {

    @Resource
    private AdminCategorySecondService adminCategorySecondService;
    @Resource
    private AdminCategoryService adminCategoryService;

    //���¶�������
    @RequestMapping(value = "/updateCategorySecond", method = RequestMethod.POST)
    public ModelAndView updateCategorySecond(@RequestParam("csid") Integer csid, @RequestParam("csname") String csname,
                                             @RequestParam("cid") Integer cid) {
        Category category = adminCategoryService.findCategory(cid);
        CategorySecond categorySecond = adminCategorySecondService.findCategorySecond(csid);
        categorySecond.setCategory(category);
        categorySecond.setCsname(csname);
        adminCategorySecondService.updateCategorySecond(categorySecond);
        ModelAndView modelAndView = new ModelAndView("redirect:/listCategorySecond/1");
        return modelAndView;
    }

    //��ת���޸Ķ����������
    @RequestMapping(value = "/gotoEditCategorySecond/{csid}")
    public String gotoEditCategorySecond(@PathVariable("csid") Integer csid,
                                         Map<String, Object> map) {
        System.out.println("��������������������������" + csid);
        //���Ҷ�Ӧ�Ķ�������
        CategorySecond categorySecond = adminCategorySecondService.findCategorySecond(csid);
        map.put("categorySecond", categorySecond);
        //���Ҷ�Ӧ��һ������
        List<Category> categorys = adminCategoryService.findCategory();
        map.put("categorys", categorys);
        return "admin/categorysecond/edit";
    }

    //ɾ����������
    @RequestMapping(value = "/deleteCategorySecond/{csid}/{page}")
    public ModelAndView deleteCategorySecond(@PathVariable("csid") Integer csid, @PathVariable("page") Integer page) {
        adminCategorySecondService.deleteCategorySecond(csid);
        ModelAndView modelAndView = new ModelAndView("redirect:/listCategorySecond/" + page);
        return modelAndView;
    }

    //��Ӷ�������
    @RequestMapping(value = "/addCategorySecond")
    public ModelAndView addCategorySecond(@RequestParam("csname") String csname, @RequestParam("cid") Integer cid) {
        //����һ���������
        Category category = adminCategoryService.findCategory(cid);
        //���������������
        CategorySecond categorySecond = new CategorySecond();
        //����һ������Ͷ�������Ĺ�����ϵ
        categorySecond.setCategory(category);
        categorySecond.setCsname(csname);
        //�������
        adminCategorySecondService.addCategorySecond(categorySecond);
        ModelAndView modelAndView = new ModelAndView("redirect:listCategorySecond/1");
        return modelAndView;
    }

    //��ת����Ӷ�������Ľ���
    @RequestMapping(value = "/gotoAddCategorySecond")
    public String gotoAddCategorySecond(Map<String, Object> map) {
        List<Category> categorys = adminCategoryService.findCategory();
        map.put("categorys", categorys);
        return "admin/categorysecond/add";
    }

    //����ҳ��ʾ��������
    @RequestMapping(value = "/listCategorySecond/{page}")
    public String listCategorySecond(@PathVariable("page") Integer page, Map<String, Object> map) {
        List<CategorySecond> categorySeconds = adminCategorySecondService.listCategorySecond(page);
        map.put("categorySeconds", categorySeconds);
        map.put("page", page);
        //ͳ�ƶ��������ҳ��
        Integer count = adminCategorySecondService.countCategorySecond();
        map.put("count", count);
        return "admin/categorysecond/list";
    }
}
