package com.kh.miniproject.member.vo;

import java.io.Serializable;

public class Member implements Serializable {

	private String name;
	private String id;
	private String pwd;
	private String email;
	private int age;
	private String pNumber;

	private int restTime;		// 잔여 시간
	private int accTime;		// 누적 시간
	private boolean admission;

	public Member(){this.id = "";}

	public Member(String name, String id, String pwd, String email, int age, String pNumber) {
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.age = age;
		this.pNumber = pNumber;
	}

	public Member(String name, String id, String pwd, String email, int age, String pNumber,
			int restTime, int accTime, boolean admission) {
		super();
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.age = age;
		this.pNumber = pNumber;
		this.restTime = restTime;
		this.accTime = accTime;
		this.admission = admission;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getpNumber() {
		return pNumber;
	}

	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}

	public int getRestTime() {
		return restTime;
	}

	public void setRestTime(int restTime) {
		this.restTime = restTime;
	}


	public int getAccTime() {
		return accTime;
	}

	public void setAccTime(int accTime) {
		this.accTime = accTime;
	}

	public boolean getAdmission() {
		return admission;
	}

	public void setAdmission(boolean admission) {
		this.admission = admission;
	}

	@Override
	public String toString() {
		return name + ", " + id + ", " + pwd + ", " + email + ", " + age
				+ ", " + pNumber + ", " + restTime + ", " + accTime
				+ ", " + admission;
	}
	
}
