package com.kh.miniproject.view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.miniproject.iTime.ConversionTime;
import com.kh.miniproject.seat.controller.SeatManager;
import com.kh.miniproject.seat.dao.SeatDao;

public class UseTimeCheck extends Thread implements ConversionTime {
	
	
	private MainFrame mf;
	//private JPanel seat;
	
	private JTextField jf;
	
	private int seatNo;
	
	SeatManager sm = new SeatManager();

	public UseTimeCheck(MainFrame mf, /*JPanel seat1,*/ JTextField test, int seatNo) {
	
		this.mf = mf;
		this.jf = test;
		this.seatNo = seatNo;
	}
	
	@Override
	public void run() {
		
		int count = 0;
		
		
		while(true){
			try {
				Thread.sleep(1000);	// 1√ 
				count = SeatDao.iList[seatNo-1];
				jf.setText(conversionTime(count));
				mf.repaint();
				
			} catch (InterruptedException e) {
				return;
			}

		}
	}

	@Override
	public String conversionTime(int time) {
		long cTime = time;


		long second = (long) ((cTime ) % 60);
		long minute = (long) ((cTime / (  60)) % 60);
		long hour = (long) ((cTime / ( 60 * 60)));

		String s = null;
		s = String.format("%02d:%02d:%02d", hour, minute, second);

		return s;
	}
	
}