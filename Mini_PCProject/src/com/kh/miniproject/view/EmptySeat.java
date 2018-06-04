package com.kh.miniproject.view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class EmptySeat extends JPanel 
{
	private MainFrame mf;

	public EmptySeat(MainFrame mf) 
	{
		this.mf = mf;
		this.setSize(mf.getWidth(), mf.getHeight());
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		
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
							StartPanel start = new StartPanel(mf);
							changePanel(start);
						}
				});
		this.add(goback);
		
		//��� ���� �г� //�г� �� �󺧷� ����
		JPanel title = new JPanel();
		title.setLayout(null);
		title.setLocation(300, 50);
		title.setBackground(Color.WHITE);
		title.setSize(600,100);
		//�г� �� ���� ��
		JLabel text = new JLabel("����ִ� �¼�");
		text.setSize(600, 50);
		text.setLocation(5, 25);
		text.setBackground(Color.GREEN);
		text.setFont(new Font("���� ����", Font.BOLD, 40));
		text.setHorizontalAlignment(JTextField.CENTER);
		title.add(text);
		this.add(title);

		// �޴��г�
		JPanel menu = new JPanel();
		menu.setBackground(Color.LIGHT_GRAY);
		menu.setLayout(null);
		menu.setBounds(75, 200, 400, 525);
		JLabel menul = new JLabel("�޴�");
		menul.setFont(new Font("��������", Font.BOLD, 40));
		menul.setForeground(Color.BLACK);
		menul.setHorizontalAlignment(JLabel.CENTER);
		EtchedBorder eborder = new EtchedBorder(EtchedBorder.RAISED);
		menul.setBorder(eborder);
		menul.setBounds(0, 0, 400, 100);
		menu.add(menul);

		// �������г�
		JPanel iconp = new JPanel();
		iconp.setLayout(null);
		iconp.setBounds(0, 110, 400, 425);
		iconp.setBackground(Color.LIGHT_GRAY);
		Font font = new Font("��������", Font.BOLD, 18);
		// �ð��߰� ��ư
		JButton seatPlus = new JButton();
		Image clock = new ImageIcon("icon/addSeat.PNG").getImage().getScaledInstance(150, 150, 0);
		seatPlus.setIcon(new ImageIcon(clock));
		seatPlus.setBackground(null);
		seatPlus.setBounds(120, 110, 150, 150);
		seatPlus.setBorderPainted(false);
		seatPlus.addMouseListener(new MouseAdapter()
				{
					@Override
					public void mouseClicked(MouseEvent e)
					{
						AddTimePanel atp = new AddTimePanel(mf);
						//changePanel(atp);
						changePanel(atp);
					}
				});
		JLabel seatPlusL = new JLabel("�¼��߰�");
		seatPlusL.setFont(font);
		seatPlusL.setHorizontalAlignment(JLabel.CENTER);
		seatPlusL.setBounds(120, 260, 150, 25);
		

		iconp.add(seatPlus);
		iconp.add(seatPlusL);
		

		// �¼��г�
		JPanel seatP = new JPanel();
		seatP.setLayout(null);
		seatP.setBounds(500, 200, 650, 525);
		seatP.setBackground(Color.LIGHT_GRAY);
		JLabel seatTitle = new JLabel("�¼�");
		seatTitle.setFont(new Font("��������", Font.BOLD, 40));
		seatTitle.setHorizontalAlignment(JLabel.CENTER);
		seatTitle.setBorder(eborder);
		seatTitle.setBounds(0, 0, 650, 100);
		seatP.add(seatTitle);
		
		JLabel seatNo = new JLabel("1");
		seatNo.setHorizontalAlignment(JLabel.CENTER);
		seatNo.setBounds(10,100,100,100);
		seatNo.setFont(new Font("��������", Font.BOLD, 40));
		seatP.add(seatNo);
		
		JLabel seatUse = new JLabel("Empty");
		seatUse.setHorizontalAlignment(JLabel.CENTER);
		seatUse.setBounds(225, 200, 200, 200);
		seatUse.setFont(new Font("��������", Font.BOLD, 44));
		seatP.add(seatUse);
		
		
		menu.add(iconp);

		this.add(menu);
		this.add(seatP);

		mf.add(this);

	}
	
	
	public void changePanel(JPanel panel)
	{
		mf.remove(this);
		mf.add(panel);
		mf.repaint();
	}
}
