package com.kh.miniproject.seat.controller;

import java.util.Scanner;

import com.kh.miniproject.member.controller.MemberManager;
import com.kh.miniproject.member.vo.Member;
import com.kh.miniproject.seat.dao.SeatDao;

public class SeatManager {

	
	Scanner sc = new Scanner(System.in);
	
	MemberManager mm = new MemberManager();
	
	SeatDao sd = new SeatDao();
	
	public void printAllSeat(){
		sd.printAllSeat();
	}
	
	
	public void checkSeat(int seatNo){
		
		sd.checkSeat(seatNo);
		
	}
	
	public void useSeat(int seatNo){
		
		System.out.print("등록할 회원 id : " );
		String id = sc.nextLine();
		
		Member m = mm.memberInfo(id);
		
		if(m.getId() == ""){
			System.out.println("해당 id가 존재하지 않습니다.");
			return;
		}
		
		if(m.getAdmission() == false){
			System.out.println("가입 미승인 회원은 사용할 수 없습니다.");
			return;
		}
		
		//m.getRestTime() 초로 저장되어있음..
		
		sd.useSeat(seatNo, id, m.getRestTime());
		
	}
	
	public void plusTime(String id){
		
		Member m = mm.memberInfo(id);
		
		if(m.getId() == null){
			System.out.println("해당 id가 존재하지 않습니다.");
			
			return;
		}
		
	
		System.out.print("추가할 시간 : ");
		int time = sc.nextInt();
		mm.timePlus(id, time);
		
	}
	
	
	public void exitSeat(int seatNo/*, int userTime*/){
		
		
		mm.useTime(sd.exitSeat(seatNo), (SeatDao.iList[seatNo-1] * 60 * 60 ));
		
	}
	
}
