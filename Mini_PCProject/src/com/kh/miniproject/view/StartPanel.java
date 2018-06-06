package com.kh.miniproject.view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import com.kh.miniproject.view.decoration.*;


public class StartPanel extends JPanel
{
	private MainFrame mf;
	
	public StartPanel(MainFrame mf)
	{
		this.mf = mf;
		
		this.setLayout(null);
		this.setSize(mf.getWidth(), mf.getHeight());
		this.setBackground(Color.BLACK);
		
		//È¸¿ø°¡ÀÔ ¹öÆ°
		JButton signup = new RoundedButton("È¸¿ø°¡ÀÔ");
		signup.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		signup.setBackground(Color.WHITE);
		signup.setSize(200, 50);
		signup.setLocation(50, 50);
		signup.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				MemberJoinPanel mjp = new MemberJoinPanel(mf);
				changePanel(mjp);
			}
		});
		this.add(signup);
		
		//Å¸ÀÌÆ²
		JPanel titlep = new JPanel();
		titlep.setLayout(null);
		titlep.setBackground(Color.BLACK);
		titlep.setBounds(300, 150, 600, 170);
		JLabel title = new JLabel("¾Ñ! ÇÇ½Ã¹æºñ°¡ Å¸ÀÌ¾îº¸´Ù ½Î´Ù!");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 40));
		title.setForeground(Color.WHITE);
		title.setBounds(0, 25, 600, 50);
		titlep.add(title);
		JLabel mode = new JLabel("°ü¸®ÀÚ¸ðµå");
		mode.setHorizontalAlignment(JLabel.CENTER);
		mode.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 40));
		mode.setForeground(Color.WHITE);
		mode.setBounds(0, 100, 600, 50);
		titlep.add(mode);
		this.add(titlep);

		
		JPanel loginp = new JPanel();
		loginp.setLayout(null);
		loginp.setBounds(400, 350, 400, 300);
		loginp.setBackground(Color.BLACK);
		
		JLabel idicon = new JLabel();
		Image icon = new ImageIcon("icon/id.png").getImage().getScaledInstance(50, 50, 0);
		idicon.setIcon(new ImageIcon(icon));
		idicon.setBounds(25, 20, 50, 50);
		
		JTextField id = new JTextField(16);
		id.setBounds(80, 20, 300, 50);
		id.setEditable(true);
		
		JLabel pwicon = new JLabel();
		icon = new ImageIcon("icon/pw.png").getImage().getScaledInstance(50, 50, 0);
		pwicon.setIcon(new ImageIcon(icon));
		pwicon.setBounds(25, 75, 50, 50);
		pwicon.setBackground(Color.WHITE);
		
		JPasswordField pw = new JPasswordField(16);
		pw.setEditable(true);
		pw.setBounds(80,75,300,50);
		
		JButton login = new RoundedButton("Login");
		login.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		login.setBackground(Color.WHITE);
		login.setBounds(100,140,190,50);
		login.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
				/*if(id.getText().equals("admin") && pw.getText().equals("1234")){
					
					MainPanel mp = new MainPanel(mf);
					changePanel(mp);
					
				}else{
					System.out.println("¿À·ù");
				}*/
				MainPanel mp = new MainPanel(mf);
				changePanel(mp);
				
			}
		});
		
		loginp.add(idicon);
		loginp.add(pwicon);
		loginp.add(id);
		loginp.add(pw);
		loginp.add(login);
		
		
		this.add(loginp);
		
		mf.add(this);
		
	}
	
	public void changePanel(JPanel panel)
	{
		mf.remove(this);
		mf.add(panel);
		mf.repaint();
	}
}
