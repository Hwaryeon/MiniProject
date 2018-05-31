package com.kh.miniproject.view;

import com.kh.miniproject.member.controller.MemberManager;
import com.kh.miniproject.seat.controller.SeatManager;

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

	@Override
	public void run() {
		System.out.println();
		System.out.println();

				for(int j = 0; j <= time; j++){
					try {
						Thread.sleep(1000);
						count++;
						System.out.println(id + "님의 사용시간 : " + j );
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}

			//	sm.exitSeat(seatNum, 0);
			//	mm.useTime(id, time);
				
				
			// thread 부분
		
	}
	
	public int rCount(){
		
		System.out.println("스래드 테스트");
		return count;
		
	}
	
	
}
