package com.kh.miniproject.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.miniproject.ProductAndProfit.vo.Profit;


public class Profit_view  extends JPanel {

	private MainFrame mf;

	public Profit_view(MainFrame mf)
	{

		this.mf = mf;
		Profit pf = new Profit();
		this.setLayout(null);
		this.setSize(mf.getWidth(), mf.getHeight());
		this.setBackground(Color.BLACK);

		// µÚ·Î°¡±â ¹öÆ°
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

		JPanel memberManagePanel = new JPanel();
		memberManagePanel.setLayout(null);
		memberManagePanel.setLocation(300, 50);
		memberManagePanel.setBackground(Color.WHITE);
		memberManagePanel.setSize(600,100);

		//ÆÐ³Î À§ "¼öÀÍ°ü¸®" ¶óº§
		JLabel text = new JLabel("¼öÀÍ°ü¸®");
		text.setSize(600, 100);
		text.setLocation(100, 100);
		text.setForeground(Color.BLACK);
		text.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 40));
		text.setHorizontalAlignment(JLabel.CENTER);
		memberManagePanel.add(text);      

		JPanel member = new JPanel();
		member.setLayout(null);
		member.setSize(1000,500);
		member.setLocation(100, 200);
		member.setBackground(Color.YELLOW);

		JPanel allM = new JPanel();
		allM.setLayout(null);
		allM.setBackground(Color.WHITE);
		allM.setSize(250, 150);
		allM.setLocation(110, 80);

		JLabel empty = new JLabel();
		Image emptyicon = new ImageIcon("icon/middleLine.png").getImage().getScaledInstance(300, 100, 0);
		empty.setIcon(new ImageIcon(emptyicon));
		empty.setBounds(0, 60, 500, 50);
		allM.add(empty);

		JLabel allMN = new JLabel("ÃÑ ´©Àû¼öÀÍ");
		allMN.setHorizontalAlignment(JLabel.CENTER);
		allMN.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		allMN.setSize(200,100);
		allMN.setLocation(25,0);
		allM.add(allMN);

		JLabel allMI = new JLabel(pf.getAll_M()+"");
		allMI.setHorizontalAlignment(JLabel.CENTER);
		allMI.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		allMI.setSize(100,100);
		allMI.setLocation(65,65);
		allM.add(allMI);

		member.add(allM);


		JPanel dayM = new JPanel();
		dayM.setLayout(null);
		dayM.setBackground(Color.WHITE);
		dayM.setSize(250, 150);
		dayM.setLocation(610, 80);

		JLabel empty1 = new JLabel();
		Image emptyicon1 = new ImageIcon("icon/middleLine.png").getImage().getScaledInstance(300, 100, 0);

		empty.setIcon(new ImageIcon(emptyicon1));
		empty.setBounds(0, 60, 500, 50);
		dayM.add(empty);

		JLabel dayMN = new JLabel("ÇÏ·ç¼öÀÍ");
		dayMN.setHorizontalAlignment(JLabel.CENTER);
		dayMN.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		dayMN.setSize(100,100);
		dayMN.setLocation(65,0);
		dayM.add(dayMN);

		JLabel dayMI = new JLabel(pf.getDay_M()+""/*Integer.parseInt(getDay_M())*/);
		dayMI.setHorizontalAlignment(JLabel.CENTER);
		dayMI.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		dayMI.setSize(100,100);
		dayMI.setLocation(65,65);
		dayM.add(dayMI);

		member.add(dayM);

		JPanel itemM = new JPanel();
		itemM.setLayout(null);
		itemM.setBackground(Color.WHITE);
		itemM.setSize(250, 150);
		itemM.setLocation(110, 300);

		JLabel empty2 = new JLabel();
		Image emptyicon2 = new ImageIcon("icon/middleLine.png").getImage().getScaledInstance(300, 100, 0);
		empty.setIcon(new ImageIcon(emptyicon2));
		empty.setBounds(0, 60, 500, 50);
		allM.add(empty);

		JLabel itemMN = new JLabel("»óÇ°¼öÀÍ");
		itemMN.setHorizontalAlignment(JLabel.CENTER);
		itemMN.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		itemMN.setSize(100,100);
		itemMN.setLocation(65,0);
		itemM.add(itemMN);

		JLabel itemMI = new JLabel(pf.getItem_M()+"");
		itemMI.setHorizontalAlignment(JLabel.CENTER);
		itemMI.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		itemMI.setSize(100,100);
		itemMI.setLocation(65,65);
		itemM.add(itemMI);

		member.add(itemM);

		JPanel timeM = new JPanel();
		timeM.setLayout(null);
		timeM.setBackground(Color.WHITE);
		timeM.setSize(250, 150);
		timeM.setLocation(610, 300);

		JLabel empty3 = new JLabel();
		Image emptyicon3 = new ImageIcon("icon/middleLine.png").getImage().getScaledInstance(300, 100, 0);
		empty.setIcon(new ImageIcon(emptyicon3));
		empty.setBounds(0, 60, 500, 50);
		allM.add(empty);

		JLabel timeMN = new JLabel("»ç¿ë·á ¼öÀÍ");
		timeMN.setHorizontalAlignment(JLabel.CENTER);
		timeMN.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		timeMN.setSize(200,100);
		timeMN.setLocation(25,0);
		timeM.add(timeMN);

		member.add(timeM);

		JLabel timeMI = new JLabel(pf.getTime_M()+"");
		timeMI.setHorizontalAlignment(JLabel.CENTER);
		timeMI.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		timeMI.setSize(100,100);
		timeMI.setLocation(65,65);
		timeM.add(timeMI);

		this.add(memberManagePanel);
		this.add(member);
		mf.add(this);
	}

	public void changePanel(JPanel panel)
	{
		mf.remove(this);
		mf.add(panel);
		mf.repaint();
	}

}
