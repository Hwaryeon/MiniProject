package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SecondFrame extends JFrame {
	
	private JPanel panel;
	   
	   public SecondFrame()
	   {
		   
	     this.setSize(600,1000);
	     this.setTitle("앗! 피시방비가 타이어보다 싸다!");
	     
	     new userBuy(this);
	     this.setVisible(true);
	   }
	      
}