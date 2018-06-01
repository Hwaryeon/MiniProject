package com.kh.miniproject.view;

import com.kh.miniproject.member.controller.MemberManager;
import com.kh.miniproject.seat.controller.SeatManager;
import com.kh.miniproject.seat.dao.SeatDao;

public class Timer extends Thread{

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
				//System.out.println(id + "���� ���ð� : " + j );
			} catch (InterruptedException e) {
				System.out.println("�¼� �̿� ����...");
				System.out.println("���ð�(��) : "
						+ SeatDao.iList[seatNum-1]);
				//this.interrupt();
				this.stop();
			}

		}

		sm.exitSeat(seatNum);

		System.out.println();
		System.out.println(id + "���� ���ð�����");

	}


}
