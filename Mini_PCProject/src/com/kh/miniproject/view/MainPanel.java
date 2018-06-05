package com.kh.miniproject.view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class MainPanel extends JPanel 
{
	private MainFrame mf;

	public MainPanel(MainFrame mf) 
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
		JLabel titleLayer = new JLabel();
		Image titleLayerI = new ImageIcon("icon/titleLayer.png").getImage().getScaledInstance(600, 100, 0);
		titleLayer.setIcon(new ImageIcon(titleLayerI));
		titleLayer.setBounds(0, 0, 600, 100);
		//�г� �� ���� ��
		JLabel text = new JLabel("��! �ǽù�� Ÿ�̾�� �δ�!");
		text.setSize(600, 50);
		text.setLocation(0, 25);
		text.setBackground(Color.GREEN);
		text.setFont(new Font("���� ���", Font.BOLD, 40));
		text.setHorizontalAlignment(JLabel.CENTER);
		title.add(text);
		title.add(titleLayer);
		this.add(title);

		// �޴��г�
		JPanel menu = new JPanel();
		menu.setBackground(Color.LIGHT_GRAY);
		menu.setLayout(null);
		menu.setBounds(75, 200, 400, 525);
		JLabel menul = new JLabel("�޴�");
		menul.setFont(new Font("�������", Font.BOLD, 40));
		menul.setForeground(Color.BLACK);
		menul.setHorizontalAlignment(JLabel.CENTER);
		EtchedBorder eborder = new EtchedBorder(EtchedBorder.RAISED);
		menul.setBorder(eborder);
		menul.setBounds(0, 0, 400, 100);
		menu.add(menul);

		// �������г�
		JPanel iconp = new JPanel();
		iconp.setLayout(null);
		iconp.setBounds(0, 100, 400, 425);
		iconp.setBackground(Color.LIGHT_GRAY);
		Font font = new Font("�������", Font.BOLD, 18);
		// �ð��߰� ��ư
		JButton timePlus = new JButton();
		Image clock = new ImageIcon("icon/time.png").getImage().getScaledInstance(150, 150, 0);
		timePlus.setIcon(new ImageIcon(clock));
		timePlus.setBackground(null);
		timePlus.setBounds(25, 25, 150, 150);
		timePlus.setBorderPainted(false);
		timePlus.addMouseListener(new MouseAdapter()
				{
					@Override
					public void mouseClicked(MouseEvent e)
					{
						AddTimePanel atp = new AddTimePanel(mf);
						changePanel(atp);
					}
				});
		JLabel timePlusL = new JLabel("�ð��߰�");
		timePlusL.setFont(font);
		timePlusL.setHorizontalAlignment(JLabel.CENTER);
		timePlusL.setBounds(25, 180, 150, 25);
		// ȸ������ ��ư
		JButton manageuser = new JButton();
		Image user = new ImageIcon("icon/user.png").getImage().getScaledInstance(150, 150, 0);
		manageuser.setIcon(new ImageIcon(user));
		manageuser.setBackground(null);
		manageuser.setBounds(225, 25, 150, 150);
		manageuser.setBorderPainted(false);
		manageuser.addMouseListener(new MouseAdapter()
				{
					@Override
					public void mouseClicked(MouseEvent e)
					{
						MemberManagement mmp = new MemberManagement(mf);
						changePanel(mmp);
					}
				});
		JLabel userL = new JLabel("ȸ������");
		userL.setFont(font);
		userL.setHorizontalAlignment(JLabel.CENTER);
		userL.setBounds(225, 180, 150, 25);
		// ���Ͱ��� ��ư
		JButton chart = new JButton();
		Image graph = new ImageIcon("icon/graph.png").getImage().getScaledInstance(150, 150, 0);
		chart.setIcon(new ImageIcon(graph));
		chart.setBackground(null);
		chart.setBounds(25, 225, 150, 150);
		chart.setBorderPainted(false);
		JLabel chartL = new JLabel("���Ͱ���");
		chartL.setFont(font);
		chartL.setHorizontalAlignment(JLabel.CENTER);
		chartL.setBounds(25, 380, 150, 25);
		// ������ ��ư
		JButton product = new JButton();
		Image cart = new ImageIcon("icon/shopping.png").getImage().getScaledInstance(150, 150, 0);
		product.setIcon(new ImageIcon(cart));
		product.setBackground(null);
		product.setBorderPainted(false);
		product.setBounds(225, 225, 150, 150);
		JLabel productL = new JLabel("������");
		productL.setFont(font);
		productL.setHorizontalAlignment(JLabel.CENTER);
		productL.setBounds(225, 380, 150, 25);

		iconp.add(timePlus);
		iconp.add(timePlusL);
		iconp.add(manageuser);
		iconp.add(userL);
		iconp.add(chart);
		iconp.add(chartL);
		iconp.add(product);
		iconp.add(productL);

		// �¼��г�
		JPanel seatP = new JPanel();
		seatP.setLayout(null);
		seatP.setBounds(500, 200, 650, 525);
		seatP.setBackground(Color.LIGHT_GRAY);
		JLabel seatTitle = new JLabel("�¼�");
		seatTitle.setFont(new Font("�������", Font.BOLD, 40));
		seatTitle.setHorizontalAlignment(JLabel.CENTER);
		seatTitle.setBorder(eborder);
		seatTitle.setBounds(0, 0, 650, 100);
		seatP.add(seatTitle);

		// �������(empty)
		Image empty = new ImageIcon("icon/empty.png").getImage().getScaledInstance(100, 45, 0);
		JPanel seatGP = new JPanel();
		seatGP.setLayout(null);
		seatGP.setBounds(0, 100, 650, 425);
		seatGP.setBackground(null);
		
		// 1���¼�
		JPanel seat1 = new JPanel();
		seat1.setLayout(null);
		seat1.setBackground(Color.GRAY);
		seat1.setBounds(25, 25, 100, 75);
		JLabel seatl01 = new JLabel("1");
		seatl01.setHorizontalAlignment(JLabel.CENTER);
		seatl01.setBounds(10, 10, 20, 20);
		JLabel seat1e = new JLabel();
		seat1e.setIcon(new ImageIcon(empty));
		seat1e.setBounds(10, 30, 90, 45);
		seat1.add(seatl01);
		seat1.add(seat1e);
		seatGP.add(seat1);
		
		// 2���¼�
		JPanel seat2 = new JPanel();
		seat2.setLayout(null);
		seat2.setBackground(Color.GRAY);
		seat2.setBounds(150, 25, 100, 75);
		JLabel seatl02 = new JLabel("2");
		seatl02.setHorizontalAlignment(JLabel.CENTER);
		seatl02.setBounds(10, 10, 20, 20);
		JLabel seat2e = new JLabel();
		seat2e.setIcon(new ImageIcon(empty));
		seat2e.setBounds(10, 30, 90, 45);
		seat2.add(seatl02);
		seat2.add(seat2e);
		seatGP.add(seat2);
		
		// 3���¼�
		JPanel seat3 = new JPanel();
		seat3.setLayout(null);
		seat3.setBackground(Color.GRAY);
		seat3.setBounds(275,25,100,75);
		JLabel seatl03 = new JLabel("3");
		seatl03.setHorizontalAlignment(JLabel.CENTER);
		seatl03.setBounds(10, 10, 20, 20);
		JLabel seat3e = new JLabel();
		seat3e.setIcon(new ImageIcon(empty));
		seat3e.setBounds(10, 30, 90, 45);
		seat3.add(seat3e);
		seat3.add(seatl03);
		seatGP.add(seat3);
		
		// 4���¼�
		JPanel seat4 = new JPanel();
		seat4.setLayout(null);
		seat4.setBackground(Color.GRAY);
		seat4.setBounds(400,25,100,75);
		JLabel seatl04 = new JLabel("4");
		seatl04.setHorizontalAlignment(JLabel.CENTER);
		seatl04.setBounds(10, 10, 20, 20);
		JLabel seat4e = new JLabel();
		seat4e.setIcon(new ImageIcon(empty));
		seat4e.setBounds(10, 30, 90, 45);
		seat4.add(seat4e);
		seat4.add(seatl04);
		seatGP.add(seat4);
		
		// 5���¼�
		JPanel seat5 = new JPanel();
		seat5.setLayout(null);
		seat5.setBackground(Color.GRAY);
		seat5.setBounds(525,25,100,75);
		JLabel seatl05 = new JLabel("5");
		seatl05.setHorizontalAlignment(JLabel.CENTER);
		seatl05.setBounds(10, 10, 20, 20);
		JLabel seat5e = new JLabel();
		seat5e.setIcon(new ImageIcon(empty));
		seat5e.setBounds(10, 30, 90, 45);
		seat5.add(seat5e);
		seat5.add(seatl05);
		seatGP.add(seat5);
		
		// 6�� �¼�
		JPanel seat6 = new JPanel();
		seat6.setLayout(null);
		seat6.setBackground(Color.GRAY);
		seat6.setBounds(25, 125, 100, 75);
		JLabel seatl06 = new JLabel("6");
		seatl06.setHorizontalAlignment(JLabel.CENTER);
		seatl06.setBounds(10, 10, 20, 20);
		JLabel seat6e = new JLabel();
		seat6e.setIcon(new ImageIcon(empty));
		seat6e.setBounds(10, 30, 90, 45);
		seat6.add(seat6e);
		seat6.add(seatl06);
		seatGP.add(seat6);
		
		// 7���¼�
		JPanel seat7 = new JPanel();
		seat7.setLayout(null);
		seat7.setBackground(Color.GRAY);
		seat7.setBounds(150, 125, 100, 75);
		JLabel seatl07 = new JLabel("7");
		seatl07.setHorizontalAlignment(JLabel.CENTER);
		seatl07.setBounds(10, 10, 20, 20);
		JLabel seat7e = new JLabel();
		seat7e.setIcon(new ImageIcon(empty));
		seat7e.setBounds(10, 30, 90, 45);
		seat7.add(seat7e);
		seat7.add(seatl07);
		seatGP.add(seat7);
		
		// 8���¼�
		JPanel seat8 = new JPanel();
		seat8.setLayout(null);
		seat8.setBackground(Color.GRAY);
		seat8.setBounds(275,125,100,75);
		JLabel seatl08 = new JLabel("8");
		seatl08.setHorizontalAlignment(JLabel.CENTER);
		seatl08.setBounds(10, 10, 20, 20);
		JLabel seat8e = new JLabel();
		seat8e.setIcon(new ImageIcon(empty));
		seat8e.setBounds(10, 30, 90, 45);
		seat8.add(seat8e);
		seat8.add(seatl08);
		seatGP.add(seat8);
		
		// 9���¼�
		JPanel seat9 = new JPanel();
		seat9.setLayout(null);
		seat9.setBackground(Color.GRAY);
		seat9.setBounds(400, 125, 100, 75);
		JLabel seatl09 = new JLabel("9");
		seatl09.setHorizontalAlignment(JLabel.CENTER);
		seatl09.setBounds(10, 10, 20, 20);
		JLabel seat9e = new JLabel();
		seat9e.setIcon(new ImageIcon(empty));
		seat9e.setBounds(10, 30, 90, 45);
		seat9.add(seat9e);
		seat9.add(seatl09);
		seatGP.add(seat9);
		
		// 10���¼�
		JPanel seat10 = new JPanel();
		seat10.setLayout(null);
		seat10.setBackground(Color.GRAY);
		seat10.setBounds(525, 125, 100, 75);
		JLabel seatl10 = new JLabel("10");
		seatl10.setHorizontalAlignment(JLabel.CENTER);
		seatl10.setBounds(10, 10, 20, 20);
		JLabel seat10e = new JLabel();
		seat10e.setIcon(new ImageIcon(empty));
		seat10e.setBounds(10, 30, 90, 45);
		seat10.add(seat10e);
		seat10.add(seatl10);
		seatGP.add(seat10);
		
		// 11���¼�
		JPanel seat11 = new JPanel();
		seat11.setLayout(null);
		seat11.setBackground(Color.GRAY);
		seat11.setBounds(25, 225, 100, 75);
		JLabel seatl11 = new JLabel("11");
		seatl11.setHorizontalAlignment(JLabel.CENTER);
		seatl11.setBounds(10, 10, 20, 20);
		JLabel seat11e = new JLabel();
		seat11e.setIcon(new ImageIcon(empty));
		seat11e.setBounds(10, 30, 90, 45);
		seat11.add(seat11e);
		seat11.add(seatl11);
		seatGP.add(seat11);
		
		// 12���¼�
		JPanel seat12 = new JPanel();
		seat12.setLayout(null);
		seat12.setBackground(Color.GRAY);
		seat12.setBounds(150, 225, 100, 75);
		JLabel seatl12 = new JLabel("12");
		seatl12.setHorizontalAlignment(JLabel.CENTER);
		seatl12.setBounds(10, 10, 20, 20);
		JLabel seat12e = new JLabel();
		seat12e.setIcon(new ImageIcon(empty));
		seat12e.setBounds(10, 30, 90, 45);
		seat12.add(seat12e);
		seat12.add(seatl12);
		seatGP.add(seat12);
		
		// 13���¼�
		JPanel seat13 = new JPanel();
		seat13.setLayout(null);
		seat13.setBackground(Color.GRAY);
		seat13.setBounds(275, 225, 100, 75);
		JLabel seatl13 = new JLabel("13");
		seatl13.setHorizontalAlignment(JLabel.CENTER);
		seatl13.setBounds(10, 10, 20, 20);
		JLabel seat13e = new JLabel();
		seat13e.setIcon(new ImageIcon(empty));
		seat13e.setBounds(10, 30, 90, 45);
		seat13.add(seat13e);
		seat13.add(seatl13);
		seatGP.add(seat13);
		
		// 14���¼�
		JPanel seat14 = new JPanel();
		seat14.setLayout(null);
		seat14.setBackground(Color.GRAY);
		seat14.setBounds(400, 225, 100, 75);
		JLabel seatl14 = new JLabel("14");
		seatl14.setHorizontalAlignment(JLabel.CENTER);
		seatl14.setBounds(10, 10, 20, 20);
		JLabel seat14e = new JLabel();
		seat14e.setIcon(new ImageIcon(empty));
		seat14e.setBounds(10, 30, 90, 45);
		seat14.add(seat14e);
		seat14.add(seatl14);
		seatGP.add(seat14);
		
		// 15���¼�
		JPanel seat15 = new JPanel();
		seat15.setLayout(null);
		seat15.setBackground(Color.GRAY);
		seat15.setBounds(525, 225, 100, 75);
		JLabel seatl15 = new JLabel("15");
		seatl15.setHorizontalAlignment(JLabel.CENTER);
		seatl15.setBounds(10, 10, 20, 20);
		JLabel seat15e = new JLabel();
		seat15e.setIcon(new ImageIcon(empty));
		seat15e.setBounds(10, 30, 90, 45);
		seat15.add(seat15e);
		seat15.add(seatl15);
		seatGP.add(seat15);
		
		// 16���¼�
		JPanel seat16 = new JPanel();
		seat16.setLayout(null);
		seat16.setBackground(Color.GRAY);
		seat16.setBounds(25, 325, 100, 75);
		JLabel seatl16 = new JLabel("16");
		seatl16.setHorizontalAlignment(JLabel.CENTER);
		seatl16.setBounds(10, 10, 20, 20);
		JLabel seat16e = new JLabel();
		seat16e.setIcon(new ImageIcon(empty));
		seat16e.setBounds(10, 30, 90, 45);
		seat16.add(seat16e);
		seat16.add(seatl16);
		seatGP.add(seat16);
		
		// 17���¼�
		JPanel seat17 = new JPanel();
		seat17.setLayout(null);
		seat17.setBackground(Color.GRAY);
		seat17.setBounds(150, 325, 100, 75);
		JLabel seatl17 = new JLabel("17");
		seatl17.setHorizontalAlignment(JLabel.CENTER);
		seatl17.setBounds(10, 10, 20, 20);
		JLabel seat17e = new JLabel();
		seat17e.setIcon(new ImageIcon(empty));
		seat17e.setBounds(10, 30, 90, 45);
		seat17.add(seat17e);
		seat17.add(seatl17);
		seatGP.add(seat17);
		
		// 18���¼�
		JPanel seat18 = new JPanel();
		seat18.setLayout(null);
		seat18.setBackground(Color.GRAY);
		seat18.setBounds(275, 325, 100, 75);
		JLabel seatl18 = new JLabel("18");
		seatl18.setHorizontalAlignment(JLabel.CENTER);
		seatl18.setBounds(10, 10, 20, 20);
		JLabel seat18e = new JLabel();
		seat18e.setIcon(new ImageIcon(empty));
		seat18e.setBounds(10, 30, 90, 45);
		seat18.add(seat18e);
		seat18.add(seatl18);
		seatGP.add(seat18);
		
		// 19���¼�
		JPanel seat19 = new JPanel();
		seat19.setLayout(null);
		seat19.setBackground(Color.GRAY);
		seat19.setBounds(400, 325, 100, 75);
		JLabel seatl19 = new JLabel("19");
		seatl19.setHorizontalAlignment(JLabel.CENTER);
		seatl19.setBounds(10, 10, 20, 20);
		JLabel seat19e = new JLabel();
		seat19e.setIcon(new ImageIcon(empty));
		seat19e.setBounds(10, 30, 90, 45);
		seat19.add(seat19e);
		seat19.add(seatl19);
		seatGP.add(seat19);
		
		// 20���¼�
		JPanel seat20 = new JPanel();
		seat20.setLayout(null);
		seat20.setBackground(Color.GRAY);
		seat20.setBounds(525, 325, 100, 75);
		JLabel seatl20 = new JLabel("20");
		seatl20.setHorizontalAlignment(JLabel.CENTER);
		seatl20.setBounds(10, 10, 20, 20);
		JLabel seat20e = new JLabel();
		seat20e.setIcon(new ImageIcon(empty));
		seat20e.setBounds(10, 30, 90, 45);
		seat20.add(seat20e);
		seat20.add(seatl20);
		seatGP.add(seat20);

		seatP.add(seatGP);
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
