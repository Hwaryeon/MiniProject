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

	public void idSearch(){

		System.out.println();
		System.out.println("���̵� ã������ �ش� ������ �Է����ּ���.");
		System.out.print("NAME : ");
		String name = sc.nextLine();
		System.out.print("EMAIL : ");
		String email = sc.nextLine();

		md.idSearch(name, email);

	}

	public void pwSearch(){

		System.out.println();
		System.out.println("���̵� ã������ �ش� ������ �Է����ּ���.");
		System.out.print("NAME : ");
		String name = sc.nextLine();
		System.out.print("ID : ");
		String id = sc.nextLine();

		md.pwSearch(name, id);

	}

	public void memberAdmission(String id){

		System.out.print("�ش�  " + id + "�� ȸ�������� �����Ͻðڽ��ϱ� ? (y,n) : ");
		char ch = sc.next().charAt(0);

		if(ch == 'y' || ch == 'Y'){
			md.memberAdmission(id);
		}else{
			System.out.println("������ ��ҵǾ����ϴ�.");
			return;
		}

	}

	public void timePlus(){

		System.out.print("������ ID : ");
		String id = sc.nextLine();
		System.out.print("������ �ð� : ");
		int time = sc.nextInt();

		md.timePlus(id, time);
	}

	public void timePlus(String id, int time){

		md.timePlus(id, time);
	}

	public Member memberInfo(String id){

		int time = 0;
		
		System.out.println(id + "���� ȸ�������� ����մϴ�.");
		
		Member m = md.memberInfo(id);
		
		time = m.getUseTime();
		
		if(m.getId() != ""){
			return m;
		}

		return m;

	}
	
	public Member memberInfo_time(String id){

		int time = 0;
		
		System.out.println(id + "���� ȸ�������� ����մϴ�.");
		
		Member m = md.memberInfo_time(id);
		
		time = m.getUseTime();
		
		if(m.getId() != ""){
			return m;
		}

		return m;

	}
	
	public void useTime(String id, int time){
		
		md.useTime(id, time);
		
		
	}

}
