package com.shop.controller;

import com.shop.entity.Category;
import com.shop.service.AdminCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class AdminCategoryController {

    @Resource
    private AdminCategoryService adminCategoryService;

    @ModelAttribute("category")
    public void getCategory(@RequestParam(value = "cid", required = false) Integer cid, Map<String, Object> map) {
        if (cid != null) {
            Category category = adminCategoryService.findCategory(cid);
            map.put("category", category);
        }
    }

    //�޸�һ������
    @RequestMapping(value = "/updateCategory")
    public ModelAndView updateCategory(@ModelAttribute("category") Category category) {
        adminCategoryService.updateCategory(category);
        ModelAndView modelAndView = new ModelAndView("redirect:/listCategory/1");
        return modelAndView;
    }

    //��ת���޸�һ������
    @RequestMapping(value = "/gotoEditCategory/{cid}")
    public String gotoEditCategory(@PathVariable("cid") Integer cid, Map<String, Object> map) {
        Category category = adminCategoryService.findCategory(cid);
        map.put("category", category);
        return "admin/category/edit";
    }

    //ɾ��һ������
    @RequestMapping(value = "/deleteCategory/{cid}/{page}")
    public ModelAndView deleteCategory(@PathVariable("cid") Integer cid, @PathVariable("page") Integer page) {
        adminCategoryService.deleteCategory(cid);
        ModelAndView modelAndView = new ModelAndView("redirect:/listCategory/" + page);
        return modelAndView;
    }

    //���һ�����࣬cnameΪǰ̨��������һ�����������
    @RequestMapping(value = "/addCategory")
    public ModelAndView addCategory(@RequestParam(value = "cname", required = true) String cname) {
        //����һ������Ķ���
        Category category = new Category();
        category.setCname(cname);
        adminCategoryService.addCategory(category);
        ModelAndView modelAndView = new ModelAndView("redirect:listCategory/1");
        return modelAndView;
    }

    //��ת�����һ������
    @RequestMapping(value = "/gotoAddCategory")
    public String gotoAddCategory() {
        return "admin/category/add";
    }

    //��ѯһ������
    @RequestMapping(value = "/listCategory/{page}")
    public String listCategory(@PathVariable("page") Integer page, Map<String, Object> map) {
        List<Category> categorys = adminCategoryService.listCategory(page);
        map.put("categorys", categorys);
        map.put("page", page);
        //��ѯһ�������ҳ��
        Integer count = adminCategoryService.countCategory();
        map.put("count", count);
        return "admin/category/list";
    }
}