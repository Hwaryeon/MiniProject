package com.kh.miniproject.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EtchedBorder;

import com.kh.miniproject.event.MyMouseAdapter;
import com.kh.miniproject.member.controller.MemberManager;
import com.kh.miniproject.seat.controller.SeatManager;

public class MainPanel extends JPanel 
{
	private MainFrame mf;
	private SeatManager sm = new SeatManager();
	private MemberManager mm = new MemberManager();

	public ArrayList<Thread> thList = new ArrayList(20);

	public MainPanel(MainFrame mf) 
	{
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		this.mf = mf;
		this.setSize(mf.getWidth(), mf.getHeight());
		this.setLayout(null);
		this.setBackground(Color.BLACK);

		//µÚ·Î°¡±â ¹öÆ°
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

		//»ó´Ü Á¦¸ñ ÆÐ³Î //ÆÐ³Î À§ ¶óº§·Î ±¸¼º
		JPanel title = new JPanel();
		title.setLayout(null);
		title.setLocation(300, 50);
		title.setBackground(Color.WHITE);
		title.setSize(600,100);
		JLabel titleLayer = new JLabel();
		Image titleLayerI = new ImageIcon("icon/titleLayer.png").getImage().getScaledInstance(600, 100, 0);
		titleLayer.setIcon(new ImageIcon(titleLayerI));
		titleLayer.setBounds(0, 0, 600, 100);
		//ÆÐ³Î À§ Á¦¸ñ ¶óº§
		JLabel text = new JLabel("¾Ñ! ÇÇ½Ã¹æºñ°¡ Å¸ÀÌ¾îº¸´Ù ½Î´Ù!");
		text.setSize(600, 50);
		text.setLocation(0, 25);
		text.setBackground(Color.GREEN);
		text.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 40));
		text.setHorizontalAlignment(JLabel.CENTER);
		title.add(text);
		title.add(titleLayer);
		this.add(title);

		// ¸Þ´ºÆÐ³Î
		JPanel menu = new JPanel();
		menu.setBackground(Color.LIGHT_GRAY);
		menu.setLayout(null);
		menu.setBounds(75, 200, 400, 525);
		JLabel menul = new JLabel("¸Þ´º");
		menul.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 40));
		menul.setForeground(Color.BLACK);
		menul.setHorizontalAlignment(JLabel.CENTER);
		EtchedBorder eborder = new EtchedBorder(EtchedBorder.RAISED);
		menul.setBorder(eborder);
		menul.setBounds(0, 0, 400, 100);
		menu.add(menul);

		/* JLabel capture = new JLabel();
	      Image capImage = new ImageIcon("icon/menu.png").getImage().getScaledInstance(400, 100, 0);
	      capture.setIcon(new ImageIcon(capImage));
	      capture.setBounds(0, 0, 400, 100);
		
	      menu.add(capture);*/
		
		// ¾ÆÀÌÄÜÆÐ³Î
		JPanel iconp = new JPanel();
		iconp.setLayout(null);
		iconp.setBounds(0, 100, 400, 425);
		iconp.setBackground(Color.LIGHT_GRAY);
		Font font = new Font("¸¼Àº°íµñ", Font.BOLD, 18);
		// ½Ã°£Ãß°¡ ¹öÆ°
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
		JLabel timePlusL = new JLabel("½Ã°£Ãß°¡");
		timePlusL.setFont(font);
		timePlusL.setHorizontalAlignment(JLabel.CENTER);
		timePlusL.setBounds(25, 180, 150, 25);
		// È¸¿ø°ü¸® ¹öÆ°
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
		JLabel userL = new JLabel("È¸¿ø°ü¸®");
		userL.setFont(font);
		userL.setHorizontalAlignment(JLabel.CENTER);
		userL.setBounds(225, 180, 150, 25);
		// ¼öÀÍ°ü¸® ¹öÆ°
		JButton chart = new JButton();
		Image graph = new ImageIcon("icon/graph.png").getImage().getScaledInstance(150, 150, 0);
		chart.setIcon(new ImageIcon(graph));
		chart.setBackground(null);
		chart.setBounds(25, 225, 150, 150);
		chart.setBorderPainted(false);
		JLabel chartL = new JLabel("¸ÅÃâ°ü¸®");
		chartL.setFont(font);
		chartL.setHorizontalAlignment(JLabel.CENTER);
		chartL.setBounds(25, 380, 150, 25);

		chart.addMouseListener(new MyMouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("¼öÀÍ°ü¸® ...");
				Profit_view pv = new Profit_view(mf);
				changePanel(pv);

			}
		});


		// Àç°í°ü¸® ¹öÆ°
		JButton product = new JButton();
		Image cart = new ImageIcon("icon/shopping.png").getImage().getScaledInstance(150, 150, 0);
		product.setIcon(new ImageIcon(cart));
		product.setBackground(null);
		product.setBorderPainted(false);
		product.setBounds(225, 225, 150, 150);
		JLabel productL = new JLabel("Àç°í°ü¸®");
		productL.setFont(font);
		productL.setHorizontalAlignment(JLabel.CENTER);
		productL.setBounds(225, 380, 150, 25);

		product.addMouseListener(new MyMouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Àç°í°ü¸® ...");

				Product_Panel pp = new Product_Panel(mf);
				changePanel(pp);

			}
		});

		iconp.add(timePlus);
		iconp.add(timePlusL);
		iconp.add(manageuser);
		iconp.add(userL);
		iconp.add(chart);
		iconp.add(chartL);
		iconp.add(product);
		iconp.add(productL);

		// ÁÂ¼®ÆÐ³Î
		JPanel seatP = new JPanel();
		seatP.setLayout(null);
		seatP.setBounds(500, 200, 650, 525);
		seatP.setBackground(Color.LIGHT_GRAY);
		JLabel seatTitle = new JLabel("ÁÂ¼®");
		seatTitle.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 40));
		seatTitle.setHorizontalAlignment(JLabel.CENTER);
		seatTitle.setBorder(eborder);
		seatTitle.setBounds(0, 0, 650, 100);
		seatP.add(seatTitle);

		// ºñ¾îÀÖÀ½(empty)
		Image empty = new ImageIcon("icon/empty.png").getImage().getScaledInstance(70, 25, 0);
		JPanel seatGP = new JPanel();
		seatGP.setLayout(null);
		seatGP.setBounds(0, 100, 650, 425);
		seatGP.setBackground(null);

		// 1¹øÁÂ¼® 1
		JPanel seat1 = new JPanel();
		seat1.setLayout(null);
		seat1.setBackground(Color.GRAY);

		seat1.setBounds(25, 25, 100, 75);
		//seat1.setBounds(25, 25, 500, 580);
		JLabel seatl01 = new JLabel("1");
		seatl01.setHorizontalAlignment(JLabel.CENTER);
		seatl01.setBounds(10, 10, 20, 20);

		seat1.add(seatl01);

		seatGP.add(seat1);
		if(sm.checkSeat(1) != null){
			JTextField useTime = new JTextField("»ç¿ë½Ã°£");
			useTime.setBounds(10, 50, 70, 20);
			useTime.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 13));
			useTime.setHorizontalAlignment(JLabel.CENTER);
			useTime.setBackground(Color.BLACK);
			useTime.setForeground(Color.WHITE);
			useTime.setEditable(false);
			seat1.add(useTime);

			JLabel seat1u = new JLabel(sm.checkSeat(1));
			seat1u.setBounds(10, 30, 50, 20);
			seat1u.setHorizontalAlignment(JLabel.CENTER);
			seat1u.setBackground(Color.RED);
			seat1.add(seat1u);
			UseTimeCheck tc = new UseTimeCheck(mf, /*seat1, */useTime, 1);
			thList.add(tc);
			tc.start();
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
					//GamePanel gp = new GamePanel(mf);
					EmptySeat es = new EmptySeat(mf, seatNo);
					//seatGP.add(gp);
					changePanel(es);
				}else{
					InUseSeat us = new InUseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)),
							seatNo);
					changePanel(us);
				}
			}
		});

		// 2¹øÁÂ¼®
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
			JTextField useTime2 = new JTextField("»ç¿ë½Ã°£");
			useTime2.setBounds(10, 50, 70, 20);
			useTime2.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 13));
			useTime2.setHorizontalAlignment(JLabel.CENTER);
			useTime2.setBackground(Color.BLACK);
			useTime2.setForeground(Color.WHITE);
			useTime2.setEditable(false);
			seat2.add(useTime2);

			JLabel seat2u = new JLabel(sm.checkSeat(2));
			seat2u.setBounds(10, 30, 50, 20);
			seat2u.setHorizontalAlignment(JLabel.CENTER);
			seat2u.setBackground(Color.white);
			seat2.add(seat2u);
			UseTimeCheck tc = new UseTimeCheck(mf,useTime2, 2);
			thList.add(tc);
			tc.start();
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
					InUseSeat us = new InUseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 3¹øÁÂ¼®
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
			JTextField useTime3 = new JTextField("»ç¿ë½Ã°£");
			useTime3.setBounds(10, 50, 70, 20);
			useTime3.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 13));
			useTime3.setHorizontalAlignment(JLabel.CENTER);
			useTime3.setBackground(Color.BLACK);
			useTime3.setForeground(Color.WHITE);
			useTime3.setEditable(false);
			seat3.add(useTime3);
			JLabel seat3u = new JLabel(sm.checkSeat(3));
			seat3u.setBounds(10, 30, 50, 20);
			seat3u.setHorizontalAlignment(JLabel.CENTER);
			seat3u.setBackground(Color.white);
			seat3.add(seat3u);
			UseTimeCheck tc = new UseTimeCheck(mf,  useTime3, 3);
			thList.add(tc);
			tc.start();

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
					InUseSeat us = new InUseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 4¹øÁÂ¼®
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
			JTextField useTime4 = new JTextField("»ç¿ë½Ã°£");
			useTime4.setBounds(10, 50, 70, 20);
			useTime4.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 13));
			useTime4.setHorizontalAlignment(JLabel.CENTER);
			useTime4.setBackground(Color.BLACK);
			useTime4.setForeground(Color.WHITE);
			useTime4.setEditable(false);
			seat4.add(useTime4);
			JLabel seat4u = new JLabel(sm.checkSeat(4));
			seat4u.setBounds(10, 30, 50, 20);
			seat4u.setHorizontalAlignment(JLabel.CENTER);
			seat4u.setBackground(Color.white);
			seat4.add(seat4u);
			UseTimeCheck tc = new UseTimeCheck(mf, useTime4, 4);
			thList.add(tc);
			tc.start();


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
					InUseSeat us = new InUseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 5¹øÁÂ¼®
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

			JTextField useTime5 = new JTextField("»ç¿ë½Ã°£");
			useTime5.setBounds(10, 50, 70, 20);
			useTime5.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 13));
			useTime5.setHorizontalAlignment(JLabel.CENTER);
			useTime5.setBackground(Color.BLACK);
			useTime5.setForeground(Color.WHITE);
			useTime5.setEditable(false);
			seat5.add(useTime5);
			JLabel seat5u = new JLabel(sm.checkSeat(5));
			seat5u.setBounds(10, 30, 50, 20);
			seat5u.setHorizontalAlignment(JLabel.CENTER);
			seat5u.setBackground(Color.white);
			seat5.add(seat5u);
			UseTimeCheck tc = new UseTimeCheck(mf, useTime5, 5);
			thList.add(tc);
			tc.start();

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
					InUseSeat us = new InUseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}

			}
		});


		// 6¹ø ÁÂ¼®
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
			JTextField useTime6 = new JTextField("»ç¿ë½Ã°£");
			useTime6.setBounds(10, 50, 70, 20);
			useTime6.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 13));
			useTime6.setHorizontalAlignment(JLabel.CENTER);
			useTime6.setBackground(Color.BLACK);
			useTime6.setForeground(Color.WHITE);
			useTime6.setEditable(false);
			seat6.add(useTime6);
			JLabel seat6u = new JLabel(sm.checkSeat(6));
			seat6u.setBounds(10, 30, 50, 20);
			seat6u.setHorizontalAlignment(JLabel.CENTER);
			seat6u.setBackground(Color.white);
			seat6.add(seat6u);
			UseTimeCheck tc = new UseTimeCheck(mf, useTime6, 6);
			thList.add(tc);
			tc.start();

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
					InUseSeat us = new InUseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 7¹øÁÂ¼®
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
			JTextField useTime7 = new JTextField("»ç¿ë½Ã°£");
			useTime7.setBounds(10, 50, 70, 20);
			useTime7.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 13));
			useTime7.setHorizontalAlignment(JLabel.CENTER);
			useTime7.setBackground(Color.BLACK);
			useTime7.setForeground(Color.WHITE);
			useTime7.setEditable(false);
			seat7.add(useTime7);
			JLabel seat7u = new JLabel(sm.checkSeat(7));
			seat7u.setBounds(10, 30, 50, 20);
			seat7u.setHorizontalAlignment(JLabel.CENTER);
			seat7u.setBackground(Color.white);
			seat7.add(seat7u);
			UseTimeCheck tc = new UseTimeCheck(mf,  useTime7, 7);
			thList.add(tc);
			tc.start();

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
					InUseSeat us = new InUseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 8¹øÁÂ¼®
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
			JTextField useTime8 = new JTextField("»ç¿ë½Ã°£");
			useTime8.setBounds(10, 50, 70, 20);
			useTime8.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 13));
			useTime8.setHorizontalAlignment(JLabel.CENTER);
			useTime8.setBackground(Color.BLACK);
			useTime8.setForeground(Color.WHITE);
			useTime8.setEditable(false);
			seat8.add(useTime8);
			JLabel seat8u = new JLabel(sm.checkSeat(8));
			seat8u.setBounds(10, 30, 50, 20);
			seat8u.setHorizontalAlignment(JLabel.CENTER);
			seat8u.setBackground(Color.white);
			seat8.add(seat8u);
			UseTimeCheck tc = new UseTimeCheck(mf, useTime8, 8);
			thList.add(tc);
			tc.start();

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
					InUseSeat us = new InUseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 9¹øÁÂ¼®
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
			JTextField useTime9 = new JTextField("»ç¿ë½Ã°£");
			useTime9.setBounds(10, 50, 70, 20);
			useTime9.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 13));
			useTime9.setHorizontalAlignment(JLabel.CENTER);
			useTime9.setBackground(Color.BLACK);
			useTime9.setForeground(Color.WHITE);
			useTime9.setEditable(false);
			seat9.add(useTime9);
			JLabel seat9u = new JLabel(sm.checkSeat(9));
			seat9u.setBounds(10, 30, 50, 20);
			seat9u.setHorizontalAlignment(JLabel.CENTER);
			seat9u.setBackground(Color.white);
			seat9.add(seat9u);
			UseTimeCheck tc = new UseTimeCheck(mf, useTime9, 9);
			thList.add(tc);
			tc.start();

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
					InUseSeat us = new InUseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 10¹øÁÂ¼®
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
			JTextField useTime10 = new JTextField("»ç¿ë½Ã°£");
			useTime10.setBounds(10, 50, 70, 20);
			useTime10.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 13));
			useTime10.setHorizontalAlignment(JLabel.CENTER);
			useTime10.setBackground(Color.BLACK);
			useTime10.setForeground(Color.WHITE);
			useTime10.setEditable(false);
			seat10.add(useTime10);
			JLabel seat10u = new JLabel(sm.checkSeat(10));
			seat10u.setBounds(10, 30, 50, 20);
			seat10u.setHorizontalAlignment(JLabel.CENTER);
			seat10u.setBackground(Color.white);
			seat10.add(seat10u);
			UseTimeCheck tc = new UseTimeCheck(mf, useTime10, 10);
			thList.add(tc);
			tc.start();

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
					InUseSeat us = new InUseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 11¹øÁÂ¼®
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
			JTextField useTime11 = new JTextField("»ç¿ë½Ã°£");
			useTime11.setBounds(10, 50, 70, 20);
			useTime11.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 13));
			useTime11.setHorizontalAlignment(JLabel.CENTER);
			useTime11.setBackground(Color.BLACK);
			useTime11.setForeground(Color.WHITE);
			useTime11.setEditable(false);
			seat11.add(useTime11);
			JLabel seat11u = new JLabel(sm.checkSeat(11));
			seat11u.setBounds(10, 30, 50, 20);
			seat11u.setHorizontalAlignment(JLabel.CENTER);
			seat11u.setBackground(Color.white);
			seat11.add(seat11u);
			UseTimeCheck tc = new UseTimeCheck(mf, useTime11, 11);
			thList.add(tc);
			tc.start();

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
					InUseSeat us = new InUseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 12¹øÁÂ¼®
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
			JTextField useTime12 = new JTextField("»ç¿ë½Ã°£");
			useTime12.setBounds(10, 50, 70, 20);
			useTime12.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 13));
			useTime12.setHorizontalAlignment(JLabel.CENTER);
			useTime12.setBackground(Color.BLACK);
			useTime12.setForeground(Color.WHITE);
			useTime12.setEditable(false);
			seat12.add(useTime12);
			JLabel seat12u = new JLabel(sm.checkSeat(12));
			seat12u.setBounds(10, 30, 50, 20);
			seat12u.setHorizontalAlignment(JLabel.CENTER);
			seat12u.setBackground(Color.white);
			seat12.add(seat12u);
			UseTimeCheck tc = new UseTimeCheck(mf,  useTime12, 12);
			thList.add(tc);
			tc.start();

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
					InUseSeat us = new InUseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 13¹øÁÂ¼®
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
			JTextField useTime13 = new JTextField("»ç¿ë½Ã°£");
			useTime13.setBounds(10, 50, 70, 20);
			useTime13.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 13));
			useTime13.setHorizontalAlignment(JLabel.CENTER);
			useTime13.setBackground(Color.BLACK);
			useTime13.setForeground(Color.WHITE);
			useTime13.setEditable(false);
			seat13.add(useTime13);
			JLabel seat13u = new JLabel(sm.checkSeat(13));
			seat13u.setBounds(10, 30, 50, 20);
			seat13u.setHorizontalAlignment(JLabel.CENTER);
			seat13u.setBackground(Color.white);
			seat13.add(seat13u);
			UseTimeCheck tc = new UseTimeCheck(mf,  useTime13, 13);
			thList.add(tc);
			tc.start();
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
					InUseSeat us = new InUseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 14¹øÁÂ¼®
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
			JTextField useTime14 = new JTextField("»ç¿ë½Ã°£");
			useTime14.setBounds(10, 50, 70, 20);
			useTime14.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 13));
			useTime14.setHorizontalAlignment(JLabel.CENTER);
			useTime14.setBackground(Color.BLACK);
			useTime14.setForeground(Color.WHITE);
			useTime14.setEditable(false);
			seat14.add(useTime14);
			JLabel seat14u = new JLabel(sm.checkSeat(14));
			seat14u.setBounds(10, 30, 50, 20);
			seat14u.setHorizontalAlignment(JLabel.CENTER);
			seat14u.setBackground(Color.white);
			seat14.add(seat14u);
			UseTimeCheck tc = new UseTimeCheck(mf,  useTime14, 14);
			thList.add(tc);
			tc.start();

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
					InUseSeat us = new InUseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 15¹øÁÂ¼®
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
			JTextField useTime15 = new JTextField("»ç¿ë½Ã°£");
			useTime15.setBounds(10, 50, 70, 20);
			useTime15.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 13));
			useTime15.setHorizontalAlignment(JLabel.CENTER);
			useTime15.setBackground(Color.BLACK);
			useTime15.setForeground(Color.WHITE);
			useTime15.setEditable(false);
			seat15.add(useTime15);
			JLabel seat15u = new JLabel(sm.checkSeat(15));
			seat15u.setBounds(10, 30, 50, 20);
			seat15u.setHorizontalAlignment(JLabel.CENTER);
			seat15u.setBackground(Color.white);
			seat15.add(seat15u);
			UseTimeCheck tc = new UseTimeCheck(mf, useTime15, 15);
			thList.add(tc);
			tc.start();

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
					InUseSeat us = new InUseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 16¹øÁÂ¼®
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
			JTextField useTime16 = new JTextField("»ç¿ë½Ã°£");
			useTime16.setBounds(10, 50, 70, 20);
			useTime16.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 13));
			useTime16.setHorizontalAlignment(JLabel.CENTER);
			useTime16.setBackground(Color.BLACK);
			useTime16.setForeground(Color.WHITE);
			useTime16.setEditable(false);
			seat16.add(useTime16);
			JLabel seat16u = new JLabel(sm.checkSeat(16));
			seat16u.setBounds(10, 30, 50, 20);
			seat16u.setHorizontalAlignment(JLabel.CENTER);
			seat16u.setBackground(Color.white);
			seat16.add(seat16u);
			UseTimeCheck tc = new UseTimeCheck(mf, useTime16, 16);
			thList.add(tc);
			tc.start();

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
					InUseSeat us = new InUseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 17¹øÁÂ¼®
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
			JTextField useTime17 = new JTextField("»ç¿ë½Ã°£");
			useTime17.setBounds(10, 50, 70, 20);
			useTime17.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 13));
			useTime17.setHorizontalAlignment(JLabel.CENTER);
			useTime17.setBackground(Color.BLACK);
			useTime17.setForeground(Color.WHITE);
			useTime17.setEditable(false);
			seat17.add(useTime17);
			JLabel seat17u = new JLabel(sm.checkSeat(17));
			seat17u.setBounds(10, 30, 50, 20);
			seat17u.setHorizontalAlignment(JLabel.CENTER);
			seat17u.setBackground(Color.white);
			seat17.add(seat17u);
			UseTimeCheck tc = new UseTimeCheck(mf,useTime17, 17);
			thList.add(tc);
			tc.start();

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
					InUseSeat us = new InUseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 18¹øÁÂ¼®
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
			JTextField useTime18 = new JTextField("»ç¿ë½Ã°£");
			useTime18.setBounds(10, 50, 70, 20);
			useTime18.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 13));
			useTime18.setHorizontalAlignment(JLabel.CENTER);
			useTime18.setBackground(Color.BLACK);
			useTime18.setForeground(Color.WHITE);
			useTime18.setEditable(false);
			seat18.add(useTime18);
			JLabel seat18u = new JLabel(sm.checkSeat(18));
			seat18u.setBounds(10, 30, 50, 20);
			seat18u.setHorizontalAlignment(JLabel.CENTER);
			seat18u.setBackground(Color.white);
			seat18.add(seat18u);
			UseTimeCheck tc = new UseTimeCheck(mf, useTime18, 18);
			thList.add(tc);
			tc.start();

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
					InUseSeat us = new InUseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 19¹øÁÂ¼®
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
			JTextField useTime19 = new JTextField("»ç¿ë½Ã°£");
			useTime19.setBounds(10, 50, 70, 20);
			useTime19.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 13));
			useTime19.setHorizontalAlignment(JLabel.CENTER);
			useTime19.setBackground(Color.BLACK);
			useTime19.setForeground(Color.WHITE);
			useTime19.setEditable(false);
			seat19.add(useTime19);
			JLabel seat19u = new JLabel(sm.checkSeat(19));
			seat19u.setBounds(10, 30, 50, 20);
			seat19u.setHorizontalAlignment(JLabel.CENTER);
			seat19u.setBackground(Color.white);
			seat19.add(seat19u);
			UseTimeCheck tc = new UseTimeCheck(mf, useTime19, 19);
			thList.add(tc);
			tc.start();

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
					InUseSeat us = new InUseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
					changePanel(us);
				}
			}
		});

		// 20¹øÁÂ¼®
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
			JTextField useTime20 = new JTextField("»ç¿ë½Ã°£");
			useTime20.setBounds(10, 50, 70, 20);
			useTime20.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 13));
			useTime20.setHorizontalAlignment(JLabel.CENTER);
			useTime20.setBackground(Color.BLACK);
			useTime20.setForeground(Color.WHITE);
			useTime20.setEditable(false);
			seat20.add(useTime20);
			JLabel seat20u = new JLabel(sm.checkSeat(20));
			seat20u.setBounds(10, 30, 50, 20);
			seat20u.setHorizontalAlignment(JLabel.CENTER);
			seat20u.setBackground(Color.white);
			seat20.add(seat20u);
			UseTimeCheck tc = new UseTimeCheck(mf, useTime20, 20);
			thList.add(tc);
			tc.start();

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
					InUseSeat us = new InUseSeat(mf, mm.memberInfo(sm.checkSeat(seatNo)), seatNo);
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

	public int thEnd(){
		for(int i = 0; i < thList.size(); i++){

			thList.get(i).interrupt();

		}
		return 0;
	}

	public void changePanel(JPanel panel)
	{
		mf.remove(this);
		mf.add(panel);
		mf.repaint();

		for(int i = 0; i < thList.size(); i++){
			thList.get(i).interrupt();
		}
	}
}
