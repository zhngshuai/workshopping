package com.shop.entity;

public class CartItem {

    private Product product; // ����������Ʒ��Ϣ
    private Float price = 1.0f;    //����۸�
    private int count; // ����ĳ����Ʒ����
    @SuppressWarnings("unused")
    private float subtotal; // ����ĳ����ƷС��

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getSubtotal() {
        /*if (product.getShop_price() != null) {
			return count * product.getShop_price()
					* product.getCategorySecond().getCategory().getDiscount();
		}*/

        return count * getPrice();

    }


}
