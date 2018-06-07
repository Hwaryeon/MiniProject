package com.kh.miniproject.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import com.kh.miniproject.ProductAndProfit.controller.Inventory_Management;
import com.kh.miniproject.ProductAndProfit.vo.Product;
import com.kh.miniproject.view.Product_List.Product_List;

	//재고관리 UI
public class Product_Panel  extends JPanel{
	private MainFrame mf;
	private JPanel mp;
	private Inventory_Management iMt= null;
	private String category_first = "라면";
	
	public Product_Panel(MainFrame mf){
		
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");	//윈도우테마
		}catch(Exception e){
		}
		
		this.mf = mf;   
		iMt = new Inventory_Management();	//재고관리 매니저
		
		//메인 프레임과 같은 사이즈의 패널
		this.setLayout(null);
		this.setSize(mf.getSize());
		this.setBackground(Color.BLACK);
		
		// 뒤로가기 버튼
		JButton goback = new JButton();
		Image back = new ImageIcon("icon/pointer.png").getImage().getScaledInstance(100, 100, 0);
		goback.setIcon(new ImageIcon(back));
		goback.setBounds(25, 25, 100, 100);
		goback.setBorderPainted(false);
		goback.setBackground(null);
		goback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainPanel mp = new MainPanel(mf);
				changePanel(mp);
			}
		});
		this.add(goback);
		
		
		//상단 시간추가 패널 //패널 위 TextField로 구성
		JPanel addTimeText = new JPanel();
		addTimeText.setLayout(null);
		addTimeText.setLocation(300, 50);
		addTimeText.setBackground(Color.WHITE);
		addTimeText.setSize(600,100);
		
		//패널 위 "재고관리" 텍스트필드
		JLabel text = new JLabel("재고관리");
		text.setSize(200, 50);
		text.setLocation(200, 25);
		text.setBackground(Color.GREEN);
		text.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		text.setHorizontalAlignment(JTextField.CENTER);
		addTimeText.add(text);
		
		//하단 메인 패널 //
		JPanel WHpanel = new JPanel();
		WHpanel.setLayout(new BorderLayout());
		WHpanel.setSize(1000,500);
		WHpanel.setLocation(100, 200);
		WHpanel.setBackground(Color.LIGHT_GRAY);

				
		// 재고관리 메뉴
		JPanel MainMenuPanel = new JPanel();
		MainMenuPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		
		// - 1 재고관리 메뉴 재고목록
		JPanel ViewPanel = new JPanel();
		
		first_list(ViewPanel);	//시작시 첫 패널뷰설정
		
		String[] kinds = {"라면", "캔음료", "과자", "커피"};
		JComboBox category = new JComboBox(kinds);			//카테고리
		
		category.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewPanel.removeAll();	//패널안에 있는 컴포넌트 초기화
				category_first = (String)((JComboBox)e.getSource()).getSelectedItem();
				ArrayList<Product> category_list = iMt.Record(category_first); //해당종류의 상품들
				
				//-1 재고 리스트
				int list_num = category_list.size();	//목록 갯수
				
				Product_List[] P_list = new Product_List[list_num];	//패널양식
				ViewPanel.setLayout(new GridLayout(list_num+6, 1,5,5));
				
				for(int i=0;i<list_num;i++){
					P_list[i] = new Product_List(category_list.get(i),iMt);	//패널에 iMt로 부터 받은 카테고리 리스트를 하나씩 넣어 패널로만든다.
					ViewPanel.add(P_list[i]);
				}
				ViewPanel.setBorder(new MatteBorder(5, 10, 5, 10, Color.GRAY));
				ViewPanel.revalidate();				//동적 패널 함수호출
			}
		});
		
		JScrollPane scrollSingle = new JScrollPane(ViewPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollSingle.getVerticalScrollBar().setUnitIncrement(16);    //스크롤 속도
		WHpanel.add(scrollSingle,"Center");
		
		// - 2 제고관리  상단 버튼
		JButton jtn1 = new JButton("제품등록창아아아");			//제품등록버튼
		JTextField jtx_Seach = new JTextField(9);
		JButton jtn_Seach = new JButton("검색");
		JButton jtn_Refresh = new JButton("새로고침");
		
		//제품등록창 버튼
		jtn1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				iMt.Add(mf);
				mf.setEnabled(false);	//메인프레임 비활성
			}
		});
		//제품검색 버튼
		jtn_Seach.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Product> pro = iMt.Seach(jtx_Seach.getText());
				if(jtx_Seach.getText().equals("") || pro.size() == 0){
					JOptionPane.showMessageDialog(null, "해당 제품은 존재하지않습니다.", "입력 오류", JOptionPane.ERROR_MESSAGE);
				}else
					seach_list(ViewPanel,pro);
			}
		});
		//새로고침 버튼
		jtn_Refresh.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				first_list(ViewPanel);	// 패널 새로고침
			}
		});
		
		
		MainMenuPanel.add(category,"North");
		MainMenuPanel.add(jtn1,"North");
		MainMenuPanel.add(jtx_Seach,"North");
		MainMenuPanel.add(jtn_Seach,"North");
		MainMenuPanel.add(jtn_Refresh,"North");
		
		WHpanel.add(MainMenuPanel,"North");
		
		this.add(WHpanel);
		this.add(addTimeText);
		mf.add(this);
		
	}
	
	//재고관리창 초기 "라면" 패널 설정
	public void first_list(JPanel ViewPanel){
		ViewPanel.removeAll();	//패널안에 있는 컴포넌트 초기화
		ArrayList<Product> first_list = iMt.Record(category_first);
		
		//-1 재고 리스트
		int list_num = first_list.size();	//목록 갯수
		
		Product_List[] P_list = new Product_List[list_num];	//패널양식
		ViewPanel.setLayout(new GridLayout(list_num+6, 1,5,5));
		
		for(int i=0;i<list_num;i++){
			P_list[i] = new Product_List(first_list.get(i),iMt);	//패널에 iMt로 부터 받은 카테고리 리스트를 하나씩 넣어 패널로만든다.
			ViewPanel.add(P_list[i]);
		}
		ViewPanel.setBorder(new MatteBorder(5, 10, 5, 10, Color.GRAY));
		ViewPanel.revalidate();				//동적 패널 함수호출
	}
	 
	//재고관리창 검색한 리스트 패널 설정
	public void seach_list(JPanel ViewPanel, ArrayList<Product> product){
		ViewPanel.removeAll();	//패널안에 있는 컴포넌트 초기화
		
		ArrayList<Product> first_list = product;
		int list_num = first_list.size();	//목록 갯수
		Product_List[] P_list = new Product_List[list_num];	//패널양식
		ViewPanel.setLayout(new GridLayout(list_num+6, 1,5,5));
		
		for(int i=0;i<list_num;i++){
			P_list[i] = new Product_List(first_list.get(i),iMt);	//패널에 iMt로 부터 받은 카테고리 리스트를 하나씩 넣어 패널로만든다.
			ViewPanel.add(P_list[i]);
		}
		ViewPanel.setBorder(new MatteBorder(5, 10, 5, 10, Color.GRAY));
		ViewPanel.revalidate();				//동적 패널 함수호출
	}
	
	public void changePanel(JPanel panel)
	{
		mf.remove(this);
		mf.add(panel);
		mf.repaint();
	}
}
