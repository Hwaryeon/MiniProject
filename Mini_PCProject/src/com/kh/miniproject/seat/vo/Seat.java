package com.kh.miniproject.seat.vo;

public class Seat {

	private int seatNo;
	private String userId;
	private boolean useCheck = false;

	public Seat(){}

	public Seat(int seatNo){
		this.seatNo = seatNo;
	}

	public Seat(int seatNo, String userId){

		this.seatNo = seatNo;
		this.userId = userId;
		this.useCheck = true;

	}	
	public Seat(int seatNo, String userId, boolean useCheck){

		this.seatNo = seatNo;
		this.userId = userId;
		this.useCheck = useCheck;

	}


	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean getUseCheck() {
		return useCheck;
	}

	public void setUseCheck(boolean useCheck) {
		this.useCheck = useCheck;
	}

	@Override
	public String toString() {
		return seatNo + ", " + userId + ", " + useCheck;
	}




}
