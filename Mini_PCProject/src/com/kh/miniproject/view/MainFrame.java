package com.kh.miniproject.view;

import javax.swing.*;

public class MainFrame extends JFrame{
	private JPanel panel;
	
	public MainFrame(){
		this.setSize(1200,800);
		this.setTitle("��! �ǽù�� Ÿ�̾�� �δ�!");
		
		new StartPanel(this);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
