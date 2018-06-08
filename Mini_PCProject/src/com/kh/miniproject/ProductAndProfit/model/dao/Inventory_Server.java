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
			
			System.out.println("서버 오픈");
			
			if(socket.isConnected()){	//접속확인
				
				ObjectOutputStream outs = new ObjectOutputStream(socket.getOutputStream());

				//창고 리스트 갯수 전송
				outs.writeObject(iDao.warehouse.size());
				//창고 리스트 이름과 갯수 전송
				for(int i=0; i<iDao.warehouse.size() ; i++){
					outs.writeObject(iDao.warehouse.get(i).getNames());
					outs.writeObject(iDao.warehouse.get(i).getPrice());
				}
				
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
				String item = (String)ois.readObject();
				int num = Integer.parseInt((String)ois.readObject());
				
				System.out.println("가져온 제품 : "+ item);
				System.out.println("가져온 갯수 : " + num);

				String ip = ""+socket.getInetAddress();
				if(iDao.product_UserSale(item, num)){
					//재고에 접근해 팔아버리깃!
					JOptionPane.showMessageDialog(null,ip+"유저가 "+ item+" 을 "+num+"개 구매하였습니다.", "접속확인", JOptionPane.ERROR_MESSAGE);
				}else
					JOptionPane.showMessageDialog(null,ip+"유저가 "+ item+" 을 "+num+"개 구매할려했으나\n 없는 제품이거나 구매할제품갯수가 재고갯수보다 많아서 실패하엿습니다..", "접속확인", JOptionPane.ERROR_MESSAGE);
				
				 
			}

		}catch(Exception ex){
			port += 1;
			System.out.println("사용자가 강제 종료함으로"+ port + " 포트 변경");
		}finally{
			System.out.println("서버 한번 종료");
		}
		

	}
}

