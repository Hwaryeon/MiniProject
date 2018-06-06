package com.kh.miniproject.ProductAndProfit.vo;

import java.io.Serializable;

public class Product implements Serializable{

	private String names = "";	//��ǰ�̸�
	private int count = 0;		//��ǰ����
	private int price = 0;		//��ǰ����
	private String kind = "";	//��ǰ���� ��)����, ���, ���ڵ�
	private String Photo = "";	//��ǰ�׸��ּ� ��)coffee.png 
	
	//��ǰ��� �Է�
	public Product(String names, int price, int count, String kind, String photo) {
		this.names = names;
		this.count = count;
		this.price = price;
		this.kind = kind;
		Photo = photo;
	}
	
	@Override
	public String toString() {
		return "Product_Form [names=" + names + ", count=" + count + ", price=" + price + ", kind=" + kind + ", Photo="
				+ Photo + "]";
	}

	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String photo) {
		Photo = photo;
	}
	
	
}
