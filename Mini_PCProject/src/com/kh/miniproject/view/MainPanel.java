package com.kh.miniproject.view;

import java.awt.*;
import javax.swing.*;

public class MainPanel extends JPanel
{
	private MainFrame mf;
	public MainPanel(MainFrame mf)
	{
		this.mf = mf;
		this.setSize(mf.getWidth(), mf.getHeight());
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		
	}
}
