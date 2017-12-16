package com.shop.controller;

import com.shop.entity.Admin;
import com.shop.entity.User;
import com.shop.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Controller
public class AdminController {

    @Resource
    private AdminService adminService;

    @ModelAttribute(value = "user")
    public void getUser(@RequestParam(value = "uid", required = false) Integer uid, Map<String, Object> map) {
        if (uid != null) {
            User user = adminService.findUserByUid(uid);
            map.put("user", user);
        }
    }

    //�����û�
    @RequestMapping(value = "/updateUser")
    public ModelAndView updateUser(@ModelAttribute("user") User user) {
        adminService.updateUser(user);
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/listUser/1");
        return model;
    }

    //�޸��û�
    @RequestMapping(value = "/editUser/{uid}")
    public String editUser(@PathVariable("uid") Integer uid, @ModelAttribute("user") User user, Map<String, Object>
            map) {
        user = adminService.findUserByUid(uid);
        map.put("user", user);
        return "admin/user/edit";
    }

    //ɾ���û� uid:�û���id page:��ǰ�ڼ�ҳ
    @RequestMapping(value = "/deleteUser/{uid}/{page}")
    public ModelAndView deleteUser(@PathVariable("uid") Integer uid, @PathVariable("page") Integer page) {
        adminService.deleteUser(uid);
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/listUser/" + page);
        return model;
    }

    //����Ա��ѯ�û�
    @RequestMapping(value = "/listUser/{page}")
    public String listUser(@PathVariable("page") Integer page, Map<String, Object> map) {
        //���������û��ļ���
        List<User> users = adminService.findUser(page);
        //��ѯ�ö���ҳ
        Integer count = adminService.countUser();
        map.put("count", count);
        map.put("page", page);
        map.put("users", users);
        return "admin/user/list";
    }

    // �������Ա��½
    @RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
    public String adminLogin(Admin admin,
                             HttpSession session) {
        Admin checkUser = adminService.checkUser(admin);
        if (null == checkUser) {
            return "admin/index";
        } else {
            session.setAttribute("admin", admin);
        }
        return "admin/home";
    }

    // ��ת������Ա�ĵ�½����
    @RequestMapping(value = "/adminIndex")
    public String adminIndex() {
        return "admin/index";
    }

    //����Ա��ҳ�����Ľ���
    @RequestMapping("/adminTop")
    public String adminTop() {
        return "admin/top";
    }

    //����Ա��ҳ���Ľ���
    @RequestMapping("/adminLeft")
    public String adminLeft() {
        return "admin/left";
    }

    //����Ա��½�ɹ����Ҳ�Ľ���
    @RequestMapping("/adminWelcome")
    public String adminWelcome() {
        return "admin/welcome";
    }

    //����Ա��ҳ�ײ��Ľ���
    @RequestMapping("/adminBottom")
    public String adminButtom() {
        return "admin/bottom";
    }
}
