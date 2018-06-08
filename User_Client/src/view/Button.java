package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Button extends JFrame {
	
	private MainFrame mf;
	
	public Button(MainFrame mf)
	{
		  this.mf = mf;
	      
		  JPanel start = new JPanel();
		  start.setLayout(null);
	      start.setSize(mf.getWidth(), mf.getHeight());
	      start.setBackground(Color.BLACK);
	      
	      JPanel member = new JPanel();
	      //member.setLayout(null);
	      member.setSize(400,300);
	      member.setLocation(85,180);
	      //member.setBackground(Color.GREEN);
	      
	      JLabel imgLabel = new JLabel();
	      Image orderImg = new ImageIcon("icon/order.PNG").getImage().getScaledInstance(400, 300, 0);
	      imgLabel.setIcon(new ImageIcon(orderImg));
	      imgLabel.setBounds(0, 0, 400, 300);
	      member.add(imgLabel);
	      
	    //=================================================
	      JPanel memberManagePanel = new JPanel();
	      memberManagePanel.setSize(400, 180);
	      memberManagePanel.setLocation(85, 10);
	      //memberManagePanel.setBackground(Color.WHITE);
	    //=================================================
	      //JLabel orderL = new JLabel("±∏∏≈");
	      JLabel orderL = new JLabel();
	      Image imgL = new ImageIcon("icon/orderLabel.PNG").getImage().getScaledInstance(400, 180, 0);
	      orderL.setIcon(new ImageIcon(imgL));
	      orderL.setBounds(0, 0, 400, 180);
	      memberManagePanel.add(orderL);
	      
	     /* text.setSize(300, 50);
	      text.setLocation(85, 80);
	      text.setForeground(Color.BLACK);
	      text.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 40));
	      text.setHorizontalAlignment(JLabel.CENTER);
	      memberManagePanel.add(text);      */
	    //=================================================
	      JButton profitV = new JButton("ªÛ«∞∏Ò∑œ ∫∏±‚");
	      profitV.setBounds(150, 500, 250, 50);
	      profitV.setForeground(Color.BLACK);
	      profitV.setBackground(Color.WHITE);
	      profitV.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 16));
	      start.add(profitV);
	      
	      profitV.addActionListener(
	              new ActionListener()
	              {
	                 @Override
	                 public void actionPerformed(ActionEvent arg0) 
	                 {
	                	 new SecondFrame();

	                 }
	              });
	      
	    //=================================================
	     
	      mf.add(profitV);
	      mf.add(memberManagePanel);  
	      mf.add(member);
	      mf.add(start);

	}
}
