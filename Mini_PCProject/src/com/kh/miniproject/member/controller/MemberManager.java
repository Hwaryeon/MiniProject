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

	public void idSearch(){

		System.out.println();
		System.out.println("아이디 찾기위해 해당 정보를 입력해주세요.");
		System.out.print("NAME : ");
		String name = sc.nextLine();
		System.out.print("EMAIL : ");
		String email = sc.nextLine();

		md.idSearch(name, email);

	}

	public void pwSearch(){

		System.out.println();
		System.out.println("아이디 찾기위해 해당 정보를 입력해주세요.");
		System.out.print("NAME : ");
		String name = sc.nextLine();
		System.out.print("ID : ");
		String id = sc.nextLine();

		md.pwSearch(name, id);

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
