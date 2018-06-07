package com.kh.miniproject.view;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainFrame extends JFrame{
	private JPanel panel;
	
	public MainFrame(){
		this.setSize(1200,800);
		this.setTitle("��! �ǽù�� Ÿ�̾�� �δ�!");
		
		new StartPanel(this);
		
		try {
			this.setIconImage(ImageIO.read(new File("icon/t1.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
