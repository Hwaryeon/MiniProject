package com.kh.miniproject.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GamePanel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	private JLabel pororo;
	private JTextField scoreLabel;
	private JLabel[] arrows;
	private ArrayList<JLabel> inputs;
	private int[] arrNo;
	private int x = 50;
	private int x2 = 50;
	private int index = 0;
	private int ctn = 0;
	public static int point = 0;
	private String userId;

	public GamePanel(JFrame mf) {
		this.mf = mf;
		panel = this;
		this.setBackground(Color.blue);

		arrows = new JLabel[10];
		inputs = new ArrayList<JLabel>();
		arrNo = new int[10];

		this.setBounds(0, 0, 1000, 800);
		scoreLabel();
		System.out.println("패널생성");

		//pororoInit();
		//buttonInit();

		mf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int num = 0;


				if(e.getKeyCode() == KeyEvent.VK_UP) {
					num = 4;
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					num = 2;
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					num = 1;
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					num = 3;
				}


				//addButton(num);
				ctn++;
				

			}

		});



	}

/*	public void pororoInit(){
		System.out.println("뽀로로초기화");
		URL url = getClass().getClassLoader().getResource("pororo-0.png");
		System.out.println(url);
		pororo = new JLabel(new ImageIcon(url));
		
		pororo.setBounds(350, 50, 300, 450);
		
		this.add(pororo);
		
		repaint();
	}*/
/*
	public void buttonInit(){
		x=50;

		for(int i = 0; i < arrows.length; i++) {
			int num = new Random().nextInt(4) + 1;
			arrNo[i] = num;
			URL url = getClass().getClassLoader().getResource(num+"-blue.png");
			arrows[i] = new JLabel(new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(80, 80, 0)));
			arrows[i].setBounds(x, 500, 80, 80);
			x += 90;
			this.add(arrows[i]);
			this.repaint();

		}

	}*/



	/*public void addButton(int num) {
		//x2=50;


		if(index >= 10){
			reset();
			index = 0;
		}else{
			System.out.println("index : " + index);

			String color = "";
			if(arrNo[index] == num) {
				color = "green";
				URL url = getClass().getClassLoader().getResource("pororo-"+num+".png");
				pororo.setIcon(new ImageIcon(url));
				point += 50;
				scoreLabel.setText("SCORE : " + point);
				this.setBackground(Color.BLUE);
				scoreLabel.setBackground(Color.BLUE);
				
			}else {
				color = "red";
				pororo.setIcon(new ImageIcon("images/pororo-6.png"));
				this.setBackground(Color.RED);
				scoreLabel.setBackground(Color.red);
			}
			URL url = getClass().getClassLoader().getResource(num + "-" + color + ".png");
			JLabel input = new JLabel(new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(80, 80, 0)));
			input.setBounds(x2, 600, 80, 80);
			inputs.add(input);
			x2 += 90;
			this.add(inputs.get(index));
			this.repaint();
			index++;
		}


	}*/

/*	public void reset(){

		System.out.println("오니");
		this.remove(pororo);
		pororoInit();

		for (int i = 0; i < arrows.length; i++) {
			this.remove(arrows[i]);
			this.repaint();
		}
		buttonInit();

		for (int i = 0; i < arrNo.length; i++) {
			this.remove(this.inputs.get(i));
			this.repaint();
		}
		
		inputs.clear();

		//mf.add(this);
		mf.repaint();
		index = 0;
		x = 50;
		x2 = 50;
	}*/
	
	public void scoreLabel(){
		scoreLabel = new JTextField("SCORE : " + point);
		scoreLabel.setFont(new Font("Sanscerif", Font.BOLD, 20));
		scoreLabel.setBorder(BorderFactory.createEmptyBorder());
		scoreLabel.setBackground(Color.blue);
		this.setComponentZOrder(scoreLabel, 0);
		scoreLabel.setBounds(20, 0, 200, 50);
		this.add(scoreLabel);
	}
	
	public void setUserId(String userId){
		this.userId = userId;
		
		System.out.println(this.userId);
	}
	
}
