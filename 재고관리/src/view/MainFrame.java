package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame
{
	private JPanel panel;
	
	public MainFrame()
	{
		this.setSize(1200,800);
		this.setTitle("��! �ǽù�� Ÿ�̾�� �δ�!");
		new Product_Panel(this);	//������
//		new Profit_view(this);		//���Ͱ���
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
