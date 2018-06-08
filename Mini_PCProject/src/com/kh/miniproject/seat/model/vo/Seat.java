package com.kh.miniproject.seat.model.vo;

public class Seat {

	private int seatNo;
	private String userId;
	private boolean useCheck = false;
	private int userTime;

	public Seat(){}

	public Seat(int seatNo){
		this.seatNo = seatNo;
	}

	public Seat(int seatNo, String userId, boolean useCheck, int userTime){
		this.seatNo = seatNo;
		this.userId = userId;
		this.useCheck = useCheck;
		this.userTime = userTime;
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

	public int getUserTime() {
		return userTime;
	}

	public void setUserTime(int userTime) {
		this.userTime = userTime;
	}

	@Override
	public String toString() {
		return seatNo + ", " + userId + ", " + useCheck + ", " + userTime;
	}

}
