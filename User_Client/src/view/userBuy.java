package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class userBuy extends JFrame {
	
	private SecondFrame sf;
	int list_num = 5;
	String[] item_name = null;
	int[] item_price = null;
	Socket socket = null;
	
	//이름 가격 개수 
	public userBuy(SecondFrame sf)
	{
			      
		  this.sf = sf;
		  sf.setSize(600 , 700);
		  
		  //관리자에서 리스트 가져오기
		  try{
			this.socket = new Socket("192.168.20.47", 191);		//기본포트 190
			
			if(socket.isConnected()){
				System.out.println("열림");
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

				this.list_num = (Integer)ois.readObject();
				this.item_name = new String[list_num];
				this.item_price = new int[list_num];
				
				for(int i=0; i< list_num; i++){
					item_name[i] = (String)ois.readObject();
					item_price[i] = (Integer)ois.readObject();
					System.out.println("이름 : "+ item_name[i] + "\t 가격 : "+ item_price[i]);
				}
			}
		  }catch(Exception ex){
			  
		  }
		  
		  JPanel start1 = new JPanel();
		  start1.setLayout(null);
	      start1.setSize(this.getWidth(), this.getHeight());
	      start1.setBackground(Color.BLACK);
		  	      
	      JPanel member1 = new JPanel();
	      member1.setLayout(null);
	      member1.setSize(400, 700);
	      member1.setLocation(85,30);
	      member1.setBackground(Color.BLACK);
	      member1.setBorder(null);
	      
	      
	    //=================================================
	      
	      JPanel memberManagePanel1 = new JPanel();
	      memberManagePanel1.setSize(400,70);
	      memberManagePanel1.setLocation(85, 30);
	      memberManagePanel1.setBackground(Color.BLACK);
	      
	      
	    //=================================================
	      
	      JLabel text1 = new JLabel("음식 리스트");
	      text1.setSize(600, 150);
	      text1.setLocation(85, 100);
	      text1.setForeground(Color.WHITE);
	      text1.setFont(new Font("맑은 고딕", Font.BOLD, 40));
	      text1.setHorizontalAlignment(JLabel.CENTER);
	      memberManagePanel1.add(text1);
	        
	    //=================================================
	      
	     
	      
	      JLabel[] ItemName = new JLabel[list_num];
	      JTextField[] ItemNamet = new JTextField[list_num];
	      
	      JLabel[] ItemPrice = new JLabel[list_num];
	      JTextField[] ItemPricet = new JTextField[list_num];
	      for(int i = 0; i < list_num; i++)
	      {
	      
	      ItemNamet[i] = new JTextField(4);
	      ItemNamet[i].setEditable(false);
	      ItemNamet[i].setBounds(85, 120 +(i * 60) ,100, 30);
	      ItemNamet[i].setForeground(Color.BLACK);
	      ItemNamet[i].setBackground(Color.WHITE);
	      ItemNamet[i].setFont(new Font("맑은 고딕", Font.BOLD, 16));
	      ItemNamet[i].setLayout(null);
	      ItemNamet[i].setText(item_name[i]);			//재고 이름 
	      
	      ItemName[i] = new JLabel("상품이름");
	      ItemName[i].setForeground(Color.WHITE);
	      ItemName[i].setBounds(10, 85 +(i * 60), 100, 100);
	      ItemName[i].setFont(new Font("맑은 고딕", Font.BOLD, 16));
	      ItemName[i].setLayout(null);
	      member1.add(ItemName[i]);
	      member1.add(ItemNamet[i]);
	      
	      
	      
	      ItemPricet[i] = new JTextField(4);
	      ItemPricet[i].setEditable(false);
	      ItemPricet[i].setBounds(265, 120 +(i * 60) ,100, 30);
	      ItemPricet[i].setForeground(Color.BLACK);
	      ItemPricet[i].setBackground(Color.WHITE);
	      ItemPricet[i].setFont(new Font("맑은 고딕", Font.BOLD, 16));
	      ItemPricet[i].setLayout(null);
	      ItemPricet[i].setText(""+item_price[i]);		//재고 가격
	      
	      ItemPrice[i] = new JLabel("상품가격");
	      ItemPrice[i].setForeground(Color.WHITE);
	      ItemPrice[i].setBounds(190, 85 +(i * 60), 100, 100);
	      ItemPrice[i].setFont(new Font("맑은 고딕", Font.BOLD, 16));
	      ItemPrice[i].setLayout(null);
	      member1.add(ItemPrice[i]);
	      member1.add(ItemPricet[i]);
	      
	      }

	      JTextField name = new JTextField(5);
	      name.setBounds(85, 400, 100, 50);
	      JTextField nameT = new JTextField("상품이름");
	      nameT.setBounds(15, 400, 60, 50);
	      nameT.setHorizontalAlignment(JLabel.CENTER);
	      nameT.setBackground(Color.BLACK);
	      nameT.setForeground(Color.WHITE);
	      member1.add(nameT);
	      nameT.setEditable(false);
	      member1.add(name);
	      
	      
	      JTextField count = new JTextField(5);
	      count.setBounds(265, 400, 100, 50);
	      JTextField countT = new JTextField("개수");
	      countT.setBounds(195, 400, 60, 50);
	      countT.setHorizontalAlignment(JLabel.CENTER);
	      countT.setBackground(Color.BLACK);
	      countT.setForeground(Color.WHITE);
	      member1.add(countT);
	      countT.setEditable(false);
	      member1.add(count);
	      
	      JButton profitV1 = new JButton("물품 구매");
	      profitV1.setBounds(160, 530, 250, 50);
	      profitV1.setForeground(Color.WHITE);
	      profitV1.setBackground(Color.BLACK);
	      profitV1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
	      member1.add(profitV1);
	      
	      profitV1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				try(ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())){
					
					out.writeObject(name.getText());
					out.writeObject(count.getText());
					
				}catch(IOException ex){
				}finally{
					try {
						socket.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					sf.dispose();
				}
			}
	      });
	      
	     
	      sf.add(profitV1);
	      sf.add(memberManagePanel1);  
	      sf.add(member1);
	      sf.add(start1);
			 
	      
	}
}
