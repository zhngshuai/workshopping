package com.shop.controller;

import com.shop.entity.*;
import com.shop.service.PacketService;
import com.shop.service.ProductService;
import com.shop.service.TicketService;
import com.shop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

@Controller
public class CartController {
    @Resource
    private ProductService productService;
    private UserService userService;
    private PacketService packetService;
    private TicketService ticketService;

    //��ҳ����ת�����ﳵ
    @RequestMapping("/myCart")
    public String myCart() {
        return "cart";
    }

    //��չ��ﳵ
    @RequestMapping(value = "/clearCart")
    public String clearCart(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        cart.clearCart();
        return "cart";
    }

    //ɾ�����ﳵ�е���Ʒ
    @RequestMapping(value = "/removeCart/{pid}")
    public String removeCart(@PathVariable("pid") Integer pid, HttpSession session) {
        //��ù��ﳵ����
        Cart cart = (Cart) session.getAttribute("cart");
        //������Ʒ��pid�ӹ��ﳵ���Ƴ���Ʒ
        cart.removeCart(pid);
        return "cart";
    }

    //�޸Ĺ��ﳵ�Żݺ�ļ۸�
    @RequestMapping(value = "/ChangeTotal/{total}", method = RequestMethod.POST)
    @ResponseBody
    public String changeCart(@PathVariable("total") float total, HttpSession session) {
        //	System.out.println(total);
        //��ù��ﳵ����
        Cart cart = (Cart) session.getAttribute("cart");
        cart.setTotal(total);
        session.setAttribute("cart", cart);
        return null;
    }

    //��ӵ����ﳵ
    @RequestMapping(value = "/addCart")
    public String addCart(Integer pid, Integer count, HttpSession session, Map<String, Object> map) {


//		System.out.println("pid:"+ pid);
        Product product = productService.findByPid(pid);
//        System.out.println(product.getShop_price());

        CategorySecond categorySecond = product.getCategorySecond();
        Category category = categorySecond.getCategory();

        Date privilege = category.getPrivilegeTime();
        String privilegeTime = privilege.toString().substring(0, 10);    //��ȡcategory����privilegeTime�ֶε�������
        map.put("privilegeTime", privilegeTime);    //put privilegeTime

//        Ticket ticket = ticketService.findTicketByCid(1);
        Ticket ticket = category.getTicket();
        map.put("ticket", ticket);  //put ticket����
        map.put("count", count);    //put count

        Float finalPrice = Float.valueOf(((String) session.getAttribute("price")).replace(",", ""));

//        User user = (User) session.getAttribute("user");

        CartItem cartItem = new CartItem();
        cartItem.setCount(count);
        cartItem.setProduct(product);
        cartItem.setPrice(finalPrice);

        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        // ����������ӵ����ﳵ.
        cart.addCart(cartItem);
        return "cart";
    }

}
