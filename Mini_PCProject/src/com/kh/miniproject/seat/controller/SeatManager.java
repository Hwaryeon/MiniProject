package com.kh.miniproject.seat.controller;

import java.util.Scanner;

import com.kh.miniproject.member.controller.MemberManager;
import com.kh.miniproject.seat.dao.SeatDao;

public class SeatManager {

	
	Scanner sc = new Scanner(System.in);
	
	MemberManager mm = new MemberManager();
	
	SeatDao sd = new SeatDao();
	
	public void printAllSeat(){
		sd.printAllSeat();
	}
	
	
	public void CheckSeat(int seatNo){
		
		sd.CheckSeat(seatNo);
		
	}
	
	public void UseSeat(int seatNo){
		
		System.out.print("등록할 회원 id : " );
		String id = sc.nextLine();
		
		int time = 0;
		
		time = mm.MemberInfo(id);
		
		if(time == -1){
			System.out.println("해당 id가 존재하지 않습니다.");
			return;
		}
		
		
		sd.UseSeat(seatNo, id, time);
		
	}
	
	public void PlusTime(String id){
		
		if(mm.MemberInfo(id) == -1){
			System.out.println("해당 id가 존재하지 않습니다.");
			return;
		}
		
	
		System.out.println("추가할 시간 : ");
		int time = sc.nextInt();
		mm.TimePlus(id, time);
		
	}
	
	
	public void exitSeat(int seatNo, int userTime){
		
		
		mm.useTime(sd.exitSeat(seatNo), userTime);
		
	}
	
	
	public void timeThread(){
		
		
		
	}
	
}
