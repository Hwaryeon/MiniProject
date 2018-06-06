package com.kh.miniproject.ProductAndProfit.controller;

import java.util.ArrayList;

import javax.swing.JLabel;

import com.kh.miniproject.ProductAndProfit.dao.InventoryDao;
import com.kh.miniproject.ProductAndProfit.vo.Product;
import com.kh.miniproject.view.MainFrame;
import com.kh.miniproject.view.ProductAdd_Frame.Iventory_Sale;
import com.kh.miniproject.view.ProductAdd_Frame.ProductAdd;


public class Inventory_Management {

	InventoryDao iDao = null;
	public Product pro = null;
	//�ӽ��Է�
	java.util.Scanner sc = new java.util.Scanner(System.in);
	
	//InventoryDaoȣ��
	public Inventory_Management() {
		iDao = new InventoryDao();
	}

	//ī�װ� ��ȸ
	public ArrayList<Product> Record(String kinds){
		
		return iDao.product_Record(kinds);
		
		/*
		 * ī�װ� ��ȸ ���ý� �ش� ������ �ִ� ��� ��� ���
		 * 
		 */
	}
	
	//��� �˻�â
	public ArrayList<Product> Seach(String name){
		return iDao.product_Seach(name);
		
		/*product_Seach(�Էµ� �̸�)�� �ε����� ��ǰ�� ��ü�� ������ �� ���*/ 
	}
	
	//��� �߰�
	public void Add(MainFrame mf){
		new ProductAdd(iDao, mf);		//��ǰ ����â
		
		/* 
		 * ��ǰ���� Frame�� �����Ͽ� 
		 * new Inventory_Add(); ȣ��
		 * */
	}
	
	//�Ǹ������� â ���
	public void SaleFrame(Product pro, JLabel num_jbl){
		
		new Iventory_Sale(pro,iDao, num_jbl);
		
		/*
		 * ����ڰ� �ش� ��ǰ�� �Ǹ��ϱ� ������ 
		 * ��ǰ�Ǹ� Dialog�� �����Ͽ� 
		new Inventory_Sale(��������ǰ��ü, InventoryDao); �� ����
		*/
	}
	
}
