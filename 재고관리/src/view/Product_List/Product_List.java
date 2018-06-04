package view.Product_List;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import controller.Inventory_Management;
import vo.Product;

public class Product_List extends JPanel{
	//������ ��Ͽ� ������ ����Ʈ�г�

	public Product_List(Product pro, Inventory_Management iMt){
		
		this.setBorder(new MatteBorder(5, 10, 5, 10, Color.black));
		//		this.setLayout(new BorderLayout());
		this.setLayout(new GridLayout(1,20,5,5));
		
		this.setBackground(Color.LIGHT_GRAY);
		Image ic  = new ImageIcon(pro.getPhoto()).getImage().getScaledInstance(100, 100, 0);
		JLabel img_label  = new JLabel(new ImageIcon(ic));
		
		this.add(img_label,"West");

		this.add(new JLabel("  ��ǰ�̸� : "+pro.getNames()),"Center");
		this.add(new JLabel("  ��ǰ���� : "+pro.getKind()),"Center");
		this.add(new JLabel("  ����  : "+pro.getPrice()),"Center");
		JLabel num_jbl = new JLabel("  ��ǰ������  : "+pro.getCount());
		this.add(num_jbl,"Center");
		
		//���ǳ�
//		SpinnerNumberModel scoreModel = new SpinnerNumberModel(0,0,100,5);
//		this.add(new JSpinner(scoreModel));
		
		JButton btn = new JButton("�Ǹ�");
		btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				num_jbl.setText("  ��ǰ������  : "+pro.getCount());
				iMt.SaleFrame(pro, num_jbl);
				
			}
		});
		
		this.add(btn, "Center");
	}
}
