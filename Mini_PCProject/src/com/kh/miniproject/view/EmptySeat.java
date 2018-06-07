package com.kh.miniproject.view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class EmptySeat extends JPanel 
{
	private MainFrame mf;

	public EmptySeat(MainFrame mf, int seatNo) 
	{
		this.mf = mf;
		this.setSize(mf.getWidth(), mf.getHeight());
		this.setLayout(null);
		this.setBackground(Color.BLACK);

		//µÚ·Î°¡±â ¹öÆ°
		JButton goback = new JButton();
		Image back = new ImageIcon("icon/pointer.png").getImage().getScaledInstance(100, 100, 0);
		goback.setIcon(new ImageIcon(back));
		goback.setBounds(25, 25, 100, 100);
		goback.setBorderPainted(false);
		goback.setBackground(null);
		goback.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				MainPanel mp = new MainPanel(mf);
				changePanel(mp);
			}
		});
		this.add(goback);

		JPanel emptyPanel = new JPanel();
		emptyPanel.setLayout(null);
		emptyPanel.setLocation(300, 50);
		emptyPanel.setBackground(Color.WHITE);
		emptyPanel.setSize(600,100);
		JLabel titleLayer = new JLabel();
		Image titleLayerI = new ImageIcon("icon/titleLayer.png").getImage().getScaledInstance(600, 100, 0);
		titleLayer.setIcon(new ImageIcon(titleLayerI));
		titleLayer.setBounds(0, 0, 600, 100);



		//ÆÐ³Î À§ Á¦¸ñ ¶óº§
		JLabel text = new JLabel("ºñ¾îÀÖ´Â ÁÂ¼®");
		text.setSize(300, 50);
		text.setLocation(150, 25);
		text.setBackground(Color.GREEN);
		text.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 40));
		text.setHorizontalAlignment(JTextField.CENTER);

		emptyPanel.add(text);
		emptyPanel.add(titleLayer);

		// ¸Þ´ºÆÐ³Î
		JPanel menu = new JPanel();
		menu.setBackground(Color.LIGHT_GRAY);
		menu.setLayout(null);
		menu.setBounds(75, 200, 400, 525);
		JLabel menul = new JLabel("¸Þ´º");
		menul.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 40));
		menul.setForeground(Color.BLACK);
		menul.setHorizontalAlignment(JLabel.CENTER);
		EtchedBorder eborder = new EtchedBorder(EtchedBorder.RAISED);
		menul.setBorder(eborder);
		menul.setBounds(0, 0, 400, 100);
		menu.add(menul);

		// ¾ÆÀÌÄÜÆÐ³Î
		JPanel iconp = new JPanel();
		iconp.setLayout(null);
		iconp.setBounds(0, 110, 400, 425);
		iconp.setBackground(Color.LIGHT_GRAY);
		Font font = new Font("¸¼Àº°íµñ", Font.BOLD, 18);
		// ÁÂ¼®Ãß°¡ ¹öÆ°
		JButton seatPlus = new JButton();
		Image clock = new ImageIcon("icon/addSeat.PNG").getImage().getScaledInstance(150, 150, 0);
		seatPlus.setIcon(new ImageIcon(clock));
		seatPlus.setBackground(null);
		seatPlus.setBounds(120, 110, 150, 150);
		seatPlus.setBorderPainted(false);
		seatPlus.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				UseSeat atp = new UseSeat(mf, seatNo);
				changePanel(atp);
			}
		});
		JLabel seatPlusL = new JLabel("ÁÂ¼®Ãß°¡");
		seatPlusL.setFont(font);
		seatPlusL.setHorizontalAlignment(JLabel.CENTER);
		seatPlusL.setBounds(120, 260, 150, 25);

		iconp.add(seatPlus);
		iconp.add(seatPlusL);

		// ÁÂ¼®ÆÐ³Î
		JPanel seatP = new JPanel();
		seatP.setLayout(null);
		seatP.setBounds(500, 200, 650, 525);
		seatP.setBackground(Color.LIGHT_GRAY);
		JLabel seatTitle = new JLabel("ÁÂ¼®");
		seatTitle.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 40));
		seatTitle.setHorizontalAlignment(JLabel.CENTER);
		seatTitle.setBorder(eborder);
		seatTitle.setBounds(0, 0, 650, 100);
		seatP.add(seatTitle);

		JLabel seatNoLabel = new JLabel(seatNo+"");
		seatNoLabel.setHorizontalAlignment(JLabel.CENTER);
		seatNoLabel.setBounds(10,100,100,100);
		seatNoLabel.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 40));
		seatP.add(seatNoLabel);

		JLabel seatUse = new JLabel("Empty");
		seatUse.setHorizontalAlignment(JLabel.CENTER);
		seatUse.setBounds(225, 200, 200, 200);
		seatUse.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 44));
		seatP.add(seatUse);

		menu.add(iconp);

		this.add(menu);
		this.add(seatP);
		this.add(emptyPanel);
		mf.add(this);

	}

	public void changePanel(JPanel panel)
	{
		mf.remove(this);
		mf.add(panel);
		mf.repaint();
	}
}
