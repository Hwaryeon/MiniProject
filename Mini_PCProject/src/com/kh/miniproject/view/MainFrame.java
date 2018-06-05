package com.kh.miniproject.view;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

import com.kh.miniproject.seat.dao.SeatDao;

public class MainFrame extends JFrame{
	private JPanel panel;
	
	public MainFrame(){
		this.setSize(1200,800);
		this.setTitle("앗! 피시방비가 타이어보다 싸다!");
		
		new StartPanel(this);
		this.setVisible(true);
				
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
