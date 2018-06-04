package controller;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import dao.InventoryDao;
import view.MainFrame;
import view.ProductAdd_Frame.Iventory_Sale;
import view.ProductAdd_Frame.ProductAdd;
import vo.Product;

public class Inventory_Management {

	InventoryDao iDao = null;
	public Product pro = null;
	//임시입력
	java.util.Scanner sc = new java.util.Scanner(System.in);
	
	//InventoryDao호출
	public Inventory_Management() {
		iDao = new InventoryDao();
	}

	//카테고리 조회
	public ArrayList<Product> Record(String kinds){
		
		return iDao.product_Record(kinds);
		
		/*
		 * 카테고리 조회 선택시 해당 종류에 있는 모든 재고를 출력
		 * 
		 */
	}
	
	//재고 검색창
	public ArrayList<Product> Seach(String name){
		return iDao.product_Seach(name);
		
		/*product_Seach(입력된 이름)의 인덱스로 제품의 객체를 가져온 후 출력*/ 
	}
	
	//재고 추가
	public void Add(MainFrame mf){
		new ProductAdd(iDao, mf);		//제품 생성창
		
		/* 
		 * 제품생성 Frame를 생성하여 
		 * new Inventory_Add(); 호출
		 * */
	}
	
	//판매프레임 창 출력
	public void SaleFrame(Product pro, JLabel num_jbl){
		
		new Iventory_Sale(pro,iDao, num_jbl);
		
		/*
		 * 사용자가 해당 제품의 판매하기 누르면 
		 * 제품판매 Dialog를 생성하여 
		new Inventory_Sale(선택한제품객체, InventoryDao); 을 실행
		*/
	}
	
}
