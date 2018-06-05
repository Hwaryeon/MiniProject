package com.kh.miniproject.member.controller;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JTextField;

import com.kh.miniproject.member.dao.MemberDao;
import com.kh.miniproject.member.vo.Member;

public class MemberManager {

	Scanner sc = new Scanner(System.in);

	MemberDao md = new MemberDao();

	public void memberJoin(String textName, String textId, String textPwd
			, String textEmail, String textPhoneNum){


		String name = textName;
		String id = textId;
		String pwd = textPwd;
		String email = textEmail;
		int age = 20;
		String pNumber = textPhoneNum;

		Member m = new Member(name, id, pwd, email, age, pNumber);

		md.memberJoin(m);
		System.out.println(m.toString());

	}

	public String idSearch(String name, String email){

		return md.idSearch(name, email);

	}

	public String pwSearch(String id, String name){
		
				return md.pwSearch(name, id);
		
			}

	public void memberAdmission(String id){

			md.memberAdmission(id);
			return;

	}

	public void timePlus(){

		System.out.print("충전할 ID : ");
		String id = sc.nextLine();
		System.out.print("충전할 시간 : ");
		int time = sc.nextInt();

		md.timePlus(id, time);
	}

	public void timePlus(String id, int time){

		System.out.println("시간추가");
		
		md.timePlus(id, time);
	}

	public Member memberInfo(String id){

		System.out.println(id + "님의 회원정보를 출력합니다.");

		Member m = md.memberInfo(id);

		if(m.getId() != ""){
			return m;
		}

		return m;

	}

	public void useTime(String id, int time){

		md.useTime(id, time);


	}

	public ArrayList<Member> memberTFList(boolean b){


		return md.memberTFList(b);



	}

	public ArrayList<Member> memberList(){
	
		
		return md.memberList();
	}
	
	
	public int checkUser(String id){
		
		return md.checkUser(id);
		
	}
	

}
