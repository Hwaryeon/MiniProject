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
		
		System.out.print("����� ȸ�� id : " );
		String id = sc.nextLine();
		
		int time = 0;
		
		time = mm.MemberInfo(id);
		
		if(time == -1){
			System.out.println("�ش� id�� �������� �ʽ��ϴ�.");
			return;
		}
		
		
		sd.UseSeat(seatNo, id, time);
		
	}
	
	public void PlusTime(String id){
		
		if(mm.MemberInfo(id) == -1){
			System.out.println("�ش� id�� �������� �ʽ��ϴ�.");
			return;
		}
		
	
		System.out.println("�߰��� �ð� : ");
		int time = sc.nextInt();
		mm.TimePlus(id, time);
		
	}
	
	
	public void exitSeat(int seatNo, int userTime){
		
		
		mm.useTime(sd.exitSeat(seatNo), userTime);
		
	}
	
	
	public void timeThread(){
		
		
		
	}
	
}
