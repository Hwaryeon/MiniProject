package com.kh.miniproject.ProductAndProfit.controller;

import com.kh.miniproject.ProductAndProfit.model.vo.Product;

public class Inventory_Add {

	//InventoryDao호출
	public Inventory_Add() {
		/*new Frame()으로 새로운 창을 호출*/
	}
	
	//재고 입력
	public Product product_Enter(Product pro){
		return pro;
		/*양식에 맞는 텍스트 입력 받은후 new Product(재품이름, 제품갯수[숫자만기입], 제품가격[숫자만기입], 제품종류[콤보박스],사진url)
		 * ida.product_Add()에 매개변수로 전해준다.
		 *  */
	}

	
}
