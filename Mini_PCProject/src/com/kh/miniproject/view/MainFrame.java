package com.kh.miniproject.view;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	private JPanel panel;
	public static boolean only_one = true;
	
	
	public MainFrame(){
		this.setSize(1200,800);
		this.setTitle("앗! 피시방비가 타이어보다 싸다!");
		
		new StartPanel(this);
		//new Product_Panel(this);
		try {
			this.setIconImage(ImageIO.read(new File("icon/t1.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
