package com.kh.miniproject.seat.vo;

public class Seat {
	private boolean useCheck;
	private String useUserInfo;
	private int seatNo;
	
	
	
	
	@Override
	public String toString() {
		return "Seat [useCheck=" + useCheck + ", useUserInfo=" + useUserInfo + ", seatNo=" + seatNo + "]";
	}
	public boolean isUseCheck() {
		return useCheck;
	}
	public void setUseCheck(boolean useCheck) {
		this.useCheck = useCheck;
	}
	public String getUseUserInfo() {
		return useUserInfo;
	}
	public void setUseUserInfo(String useUserInfo) {
		this.useUserInfo = useUserInfo;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	
	
}
