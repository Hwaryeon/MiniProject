package com.kh.miniproject.member.controller;

import java.util.Scanner;

import com.kh.miniproject.member.dao.MemberDao;
import com.kh.miniproject.member.vo.Member;

public class MemberManager {

	Scanner sc = new Scanner(System.in);

	MemberDao md = new MemberDao();

	public void memberJoin(){

		System.out.println();

		System.out.print("NAME : ");
		String name = sc.nextLine();
		System.out.print("ID : ");
		String id = sc.nextLine();
		System.out.print("PASSWORD : ");
		String pwd = sc.nextLine();
		System.out.print("EMAIL : ");
		String email = sc.nextLine();
		System.out.print("AGE : ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.print("PHONENUMBER : ");
		String pNumber = sc.nextLine();

		Member m = new Member(name, id, pwd, email, age, pNumber);

		md.memberJoin(m);

	}

	public String idSearch(String name, String email){

		return md.idSearch(name, email);

	}

	public String pwSearch(String id, String name){

		return md.pwSearch(name, id);

	}

	public void memberAdmission(String id){

		System.out.print("해당  " + id + "의 회원가입을 승인하시겠습니까 ? (y,n) : ");
		char ch = sc.next().charAt(0);

		if(ch == 'y' || ch == 'Y'){
			md.memberAdmission(id);
		}else{
			System.out.println("승인이 취소되었습니다.");
			return;
		}

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

	public void memberTFList(boolean b){


		md.memberTFList(b);



	}
	
	public int checkUser(String id){
	      
	      return md.checkUser(id);
	      
	   }


}
