package com.kh.miniproject.view;

import javax.swing.JTextField;

public class TestC extends Thread {
	
	
	private MainFrame mf;
	private JTextField jf;
	

	public TestC(MainFrame mf, JTextField test) {

	
		this.mf = mf;
		this.jf = test;
	
	}
}