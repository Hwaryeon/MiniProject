package com.kh.miniproject.view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.miniproject.member.controller.MemberManager;
import com.kh.miniproject.view.decoration.RoundedButton;


public class MemberJoinPanel extends JPanel {
	private MainFrame mf;
	private MainPanel mp;

	MemberManager mm = new MemberManager();

	public MemberJoinPanel(MainFrame mf){
		this.mf = mf;

		this.setLayout(null);
		this.setSize(mf.getWidth(), mf.getHeight());
		this.setBackground(Color.BLACK);

		boolean overlapCheck = false;
		
		// �ڷΰ��� ��ư
		JButton goback = new JButton();
		Image back = new ImageIcon("icon/pointer.png").getImage().getScaledInstance(100, 100, 0);
		goback.setIcon(new ImageIcon(back));
		goback.setBorderPainted(false);
		goback.setBounds(25, 25, 100, 100);
		goback.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				StartPanel sp = new StartPanel(mf);
				changePanel(sp);
			}
		});
		this.add(goback);

		//��� ȸ������ �г� //�г� �� �󺧷� ����
		JPanel memberJoinText = new JPanel();
		memberJoinText.setLayout(null);
		memberJoinText.setLocation(300, 50);
		memberJoinText.setBackground(Color.WHITE);
		memberJoinText.setSize(600,100);
		JLabel titleLayer = new JLabel();
		Image titleLayerI = new ImageIcon("icon/titleLayer.png").getImage().getScaledInstance(600, 100, 0);
		titleLayer.setIcon(new ImageIcon(titleLayerI));
		titleLayer.setBounds(0, 0, 600, 100);
		//�г� �� "ȸ������" ��
		JLabel text = new JLabel("ȸ������");
		//text.setSize(200, 50);
		//text.setLocation(200, 25);
		text.setBounds(0, 0, 600, 100);
		text.setFont(new Font("���� ���", Font.BOLD, 40));
		text.setHorizontalAlignment(JTextField.CENTER);
		memberJoinText.add(text);
		memberJoinText.add(titleLayer);

		//ȸ�� ���� ���� �г� //
		JPanel joinMain = new JPanel();
		joinMain.setLayout(null);
		joinMain.setSize(1000,500);
		joinMain.setLocation(100, 200);
		joinMain.setBackground(Color.LIGHT_GRAY);


		//ȸ�� ���� �Է� �ؽ�Ʈ�ʵ�, ��
		JLabel id = new JLabel("���̵�");
		id.setFont(new Font("���� ���", Font.BOLD, 16));
		id.setBounds(30, 0, 100, 100);
		JTextField textId = new JTextField();
		textId.setFont(new Font("���� ���", Font.BOLD, 14));
		textId.setBounds(30, 70, 200, 30);

		JLabel pwd = new JLabel("��й�ȣ");
		pwd.setFont(new Font("���� ���", Font.BOLD, 16));
		pwd.setBounds(30, 80, 100, 100);		
		JTextField textPwd = new JTextField();		
		textPwd.setFont(new Font("���� ���", Font.BOLD, 14));	
		textPwd.setBounds(30, 150, 200, 30);

		JLabel name = new JLabel("�̸�");
		name.setFont(new Font("���� ���", Font.BOLD, 16));
		name.setBounds(30, 160, 100, 100);
		JTextField textName = new JTextField();
		textName.setFont(new Font("���� ���", Font.BOLD, 14));
		textName.setBounds(30, 230, 200, 30);

		JLabel phoneNum = new JLabel("��ȭ��ȣ");
		phoneNum.setFont(new Font("���� ���", Font.BOLD, 16));
		phoneNum.setBounds(30, 240, 100, 100);
		JTextField textPhoneNum = new JTextField();
		textPhoneNum.setFont(new Font("���� ���", Font.BOLD, 14));
		textPhoneNum.setBounds(30, 310, 200, 30);

		JLabel email = new JLabel("����");
		email.setFont(new Font("���� ���", Font.BOLD, 16));
		email.setBounds(30, 320, 100, 100);
		JTextField textEmail = new JTextField();
		textEmail.setFont(new Font("���� ���", Font.BOLD, 14));
		textEmail.setBounds(30, 390, 200, 30);
		
		JLabel joinSuccess = new JLabel();
		joinSuccess.setBounds(250, 435, 250, 50);
		joinSuccess.setBackground(Color.WHITE);
		joinSuccess.setFont(new Font("���� ���", Font.BOLD, 22));
		joinSuccess.setForeground(Color.RED);

		JButton overlap = new RoundedButton("ID �ߺ�Ȯ��");
		overlap.setBounds(250, 70, 130, 30);
		overlap.setForeground(Color.WHITE);
		overlap.setBackground(Color.black);
		overlap.setFont(new Font("���� ���", Font.BOLD, 16));

		Dialog overlapDialog = new Dialog(mf);
		overlapDialog.setBounds(500, 380, 200, 100);

		JButton dialogClose = new RoundedButton("�ݱ�");
		dialogClose.setBounds(50, 125, 50, 50);

		JLabel checkOverlap = new JLabel("�ߺ��� ���̵� �Դϴ�.");
		checkOverlap.setHorizontalAlignment(JLabel.CENTER);
		
		
		//boolean overlapCheck = false;
		
		overlapDialog.add(dialogClose, "South");
		overlapDialog.add(checkOverlap, "North");
		//�ߺ� �˻� �˾�â //checkOverlap ��� �����Ͽ� �ߺ� �˻� �ʿ�
		overlap.addActionListener(new ActionListener(){	
			@Override
			public void actionPerformed(ActionEvent e) {

				int check = mm.checkUser(textId.getText());

				System.out.println("check : "  + check);

				if(check == 0){		// �ߺ� x
					boolean overlapCheck = true;
					checkOverlap.setText("��� ������ ���̵��Դϴ�.");
				}else if(check == 1){	// �ߺ� o
					checkOverlap.setText("�ߺ��� ���̵� �Դϴ�.");
					boolean overlapCheck = false;
				}

				overlapDialog.setVisible(true);


			}

		});
		//�ߺ� �˻� �˾�â �ݱ� ��ư
		dialogClose.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {


				overlapDialog.setVisible(false);

			}

		});



		//�ð� �߰� ��ư
		JButton join = new RoundedButton("����");
		join.setBounds(30, 435, 100, 50);
		join.setBackground(Color.BLACK);
		join.setForeground(Color.WHITE);
		join.setFont(new Font("���� ���", Font.BOLD, 20));
		//�ð��߰� ��ư ��� ����
		join.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				if(textName.getText().equals("") || textId.getText().equals("")
						|| textPwd.getText().equals("")
						|| textEmail.getText().equals("")
						|| textPhoneNum.getText().equals("")
						|| overlapCheck == false
						){

					checkOverlap.setText("��� ������ �Է��ϼž��մϴ�.");
					overlapDialog.setVisible(true);
				}else{
					joinSuccess.setText("���� �Ϸ�Ǿ����ϴ�");
					mm.memberJoin(textName.getText(), textId.getText(),
							textPwd.getText(), textEmail.getText(),
							textPhoneNum.getText());
				}



			}

		});

		//����â
		JLabel capture = new JLabel();
		Image capImage = new ImageIcon("icon/project-1.PNG").getImage().getScaledInstance(450, 400, 0);
		capture.setIcon(new ImageIcon(capImage));
		capture.setBounds(500, 50, 450, 400);



		joinMain.add(joinSuccess);
		joinMain.add(join);
		joinMain.add(capture);
		joinMain.add(overlap);
		joinMain.add(email);
		joinMain.add(textEmail);
		joinMain.add(phoneNum);
		joinMain.add(textPhoneNum);
		joinMain.add(name);
		joinMain.add(textName);
		joinMain.add(id);
		joinMain.add(textId);
		joinMain.add(pwd);
		joinMain.add(textPwd);

		this.add(joinMain);
		this.add(memberJoinText);
		mf.add(this);

	}

	public void changePanel(JPanel panel)
	{
		mf.remove(this);
		mf.add(panel);
		mf.repaint();
	}


}
