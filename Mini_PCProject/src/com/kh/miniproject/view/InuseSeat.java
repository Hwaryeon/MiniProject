package com.kh.miniproject.view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.kh.miniproject.member.dao.MemberDao;
import com.kh.miniproject.member.vo.Member;
import com.kh.miniproject.seat.controller.SeatManager;

public class InuseSeat extends JPanel 
{
	private MainFrame mf;
	private MemberDao md = new MemberDao();
	private SeatManager sm = new SeatManager();

	useTimeCheck tc;

	public InuseSeat(MainFrame mf, Member m, int seatNo) 
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
				MainPanel mp = new MainPanel(mf);
				changePanel(mp);
			}
		});
		this.add(goback);

		//상단 제목 패널 //패널 위 라벨로 구성
		JPanel inUsePanel = new JPanel();
		inUsePanel.setLayout(null);
		inUsePanel.setLocation(300, 50);
		inUsePanel.setBackground(Color.WHITE);
		inUsePanel.setSize(600,100);
		JLabel titleLayer = new JLabel();
		Image titleLayerI = new ImageIcon("icon/titleLayer.png").getImage().getScaledInstance(600, 100, 0);
		titleLayer.setIcon(new ImageIcon(titleLayerI));
		titleLayer.setBounds(0, 0, 600, 100);
		//패널 위 제목 라벨
		JLabel text = new JLabel("사용중인 좌석");
		text.setSize(300, 50);
		text.setLocation(150, 25);
		text.setBackground(Color.GREEN);
		text.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		text.setHorizontalAlignment(JTextField.CENTER);
		inUsePanel.add(text);
		inUsePanel.add(titleLayer);

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
		iconp.setBounds(0, 110, 400, 425);
		iconp.setBackground(Color.LIGHT_GRAY);
		Font font = new Font("맑은고딕", Font.BOLD, 18);
		// 시간추가 버튼
		JButton timePlus = new JButton();
		Image clock = new ImageIcon("icon/addSeat.PNG").getImage().getScaledInstance(150, 150, 0);
		timePlus.setIcon(new ImageIcon(clock));
		timePlus.setBackground(null);
		timePlus.setBounds(20, 110, 150, 150);
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
		JLabel timePlusL = new JLabel("시간추가");
		timePlusL.setFont(font);
		timePlusL.setHorizontalAlignment(JLabel.CENTER);
		timePlusL.setBounds(20, 260, 150, 25);

		iconp.add(timePlus);
		iconp.add(timePlusL);

		//사용종료 버튼
		JButton endBtn = new JButton();
		Image monitor = new ImageIcon("icon/enduse.PNG").getImage().getScaledInstance(150, 150, 0);
		endBtn.setIcon(new ImageIcon(monitor));
		endBtn.setBackground(null);
		endBtn.setBounds(200, 110, 150, 150);
		endBtn.setBorderPainted(false);
		endBtn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				sm.exitSeat(seatNo);
				MainPanel mp = new MainPanel(mf);
				changePanel(mp);
			}
		});
		JLabel endBtnL = new JLabel("사용종료");
		endBtnL.setFont(font);
		endBtnL.setHorizontalAlignment(JLabel.CENTER);
		endBtnL.setBounds(200, 260, 150, 25);

		iconp.add(endBtn);
		iconp.add(endBtnL);

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

		JTextField seatNoLabel = new JTextField(seatNo+"");
		seatNoLabel.setHorizontalAlignment(JLabel.CENTER);
		seatNoLabel.setBounds(25,120,100,100);
		seatNoLabel.setBackground(Color.BLACK);
		seatNoLabel.setForeground(Color.WHITE);
		seatNoLabel.setFont(new Font("맑은고딕", Font.BOLD, 40));
		seatP.add(seatNoLabel);
		//사용중인 좌석 내부패널
		JPanel seatInUse = new JPanel();
		seatInUse.setLayout(null);
		seatInUse.setBackground(Color.LIGHT_GRAY);
		seatInUse.setBounds(15, 110, 620, 410);
		seatP.add(seatInUse);
		//아이디 출력
		JTextField useIDL = new JTextField("아이디");
		useIDL.setBounds(10, 120, 150, 50);
		useIDL.setFont(new Font("맑은고딕", Font.BOLD, 30));
		useIDL.setBackground(Color.BLACK);
		useIDL.setForeground(Color.WHITE);
		useIDL.setEditable(false);
		seatInUse.add(useIDL);
		JTextField useIDT = new JTextField(m.getId());
		useIDT.setBounds(170, 120, 150, 50);
		useIDT.setFont(new Font("맑은고딕", Font.BOLD, 30));
		useIDT.setBackground(Color.BLACK);
		useIDT.setForeground(Color.WHITE);
		useIDT.setEditable(false);
		seatInUse.add(useIDT);
		//이름 출력
		JTextField useNameL = new JTextField("이름");
		useNameL.setBounds(10, 190, 150, 50);
		useNameL.setFont(new Font("맑은고딕", Font.BOLD, 30));
		useNameL.setBackground(Color.BLACK);
		useNameL.setForeground(Color.WHITE);
		useNameL.setEditable(false);
		seatInUse.add(useNameL);
		JTextField useNameT = new JTextField(m.getName());
		useNameT.setBounds(170, 190, 150, 50);
		useNameT.setFont(new Font("맑은고딕", Font.BOLD, 30));
		useNameT.setBackground(Color.BLACK);
		useNameT.setForeground(Color.WHITE);
		useNameT.setEditable(false);
		seatInUse.add(useNameT);
		//잔여시간 출력
		JTextField useRestTimeL = new JTextField("잔여시간");
		useRestTimeL.setBounds(10, 260, 150, 50);
		useRestTimeL.setFont(new Font("맑은고딕", Font.BOLD, 30));
		useRestTimeL.setBackground(Color.BLACK);
		useRestTimeL.setForeground(Color.WHITE);
		useRestTimeL.setEditable(false);
		seatInUse.add(useRestTimeL);
		JTextField useRestTimeT = new JTextField();

		useRestTimeT.setText(md.conversionTime(m.getRestTime()));

		useRestTimeT.setBounds(170, 260, 150, 50);
		useRestTimeT.setFont(new Font("맑은고딕", Font.BOLD, 30));
		useRestTimeT.setBackground(Color.BLACK);
		useRestTimeT.setForeground(Color.WHITE);
		useRestTimeT.setEditable(false);
		seatInUse.add(useRestTimeT);
		//사용시간 출력
		JTextField useAccTimeL = new JTextField("사용시간");
		useAccTimeL.setBounds(10, 330, 150, 50);
		useAccTimeL.setFont(new Font("맑은고딕", Font.BOLD, 30));
		useAccTimeL.setBackground(Color.BLACK);
		useAccTimeL.setForeground(Color.WHITE);
		useAccTimeL.setEditable(false);
		seatInUse.add(useAccTimeL);


		JTextField useAccTimeT = new JTextField("");

		tc = new useTimeCheck(mf, useAccTimeT, seatNo);
		tc.start();

		useAccTimeT.setBounds(170, 330, 150, 50);
		useAccTimeT.setFont(new Font("맑은고딕", Font.BOLD, 30));
		useAccTimeT.setBackground(Color.BLACK);
		useAccTimeT.setForeground(Color.WHITE);
		useAccTimeT.setEditable(false);
		seatInUse.add(useAccTimeT);

		JLabel guksuImage = new JLabel();
		Image guksu = new ImageIcon("icon/guksu.PNG").getImage().getScaledInstance(270, 390, 0);
		guksuImage.setIcon(new ImageIcon(guksu));
		guksuImage.setBounds(340, 10, 270, 390);

		seatInUse.add(guksuImage);

		menu.add(iconp);

		this.add(menu);
		this.add(seatP);
		this.add(inUsePanel);

		mf.add(this);

	}

	public void changePanel(JPanel panel)
	{
		mf.remove(this);
		mf.add(panel);
		mf.repaint();
		tc.interrupt();

	}
}
