package com.kh.miniproject.view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

import com.kh.miniproject.iTime.ConversionTime;
import com.kh.miniproject.member.controller.MemberManager;
import com.kh.miniproject.member.vo.Member;
import com.kh.miniproject.view.decoration.RoundedButton;

public class MemberManagement extends JPanel implements ConversionTime{
	private MainFrame mf;
	private MainPanel mp;

	MemberManager mm = new MemberManager();

	public MemberManagement(MainFrame mf){
		this.mf = mf;

		this.setLayout(null);
		this.setSize(mf.getWidth(), mf.getHeight());
		this.setBackground(Color.BLACK);
		
		//상단 회원관리 패널 //패널 위 라벨로 구성
		JPanel memberManagePanel = new JPanel();
		memberManagePanel.setLayout(null);
		memberManagePanel.setLocation(300, 50);
		memberManagePanel.setBackground(Color.WHITE);
		memberManagePanel.setSize(600,100);
		JLabel titleLayer = new JLabel();
		Image titleLayerI = new ImageIcon("icon/titleLayer.png").getImage().getScaledInstance(600, 100, 0);
		titleLayer.setIcon(new ImageIcon(titleLayerI));
		titleLayer.setBounds(0, 0, 600, 100);
		//패널 위 "회원가입" 라벨
		JLabel text = new JLabel("회원관리");
		text.setSize(200, 50);
		text.setLocation(200, 25);
		text.setBackground(Color.GREEN);
		text.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		text.setHorizontalAlignment(JTextField.CENTER);
		memberManagePanel.add(text);
		memberManagePanel.add(titleLayer);

		// 뒤로가기 버튼
		JButton goback = new JButton();
		Image back = new ImageIcon("icon/pointer.png").getImage().getScaledInstance(100, 100, 0);
		goback.setIcon(new ImageIcon(back));
		goback.setBorderPainted(false);
		goback.setBounds(25, 25, 100, 100);
		goback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainPanel mp = new MainPanel(mf);
				changePanel(mp);
			}
		});
		this.add(goback);

		//라디오 버튼
		JRadioButton list = new JRadioButton("회원 리스트");
		list.setBounds(0, 0, 200, 50);
		list.setBackground(Color.LIGHT_GRAY);
		JRadioButton approve = new JRadioButton("회원 승인");
		approve.setBounds(200, 0, 200, 50);
		approve.setBackground(Color.LIGHT_GRAY);
		JRadioButton search = new JRadioButton("회원 찾기");
		search.setBounds(400, 0, 200, 50);
		search.setBackground(Color.LIGHT_GRAY);

		ButtonGroup memberButton = new ButtonGroup();
		memberButton.add(list);
		memberButton.add(approve);
		memberButton.add(search);


		//회원관리 메인 패널 //
		JPanel member = new JPanel();
		member.setLayout(null);
		member.setSize(1000,500);
		member.setLocation(100, 200);
		member.setBackground(Color.LIGHT_GRAY);


		member.add(search);
		member.add(approve);
		member.add(list);

		//회원리스트 패널
		JPanel memberlist = new JPanel();
		memberlist.setLayout(null);
		memberlist.setSize(950,400);
		memberlist.setLocation(25, 75);

		ArrayList<Member> mList =  mm.memberList();

		String[] listHeader = {"회원아이디", "이름", "잔여시간", "누적시간"};
		String[][] listContents = new String[mList.size()][listHeader.length];

		for(int i = 0; i < mList.size(); i++){
			for(int j = 0; j < 4; j++){
				switch(j){
				case 0 :
					listContents[i][j]
							= new String(mList.get(i).getId());		
					break;
				case 1 : 
					listContents[i][j]
							= new String(mList.get(i).getName());
					break;
				case 2 :
					listContents[i][j]
							= new String(conversionTime(mList.get(i).getRestTime()));
					break;
				case 3 :
					listContents[i][j]
							= new String(conversionTime(mList.get(i).getAccTime()));
					break;
				}
			}
		}

		JTable tableList = new JTable(listContents, listHeader);
		tableList.setBounds(0,0,800,300);

		tableList.getTableHeader().setReorderingAllowed(false);

		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		tableList.getColumn("회원아이디").setCellRenderer(celAlignCenter);
		tableList.getColumn("이름").setCellRenderer(celAlignCenter);
		tableList.getColumn("잔여시간").setCellRenderer(celAlignCenter);
		tableList.getColumn("누적시간").setCellRenderer(celAlignCenter);
		JScrollPane scrollList = new JScrollPane(tableList);

		scrollList.setBounds(0,0,950,400);

		memberlist.add(scrollList);

		//회원승인 패널
		JPanel memberApprove = new JPanel();
		memberApprove.setLayout(null);
		memberApprove.setSize(950,400);
		memberApprove.setLocation(25, 75);
		memberApprove.setBackground(Color.YELLOW);

		mList =  mm.memberTFList(false);

		String[] approveHeader = {"회원아이디", "이름", "전화번호", "승인여부"};
		String[][] approveContents = new String[mList.size()][approveHeader.length];

		label:
			for(int i = 0; i < mList.size(); i++){
				if(mList.get(i).getAdmission() == true){
					continue label;
				}
				for(int j = 0; j < 4; j++){

					switch(j){
					case 0 :
						approveContents[i][j]
								= new String(mList.get(i).getId());		
						break;
					case 1 : 
						approveContents[i][j]
								= new String(mList.get(i).getName());
						break;
					case 2 :
						approveContents[i][j]
								= new String(mList.get(i).getpNumber());
						break;
					case 3 :
						approveContents[i][j]
								= new String("비승인");
						break;
					}
				}
			}



		JTable tableSearch = new JTable(approveContents, approveHeader);
		tableSearch.setBounds(0, 0, 800, 200);
		tableSearch.getTableHeader().setReorderingAllowed(false);

		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		tableSearch.getColumn("회원아이디").setCellRenderer(celAlignCenter);
		tableSearch.getColumn("이름").setCellRenderer(celAlignCenter);
		tableSearch.getColumn("전화번호").setCellRenderer(celAlignCenter);
		tableSearch.getColumn("승인여부").setCellRenderer(celAlignCenter);

		JScrollPane scrollSearch = new JScrollPane(tableSearch);
		scrollSearch.setBounds(0,0,800,200);

		memberApprove.add(scrollSearch);

		JLabel roundLabel = new JLabel();
		Image roundImage = new ImageIcon("icon/life.PNG").getImage().getScaledInstance(800, 200, 0);
		roundLabel.setIcon(new ImageIcon(roundImage));
		roundLabel.setBounds(0, 200, 800, 200);
		memberApprove.add(roundLabel);

		JLabel khLabel = new JLabel();
		Image khImage = new ImageIcon("icon/khcop.PNG").getImage().getScaledInstance(150, 360, 0);
		khLabel.setIcon(new ImageIcon(khImage));
		khLabel.setBounds(800, 40, 150, 360);
		memberApprove.add(khLabel);

		JButton approveBtn = new JButton("승인");
		approveBtn.setBounds(800, 0, 150, 40);
		approveBtn.setForeground(Color.WHITE);
		approveBtn.setBackground(Color.black);
		approveBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));


		Dialog approveDialog = new Dialog(mf);
		approveDialog.setLayout(null);
		approveDialog.setBounds(500, 400, 300, 180);
		approveDialog.setBackground(Color.LIGHT_GRAY);


		JButton selectApv = new JButton("승인하기");
		selectApv.setBounds(15, 100, 135, 60);
		JButton dialogClose = new JButton("닫기");
		dialogClose.setBounds(150, 100, 135, 60);

		JLabel apvID = new JLabel("아이디를 입력하세요");
		apvID.setBounds(15, 25, 200, 50);
		JTextField insertID = new JTextField();
		insertID.setHorizontalAlignment(JLabel.CENTER);
		insertID.setBounds(15, 60, 260, 30);



		approveDialog.add(apvID);
		approveDialog.add(selectApv);
		approveDialog.add(dialogClose);
		approveDialog.add(insertID);

		//승인하기 버튼 추가

		memberApprove.add(approveBtn);

		//승인 팝업창 //승인여부 false인 회원 불러와서 승인해주는 기능 연결 필요
		approveBtn.addActionListener(new ActionListener(){	
			@Override
			public void actionPerformed(ActionEvent e) {
				approveDialog.setVisible(true);


			}

		});
		//승인 버튼
		selectApv.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				mm.memberAdmission(insertID.getText());
				System.out.println("승인되었습니다");
				insertID.setText("승인되었습니다");

			}

		});	

		//승인 팝업창 닫기 버튼
		dialogClose.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				approveDialog.setVisible(false);

			}

		});


		//회원찾기 패널
		JPanel memberSearch = new JPanel();
		memberSearch.setLayout(null);
		memberSearch.setSize(950,400);
		memberSearch.setLocation(25, 75);

		JLabel panelLayout = new JLabel();
		Image layoutImage = new ImageIcon("icon/line.PNG").getImage().getScaledInstance(15, 400, 0);
		panelLayout.setIcon(new ImageIcon(layoutImage));
		panelLayout.setBounds(250, 0, 15, 400);
		memberSearch.add(panelLayout);
		//회원 찾기 패널에 올라갈 아이디 관련 컴포넌트 생성
		JLabel idLabel = new JLabel("회원 이름");
		JTextField idSearch = new JTextField();
		JLabel emailLabel = new JLabel("이메일");
		JTextField emailSearch = new JTextField();

		JLabel idField = new JLabel("아이디 : ");
		//
		JTextField idResult = new JTextField();
		JButton idSearchBtn = new RoundedButton("아이디 찾기");

		//컴포넌트 ID부분 세부설정
		idLabel.setBounds(15, 0, 100, 50);
		idLabel.setBackground(Color.WHITE);
		idLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));	

		idSearch.setBounds(15, 50, 200, 35);
		idSearch.setFont(new Font("맑은 고딕", Font.BOLD, 14));

		emailLabel.setBounds(15, 100, 100, 50);
		emailLabel.setBackground(Color.WHITE);
		emailLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));

		emailSearch.setBounds(15, 150, 200, 35);
		emailSearch.setFont(new Font("맑은 고딕", Font.BOLD, 14));

		idField.setBounds(10, 220, 100, 50);
		idField.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		idResult.setBounds(85, 230, 150, 35);
		idResult.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		idResult.setEditable(false);

		idSearchBtn.setBounds(50, 330, 150, 50);
		idSearchBtn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		idSearchBtn.setBackground(Color.BLACK);
		idSearchBtn.setForeground(Color.WHITE);

		idSearchBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				/*System.out.println(idSearch.getText());
						System.out.println(emailSearch.getText());*/
				idResult.setText(mm.idSearch(idSearch.getText(), emailSearch.getText()));
				//mm.idSearch(idSearch.getText(), emailSearch.getText());

			}

		});	

		//컴포넌트 PWD 부분 추가
		JLabel pwdLabel = new JLabel("회원 아이디");
		JTextField pwdSearch = new JTextField();
		JLabel nameLabel = new JLabel("회원 이름");
		JTextField nameSearch = new JTextField();

		JLabel pwdField = new JLabel("비밀번호 : ");
		//
		JTextField pwdResult = new JTextField();
		JButton pwdSearchBtn = new RoundedButton("비밀번호 찾기");

		//컴포넌트 PWD 부분 세부 설정
		pwdLabel.setBounds(280, 0, 100, 50);
		pwdLabel.setBackground(Color.WHITE);
		pwdLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));	

		pwdSearch.setBounds(280, 50, 200, 35);
		pwdSearch.setFont(new Font("맑은 고딕", Font.BOLD, 14));

		nameLabel.setBounds(280, 100, 100, 50);
		nameLabel.setBackground(Color.WHITE);
		nameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));

		nameSearch.setBounds(280, 150, 200, 35);
		nameSearch.setFont(new Font("맑은 고딕", Font.BOLD, 14));

		pwdField.setBounds(280, 220, 100, 50);
		pwdField.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		pwdResult.setBounds(375, 230, 150, 35);
		pwdResult.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		pwdResult.setEditable(false);

		pwdSearchBtn.setBounds(330, 330, 150, 50);
		pwdSearchBtn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		pwdSearchBtn.setBackground(Color.BLACK);
		pwdSearchBtn.setForeground(Color.WHITE);


		pwdSearchBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				pwdResult.setText(mm.pwSearch(pwdSearch.getText(), nameSearch.getText()));

			}

		});

		JLabel refriPlz = new JLabel();
		Image refriImage = new ImageIcon("icon/refri.PNG").getImage().getScaledInstance(380, 350, 0);
		refriPlz.setIcon(new ImageIcon(refriImage));
		refriPlz.setBounds(540, 25, 380, 350);
		memberSearch.add(refriPlz);


		memberSearch.add(pwdSearchBtn);
		memberSearch.add(pwdResult);
		memberSearch.add(pwdField);
		memberSearch.add(nameSearch);
		memberSearch.add(nameLabel);
		memberSearch.add(pwdSearch);
		memberSearch.add(pwdLabel);

		memberSearch.add(idResult);
		memberSearch.add(idField);
		memberSearch.add(emailSearch);
		memberSearch.add(emailLabel);
		memberSearch.add(idSearch);
		memberSearch.add(idLabel);
		memberSearch.add(idSearchBtn);



		list.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(list.isSelected()){
					member.remove(memberApprove);
					member.remove(memberSearch);
					member.add(memberlist);
					member.repaint();
				}else{
					System.out.println("");
				}

			}
		});

		approve.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(approve.isSelected()){
					member.remove(memberlist);
					member.remove(memberSearch);
					member.add(memberApprove);
					member.repaint();

				}else{
					System.out.println("");
				}
			}		
		});

		search.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(search.isSelected()){
					member.remove(memberlist);
					member.remove(memberApprove);
					member.add(memberSearch);
					member.repaint();
				}else{
					System.out.println("");
				}
			}		
		});



		this.add(member);
		this.add(memberManagePanel);
		mf.add(this);
	}
	
	public void changePanel(JPanel panel)
	{
		mf.remove(this);
		mf.add(panel);
		mf.repaint();
	}

	@Override
	public String conversionTime(int time){
		long cTime = time;

		long second = (long) ((cTime ) % 60);
		long minute = (long) ((cTime / (  60)) % 60);
		long hour = (long) ((cTime / ( 60 * 60)));
		String s = null;
		
		//System.out.printf("%02d:%02d:%02d", hour, minute, second);
		s = String.format("%02d:%02d:%02d", hour, minute, second);
		
		System.out.print(s);
		
		return s;
	}
}