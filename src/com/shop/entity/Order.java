package com.shop.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name = "orders")
@Entity
public class Order {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer oid;
    private Float total;
    private Date ordertime;
    private Integer state;// 1:δ����   2:�����Ѿ�����   3:�Ѿ�����   4:��������
    private String name;
    private String phone;
    private String addr;
    // �û������:����
    @JoinColumn(name = "uid")
    @ManyToOne
    private User user;
    // ���ö�����ļ���
    //mappedBy="order"ָ��orderΪ˫���ϵά���������ĸ�������ά��
    //cascade������������,refresh:����ˢ��,remove����ɾ��
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "order")
    private Set<OrderItem> orderItems = new HashSet<OrderItem>();

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Order [oid=" + oid + ", total=" + total + ", ordertime=" + ordertime + ", state=" + state + ", name="
                + name + ", phone=" + phone + ", addr=" + addr + ", user=" + user + ", orderItems=" + orderItems + "]";
    }
}
