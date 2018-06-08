package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	private JPanel panel;
	   
	   public MainFrame()
	   {
		   
	     this.setSize(575,700);
	     this.setTitle("앗! 피시방비가 타이어보다 싸다!");
	      //new StartPanel(this);
	      //new AddTimePanel(this);
	      //new Profit_view(this);
	     new Button(this);
	     this.setVisible(true);
	     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   }
	      
}

