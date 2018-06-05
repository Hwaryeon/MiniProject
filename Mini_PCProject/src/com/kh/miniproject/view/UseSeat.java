package com.kh.miniproject.view;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.miniproject.member.controller.MemberManager;
import com.kh.miniproject.member.vo.Member;
import com.kh.miniproject.seat.controller.SeatManager;
import com.kh.miniproject.view.decoration.RoundedButton;


public class UseSeat extends JPanel{
	private MainFrame mf;
	private JPanel mp;
	private MemberManager mm = new MemberManager();

	private SeatManager sm = new SeatManager();

	public UseSeat(MainFrame mf, int seatNo){
		this.mf = mf;

		//���� �����Ӱ� ���� �������� �г�
		//JPanel start = new JPanel();

		//�ڷΰ��� ��ư
		JButton goback = new JButton();
		Image back = new ImageIcon("icon/pointer.png").getImage().getScaledInstance(100, 100, 0);
		goback.setIcon(new ImageIcon(back));
		goback.setBounds(25, 25, 100, 100);
		goback.setBorderPainted(false);
		goback.setBackground(null);
		goback.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				MainPanel mPanel = new MainPanel(mf);
				changePanel(mPanel);
			}
		});
		this.add(goback);


		System.out.println("seatNo : " + seatNo);

		this.setLayout(null);
		this.setSize(mf.getSize());
		this.setBackground(Color.BLACK);

		//��� ���� �г� //�г� �� �󺧷� ����
		JPanel usePanel = new JPanel();
		usePanel.setLayout(null);
		usePanel.setLocation(300, 50);
		usePanel.setBackground(Color.WHITE);
		usePanel.setSize(600,100);
		JLabel titleLayer = new JLabel();
		Image titleLayerI = new ImageIcon("icon/titleLayer.png").getImage().getScaledInstance(600, 100, 0);
		titleLayer.setIcon(new ImageIcon(titleLayerI));
		titleLayer.setBounds(0, 0, 600, 100);
		//�г� �� ���� ��
		JLabel text = new JLabel("�¼� �߰�");
		text.setSize(300, 50);
		text.setLocation(150, 25);
		text.setBackground(Color.GREEN);
		text.setFont(new Font("���� ���", Font.BOLD, 40));
		text.setHorizontalAlignment(JTextField.CENTER);
		usePanel.add(text);
		usePanel.add(titleLayer);

		//�¼��߰� ���� �г� //
		JPanel timeMain = new JPanel();
		timeMain.setLayout(null);
		timeMain.setSize(1000,500);
		timeMain.setLocation(100, 200);
		timeMain.setBackground(Color.LIGHT_GRAY);
		//������
		JLabel iconLabel = new JLabel();
		Image icon = new ImageIcon("icon/addSeat.PNG").getImage().getScaledInstance(100, 100, 0);
		iconLabel.setIcon(new ImageIcon(icon));
		iconLabel.setBounds(20, 20, 100, 100);
		//"�¼��߰�" �ؽ�Ʈ�ʵ�
		JTextField addTime = new JTextField("�¼� �߰�");
		addTime.setSize(300,100);
		addTime.setLocation(150, 20);
		addTime.setBackground(Color.BLACK);
		addTime.setForeground(Color.WHITE);
		addTime.setEditable(false);
		addTime.setFont(new Font("���� ���", Font.BOLD, 30));
		addTime.setHorizontalAlignment(JTextField.CENTER);
		//ID, �����ݾ� �Է� �ؽ�Ʈ�ʵ�
		JLabel id = new JLabel("ȸ�� ���̵�");
		JLabel seatNoL = new JLabel("�¼���ȣ");
		id.setFont(new Font("���� ���", Font.BOLD, 16));
		seatNoL.setFont(new Font("���� ���", Font.BOLD, 16));
		id.setBounds(30, 130, 100, 100);
		seatNoL.setBounds(30, 230, 100, 100);
		JTextField textId = new JTextField();
		textId.setFont(new Font("���� ���", Font.BOLD, 14));
		textId.setBounds(30, 200, 200, 30);

		JTextField textSeatNo = new JTextField();
		textSeatNo.setText(seatNo+"�� �¼�");
		textSeatNo.setHorizontalAlignment(JLabel.CENTER);
		textSeatNo.setFont(new Font("���� ���", Font.BOLD, 24));
		textSeatNo.setEditable(false);
		textSeatNo.setBounds(30, 300, 200, 50);

		//�¼� �߰� ��ư
		JButton add = new RoundedButton("�¼��߰�");
		add.setBounds(30, 400, 150, 70);
		add.setBackground(Color.BLACK);
		add.setFont(new Font("���� ���", Font.BOLD, 20));
		add.setForeground(Color.WHITE);
		//�ߺ� ID ��� ��
		JLabel idOverlap = new JLabel();
		idOverlap.setBounds(250, 165, 350, 100);
		idOverlap.setForeground(Color.RED);
		idOverlap.setFont(new Font("���� ���", Font.BOLD, 16));
		JLabel priceMin = new JLabel();
		priceMin.setBounds(250, 235, 300, 100);
		priceMin.setForeground(Color.RED);
		priceMin.setFont(new Font("���� ���", Font.BOLD, 16));

		//�¼� �߰� �� �˾�â
		Dialog addTimeDial = new Dialog(mf);
		addTimeDial.setLayout(null);
		addTimeDial.setBounds(500, 400, 300, 180);
		addTimeDial.setBackground(Color.LIGHT_GRAY);

		JButton selectAdd = new JButton("��");
		selectAdd.setBounds(15, 100, 135, 60);
		JButton dialogClose = new JButton("�ƴϿ�");
		dialogClose.setBounds(150, 100, 135, 60);

		JLabel addChoice = new JLabel("�����Ͻðڽ��ϱ�?");
		addChoice.setBounds(15, 25, 200, 50);
		JTextField insertID = new JTextField();
		insertID.setHorizontalAlignment(JLabel.CENTER);
		insertID.setBounds(15, 60, 260, 30);
		insertID.setEditable(false);
		insertID.setFont(new Font("���� ���", Font.BOLD, 20));

		addTimeDial.add(addChoice);
		addTimeDial.add(selectAdd);
		addTimeDial.add(dialogClose);
		addTimeDial.add(insertID);

		//�¼��߰� ��ư �̺�Ʈ
		add.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int checkUser = mm.checkUser(textId.getText());
				boolean checkAprov = true;
				int restTime = 1;
				boolean checkUse = sm.useUser(textId.getText());
				ArrayList<Member> mTfList = mm.memberTFList(false);
				Member mList = mm.memberInfo(textId.getText());
				System.out.println(checkUse);

				if(checkUse == false){
					idOverlap.setText("�ش� ID�� �̹� ������Դϴ�.");
				}

				if(mList.getRestTime() == 0){
					restTime = 0;
					idOverlap.setText("�ش� ȸ���� �ܿ��ð��� �����ϴ�.");
				}
				for(int i = 0; i < mTfList.size(); i++){
					if(mTfList.get(i).getId().equals(textId.getText())){
						checkAprov = false;
						idOverlap.setText("���ε��� ���� ȸ���Դϴ�.");
					}
				}
				if(checkUser == 0){			
					idOverlap.setText("�������� �ʴ� ȸ���Դϴ�.");
				}
				if(checkUser == 1 && checkAprov == true && restTime == 1 && 
						checkUse == true){
					idOverlap.setText("");
					sm.useSeat(mf, textId.getText(), seatNo);
					MainPanel mPanel = new MainPanel(mf);
					changePanel(mPanel);
				}
			}
		});

		//�¼��߰� �˾�â �ݱ� ��ư
		dialogClose.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				priceMin.setText("");
				idOverlap.setText("");
				textId.setText("");
				addTimeDial.setVisible(false);
			}

		});

		selectAdd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				priceMin.setText("");
				idOverlap.setText("");
				textId.setText("");
				addTimeDial.setVisible(false);
			}

		});

		//����â
		JLabel capture = new JLabel();
		Image capImage = new ImageIcon("icon/capture.PNG").getImage().getScaledInstance(350, 400, 0);
		capture.setIcon(new ImageIcon(capImage));
		capture.setBounds(600, 50, 350, 400);

		timeMain.add(capture);
		timeMain.add(priceMin);
		timeMain.add(idOverlap);
		timeMain.add(add);
		timeMain.add(textId);
		timeMain.add(textSeatNo);
		timeMain.add(id);
		timeMain.add(seatNoL);
		timeMain.add(addTime);
		timeMain.add(iconLabel);

		this.add(timeMain);
		this.add(usePanel);
		mf.add(this);

	}

	public void changePanel(JPanel panel)
	{
		mf.remove(this);
		mf.add(panel);
		mf.repaint();
	}
}
