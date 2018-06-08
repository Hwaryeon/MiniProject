package com.kh.miniproject.view;

import javax.swing.JTextField;

import com.kh.miniproject.iTime.ConversionTime;
import com.kh.miniproject.member.model.vo.Member;
import com.kh.miniproject.seat.controller.SeatManager;
import com.kh.miniproject.seat.model.dao.SeatDao;

public class UseTimeCheck extends Thread implements ConversionTime {

	private MainFrame mf;
	private JTextField urt;
	private JTextField uat;
	private Member member;
	private int seatNo;
	private int type;

	SeatManager sm = new SeatManager();


	public UseTimeCheck(MainFrame mf, JTextField useAccTimeT, int seatNo) {
		this.mf = mf;
		this.uat = useAccTimeT;
		this.seatNo = seatNo;
		this.type = 1;
	}

	public UseTimeCheck(MainFrame mf,  JTextField useRestTimeL, 
			JTextField useAccTimeT, Member m, int seatNo) {
		this.mf = mf;
		this.urt = useRestTimeL;
		this.uat = useAccTimeT;
		this.member = m;
		this.seatNo = seatNo;
		this.type = 2;
	}

	@Override
	public void run() {

		int count = 0;

		while(true){
			try {
				Thread.sleep(1000);	// 1초
				count = SeatDao.iList[seatNo-1];
				uat.setText(conversionTime(count));

				if(type == 2){
					urt.setText(conversionTime(member.getRestTime()-count));
				}

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