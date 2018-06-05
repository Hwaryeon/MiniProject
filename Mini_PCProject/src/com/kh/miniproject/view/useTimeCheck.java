package com.kh.miniproject.view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.miniproject.iTime.ConversionTime;
import com.kh.miniproject.seat.controller.SeatManager;
import com.kh.miniproject.seat.dao.SeatDao;

public class useTimeCheck extends Thread implements ConversionTime {
	
	
	private MainFrame mf;
	private JPanel seat;
	
	private JTextField jf;
	
	private int seatNo;
	
	SeatManager sm = new SeatManager();

	public useTimeCheck(MainFrame mf, JPanel seat1, JTextField test, int seatNo) {

	
		this.mf = mf;
		this.seat = seat1;
		this.jf = test;
		this.seatNo = seatNo;
	
	}
	
	@Override
	public void run() {
		
		int count = 0;
		
		//String id = sm.checkSeat(seatNo);
		
		while(true){
			try {
				Thread.sleep(1000);	// 1초
				count = SeatDao.iList[seatNo-1];
				System.out.println("사용시간test : " + count );
				
				jf.setText(conversionTime(count));
				mf.repaint();
				
				
				
				
			} catch (InterruptedException e) {
				System.out.println("좌석 사용 종료...");

				System.out.print("종료전까지 사용시간 : ");
				//conversionTime(SeatDao.iList[seatNum-1]);
				System.out.println();
				//this.interrupt();
				this.stop();
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

		//System.out.printf("%02d:%02d:%02d", hour, minute, second);
		s = String.format("%02d:%02d:%02d", hour, minute, second);

		System.out.print(s);

		return s;
	}
	
}