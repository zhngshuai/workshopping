package com.shop.controller;

import com.shop.entity.User;
import com.shop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @ModelAttribute
    public User getUser() {
        return new User();
    }

    //�û��˳�
    @RequestMapping("/quit")
    public String quit(HttpSession session, HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:index";
    }

    //�û���¼
    @RequestMapping(value = "login")
    public String login(@ModelAttribute("user") User user, String checkcode,
                        HttpSession session, Map<String, Object> map) {
        //��session�л�ȡ��֤��
        String checkCode = (String) session.getAttribute("checkcode");
        //�����֤�벻һ�£�ֱ�ӷ��ص���½��ҳ��
        if (!checkCode.equalsIgnoreCase(checkcode)) {
            map.put("errorCheckCode", "errorCheckCode");
            return "login";
        }
        //�ж��Ƿ�����û�
        User isExistUser = userService.existUser(user.getUsername());
        if (isExistUser == null) {
            map.put("notUser", "notUser");
            return "login";
        }
        //�ж��û��Ƿ񼤻�
        User u = userService.existUser(user.getUsername());
        if (u.getState() == 0) {
            map.put("notActive", "notActive");
            return "login";
        }
        //�ж��û����������Ƿ���ȷ
        u = userService.findUserByUsernameAndPassword(user);
        if (u == null) {
            map.put("notPassword", "notPassword");
            return "login";
        }
        session.setAttribute("user", u);
        return "redirect:index";
    }

    //��ת���û���¼
    @RequestMapping(value = "/userLogin")
    public String userLogin() {
        return "login";
    }

    //�û�����
    @RequestMapping(value = "/active/{code}")
    public String active(@PathVariable("code") String code, Map<String, Object> map) {
        //���ݼ�����ȥ��ѯ�û�
        User user = userService.active(code);
        if (user == null) {
            map.put("notUser", "notUser");
            return "msg";
        }
        user.setCode("");
        user.setState(1);
        userService.update(user);
        map.put("activeSuccess", "activeSuccess");
        return "msg";
    }

    // �û�ע��
    // ����һ��@Valid�Ĳ�������������һ�� BindingResult ����������spring����У�鲻ͨ��ʱֱ���׳��쳣
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(@ModelAttribute User user, BindingResult result, HttpSession session,
                           String checkcode, Map<String, Object> map) {

        //����д���ֱ����ת��ע���ҳ��
        if (result.hasErrors()) {

            //�ڿ���̨��ӡ�������Ϣ
            List<ObjectError> errorList = result.getAllErrors();
            for (ObjectError error : errorList) {
                System.out.println(error.getDefaultMessage());
            }

            //���ص�ע��ҳ��
            return "regist";
        }

        //��session�л�ȡ��֤��
        String checkCode = (String) session.getAttribute("checkcode");
        System.out.println("��̨��֤��" + checkCode);
        System.out.println("ǰ̨��֤��" + checkcode);

        //�����֤�벻һ�£�ֱ�ӷ���
        if (!checkCode.equalsIgnoreCase(checkcode)) {
            map.put("errorCheckCode", "errorCheckCode");
            return "regist";
        }
        userService.register(user);
        
        return "msg";
    }

    // ʹ��ajax�ж��û��Ƿ����
    @RequestMapping(value = "/checkUser/{userName}", method = RequestMethod.POST)
    @ResponseBody
    public String existUser(@PathVariable("userName") String userName, HttpServletResponse response)
            throws IOException {

        System.out.println(userName);
        response.setContentType("text/html;charset=UTF-8");
        if (userService.existUser(userName) != null) {

            // ��ѯ�����û�:�û����Ѿ�����
            response.getWriter().println("1");
        } else {

            // û��ѯ�����û�:�û�������ʹ��
            response.getWriter().println("0");
        }
        return null;
    }

    // �û�ע�����ת
    @RequestMapping("userRegister")
    public String register() {
        return "regist";
    }

}