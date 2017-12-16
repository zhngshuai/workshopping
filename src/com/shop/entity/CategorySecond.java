package com.shop.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * ���������ʵ��
 */
@Table(name = "categorysecond")
@Entity
public class CategorySecond implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer csid;
    private String csname;

    // ����һ������.�����һ������Ķ���.
    @JoinColumn(name = "cid")
    @ManyToOne
    private Category category;

    // ������Ʒ����
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categorySecond")
    private Set<Product> products = new HashSet<Product>();

    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public String getCsname() {
        return csname;
    }

    public void setCsname(String csname) {
        this.csname = csname;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
