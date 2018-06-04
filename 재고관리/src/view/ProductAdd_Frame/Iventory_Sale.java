package view.ProductAdd_Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import dao.InventoryDao;
import view.ProductAdd_Frame.subFunction.NumberField;
import vo.Product;

//��ǰ �Ǹ�â
public class Iventory_Sale extends JFrame{
	//�Ű����� - ��ǰ�̸� , ��ǰ����, ��ǰ����, ��ǰ����
	InventoryDao iDao = null;	//������ ��Ʈ�ѷ�
	
	public Iventory_Sale(Product pro ,InventoryDao iDao, JLabel num_jbl){
		super("�Ǹ� â");
		this.iDao = iDao;
		
		this.setVisible(true);
		this.setSize(350,500);
		this.setLayout(null);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				dispose();	//�ݱ�
			}});
		
		ImageIcon ic  = new ImageIcon(pro.getPhoto());
		JLabel img_label  = new JLabel(ic);
		img_label.setLocation(80,50);
		img_label.setSize(150,150);
		this.add(img_label);
		
		JPanel panel_view = new JPanel();
		panel_view.setLayout(new GridLayout(5,2,3,5));
		
		JLabel name_label  = new JLabel("��ǰ �̸� : ");
		panel_view.add(name_label,"East");
		panel_view.add(new JTextField(pro.getNames()));
		
		JLabel num_label  = new JLabel("��ǰ ���� : ");
		panel_view.add(num_label);
		JTextField num_text = new JTextField(""+pro.getCount());
		panel_view.add(num_text);
		
		JLabel sale_label  = new JLabel("�Ǹ��� ���� : ");
		panel_view.add(sale_label);
		JTextField jtf = new NumberField(2);
		jtf.setDocument(new JTextFieldLimit(2));
		panel_view.add(jtf); 
		
		panel_view.add(new JLabel(""));
		JButton btn = new JButton("�Ǹ��ϱ�");
		btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

				if(jtf.getText().equals("")){
					JOptionPane.showMessageDialog(null, "�Ǹ��� ������ �����Ͽ��ּ���", "�Է� ����", JOptionPane.ERROR_MESSAGE);
				}else{
					int Quantity = Integer.parseInt(jtf.getText());
					if(Quantity > pro.getCount() || Quantity == 0){
						JOptionPane.showMessageDialog(null, "���� ���������� �Ǹ��� ������ �����ϴ�.", "�Է� ����", JOptionPane.ERROR_MESSAGE);
					}else{
						num_jbl.setText("  ��ǰ������  : "+(pro.getCount()-Quantity));
						iDao.product_Sale(pro, Quantity);	//dao�� ������� ����
						
						dispose();	//������â����
					}
				}
			}
		});
		panel_view.add(btn);

		panel_view.setLocation(50,250);
		panel_view.setSize(220,180);
		this.add(panel_view);
		
	}
	
	//�ؽ�Ʈ�ʵ� �Է±��� ����
	class JTextFieldLimit extends PlainDocument {
		private int limit;
		private boolean toUppercase = false;

		JTextFieldLimit(int limit) {
			super();
			this.limit = limit;
		}

		JTextFieldLimit(int limit, boolean upper) {
			super();
			this.limit = limit;
			this.toUppercase = upper;
		}

		public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
			if (str == null) {
				return;
			}

			if ( (getLength() + str.length()) <= limit) {
				if (toUppercase) {
					str = str.toUpperCase();
				}
				super.insertString(offset, str, attr);
			}
		}
	}
}