package com.kh.miniproject.view;

import com.kh.miniproject.iTime.ConversionTime;
import com.kh.miniproject.member.controller.MemberManager;
import com.kh.miniproject.seat.controller.SeatManager;
import com.kh.miniproject.seat.dao.SeatDao;

public class Timer extends Thread implements ConversionTime{

	private int seatNum;
	private String id;
	private int time;

	private int count;

	MemberManager mm = new MemberManager();
	SeatManager sm = new SeatManager();
	
	public Timer(int seatNum, String id, int time){
		this.seatNum = seatNum;
		this.id = id;
		this.time = time;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		System.out.println();

		for(int j = 0; j < time; j++){
			try {
				Thread.sleep(1000);	// 1��
				count++;
				SeatDao.iList[seatNum-1] = count;
			//	System.out.println(id + "���� ���ð� : " + j );
			} catch (InterruptedException e) {
				System.out.println("�¼� ��� ����...");
				
				System.out.print("���������� ���ð� : ");
				conversionTime(SeatDao.iList[seatNum-1]);
				System.out.println();
				//this.stop();
				return;
			}

		}

		sm.exitSeat(seatNum);

		System.out.println();
		System.out.println(id + "���� ���ð�����");

	}

	@Override
	public String conversionTime(int time){
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
