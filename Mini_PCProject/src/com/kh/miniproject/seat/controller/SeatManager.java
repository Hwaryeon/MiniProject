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
		
		System.out.print("����� ȸ�� id : " );
		String id = sc.nextLine();
		
		Member m = mm.memberInfo(id);
		
		if(m.getId() == ""){
			System.out.println("�ش� id�� �������� �ʽ��ϴ�.");
			return;
		}
		
		if(m.getAdmission() == false){
			System.out.println("���� �̽��� ȸ���� ����� �� �����ϴ�.");
			return;
		}
		
		//m.getRestTime() �ʷ� ����Ǿ�����..
		
		sd.useSeat(seatNo, id, m.getRestTime());
		
	}
	
	public void plusTime(String id){
		
		Member m = mm.memberInfo(id);
		
		if(m.getId() == null){
			System.out.println("�ش� id�� �������� �ʽ��ϴ�.");
			
			return;
		}
		
	
		System.out.print("�߰��� �ð� : ");
		int time = sc.nextInt();
		mm.timePlus(id, time);
		
	}
	
	
	public void exitSeat(int seatNo/*, int userTime*/){
		
		
		mm.useTime(sd.exitSeat(seatNo), (SeatDao.iList[seatNo-1] * 60 * 60 ));
		
	}
	
}
