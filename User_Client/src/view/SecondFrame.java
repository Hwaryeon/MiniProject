package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SecondFrame extends JFrame {
	
	private JPanel panel;
	   
	   public SecondFrame()
	   {
		   
	     this.setSize(600,1000);
	     this.setTitle("��! �ǽù�� Ÿ�̾�� �δ�!");
	     
	     new userBuy(this);
	     this.setVisible(true);
	   }
	      
}