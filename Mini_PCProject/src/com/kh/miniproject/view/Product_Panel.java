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

	//������ UI
public class Product_Panel  extends JPanel{
	private MainFrame mf;
	private JPanel mp;
	private Inventory_Management iMt= null;
	private String category_first = "���";
	
	public Product_Panel(MainFrame mf){
		
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");	//�������׸�
		}catch(Exception e){
		}
		
		this.mf = mf;   
		iMt = new Inventory_Management();	//������ �Ŵ���
		
		//���� �����Ӱ� ���� �������� �г�
		this.setLayout(null);
		this.setSize(mf.getSize());
		this.setBackground(Color.BLACK);
		
		// �ڷΰ��� ��ư
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
		
		
		//��� �ð��߰� �г� //�г� �� TextField�� ����
		JPanel addTimeText = new JPanel();
		addTimeText.setLayout(null);
		addTimeText.setLocation(300, 50);
		addTimeText.setBackground(Color.WHITE);
		addTimeText.setSize(600,100);
		
		//�г� �� "������" �ؽ�Ʈ�ʵ�
		JLabel text = new JLabel("������");
		text.setSize(200, 50);
		text.setLocation(200, 25);
		text.setBackground(Color.GREEN);
		text.setFont(new Font("���� ���", Font.BOLD, 40));
		text.setHorizontalAlignment(JTextField.CENTER);
		addTimeText.add(text);
		
		//�ϴ� ���� �г� //
		JPanel WHpanel = new JPanel();
		WHpanel.setLayout(new BorderLayout());
		WHpanel.setSize(1000,500);
		WHpanel.setLocation(100, 200);
		WHpanel.setBackground(Color.LIGHT_GRAY);

				
		// ������ �޴�
		JPanel MainMenuPanel = new JPanel();
		MainMenuPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		
		// - 1 ������ �޴� �����
		JPanel ViewPanel = new JPanel();
		
		first_list(ViewPanel);	//���۽� ù �гκ伳��
		
		String[] kinds = {"���", "ĵ����", "����", "Ŀ��"};
		JComboBox category = new JComboBox(kinds);			//ī�װ�
		
		category.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewPanel.removeAll();	//�гξȿ� �ִ� ������Ʈ �ʱ�ȭ
				category_first = (String)((JComboBox)e.getSource()).getSelectedItem();
				ArrayList<Product> category_list = iMt.Record(category_first); //�ش������� ��ǰ��
				
				//-1 ��� ����Ʈ
				int list_num = category_list.size();	//��� ����
				
				Product_List[] P_list = new Product_List[list_num];	//�гξ��
				ViewPanel.setLayout(new GridLayout(list_num+6, 1,5,5));
				
				for(int i=0;i<list_num;i++){
					P_list[i] = new Product_List(category_list.get(i),iMt);	//�гο� iMt�� ���� ���� ī�װ� ����Ʈ�� �ϳ��� �־� �гηθ����.
					ViewPanel.add(P_list[i]);
				}
				ViewPanel.setBorder(new MatteBorder(5, 10, 5, 10, Color.GRAY));
				ViewPanel.revalidate();				//���� �г� �Լ�ȣ��
			}
		});
		
		JScrollPane scrollSingle = new JScrollPane(ViewPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollSingle.getVerticalScrollBar().setUnitIncrement(16);    //��ũ�� �ӵ�
		WHpanel.add(scrollSingle,"Center");
		
		// - 2 �������  ��� ��ư
		JButton jtn1 = new JButton("��ǰ���â�ƾƾ�");			//��ǰ��Ϲ�ư
		JTextField jtx_Seach = new JTextField(9);
		JButton jtn_Seach = new JButton("�˻�");
		JButton jtn_Refresh = new JButton("���ΰ�ħ");
		
		//��ǰ���â ��ư
		jtn1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				iMt.Add(mf);
				mf.setEnabled(false);	//���������� ��Ȱ��
			}
		});
		//��ǰ�˻� ��ư
		jtn_Seach.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Product> pro = iMt.Seach(jtx_Seach.getText());
				if(jtx_Seach.getText().equals("") || pro.size() == 0){
					JOptionPane.showMessageDialog(null, "�ش� ��ǰ�� ���������ʽ��ϴ�.", "�Է� ����", JOptionPane.ERROR_MESSAGE);
				}else
					seach_list(ViewPanel,pro);
			}
		});
		//���ΰ�ħ ��ư
		jtn_Refresh.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				first_list(ViewPanel);	// �г� ���ΰ�ħ
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
	
	//������â �ʱ� "���" �г� ����
	public void first_list(JPanel ViewPanel){
		ViewPanel.removeAll();	//�гξȿ� �ִ� ������Ʈ �ʱ�ȭ
		ArrayList<Product> first_list = iMt.Record(category_first);
		
		//-1 ��� ����Ʈ
		int list_num = first_list.size();	//��� ����
		
		Product_List[] P_list = new Product_List[list_num];	//�гξ��
		ViewPanel.setLayout(new GridLayout(list_num+6, 1,5,5));
		
		for(int i=0;i<list_num;i++){
			P_list[i] = new Product_List(first_list.get(i),iMt);	//�гο� iMt�� ���� ���� ī�װ� ����Ʈ�� �ϳ��� �־� �гηθ����.
			ViewPanel.add(P_list[i]);
		}
		ViewPanel.setBorder(new MatteBorder(5, 10, 5, 10, Color.GRAY));
		ViewPanel.revalidate();				//���� �г� �Լ�ȣ��
	}
	 
	//������â �˻��� ����Ʈ �г� ����
	public void seach_list(JPanel ViewPanel, ArrayList<Product> product){
		ViewPanel.removeAll();	//�гξȿ� �ִ� ������Ʈ �ʱ�ȭ
		
		ArrayList<Product> first_list = product;
		int list_num = first_list.size();	//��� ����
		Product_List[] P_list = new Product_List[list_num];	//�гξ��
		ViewPanel.setLayout(new GridLayout(list_num+6, 1,5,5));
		
		for(int i=0;i<list_num;i++){
			P_list[i] = new Product_List(first_list.get(i),iMt);	//�гο� iMt�� ���� ���� ī�װ� ����Ʈ�� �ϳ��� �־� �гηθ����.
			ViewPanel.add(P_list[i]);
		}
		ViewPanel.setBorder(new MatteBorder(5, 10, 5, 10, Color.GRAY));
		ViewPanel.revalidate();				//���� �г� �Լ�ȣ��
	}
	
	public void changePanel(JPanel panel)
	{
		mf.remove(this);
		mf.add(panel);
		mf.repaint();
	}
}
