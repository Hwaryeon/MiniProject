package com.kh.miniproject.view;

import javax.swing.JTextField;
import com.kh.miniproject.iTime.ConversionTime;
import com.kh.miniproject.member.vo.Member;
import com.kh.miniproject.seat.controller.SeatManager;
import com.kh.miniproject.seat.dao.SeatDao;

public class UseTimeChecks extends Thread implements ConversionTime {
	
	private MainFrame mf;
	private JTextField urt;
	private JTextField uat;
	private Member member;
	private int seatNo;
	
	SeatManager sm = new SeatManager();

	public UseTimeChecks(MainFrame mf,  JTextField useRestTimeL, JTextField useAccTimeT, Member m, int seatNo) {
		this.mf = mf;
		this.urt = useRestTimeL;
		this.uat = useAccTimeT;
		this.member = m;
		this.seatNo = seatNo;
	
	}
	
	@Override
	public void run() {
		
		int count = 0;
		
		while(true){
			try {
				Thread.sleep(1000);	// 1초
				count = SeatDao.iList[seatNo-1];
				urt.setText(conversionTime(member.getRestTime()-count));
				uat.setText(conversionTime(count));
				mf.repaint();
				
			} catch (InterruptedException e) {
				System.out.println("좌석 사용 종료...");
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