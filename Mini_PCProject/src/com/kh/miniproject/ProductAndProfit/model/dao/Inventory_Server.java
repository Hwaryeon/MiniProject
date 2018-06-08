package com.kh.miniproject.ProductAndProfit.model.dao;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Inventory_Server extends Thread{

	JFrame jfm ;
	InventoryDao iDao = null;
	private int port = 190;
	
	public Inventory_Server(InventoryDao iDao){
		
		this.iDao = iDao;
		start();
		
	}
	
	public void run(){
		while(true)
			server();
	}
	
	public void server(){	
		
		ObjectOutputStream out =null;
		InputStream in = null;
		
		try(ServerSocket serversocket = new ServerSocket(port);
		Socket socket = serversocket.accept()){
			
			System.out.println("���� ����");
			
			if(socket.isConnected()){	//����Ȯ��
				
				ObjectOutputStream outs = new ObjectOutputStream(socket.getOutputStream());

				//â�� ����Ʈ ���� ����
				outs.writeObject(iDao.warehouse.size());
				//â�� ����Ʈ �̸��� ���� ����
				for(int i=0; i<iDao.warehouse.size() ; i++){
					outs.writeObject(iDao.warehouse.get(i).getNames());
					outs.writeObject(iDao.warehouse.get(i).getPrice());
				}
				
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
				String item = (String)ois.readObject();
				int num = Integer.parseInt((String)ois.readObject());
				
				System.out.println("������ ��ǰ : "+ item);
				System.out.println("������ ���� : " + num);

				String ip = ""+socket.getInetAddress();
				if(iDao.product_UserSale(item, num)){
					//��� ������ �Ⱦƹ�����!
					JOptionPane.showMessageDialog(null,ip+"������ "+ item+" �� "+num+"�� �����Ͽ����ϴ�.", "����Ȯ��", JOptionPane.ERROR_MESSAGE);
				}else
					JOptionPane.showMessageDialog(null,ip+"������ "+ item+" �� "+num+"�� �����ҷ�������\n ���� ��ǰ�̰ų� ��������ǰ������ ��������� ���Ƽ� �����Ͽ����ϴ�..", "����Ȯ��", JOptionPane.ERROR_MESSAGE);
				
				 
			}

		}catch(Exception ex){
			port += 1;
			System.out.println("����ڰ� ���� ����������"+ port + " ��Ʈ ����");
		}finally{
			System.out.println("���� �ѹ� ����");
		}
		

	}
}

