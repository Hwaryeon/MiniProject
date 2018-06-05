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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.miniproject.member.controller.MemberManager;
import com.kh.miniproject.seat.controller.SeatManager;


public class UseSeat extends JPanel{
	private MainFrame mf;
	private JPanel mp;
	private MemberManager mm = new MemberManager();
	
	private SeatManager sm = new SeatManager();
	
	public UseSeat(MainFrame mf, JPanel seat1, int seatNo){
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

		//��� �ð��߰� �г� //�г� �� �󺧷� ����
		JPanel addTimeText = new JPanel();
		addTimeText.setLayout(null);
		addTimeText.setLocation(300, 50);
		addTimeText.setBackground(Color.WHITE);
		addTimeText.setSize(600,100);
		//�г� �� "����ȭ��" ��
		JLabel text = new JLabel("�¼� ���");
		text.setSize(200, 50);
		text.setLocation(200, 25);
		text.setBackground(Color.GREEN);
		text.setFont(new Font("���� ���", Font.BOLD, 40));
		text.setHorizontalAlignment(JTextField.CENTER);
		addTimeText.add(text);

		//�ð��߰� ���� �г� //
		JPanel timeMain = new JPanel();
		timeMain.setLayout(null);
		timeMain.setSize(1000,500);
		timeMain.setLocation(100, 200);
		timeMain.setBackground(Color.LIGHT_GRAY);
		//������
		JLabel iconLabel = new JLabel();
		Image icon = new ImageIcon("icon/cashIcon.PNG").getImage().getScaledInstance(100, 100, 0);
		iconLabel.setIcon(new ImageIcon(icon));
		iconLabel.setBounds(20, 20, 100, 100);
		//"�ð��߰�" �ؽ�Ʈ�ʵ�
		JTextField addTime = new JTextField("�¼� ���");
		addTime.setSize(300,100);
		addTime.setLocation(150, 20);
		addTime.setBackground(Color.BLACK);
		addTime.setForeground(Color.WHITE);
		addTime.setEditable(false);
		addTime.setFont(new Font("���� ���", Font.BOLD, 30));
		addTime.setHorizontalAlignment(JTextField.CENTER);
		//ID, �����ݾ� �Է� �ؽ�Ʈ�ʵ�
		JLabel id = new JLabel("ȸ�� ���̵�");
		JLabel price = new JLabel("�ݾ�");
		id.setFont(new Font("���� ���", Font.BOLD, 16));
		price.setFont(new Font("���� ���", Font.BOLD, 16));
		id.setBounds(30, 130, 100, 100);
		price.setBounds(30, 200, 100, 100);
		JTextField textId = new JTextField();
		textId.setFont(new Font("���� ���", Font.BOLD, 14));
		textId.setBounds(30, 200, 200, 30);
		
		/*String[] prices = 
			{"1000", "2000", "3000", "5000", "10000", "20000", "50000"};*/
		
		Choice priceChoice = new Choice();
		priceChoice.add("1000");
		priceChoice.add("2000");
		priceChoice.add("3000");
		priceChoice.add("5000");
		priceChoice.add("10000");
		priceChoice.add("20000");
		priceChoice.add("50000");
		priceChoice.setBounds(30, 270, 200, 20);
		
		//priceList.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		/*JScrollPane priceScroll = new JScrollPane(priceChoice);
		//priceScroll.setPreferredSize(new Dimension(200, 30));
		priceScroll.setBounds(30, 270, 200, 20);*/
		/*JTextField textPrice = new JTextField();
		textPrice.setFont(new Font("���� ���", Font.BOLD, 14));
		textPrice.setBounds(30, 270, 200, 30);*/
		/*textPrice.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == true){				
				}
				textPrice.setText("");
			}		
		});*/
		JLabel labelLayout = new JLabel();
		Image labelImage = new ImageIcon("icon/labelLayout.PNG").getImage().getScaledInstance(200, 50, 0);
		labelLayout.setIcon(new ImageIcon(labelImage));
		labelLayout.setBounds(30, 300, 200, 100);
		JLabel priceToTime = new JLabel();
		priceToTime.setFont(new Font("���� ���", Font.BOLD, 20));
		priceToTime.setBounds(0, 25, 200, 50);
		priceToTime.setBackground(Color.RED);
		priceToTime.setHorizontalAlignment(JLabel.CENTER);
		labelLayout.add(priceToTime);
		//�ð� �߰� ��ư
		JButton add = new JButton("�߰�");
		add.setBounds(30, 400, 150, 70);
		add.setBackground(Color.BLACK);
		add.setFont(new Font("���� ���", Font.BOLD, 20));
		add.setForeground(Color.WHITE);
		//�ߺ� ID, �ּұݾ� ��� ��
		JLabel idOverlap = new JLabel();
		idOverlap.setBounds(250, 165, 300, 100);
		idOverlap.setForeground(Color.RED);
		idOverlap.setFont(new Font("���� ���", Font.BOLD, 16));
		JLabel priceMin = new JLabel();
		priceMin.setBounds(250, 235, 300, 100);
		priceMin.setForeground(Color.RED);
		priceMin.setFont(new Font("���� ���", Font.BOLD, 16));

		//�ð� �߰� �� �˾�â
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

		//�ð��߰� ��ư �̺�Ʈ
		add.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int checkUser = mm.checkUser(textId.getText());

				if(checkUser == 0){
					idOverlap.setText("�������� �ʴ� ȸ���Դϴ�.");
				}else{
					idOverlap.setText("");
					
					sm.useSeat(mf, seat1, textId.getText(), seatNo);
					
					
				}
				
				
				
			
			}
		});

		//�ð��߰� �˾�â �ݱ� ��ư
		dialogClose.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				priceMin.setText("");
				idOverlap.setText("");
				priceToTime.setText("");
				textId.setText("");
				//textPrice.setText("");
				addTimeDial.setVisible(false);

			}

		});
		
		selectAdd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				priceMin.setText("");
				idOverlap.setText("");
				priceToTime.setText("");
				textId.setText("");
				//textPrice.setText("");
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
		timeMain.add(labelLayout);
		timeMain.add(textId);
		//timeMain.add(priceScroll);
		timeMain.add(priceChoice);
		timeMain.add(id);
		timeMain.add(price);
		timeMain.add(addTime);
		timeMain.add(iconLabel);


		this.add(timeMain);
		this.add(addTimeText);
		mf.add(this);



	}

	public void changePanel(JPanel panel)
	{
		mf.remove(this);
		mf.add(panel);
		mf.repaint();
	}
}
