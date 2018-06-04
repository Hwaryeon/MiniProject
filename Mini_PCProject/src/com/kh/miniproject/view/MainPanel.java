package com.kh.miniproject.view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.kh.miniproject.event.MyMouseAdapter;
import com.kh.miniproject.member.controller.MemberManager;
import com.kh.miniproject.member.vo.Member;
import com.kh.miniproject.seat.controller.SeatManager;

public class MainPanel extends JPanel 
{
	private MainFrame mf;
	private SeatManager sm = new SeatManager();
	private MemberManager mm = new MemberManager();

	public MainPanel(MainFrame mf) 
	{
		this.mf = mf;
		this.setSize(mf.getWidth(), mf.getHeight());
		this.setLayout(null);
		this.setBackground(Color.BLACK);

		//뒤로가기 버튼
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

		//상단 제목 패널 //패널 위 라벨로 구성
		JPanel title = new JPanel();
		title.setLayout(null);
		title.setLocation(300, 50);
		title.setBackground(Color.WHITE);
		title.setSize(600,100);
		//패널 위 제목 라벨
		JLabel text = new JLabel("앗! 피시방비가 타이어보다 싸다!");
		text.setSize(600, 50);
		text.setLocation(5, 25);
		text.setBackground(Color.GREEN);
		text.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		text.setHorizontalAlignment(JTextField.CENTER);
		title.add(text);
		this.add(title);

		// 메뉴패널
		JPanel menu = new JPanel();
		menu.setBackground(Color.LIGHT_GRAY);
		menu.setLayout(null);
		menu.setBounds(75, 200, 400, 525);
		JLabel menul = new JLabel("메뉴");
		menul.setFont(new Font("맑은고딕", Font.BOLD, 40));
		menul.setForeground(Color.BLACK);
		menul.setHorizontalAlignment(JLabel.CENTER);
		EtchedBorder eborder = new EtchedBorder(EtchedBorder.RAISED);
		menul.setBorder(eborder);
		menul.setBounds(0, 0, 400, 100);
		menu.add(menul);

		// 아이콘패널
		JPanel iconp = new JPanel();
		iconp.setLayout(null);
		iconp.setBounds(0, 100, 400, 425);
		iconp.setBackground(Color.LIGHT_GRAY);
		Font font = new Font("맑은고딕", Font.BOLD, 18);
		// 시간추가 버튼
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
				//changePanel(atp);
				changePanel(atp);
			}
		});
		JLabel timePlusL = new JLabel("시간추가");
		timePlusL.setFont(font);
		timePlusL.setHorizontalAlignment(JLabel.CENTER);
		timePlusL.setBounds(25, 180, 150, 25);
		// 회원관리 버튼
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
		JLabel userL = new JLabel("회원관리");
		userL.setFont(font);
		userL.setHorizontalAlignment(JLabel.CENTER);
		userL.setBounds(225, 180, 150, 25);
		// 수익관리 버튼
		JButton chart = new JButton();
		Image graph = new ImageIcon("icon/graph.png").getImage().getScaledInstance(150, 150, 0);
		chart.setIcon(new ImageIcon(graph));
		chart.setBackground(null);
		chart.setBounds(25, 225, 150, 150);
		chart.setBorderPainted(false);
		JLabel chartL = new JLabel("수익관리");
		chartL.setFont(font);
		chartL.setHorizontalAlignment(JLabel.CENTER);
		chartL.setBounds(25, 380, 150, 25);
		// 재고관리 버튼
		JButton product = new JButton();
		Image cart = new ImageIcon("icon/shopping.png").getImage().getScaledInstance(150, 150, 0);
		product.setIcon(new ImageIcon(cart));
		product.setBackground(null);
		product.setBorderPainted(false);
		product.setBounds(225, 225, 150, 150);
		JLabel productL = new JLabel("재고관리");
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

		// 좌석패널
		JPanel seatP = new JPanel();
		seatP.setLayout(null);
		seatP.setBounds(500, 200, 650, 525);
		seatP.setBackground(Color.LIGHT_GRAY);
		JLabel seatTitle = new JLabel("좌석");
		seatTitle.setFont(new Font("맑은고딕", Font.BOLD, 40));
		seatTitle.setHorizontalAlignment(JLabel.CENTER);
		seatTitle.setBorder(eborder);
		seatTitle.setBounds(0, 0, 650, 100);
		seatP.add(seatTitle);

		// 비어있음(empty)
		Image empty = new ImageIcon("icon/empty.png").getImage().getScaledInstance(100, 45, 0);
		JPanel seatGP = new JPanel();
		seatGP.setLayout(null);
		seatGP.setBounds(0, 100, 650, 425);
		seatGP.setBackground(null);

		// 1번좌석
		JPanel seat1 = new JPanel();
		seat1.setLayout(null);
		seat1.setBackground(Color.GRAY);
		seat1.setBounds(25, 25, 100, 75);
		JLabel seatl01 = new JLabel("1");
		seatl01.setHorizontalAlignment(JLabel.CENTER);
		seatl01.setBounds(10, 10, 20, 20);

		seat1.add(seatl01);

		seatGP.add(seat1);
		if(sm.checkSeat(1) != null){

			JLabel seat1u = new JLabel(sm.checkSeat(1));
			seat1u.setBounds(10, 30, 50, 20);
			seat1u.setHorizontalAlignment(JLabel.CENTER);
			seat1u.setBackground(Color.white);
			seat1.add(seat1u);


		}else{
			JLabel seat1e = new JLabel();
			seat1e.setIcon(new ImageIcon(empty));
			seat1e.setBounds(10, 30, 90, 45);
			seat1.add(seat1e);
		}


		seat1.addMouseListener(new MyMouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int seatNo = 1;
				if(sm.checkSeat(seatNo) == null){
					EmptySeat es = new EmptySeat(mf, seatNo);
					changePanel(es);
				}else{
					InuseSeat us = new InuseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 2번좌석
		JPanel seat2 = new JPanel();
		seat2.setLayout(null);
		seat2.setBackground(Color.GRAY);
		seat2.setBounds(150, 25, 100, 75);
		JLabel seatl02 = new JLabel("2");
		seatl02.setHorizontalAlignment(JLabel.CENTER);
		seatl02.setBounds(10, 10, 20, 20);

		seat2.add(seatl02);
		seatGP.add(seat2);

		if(sm.checkSeat(2) != null){
			JLabel seat2u = new JLabel(sm.checkSeat(2));
			seat2u.setBounds(10, 30, 50, 20);
			seat2u.setHorizontalAlignment(JLabel.CENTER);
			seat2u.setBackground(Color.white);
			seat2.add(seat2u);

		}else{
			JLabel seat2e = new JLabel();
			seat2e.setIcon(new ImageIcon(empty));
			seat2e.setBounds(10, 30, 90, 45);
			seat2.add(seat2e);
		}



		seat2.addMouseListener(new MyMouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int seatNo = 2;
				if(sm.checkSeat(seatNo) == null){
					EmptySeat es = new EmptySeat(mf, seatNo);
					changePanel(es);
				}else{
					InuseSeat us = new InuseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 3번좌석
		JPanel seat3 = new JPanel();
		seat3.setLayout(null);
		seat3.setBackground(Color.GRAY);
		seat3.setBounds(275,25,100,75);
		JLabel seatl03 = new JLabel("3");
		seatl03.setHorizontalAlignment(JLabel.CENTER);
		seatl03.setBounds(10, 10, 20, 20);

		seat3.add(seatl03);
		seatGP.add(seat3);

		if(sm.checkSeat(3) != null){
			JLabel seat3u = new JLabel(sm.checkSeat(3));
			seat3u.setBounds(10, 30, 50, 20);
			seat3u.setHorizontalAlignment(JLabel.CENTER);
			seat3u.setBackground(Color.white);
			seat3.add(seat3u);

		}else{
			JLabel seat3e = new JLabel();
			seat3e.setIcon(new ImageIcon(empty));
			seat3e.setBounds(10, 30, 90, 45);
			seat3.add(seat3e);
		}

		seat3.addMouseListener(new MyMouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int seatNo = 3;
				if(sm.checkSeat(seatNo) == null){
					EmptySeat es = new EmptySeat(mf, seatNo);
					changePanel(es);
				}else{
					InuseSeat us = new InuseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 4번좌석
		JPanel seat4 = new JPanel();
		seat4.setLayout(null);
		seat4.setBackground(Color.GRAY);
		seat4.setBounds(400,25,100,75);
		JLabel seatl04 = new JLabel("4");
		seatl04.setHorizontalAlignment(JLabel.CENTER);
		seatl04.setBounds(10, 10, 20, 20);

		seat4.add(seatl04);
		seatGP.add(seat4);

		if(sm.checkSeat(4) != null){
			JLabel seat4u = new JLabel(sm.checkSeat(4));
			seat4u.setBounds(10, 30, 50, 20);
			seat4u.setHorizontalAlignment(JLabel.CENTER);
			seat4u.setBackground(Color.white);
			seat4.add(seat4u);

		}else{
			JLabel seat4e = new JLabel();
			seat4e.setIcon(new ImageIcon(empty));
			seat4e.setBounds(10, 30, 90, 45);
			seat4.add(seat4e);
		}

		seat4.addMouseListener(new MyMouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int seatNo = 4;
				if(sm.checkSeat(seatNo) == null){
					EmptySeat es = new EmptySeat(mf, seatNo);
					changePanel(es);
				}else{
					InuseSeat us = new InuseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 5번좌석
		JPanel seat5 = new JPanel();
		seat5.setLayout(null);
		seat5.setBackground(Color.GRAY);
		seat5.setBounds(525,25,100,75);
		JLabel seatl05 = new JLabel("5");
		seatl05.setHorizontalAlignment(JLabel.CENTER);
		seatl05.setBounds(10, 10, 20, 20);

		seat5.add(seatl05);
		seatGP.add(seat5);

		if(sm.checkSeat(5) != null){
			JLabel seat5u = new JLabel(sm.checkSeat(5));
			seat5u.setBounds(10, 30, 50, 20);
			seat5u.setHorizontalAlignment(JLabel.CENTER);
			seat5u.setBackground(Color.white);
			seat5.add(seat5u);

		}else{
			JLabel seat5e = new JLabel();
			seat5e.setIcon(new ImageIcon(empty));
			seat5e.setBounds(10, 30, 90, 45);
			seat5.add(seat5e);
		}

		seat5.addMouseListener(new MyMouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int seatNo = 5;
				if(sm.checkSeat(seatNo) == null){
					EmptySeat es = new EmptySeat(mf, seatNo);
					changePanel(es);
				}else{
					InuseSeat us = new InuseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}

			}
		});


		// 6번 좌석
		JPanel seat6 = new JPanel();
		seat6.setLayout(null);
		seat6.setBackground(Color.GRAY);
		seat6.setBounds(25, 125, 100, 75);
		JLabel seatl06 = new JLabel("6");
		seatl06.setHorizontalAlignment(JLabel.CENTER);
		seatl06.setBounds(10, 10, 20, 20);

		seat6.add(seatl06);
		seatGP.add(seat6);

		if(sm.checkSeat(6) != null){
			JLabel seat6u = new JLabel(sm.checkSeat(6));
			seat6u.setBounds(10, 30, 50, 20);
			seat6u.setHorizontalAlignment(JLabel.CENTER);
			seat6u.setBackground(Color.white);
			seat6.add(seat6u);

		}else{
			JLabel seat6e = new JLabel();
			seat6e.setIcon(new ImageIcon(empty));
			seat6e.setBounds(10, 30, 90, 45);
			seat6.add(seat6e);
		}

		seat6.addMouseListener(new MyMouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int seatNo = 6;
				if(sm.checkSeat(seatNo) == null){
					EmptySeat es = new EmptySeat(mf, seatNo);
					changePanel(es);
				}else{
					InuseSeat us = new InuseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 7번좌석
		JPanel seat7 = new JPanel();
		seat7.setLayout(null);
		seat7.setBackground(Color.GRAY);
		seat7.setBounds(150, 125, 100, 75);
		JLabel seatl07 = new JLabel("7");
		seatl07.setHorizontalAlignment(JLabel.CENTER);
		seatl07.setBounds(10, 10, 20, 20);

		seat7.add(seatl07);
		seatGP.add(seat7);
		
		if(sm.checkSeat(7) != null){
			JLabel seat7u = new JLabel(sm.checkSeat(7));
			seat7u.setBounds(10, 30, 50, 20);
			seat7u.setHorizontalAlignment(JLabel.CENTER);
			seat7u.setBackground(Color.white);
			seat7.add(seat7u);

		}else{
			JLabel seat7e = new JLabel();
			seat7e.setIcon(new ImageIcon(empty));
			seat7e.setBounds(10, 30, 90, 45);
			seat7.add(seat7e);
		}

		seat7.addMouseListener(new MyMouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int seatNo = 7;
				if(sm.checkSeat(seatNo) == null){
					EmptySeat es = new EmptySeat(mf, seatNo);
					changePanel(es);
				}else{
					InuseSeat us = new InuseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 8번좌석
		JPanel seat8 = new JPanel();
		seat8.setLayout(null);
		seat8.setBackground(Color.GRAY);
		seat8.setBounds(275,125,100,75);
		JLabel seatl08 = new JLabel("8");
		seatl08.setHorizontalAlignment(JLabel.CENTER);
		seatl08.setBounds(10, 10, 20, 20);
		
		seat8.add(seatl08);
		seatGP.add(seat8);
		
		if(sm.checkSeat(8) != null){
			JLabel seat8u = new JLabel(sm.checkSeat(8));
			seat8u.setBounds(10, 30, 50, 20);
			seat8u.setHorizontalAlignment(JLabel.CENTER);
			seat8u.setBackground(Color.white);
			seat8.add(seat8u);

		}else{
			JLabel seat8e = new JLabel();
			seat8e.setIcon(new ImageIcon(empty));
			seat8e.setBounds(10, 30, 90, 45);
			seat8.add(seat8e);
		}

		seat8.addMouseListener(new MyMouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int seatNo = 8;
				if(sm.checkSeat(seatNo) == null){
					EmptySeat es = new EmptySeat(mf, seatNo);
					changePanel(es);
				}else{
					InuseSeat us = new InuseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 9번좌석
		JPanel seat9 = new JPanel();
		seat9.setLayout(null);
		seat9.setBackground(Color.GRAY);
		seat9.setBounds(400, 125, 100, 75);
		JLabel seatl09 = new JLabel("9");
		seatl09.setHorizontalAlignment(JLabel.CENTER);
		seatl09.setBounds(10, 10, 20, 20);
		
		seat9.add(seatl09);
		seatGP.add(seat9);
		
		if(sm.checkSeat(9) != null){
			JLabel seat9u = new JLabel(sm.checkSeat(9));
			seat9u.setBounds(10, 30, 50, 20);
			seat9u.setHorizontalAlignment(JLabel.CENTER);
			seat9u.setBackground(Color.white);
			seat9.add(seat9u);

		}else{
			JLabel seat9e = new JLabel();
			seat9e.setIcon(new ImageIcon(empty));
			seat9e.setBounds(10, 30, 90, 45);
			seat9.add(seat9e);
		}

		seat9.addMouseListener(new MyMouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int seatNo = 9;
				if(sm.checkSeat(seatNo) == null){
					EmptySeat es = new EmptySeat(mf, seatNo);
					changePanel(es);
				}else{
					InuseSeat us = new InuseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 10번좌석
		JPanel seat10 = new JPanel();
		seat10.setLayout(null);
		seat10.setBackground(Color.GRAY);
		seat10.setBounds(525, 125, 100, 75);
		JLabel seatl10 = new JLabel("10");
		seatl10.setHorizontalAlignment(JLabel.CENTER);
		seatl10.setBounds(10, 10, 20, 20);
		
		seat10.add(seatl10);
		seatGP.add(seat10);
		
		if(sm.checkSeat(10) != null){
			JLabel seat10u = new JLabel(sm.checkSeat(10));
			seat10u.setBounds(10, 30, 50, 20);
			seat10u.setHorizontalAlignment(JLabel.CENTER);
			seat10u.setBackground(Color.white);
			seat10.add(seat10u);

		}else{
			JLabel seat10e = new JLabel();
			seat10e.setIcon(new ImageIcon(empty));
			seat10e.setBounds(10, 30, 90, 45);
			seat10.add(seat10e);
		}

		seat10.addMouseListener(new MyMouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int seatNo = 10;
				if(sm.checkSeat(seatNo) == null){
					EmptySeat es = new EmptySeat(mf, seatNo);
					changePanel(es);
				}else{
					InuseSeat us = new InuseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 11번좌석
		JPanel seat11 = new JPanel();
		seat11.setLayout(null);
		seat11.setBackground(Color.GRAY);
		seat11.setBounds(25, 225, 100, 75);
		JLabel seatl11 = new JLabel("11");
		seatl11.setHorizontalAlignment(JLabel.CENTER);
		seatl11.setBounds(10, 10, 20, 20);
		
		seat11.add(seatl11);
		seatGP.add(seat11);
		
		if(sm.checkSeat(11) != null){
			JLabel seat11u = new JLabel(sm.checkSeat(11));
			seat11u.setBounds(10, 30, 50, 20);
			seat11u.setHorizontalAlignment(JLabel.CENTER);
			seat11u.setBackground(Color.white);
			seat11.add(seat11u);

		}else{
			JLabel seat11e = new JLabel();
			seat11e.setIcon(new ImageIcon(empty));
			seat11e.setBounds(10, 30, 90, 45);
			seat11.add(seat11e);
		}

		seat11.addMouseListener(new MyMouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int seatNo = 11;
				if(sm.checkSeat(seatNo) == null){
					EmptySeat es = new EmptySeat(mf, seatNo);
					changePanel(es);
				}else{
					InuseSeat us = new InuseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 12번좌석
		JPanel seat12 = new JPanel();
		seat12.setLayout(null);
		seat12.setBackground(Color.GRAY);
		seat12.setBounds(150, 225, 100, 75);
		JLabel seatl12 = new JLabel("12");
		seatl12.setHorizontalAlignment(JLabel.CENTER);
		seatl12.setBounds(10, 10, 20, 20);
		
		seat12.add(seatl12);
		seatGP.add(seat12);
		
		if(sm.checkSeat(12) != null){
			JLabel seat12u = new JLabel(sm.checkSeat(12));
			seat12u.setBounds(10, 30, 50, 20);
			seat12u.setHorizontalAlignment(JLabel.CENTER);
			seat12u.setBackground(Color.white);
			seat12.add(seat12u);

		}else{
			JLabel seat12e = new JLabel();
			seat12e.setIcon(new ImageIcon(empty));
			seat12e.setBounds(10, 30, 90, 45);
			seat12.add(seat12e);
		}

		seat12.addMouseListener(new MyMouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int seatNo = 12;
				if(sm.checkSeat(seatNo) == null){
					EmptySeat es = new EmptySeat(mf, seatNo);
					changePanel(es);
				}else{
					InuseSeat us = new InuseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 13번좌석
		JPanel seat13 = new JPanel();
		seat13.setLayout(null);
		seat13.setBackground(Color.GRAY);
		seat13.setBounds(275, 225, 100, 75);
		JLabel seatl13 = new JLabel("13");
		seatl13.setHorizontalAlignment(JLabel.CENTER);
		seatl13.setBounds(10, 10, 20, 20);
		
		seat13.add(seatl13);
		seatGP.add(seat13);
		
		if(sm.checkSeat(13) != null){
			JLabel seat13u = new JLabel(sm.checkSeat(13));
			seat13u.setBounds(10, 30, 50, 20);
			seat13u.setHorizontalAlignment(JLabel.CENTER);
			seat13u.setBackground(Color.white);
			seat13.add(seat13u);

		}else{
			JLabel seat13e = new JLabel();
			seat13e.setIcon(new ImageIcon(empty));
			seat13e.setBounds(10, 30, 90, 45);
			seat13.add(seat13e);
		}

		seat13.addMouseListener(new MyMouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int seatNo = 13;
				if(sm.checkSeat(seatNo) == null){
					EmptySeat es = new EmptySeat(mf, seatNo);
					changePanel(es);
				}else{
					InuseSeat us = new InuseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 14번좌석
		JPanel seat14 = new JPanel();
		seat14.setLayout(null);
		seat14.setBackground(Color.GRAY);
		seat14.setBounds(400, 225, 100, 75);
		JLabel seatl14 = new JLabel("14");
		seatl14.setHorizontalAlignment(JLabel.CENTER);
		seatl14.setBounds(10, 10, 20, 20);
		
		seat14.add(seatl14);
		seatGP.add(seat14);
		
		if(sm.checkSeat(14) != null){
			JLabel seat14u = new JLabel(sm.checkSeat(14));
			seat14u.setBounds(10, 30, 50, 20);
			seat14u.setHorizontalAlignment(JLabel.CENTER);
			seat14u.setBackground(Color.white);
			seat14.add(seat14u);

		}else{
			JLabel seat14e = new JLabel();
			seat14e.setIcon(new ImageIcon(empty));
			seat14e.setBounds(10, 30, 90, 45);
			seat14.add(seat14e);
		}

		seat14.addMouseListener(new MyMouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int seatNo = 14;
				if(sm.checkSeat(seatNo) == null){
					EmptySeat es = new EmptySeat(mf, seatNo);
					changePanel(es);
				}else{
					InuseSeat us = new InuseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 15번좌석
		JPanel seat15 = new JPanel();
		seat15.setLayout(null);
		seat15.setBackground(Color.GRAY);
		seat15.setBounds(525, 225, 100, 75);
		JLabel seatl15 = new JLabel("15");
		seatl15.setHorizontalAlignment(JLabel.CENTER);
		seatl15.setBounds(10, 10, 20, 20);
		
		seat15.add(seatl15);
		seatGP.add(seat15);
		
		if(sm.checkSeat(15) != null){
			JLabel seat15u = new JLabel(sm.checkSeat(15));
			seat15u.setBounds(10, 30, 50, 20);
			seat15u.setHorizontalAlignment(JLabel.CENTER);
			seat15u.setBackground(Color.white);
			seat15.add(seat15u);

		}else{
			JLabel seat15e = new JLabel();
			seat15e.setIcon(new ImageIcon(empty));
			seat15e.setBounds(10, 30, 90, 45);
			seat15.add(seat15e);
		}

		seat15.addMouseListener(new MyMouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int seatNo = 15;
				if(sm.checkSeat(seatNo) == null){
					EmptySeat es = new EmptySeat(mf, seatNo);
					changePanel(es);
				}else{
					InuseSeat us = new InuseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 16번좌석
		JPanel seat16 = new JPanel();
		seat16.setLayout(null);
		seat16.setBackground(Color.GRAY);
		seat16.setBounds(25, 325, 100, 75);
		JLabel seatl16 = new JLabel("16");
		seatl16.setHorizontalAlignment(JLabel.CENTER);
		seatl16.setBounds(10, 10, 20, 20);
		
		seat16.add(seatl16);
		seatGP.add(seat16);
		
		if(sm.checkSeat(16) != null){
			JLabel seat16u = new JLabel(sm.checkSeat(16));
			seat16u.setBounds(10, 30, 50, 20);
			seat16u.setHorizontalAlignment(JLabel.CENTER);
			seat16u.setBackground(Color.white);
			seat16.add(seat16u);

		}else{
			JLabel seat16e = new JLabel();
			seat16e.setIcon(new ImageIcon(empty));
			seat16e.setBounds(10, 30, 90, 45);
			seat16.add(seat16e);
		}

		seat16.addMouseListener(new MyMouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int seatNo = 16;
				if(sm.checkSeat(seatNo) == null){
					EmptySeat es = new EmptySeat(mf, seatNo);
					changePanel(es);
				}else{
					InuseSeat us = new InuseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 17번좌석
		JPanel seat17 = new JPanel();
		seat17.setLayout(null);
		seat17.setBackground(Color.GRAY);
		seat17.setBounds(150, 325, 100, 75);
		JLabel seatl17 = new JLabel("17");
		seatl17.setHorizontalAlignment(JLabel.CENTER);
		seatl17.setBounds(10, 10, 20, 20);
		
		seat17.add(seatl17);
		seatGP.add(seat17);
		
		if(sm.checkSeat(17) != null){
			JLabel seat17u = new JLabel(sm.checkSeat(17));
			seat17u.setBounds(10, 30, 50, 20);
			seat17u.setHorizontalAlignment(JLabel.CENTER);
			seat17u.setBackground(Color.white);
			seat17.add(seat17u);

		}else{
			JLabel seat17e = new JLabel();
			seat17e.setIcon(new ImageIcon(empty));
			seat17e.setBounds(10, 30, 90, 45);
			seat17.add(seat17e);
		}

		seat17.addMouseListener(new MyMouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int seatNo = 17;
				if(sm.checkSeat(seatNo) == null){
					EmptySeat es = new EmptySeat(mf, seatNo);
					changePanel(es);
				}else{
					InuseSeat us = new InuseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 18번좌석
		JPanel seat18 = new JPanel();
		seat18.setLayout(null);
		seat18.setBackground(Color.GRAY);
		seat18.setBounds(275, 325, 100, 75);
		JLabel seatl18 = new JLabel("18");
		seatl18.setHorizontalAlignment(JLabel.CENTER);
		seatl18.setBounds(10, 10, 20, 20);
		
		seat18.add(seatl18);
		seatGP.add(seat18);
		
		if(sm.checkSeat(18) != null){
			JLabel seat18u = new JLabel(sm.checkSeat(18));
			seat18u.setBounds(10, 30, 50, 20);
			seat18u.setHorizontalAlignment(JLabel.CENTER);
			seat18u.setBackground(Color.white);
			seat18.add(seat18u);

		}else{
			JLabel seat18e = new JLabel();
			seat18e.setIcon(new ImageIcon(empty));
			seat18e.setBounds(10, 30, 90, 45);
			seat18.add(seat18e);
		}

		seat18.addMouseListener(new MyMouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int seatNo = 18;
				if(sm.checkSeat(seatNo) == null){
					EmptySeat es = new EmptySeat(mf, seatNo);
					changePanel(es);
				}else{
					InuseSeat us = new InuseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 19번좌석
		JPanel seat19 = new JPanel();
		seat19.setLayout(null);
		seat19.setBackground(Color.GRAY);
		seat19.setBounds(400, 325, 100, 75);
		JLabel seatl19 = new JLabel("19");
		seatl19.setHorizontalAlignment(JLabel.CENTER);
		seatl19.setBounds(10, 10, 20, 20);
		
		seat19.add(seatl19);
		seatGP.add(seat19);
		
		if(sm.checkSeat(19) != null){
			JLabel seat19u = new JLabel(sm.checkSeat(19));
			seat19u.setBounds(10, 30, 50, 20);
			seat19u.setHorizontalAlignment(JLabel.CENTER);
			seat19u.setBackground(Color.white);
			seat19.add(seat19u);

		}else{
			JLabel seat19e = new JLabel();
			seat19e.setIcon(new ImageIcon(empty));
			seat19e.setBounds(10, 30, 90, 45);
			seat19.add(seat19e);
		}

		seat19.addMouseListener(new MyMouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int seatNo = 19;
				if(sm.checkSeat(seatNo) == null){
					EmptySeat es = new EmptySeat(mf, seatNo);
					changePanel(es);
				}else{
					InuseSeat us = new InuseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 20번좌석
		JPanel seat20 = new JPanel();
		seat20.setLayout(null);
		seat20.setBackground(Color.GRAY);
		seat20.setBounds(525, 325, 100, 75);
		JLabel seatl20 = new JLabel("20");
		seatl20.setHorizontalAlignment(JLabel.CENTER);
		seatl20.setBounds(10, 10, 20, 20);
		
		seat20.add(seatl20);
		seatGP.add(seat20);
		
		if(sm.checkSeat(20) != null){
			JLabel seat20u = new JLabel(sm.checkSeat(20));
			seat20u.setBounds(10, 30, 50, 20);
			seat20u.setHorizontalAlignment(JLabel.CENTER);
			seat20u.setBackground(Color.white);
			seat20.add(seat20u);

		}else{
			JLabel seat20e = new JLabel();
			seat20e.setIcon(new ImageIcon(empty));
			seat20e.setBounds(10, 30, 90, 45);
			seat20.add(seat20e);
		}

		seat20.addMouseListener(new MyMouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int seatNo = 20;
				if(sm.checkSeat(seatNo) == null){
					EmptySeat es = new EmptySeat(mf, seatNo);
					changePanel(es);
				}else{
					InuseSeat us = new InuseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

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
