package com.kh.miniproject.view;

import javax.swing.*;

public class MainFrame extends JFrame{
	private JPanel panel;
	
	public MainFrame(){
		this.setSize(1200,800);
		this.setTitle("앗! 피시방비가 타이어보다 싸다!");
		
//		new MemberJoinPanel(this);

		new MemberManagement(this);
		
		//new StartPanel(this);
		//new AddTimePanel(this);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
