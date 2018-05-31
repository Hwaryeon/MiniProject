package com.kh.miniproject.member.vo;

import java.io.Serializable;

public class Member implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5413208096723960205L;
	private String name;
	private String id;
	private String pwd;
	private String email;
	private int age;
	private String phoneNumber;
	private int restTime;
	private int useTime;
	private int accTime;
	private boolean admission;
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", id=" + id + ", pwd=" + pwd + ", email=" + email + ", age=" + age
				+ ", phoneNumber=" + phoneNumber + ", restTime=" + restTime + ", useTime=" + useTime + ", accTime="
				+ accTime + ", admission=" + admission + "]";
	}

	public Member(){}
	
	public Member(String name, String id, String pwd, String email, int age, 
			String phoneNumber) {
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}

	public Member(String name, String id, String pwd, String email, int age, 
			String phoneNumber, int restTime,
			int useTime, int accTime, boolean admission) {
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.restTime = restTime;
		this.useTime = useTime;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getRestTime() {
		return restTime;
	}

	public void setRestTime(int restTime) {
		this.restTime = restTime;
	}

	public int getUseTime() {
		return useTime;
	}

	public void setUseTime(int useTime) {
		this.useTime = useTime;
	}

	public int getAccTime() {
		return accTime;
	}

	public void setAccTime(int accTime) {
		this.accTime = accTime;
	}

	public boolean isAdmission() {
		return admission;
	}

	public void setAdmission(boolean admission) {
		this.admission = admission;
	}
	
	
	
	
	
	
}
