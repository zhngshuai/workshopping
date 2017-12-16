package com.shop.entity;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	//���ﳵ����
	//������ϣ�Map��key������Ʒpid��value��������
	private Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>();
	
	//Cart��������һ��cartItems����
	public Collection<CartItem> getCartItems(){
		return map.values();
	}

	//�����ܼ�
	private float total;

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	//���ﳵ�Ĺ��ܣ�
	//1.����������ӵ����ﳵ
	public void addCart(CartItem cartItem) {
		//�жϹ��ﳵ���Ƿ��Ѿ����ڸù�����;
		/**
		 * �����ڣ���������
		 * �ܼ� += ������С��
		 * 
		 * ��������:
		 * ��map����ӹ�����
		 * �ܼ� += ������С��
		 */
		//�����Ʒpid
		Integer pid = cartItem.getProduct().getPid();
		//�жϹ��ﳵ���Ƿ��Ѿ����ڸù�����
		if(map.containsKey(pid)){
			//���ڣ���ù��ﳵ��ԭ���Ĺ�����
			CartItem _carCartItem = map.get(pid);
			//ԭ���Ĺ�����������������ڵĹ���������
			_carCartItem.setCount(_carCartItem.getCount()+cartItem.getCount());
		}else {
			map.put(pid, cartItem);
		}
		// �����ܼƵ�ֵ
		total += cartItem.getSubtotal();
	}
	
	// 2.�ӹ��ﳵ�Ƴ�������
	public void removeCart(Integer pid) {
		//���������Ƴ����ﳵ
		CartItem cartItem = map.remove(pid);
		total -= cartItem.getSubtotal();
	}
	
	//3.��չ��ﳵ
	public void clearCart() {
		//�����й��������
		map.clear();
		//���ܼ�����Ϊ0
		total = 0;
	}
}
