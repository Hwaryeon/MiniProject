package com.kh.miniproject.seat.controller;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.miniproject.member.controller.MemberManager;
import com.kh.miniproject.member.vo.Member;
import com.kh.miniproject.seat.dao.SeatDao;
import com.kh.miniproject.view.MainFrame;

public class SeatManager {

	
	Scanner sc = new Scanner(System.in);
	
	MemberManager mm = new MemberManager();
	
	SeatDao sd = new SeatDao();
	
	public void printAllSeat(){
		sd.printAllSeat();
	}
	
	
	public String checkSeat(int seatNo, JPanel seat1, MainFrame mf){
		
		return sd.checkSeat(seatNo, seat1, mf);
		
	}
	
	public void useSeat(JFrame mf, JPanel panel, String id, int seatNo){
		
		Member m = mm.memberInfo(id);
		
		if(m.getId() == ""){
			System.out.println("해당 id가 존재하지 않습니다.");
			return;
		}
		
		if(m.getAdmission() == false){
			System.out.println("가입 미승인 회원은 사용할 수 없습니다.");
			return;
		}
		
		sd.useSeat(mf, panel, seatNo, id, m.getRestTime());
		
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
