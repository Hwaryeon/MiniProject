package com.kh.miniproject.view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class StartPanel extends JFrame
{
	private MainFrame mf;
	private JPanel mp;
	
	public StartPanel(MainFrame mf)
	{
		this.mf = mf;
		
		//System.out.println(mf.getWidth() + ", " + mf.getHeight());
		
		
		JPanel start = new JPanel();
		start.setLayout(null);
		start.setSize(mf.getWidth(), mf.getHeight());
		start.setBackground(Color.BLACK);
		this.mp = start;
		
		//È¸¿ø°¡ÀÔ ¹öÆ°
		JButton signup = new JButton("È¸¿ø·Î±×ÀÎ");
		signup.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		signup.setBackground(Color.WHITE);
		signup.setSize(200, 50);
		start.add(signup);
		signup.setLocation(50, 50);
		signup.addMouseListener(new MyMouseAdapter());
		
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
		start.add(titlep);

		
		JPanel loginp = new JPanel();
		loginp.setLayout(null);
		loginp.setBounds(400, 350, 400, 300);
		loginp.setBackground(Color.BLACK);
		
		JLabel idicon = new JLabel();
		Image icon = new ImageIcon("icon/id2.png").getImage().getScaledInstance(50, 50, 0);
		idicon.setIcon(new ImageIcon(icon));
		idicon.setBounds(25, 20, 50, 50);
		
		JTextField id = new JTextField(16);
		id.setBounds(80, 20, 300, 50);
		id.setEditable(true);
		
		JLabel pwicon = new JLabel();
		icon = new ImageIcon("icon/password2.png").getImage().getScaledInstance(50, 50, 0);
		pwicon.setIcon(new ImageIcon(icon));
		pwicon.setBounds(25, 75, 50, 50);
		pwicon.setBackground(Color.WHITE);
		
		JPasswordField pw = new JPasswordField(16);
		pw.setEditable(true);
		pw.setBounds(80,75,300,50);
		
		JButton login = new JButton("Login");
		login.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		login.setBackground(Color.WHITE);
		login.setBounds(100,140,190,50);
		
		loginp.add(idicon);
		loginp.add(pwicon);
		loginp.add(id);
		loginp.add(pw);
		loginp.add(login);
		
		
		start.add(loginp);
		
		mf.add(start);
		
	}
	
	class MyMouseAdapter extends MouseAdapter 
	{
		@Override
		public void mouseClicked(MouseEvent e)
		{
			replace();
		}
	}
	
	public JPanel callMain()
	{
		mp = new MainPanel(mf);
		return mp;
	}
	
	public void replace()
	{
		this.remove(mp);
		this.mp = callMain();
		this.add(mp);
		this.repaint();
	}
}
