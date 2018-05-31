package com.kh.miniproject.seat.controller;

import com.kh.miniproject.member.controller.MemberManager;
import com.kh.miniproject.seat.dao.SeatDao;
import com.kh.miniproject.seat.vo.Seat;

public class SeatManager {
	private Seat[][] seat;
	private SeatDao sd = new SeatDao();
	private MemberManager mm = new MemberManager();
	
	public void checkSeat(int seatNo){
		
	}
	
	public String useSeat(int seatNo){
		
		return "";
	}
	
	public void plusTime(String id){
		
	}
	
	public void exitSeat(int seatNo){
		
	}
}
