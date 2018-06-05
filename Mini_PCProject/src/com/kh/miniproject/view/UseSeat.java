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

		//메인 프레임과 같은 사이즈의 패널
		//JPanel start = new JPanel();

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
				MainPanel mPanel = new MainPanel(mf);
				changePanel(mPanel);
			}
		});
		this.add(goback);


		System.out.println("seatNo : " + seatNo);

		this.setLayout(null);
		this.setSize(mf.getSize());
		this.setBackground(Color.BLACK);

		//상단 제목 패널 //패널 위 라벨로 구성
		JPanel usePanel = new JPanel();
		usePanel.setLayout(null);
		usePanel.setLocation(300, 50);
		usePanel.setBackground(Color.WHITE);
		usePanel.setSize(600,100);
		JLabel titleLayer = new JLabel();
		Image titleLayerI = new ImageIcon("icon/titleLayer.png").getImage().getScaledInstance(600, 100, 0);
		titleLayer.setIcon(new ImageIcon(titleLayerI));
		titleLayer.setBounds(0, 0, 600, 100);
		//패널 위 제목 라벨
		JLabel text = new JLabel("좌석 추가");
		text.setSize(300, 50);
		text.setLocation(150, 25);
		text.setBackground(Color.GREEN);
		text.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		text.setHorizontalAlignment(JTextField.CENTER);
		usePanel.add(text);
		usePanel.add(titleLayer);

		//좌석추가 메인 패널 //
		JPanel timeMain = new JPanel();
		timeMain.setLayout(null);
		timeMain.setSize(1000,500);
		timeMain.setLocation(100, 200);
		timeMain.setBackground(Color.LIGHT_GRAY);
		//아이콘
		JLabel iconLabel = new JLabel();
		Image icon = new ImageIcon("icon/addSeat.PNG").getImage().getScaledInstance(100, 100, 0);
		iconLabel.setIcon(new ImageIcon(icon));
		iconLabel.setBounds(20, 20, 100, 100);
		//"좌석추가" 텍스트필드
		JTextField addTime = new JTextField("좌석 추가");
		addTime.setSize(300,100);
		addTime.setLocation(150, 20);
		addTime.setBackground(Color.BLACK);
		addTime.setForeground(Color.WHITE);
		addTime.setEditable(false);
		addTime.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		addTime.setHorizontalAlignment(JTextField.CENTER);
		//ID, 결제금액 입력 텍스트필드
		JLabel id = new JLabel("회원 아이디");
		JLabel seatNoL = new JLabel("좌석번호");
		id.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seatNoL.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		id.setBounds(30, 130, 100, 100);
		seatNoL.setBounds(30, 230, 100, 100);
		JTextField textId = new JTextField();
		textId.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		textId.setBounds(30, 200, 200, 30);

		JTextField textSeatNo = new JTextField();
		textSeatNo.setText(seatNo+"번 좌석");
		textSeatNo.setHorizontalAlignment(JLabel.CENTER);
		textSeatNo.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		textSeatNo.setEditable(false);
		textSeatNo.setBounds(30, 300, 200, 50);

		//좌석 추가 버튼
		JButton add = new RoundedButton("좌석추가");
		add.setBounds(30, 400, 150, 70);
		add.setBackground(Color.BLACK);
		add.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		add.setForeground(Color.WHITE);
		//중복 ID 출력 라벨
		JLabel idOverlap = new JLabel();
		idOverlap.setBounds(250, 165, 350, 100);
		idOverlap.setForeground(Color.RED);
		idOverlap.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		JLabel priceMin = new JLabel();
		priceMin.setBounds(250, 235, 300, 100);
		priceMin.setForeground(Color.RED);
		priceMin.setFont(new Font("맑은 고딕", Font.BOLD, 16));

		//좌석 추가 시 팝업창
		Dialog addTimeDial = new Dialog(mf);
		addTimeDial.setLayout(null);
		addTimeDial.setBounds(500, 400, 300, 180);
		addTimeDial.setBackground(Color.LIGHT_GRAY);

		JButton selectAdd = new JButton("예");
		selectAdd.setBounds(15, 100, 135, 60);
		JButton dialogClose = new JButton("아니오");
		dialogClose.setBounds(150, 100, 135, 60);

		JLabel addChoice = new JLabel("충전하시겠습니까?");
		addChoice.setBounds(15, 25, 200, 50);
		JTextField insertID = new JTextField();
		insertID.setHorizontalAlignment(JLabel.CENTER);
		insertID.setBounds(15, 60, 260, 30);
		insertID.setEditable(false);
		insertID.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		addTimeDial.add(addChoice);
		addTimeDial.add(selectAdd);
		addTimeDial.add(dialogClose);
		addTimeDial.add(insertID);

		//좌석추가 버튼 이벤트
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
					idOverlap.setText("해당 ID가 이미 사용중입니다.");
				}

				if(mList.getRestTime() == 0){
					restTime = 0;
					idOverlap.setText("해당 회원의 잔여시간이 없습니다.");
				}
				for(int i = 0; i < mTfList.size(); i++){
					if(mTfList.get(i).getId().equals(textId.getText())){
						checkAprov = false;
						idOverlap.setText("승인되지 않은 회원입니다.");
					}
				}
				if(checkUser == 0){			
					idOverlap.setText("존재하지 않는 회원입니다.");
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

		//좌석추가 팝업창 닫기 버튼
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

		//광고창
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
