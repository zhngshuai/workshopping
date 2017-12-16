package com.shop.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

/**
 * ��Ʒ��ʵ�����
 */
@Table(name = "product")
@Entity
public class Product {

    @GeneratedValue(strategy = GenerationType.AUTO, generator="my_gen")
    @GenericGenerator(name="my_gen", strategy="identity")
    @Id
    private Integer pid;
    private String pname;
    private Float market_price;
    private Float shop_price;
    private Integer inventory;
    private String image;
    private String pdesc;
    private Integer is_hot;
    private Date pdate;

    // ������������:ʹ�ö�������Ķ���.
    @JoinColumn(name = "csid")
    @ManyToOne
    private CategorySecond categorySecond;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
//		String goodName = pname;
//		if(pname.contains("="))
//			goodName = new String(Base64.getDecoder().decode(pname.getBytes()));
        return pname;
    }

    public void setPname(String pname) {
//		String goodName = pname;
//		if(pname.contains("#")){//�ڼ���ǰ�Ѿ����м��ܲ��ڽ�β����#,ȡ��#��ֱ�Ӽ������ݿ�
//			pname = pname.replace("#", "");
//			goodName = pname;
//		}else if(pname.matches("\\w+"))//ƥ��Ӣ��,���н���
//			goodName = new String(Base64.getDecoder().decode(pname.getBytes()));
        this.pname = pname;
    }

    public Float getMarket_price() {
        return market_price;
    }

    public void setMarket_price(Float market_price) {
        this.market_price = market_price;
    }

    public Float getShop_price() {
        return shop_price;
    }

    public void setShop_price(Float shop_price) {
        this.shop_price = shop_price;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public Integer getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(Integer is_hot) {
        this.is_hot = is_hot;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date date) {
        this.pdate = date;
    }

    public CategorySecond getCategorySecond() {
        return categorySecond;
    }

    public void setCategorySecond(CategorySecond categorySecond) {
        this.categorySecond = categorySecond;
    }

    @Override
    public String toString() {
        return "Product [pid=" + pid + ", pname=" + pname + ", market_price=" + market_price + ", shop_price="
                + shop_price + ", image=" + image + ", pdesc=" + pdesc + ", is_hot=" + is_hot + ", pdate=" + pdate
                + ", categorySecond=" + categorySecond + "]";
    }
}
