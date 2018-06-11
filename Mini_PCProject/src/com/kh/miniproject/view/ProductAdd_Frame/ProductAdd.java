package com.kh.miniproject.view.ProductAdd_Frame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.kh.miniproject.ProductAndProfit.model.dao.InventoryDao;
import com.kh.miniproject.ProductAndProfit.model.vo.Product;
import com.kh.miniproject.view.MainFrame;
import com.kh.miniproject.view.ProductAdd_Frame.subFunction.ImageFileView;
import com.kh.miniproject.view.ProductAdd_Frame.subFunction.ImagePreview;
import com.kh.miniproject.view.ProductAdd_Frame.subFunction.NumberField;

public class ProductAdd extends JFrame {

	private String newline = System.getProperty("line.separator");
	String path= null;
	Image icon = null;
	JLabel label = null;
	JTextField nameText = null;
	JTextField priceText = null;
	JTextField numberText = null;
	String kinds = "���";
	File file = null;

	InventoryDao iAdd = null;

	MainFrame mf = null;
	
	public ProductAdd(InventoryDao iAdd, MainFrame mf) {
		super("��� �߰�");
		this.setSize(500,200);
		this.setResizable(false);

		this.mf = mf;
		//		try{
		//			
		////			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");	//�������׸�
		//			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");			//�Թ����׸�
		//		}catch(Exception e){
		//		}

		this.setLayout(new GridLayout(1,2,10,20));

		this.iAdd = iAdd;

		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				mf.setEnabled(true);
				
				dispose();	//�ݱ�
			}});



		//-----------------------------------------------------------------------
		JPanel left = new JPanel();
		left.setLayout(new BorderLayout());
		left.setBorder(new BevelBorder(BevelBorder.RAISED));
		Image icon = new ImageIcon("IMAGE/DONOTFOUND.PNG").getImage().getScaledInstance(150, 150, 0);
		label = new JLabel(new ImageIcon(icon));
		label.setBorder(new BevelBorder(BevelBorder.RAISED));

		JButton btn = new JButton("Brouser");
		btn.addActionListener(new BrowserListener());

		left.add(label, "North");
		left.add(btn, "South");

		//-----------------------------------------------------------------------------

		JPanel right = new JPanel();
		right.setLayout(new FlowLayout());
		right.setBorder(new BevelBorder(BevelBorder.RAISED));

		JLabel namelabel = new JLabel("��ǰ�̸� : ", JLabel.LEFT);
		nameText = new JTextField(10);
		JLabel pricelabel = new JLabel("��ǰ���� : ", JLabel.LEFT);
		priceText = new NumberField(10);
		JLabel numberlabel = new JLabel("��ǰ���� : ", JLabel.LEFT);
		numberText = new NumberField(10);

		right.add(namelabel);
		right.add(nameText);
		right.add(pricelabel);
		right.add(priceText);
		right.add(numberlabel);
		right.add(numberText);

		String[] kind = {"���", "ĵ����", "����", "Ŀ��"};
		JComboBox kinds = new JComboBox(kind);
		kinds.setSelectedIndex(0);
		kinds.addActionListener(new ComboListener());

		JButton add_btn = new JButton("��ǰ���");
		add_btn.addActionListener(new AddListener((String)(kinds.getSelectedItem())));

		right.add(kinds);
		right.add(add_btn, "South");

		//-----------------------------------------

		this.add(left);
		this.add(right);

		this.setVisible(true);
	}
	
	private class BrowserListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			showChooser();
		}

		public void showChooser(){
			JFileChooser filechooser = new JFileChooser("C:/Users/1/Desktop/abc/");

			filechooser.setAcceptAllFileFilterUsed(false);		//�������� AllŸ�� ���ֱ�
			filechooser.setFileFilter(new FileNameExtensionFilter("PNG", "PNG"));	//�������� PNG
			filechooser.setFileView(new ImageFileView());
			filechooser.setAccessory(new ImagePreview(filechooser));

			int returnVal = filechooser.showDialog(null,"����");

			if (returnVal == JFileChooser.APPROVE_OPTION) {

				file = filechooser.getSelectedFile();
				path = file.getPath();		//�������� ���ϼ��ý� ��θ� �����Ѵ�.
				System.out.println(path);
				icon = new ImageIcon(path).getImage().getScaledInstance(150, 150, 0);
				label.setIcon(new ImageIcon(icon));

			} else {
				System.out.println("���");
			}
		}
	}
	class AddListener implements ActionListener {
		public AddListener(String combo) {
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			//���� ����
			try(FileInputStream input = new FileInputStream(file.getPath());
					FileOutputStream output = new FileOutputStream(new File("IMAGE/"+file.getName()));){

				iAdd.product_Add(new Product(nameText.getText(), Integer.parseInt(priceText.getText())
						, Integer.parseInt(numberText.getText()), kinds, "IMAGE/"+file.getName()));
				
				int readBuffer = 0;
				byte [] buffer = new byte[512];
				while((readBuffer = input.read(buffer)) != -1) {
					output.write(buffer, 0, readBuffer);
				}
				System.out.println("������ ����Ǿ����ϴ�.");
				mf.setEnabled(true);
				dispose();		//���â �ݱ�

			}catch(NumberFormatException ex){
				String errors = "��ǰ�̸�";
				if(nameText.getText().equals(""))
					errors = "��ǰ�̸��� �����Ͽ��ֽñ� �ٶ��ϴ�."; 
				else if(priceText.getText().equals(""))
					errors = "��ǰ�� ������ �����Ͽ��ֽñ� �ٶ��ϴ�.";
				else if(numberText.getText().equals(""))
					errors = "��ǰ�� ������ �����Ͽ��ֽñ� �ٶ��ϴ�.";

				JOptionPane.showMessageDialog(null, errors, "�Է� ����", JOptionPane.ERROR_MESSAGE);
			}catch(NullPointerException ex){
				JOptionPane.showMessageDialog(null, "������ ���������ʾҽ��ϴ�.", "�Է� ����", JOptionPane.ERROR_MESSAGE);
				new BrowserListener().showChooser();	//���� ���ñ� ȣ��
			}catch(IOException ex){
				System.out.println("IO ���� �߻�");
				ex.printStackTrace();
			}
		}
	}
	public class ComboListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JComboBox k = (JComboBox)e.getSource();
			kinds = (String) k.getSelectedItem();
		}
	}

}
