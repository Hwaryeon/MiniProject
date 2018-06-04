package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame
{
	private JPanel panel;
	
	public MainFrame()
	{
		this.setSize(1200,800);
		this.setTitle("앗! 피시방비가 타이어보다 싸다!");
		new Product_Panel(this);	//재고관리
//		new Profit_view(this);		//수익관리
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
