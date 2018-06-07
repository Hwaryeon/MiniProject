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
import javax.swing.JTextField;

import com.kh.miniproject.ProductAndProfit.vo.Profit;

public class Profit_view extends JPanel {

	private MainFrame mf;

	/*
	 * JLabel id = new JLabel("¾ÆÀÌµð"); id.setFont(new Font("¸¼Àº °íµñ", Font.BOLD,
	 * 16)); id.setBounds(30, 0, 100, 100); JTextField textId = new
	 * JTextField(); textId.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
	 * textId.setBounds(30, 70, 200, 30); member.add(id);
	 */

	public Profit_view(MainFrame mf) {

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

		//Á¦¸ñÆÐ³Î
		JPanel memberManagePanel = new JPanel();
		memberManagePanel.setSize(600, 100);
		memberManagePanel.setLocation(300, 50);
		memberManagePanel.setBackground(Color.WHITE);
		// ÆÐ³Î À§ "¼öÀÍ°ü¸®" ¶óº§
		JLabel titleLayer = new JLabel();
		Image titleLayerI = new ImageIcon("icon/titleLayer.png").getImage().getScaledInstance(600, 100, 0);
		titleLayer.setIcon(new ImageIcon(titleLayerI));
		titleLayer.setBounds(0, 0, 600, 100);
		JLabel text = new JLabel("¼öÀÍ°ü¸®");
		text.setSize(600, 100);
		text.setLocation(0, 0);
		text.setForeground(Color.BLACK);
		text.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 40));
		text.setHorizontalAlignment(JLabel.CENTER);
		memberManagePanel.add(text);
		memberManagePanel.add(titleLayer);

		JPanel member = new JPanel();
		member.setLayout(null);
		member.setSize(900, 500);
		member.setLocation(150, 200);
		member.setBackground(Color.LIGHT_GRAY);

		JPanel allM = new JPanel();
		allM.setLayout(null);
		allM.setBackground(Color.WHITE);
		allM.setSize(300, 150);
		allM.setLocation(100, 70);

		JLabel textboxLabel = new JLabel();
		Image textbox = new ImageIcon("icon/textbox2.png").getImage().getScaledInstance(300, 150, 0);
		textboxLabel.setIcon(new ImageIcon(textbox));
		textboxLabel.setBounds(0, 0, 300, 150);

		JLabel allMN = new JLabel("ÃÑ ´©Àû¼öÀÍ");
		allMN.setHorizontalAlignment(JLabel.CENTER);
		allMN.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		allMN.setSize(300, 75);
		allMN.setLocation(0, 0);
		allM.add(allMN);

		JLabel allMI = new JLabel(pf.getAll_M() + "¿ø");
		allMI.setHorizontalAlignment(JLabel.CENTER);
		allMI.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		allMI.setSize(300, 75);
		allMI.setLocation(0, 75);
		allM.add(allMI);
		allM.add(textboxLabel);
		member.add(allM);

		JPanel dayM = new JPanel();
		dayM.setLayout(null);
		dayM.setBackground(Color.WHITE);
		dayM.setSize(300, 150);
		dayM.setLocation(500, 70);
		JLabel textboxLabel1 = new JLabel();
		textboxLabel1.setIcon(new ImageIcon(textbox));
		textboxLabel1.setBounds(0, 0, 300, 150);
		JLabel dayMN = new JLabel("ÇÏ·ç¼öÀÍ");
		dayMN.setHorizontalAlignment(JLabel.CENTER);
		dayMN.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		dayMN.setSize(300, 75);
		dayMN.setLocation(0, 0);
		dayM.add(dayMN);
		JLabel dayMI = new JLabel(pf.getDay_M() + "¿ø");
		dayMI.setHorizontalAlignment(JLabel.CENTER);
		dayMI.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		dayMI.setSize(300, 75);
		dayMI.setLocation(0, 75);
		dayM.add(dayMI);
		dayM.add(textboxLabel1);
		member.add(dayM);

		JPanel itemM = new JPanel();
		itemM.setLayout(null);
		itemM.setBackground(Color.WHITE);
		itemM.setSize(300, 150);
		itemM.setLocation(100, 290);
		JLabel textboxLabel2 = new JLabel();
		textboxLabel2.setIcon(new ImageIcon(textbox));
		textboxLabel2.setBounds(0, 0, 300, 150);
		JLabel itemMN = new JLabel("»óÇ°¼öÀÍ");
		itemMN.setHorizontalAlignment(JLabel.CENTER);
		itemMN.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		itemMN.setSize(300, 75);
		itemMN.setLocation(0, 0);
		itemM.add(itemMN);
		JLabel itemMI = new JLabel(pf.getItem_M() + "¿ø");
		itemMI.setHorizontalAlignment(JLabel.CENTER);
		itemMI.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		itemMI.setSize(300, 75);
		itemMI.setLocation(0, 75);
		itemM.add(itemMI);
		itemM.add(textboxLabel2);
		member.add(itemM);

		JPanel timeM = new JPanel();
		timeM.setLayout(null);
		timeM.setBackground(Color.WHITE);
		timeM.setSize(300, 150);
		timeM.setLocation(500, 290);
		JLabel textboxLabel3 = new JLabel();
		textboxLabel3.setIcon(new ImageIcon(textbox));
		textboxLabel3.setBounds(0, 0, 300, 150);
		JLabel timeMN = new JLabel("»ç¿ë·á ¼öÀÍ");
		timeMN.setHorizontalAlignment(JLabel.CENTER);
		timeMN.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		timeMN.setSize(300, 75);
		timeMN.setLocation(0, 0);
		member.add(timeM);
		JLabel timeMI = new JLabel(pf.getTime_M() + "¿ø");
		timeMI.setHorizontalAlignment(JLabel.CENTER);
		timeMI.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		timeMI.setSize(300, 75);
		timeMI.setLocation(0, 75);
		timeM.add(timeMI);
		timeM.add(timeMN);
		timeM.add(textboxLabel3);

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