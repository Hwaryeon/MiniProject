package com.kh.miniproject.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.Map;

import javax.swing.*;


public class AddTimePanel{
	private MainFrame mf;
	private JPanel mp;
	
	public AddTimePanel(MainFrame mf){
		this.mf = mf;
		
		//메인 프레임과 같은 사이즈의 패널
		JPanel start = new JPanel();
		
		start.setLayout(null);
		start.setSize(mf.getSize());
		start.setBackground(Color.BLACK);
		
		//상단 시간추가 패널 //패널 위 라벨로 구성
		JPanel addTimeText = new JPanel();
		addTimeText.setLayout(null);
		addTimeText.setLocation(300, 50);
		addTimeText.setBackground(Color.WHITE);
		addTimeText.setSize(600,100);
		//패널 위 "결제화면" 라벨
		JLabel text = new JLabel("결제화면");
		text.setSize(200, 50);
		text.setLocation(200, 25);
		text.setBackground(Color.GREEN);
		text.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		text.setHorizontalAlignment(JTextField.CENTER);
		addTimeText.add(text);
		
		//시간추가 메인 패널 //
		JPanel timeMain = new JPanel();
		timeMain.setLayout(null);
		timeMain.setSize(1000,500);
		timeMain.setLocation(100, 200);
		timeMain.setBackground(Color.LIGHT_GRAY);
		//아이콘
		JLabel iconLabel = new JLabel();
		Image icon = new ImageIcon("icon/cashIcon.PNG").getImage().getScaledInstance(100, 100, 0);
		iconLabel.setIcon(new ImageIcon(icon));
		iconLabel.setBounds(20, 20, 100, 100);
		//"시간추가" 텍스트필드
		JTextField addTime = new JTextField("시간 추가");
		addTime.setSize(300,100);
		addTime.setLocation(150, 20);
		addTime.setBackground(Color.BLACK);
		addTime.setForeground(Color.WHITE);
		addTime.setEditable(false);
		addTime.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		addTime.setHorizontalAlignment(JTextField.CENTER);
		//ID, 결제금액 입력 텍스트필드
		JLabel id = new JLabel("회원 아이디");
		JLabel price = new JLabel("금액");
		id.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		price.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		id.setBounds(30, 130, 100, 100);
		price.setBounds(30, 200, 100, 100);
		JTextField textId = new JTextField();
		JTextField textPrice = new JTextField(" 금액 액수 입력");
		textId.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		textPrice.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		textId.setBounds(30, 200, 200, 30);
		textPrice.setBounds(30, 270, 200, 30);
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
		JLabel priceToTime = new JLabel("03 : 00 시간 충전");
		priceToTime.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		priceToTime.setBounds(0, 25, 200, 50);
		priceToTime.setBackground(Color.RED);
		priceToTime.setHorizontalAlignment(JLabel.CENTER);
		labelLayout.add(priceToTime);
		//시간 추가 버튼
		JButton add = new JButton("추가");
		add.setBounds(30, 400, 150, 70);
		add.setBackground(Color.BLACK);
		add.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		add.setForeground(Color.WHITE);
		//중복 ID, 최소금액 출력 라벨
		JLabel idOverlap = new JLabel("존재하지 않는 회원입니다.");
		idOverlap.setBounds(250, 165, 300, 100);
		idOverlap.setForeground(Color.RED);
		idOverlap.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		JLabel priceMin = new JLabel("최소 1000원 이상 결제해야 합니다");
		priceMin.setBounds(250, 235, 300, 100);
		priceMin.setForeground(Color.RED);
		priceMin.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		//광고창
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
		timeMain.add(textPrice);
		timeMain.add(id);
		timeMain.add(price);
		timeMain.add(addTime);
		timeMain.add(iconLabel);
		
		
		mf.add(timeMain);
		mf.add(addTimeText);
		mf.add(start);
		
		
		
	}
	
	
}
