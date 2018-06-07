package com.kh.miniproject.seat.controller;

import java.util.Scanner;

import javax.swing.JFrame;

import com.kh.miniproject.member.controller.MemberManager;
import com.kh.miniproject.member.vo.Member;
import com.kh.miniproject.seat.dao.SeatDao;

public class SeatManager {


	Scanner sc = new Scanner(System.in);

	MemberManager mm = new MemberManager();

	SeatDao sd = new SeatDao();

	public void seatLeset(){
		sd.seatLeset();
	}

	public void printAllSeat(){
		sd.printAllSeat();
	}


	public String checkSeat(int seatNo){

		return sd.checkSeat(seatNo);

	}

	public boolean useUser(String id){

		return sd.useUser(id);
	}

	public void useSeat(JFrame mf, String id, int seatNo){

		Member m = mm.memberInfo(id);

		if(m.getId() == ""){
			return;
		}

		if(m.getAdmission() == false){
			return;
		}

		sd.useSeat(mf, seatNo, id, m.getRestTime());

	}

	public void plusTime(String id){

		Member m = mm.memberInfo(id);

		if(m.getId() == null){

			return;
		}


		int time = sc.nextInt();
		mm.timePlus(id, time);

	}


	public void exitSeat(int seatNo/*, int userTime*/){


		mm.useTime(sd.exitSeat(seatNo), (SeatDao.iList[seatNo-1] * 60 * 60 ));

	}

}
