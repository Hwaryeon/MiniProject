package dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import IProfit.IProfit;
import vo.Product;
import vo.Profit;

public class InventoryDao implements IProfit{

	ArrayList<Product> warehouse = new ArrayList<Product>();	//��� ��ǰ���� ��� ��ü
	Profit profit = null;
	public InventoryDao() {
		/* "Inventory.dat"�� ���� ����� warehouse ������ �����´�.*/

		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Inventory.dat"));){

			warehouse = (ArrayList<Product>)ois.readObject();

		}catch(FileNotFoundException e){
			System.out.println("������ �����Ƿ� �ҷ��ü������ϴ�.");
		}catch(EOFException e){
			System.out.println("EOF����");
		}catch(IOException e){
			System.out.println("IO���ܹ߻�");
		}catch (ClassNotFoundException e) {
			System.out.println("Ŭ������ ã������ ���ٰ���");
		}


		profit = new Profit();
	}

	//ī�װ� ��ȸ
	public ArrayList<Product> product_Record(String kind){
		
		ArrayList<Product> category_box = new ArrayList<Product>();
		
		for(int i=0; i<warehouse.size() ; i++){
			if(warehouse.get(i).getKind().equals(kind)){
				category_box.add(warehouse.get(i));
			}
		}

		if(category_box.isEmpty()){
			System.out.println("�ش��ϴ� ������ ��ǰ�� ���������ʽ��ϴ�. null��ȯ");
		}
		
		return category_box;
		
		/*ī�װ� ��ȸ ���ý� �Ű�����kind ī�װ��� �ִ� ��� ��� ���
			warehouse����  ��ü������ �о�´�.*/
	}

	//��� �̸� �˻�
	public ArrayList<Product> product_Seach(String name){
		
		ArrayList<Product> seach_box = new ArrayList<Product>();
		
		for(int i=0; i<warehouse.size() ; i++){
			if(warehouse.get(i).getNames().contains(name)){
				seach_box.add(warehouse.get(i));
			}
		}
		
		return seach_box;
		/*warehouse���� name����� ��ü ��ȯ*/
	}
	
	//��� �Ǹ�
	public void product_Sale(Product pro, int Quantity){

		System.out.println("�̸� : "+ pro.getNames());
		System.out.println("���� : "+ pro.getKind());
		System.out.println("�ǸŰ��� : "+ Quantity);

		//�̸��� ������ ���ÿ� ���� ��ǰ�� ã�´�.
		for(int i=0; i<warehouse.size(); i++){
			if(pro.getKind().equals(warehouse.get(i).getKind()) &&
					pro.getNames().equals(warehouse.get(i).getNames())){
				//���� �������ִ� �������� �Ǹŵ� ������ �����Ѵ�.
				//�� ���� �����Ѵ�.
				warehouse.get(i).setCount(warehouse.get(i).getCount()-Quantity);	//�������
				Add_Money(Quantity*warehouse.get(i).getPrice());					//���Ͱ���
				//����
				product_Save();
				System.out.println("�ǸŰ� ���������� �̷�������ϴ�.");
				return;
			}
		}

		System.out.println("�� ���� ������������!");
		
		/*
		 * ��ü�� ������ش� �׷��� �� ��ü���� ��������� �־��� ������ �����.
		 * */
		//product_Save(); ���� �����Ѵ�.
	}

	//��� �߰�
	public void product_Add(Product pro){

		for(int i=0; i<warehouse.size() ; i++){
			if(warehouse.get(i).getNames().equals(pro.getNames())){
				warehouse.get(i).setCount(warehouse.get(i).getCount()+pro.getCount());
				product_Save();
				JOptionPane.showMessageDialog(null, "���� �̸��� ��ǰ�� �����Ƿ�\n���� "+pro.getCount()+"�� �� �߰��˴ϴ�.", "�Է� ����", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		
		System.out.println(pro);
		warehouse.add(pro);
		product_Save();
		/*�Ű����� product�� warehouse.add ���� �߰�*/
		//product_Save(); ���� �����Ѵ�.
	}



	//����޼ҵ�
	private void product_Save(){
		/*��ȯ�� warehouse�� �����Ѵ�.*/

		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Inventory.dat"));){

			oos.writeObject(warehouse);
			System.out.println("����Ϸ�!");
		}catch(FileNotFoundException e){
			System.out.println("������ �����Ƿ� �ҷ��ü������ϴ�.");
		}catch(EOFException e){
			System.out.println("EOF����");
		}catch(IOException e){
			System.out.println("IO���ܹ߻�");
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	//������ ����
	@Override
	public void Add_Money(int money){
		
		System.out.println("�̵� + " + money);
		profit.setItem_M(money);

		/*
		 * inven_S.Add_Money()�� �����Ͽ� ����Ǿ��ִ� 
		 * �ѱݾ��� profit.setItem()�� �����Ѵ�. 
		 * 
		 */
	}

}
