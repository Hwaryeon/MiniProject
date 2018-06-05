package com.kh.miniproject.view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
		
		//ȸ������ ��ư
		JButton signup = new RoundedButton("ȸ������");
		signup.setFont(new Font("���� ���", Font.BOLD, 18));
		//signup.setBackground(Color.WHITE);
		signup.setSize(200, 50);
		this.add(signup);
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
		
		//Ÿ��Ʋ
		JPanel titlep = new JPanel();
		titlep.setLayout(null);
		titlep.setBackground(Color.BLACK);
		titlep.setBounds(300, 150, 600, 170);
		JLabel title = new JLabel("��! �ǽù�� Ÿ�̾�� �δ�!");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("���� ���", Font.BOLD, 40));
		title.setForeground(Color.WHITE);
		title.setBounds(0, 25, 600, 50);
		titlep.add(title);
		JLabel mode = new JLabel("�����ڸ��");
		mode.setHorizontalAlignment(JLabel.CENTER);
		mode.setFont(new Font("���� ���", Font.BOLD, 40));
		mode.setForeground(Color.WHITE);
		mode.setBounds(0, 100, 600, 50);
		titlep.add(mode);
		this.add(titlep);

		
		JPanel loginp = new JPanel();
		loginp.setLayout(null);
		loginp.setBounds(400, 350, 400, 300);
		loginp.setBackground(Color.BLACK);
		
		JPanel idPanel = new JPanel();
		idPanel.setLayout(null);
		idPanel.setBackground(null);
		idPanel.setBounds(25, 20, 50, 50);
		JLabel idicon = new JLabel();
		Image icon = new ImageIcon("icon/user (2).png").getImage().getScaledInstance(50, 50, 0);
		idicon.setIcon(new ImageIcon(icon));
		idPanel.add(idicon);
		idicon.setBounds(0, 0, 50, 50);
		
		JTextField id = new JTextField(16);
		id.setBounds(80, 20, 300, 50);
		id.setEditable(true);
		
		JPanel pwPanel = new JPanel();
		pwPanel.setLayout(null);
		pwPanel.setBackground(null);
		pwPanel.setBounds(25, 75, 50, 50);
		JLabel pwicon = new JLabel();
		icon = new ImageIcon("icon/pw.png").getImage().getScaledInstance(50, 50, 0);
		pwicon.setIcon(new ImageIcon(icon));
		pwPanel.add(pwicon);
		pwicon.setBounds(0, 0, 50, 50);
		
		JPasswordField pw = new JPasswordField(16);
		pw.setEditable(true);
		pw.setBounds(80,75,300,50);
		
		JButton login = new JButton("Login");
		login.setFont(new Font("���� ���", Font.BOLD, 18));
		//login.setBackground(Color.WHITE);
		login.setBounds(100,140,190,50);
		login.addMouseListener(new MouseAdapter() 
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					MainPanel mp = new MainPanel(mf);
					changePanel(mp);
				}
			});
		
		loginp.add(idPanel);
		loginp.add(pwPanel);
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
