package com.kh.miniproject.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.miniproject.event.MyMouseAdapter;
import com.kh.miniproject.seat.model.dao.SeatDao;
import com.kh.miniproject.view.decoration.RoundedButton;

public class StartPanel extends JPanel
{
	private MainFrame mf;
	
	public StartPanel(MainFrame mf)
	{
		this.mf = mf;
		
		this.setLayout(null);
		this.setSize(mf.getWidth(), mf.getHeight());
		this.setBackground(Color.BLACK);
		
		//회원가입 버튼
		JButton signup = new RoundedButton("회원가입");
		signup.setFont(new Font("맑은 고딕", Font.BOLD, 18));
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
		
		//타이틀
		JPanel titlep = new JPanel();
		titlep.setLayout(null);
		titlep.setBackground(Color.BLACK);
		titlep.setBounds(300, 150, 600, 170);
		JLabel title = new JLabel("앗! 피시방비가 타이어보다 싸다!");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		title.setForeground(Color.WHITE);
		title.setBounds(0, 25, 600, 50);
		titlep.add(title);
		JLabel mode = new JLabel("관리자모드");
		mode.setHorizontalAlignment(JLabel.CENTER);
		mode.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		mode.setForeground(Color.WHITE);
		mode.setBounds(0, 100, 600, 50);
		titlep.add(mode);
		this.add(titlep);

		mode.addMouseListener(new MyMouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				SeatDao sd = new SeatDao();
				sd.seatLeset();
				System.out.println("좌석 초기화...");
			}
		});
		
		
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
		login.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		login.setBackground(Color.WHITE);
		login.setBounds(100,140,190,50);
		login.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				char[] pwdCheck = pw.getPassword();
				String pwd = "";
				
				for(int i=0; i < pwdCheck.length; i++){
					pwd += pwdCheck[i];
				}
				
				if(id.getText().equals("admin") && pwd.equals("1234")){
					MainPanel mp = new MainPanel(mf);
					changePanel(mp);
				}else{
					System.out.println("입력정보가 맞지않습니다.");
				}
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
