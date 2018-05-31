package com.kh.miniproject.member.controller;

import java.util.Scanner;

import com.kh.miniproject.member.dao.MemberDao;
import com.kh.miniproject.member.vo.Member;

public class MemberManager {

	Scanner sc = new Scanner(System.in);

	MemberDao md = new MemberDao();

	public void MemberJoin(){

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

		md.MemberJoin(m);

	}

	public void IdSearch(){

		System.out.println();
		System.out.println("���̵� ã������ �ش� ������ �Է����ּ���.");
		System.out.print("NAME : ");
		String name = sc.nextLine();
		System.out.print("EMAIL : ");
		String email = sc.nextLine();

		md.IdSearch(name, email);

	}

	public void PwSearch(){

		System.out.println();
		System.out.println("���̵� ã������ �ش� ������ �Է����ּ���.");
		System.out.print("NAME : ");
		String name = sc.nextLine();
		System.out.print("ID : ");
		String id = sc.nextLine();

		md.PwSearch(name, id);

	}

	public void MemberAdmission(String id){

		System.out.print("�ش�  " + id + "�� ȸ�������� �����Ͻðڽ��ϱ� ? (y,n) : ");
		char ch = sc.next().charAt(0);

		if(ch == 'y' || ch == 'Y'){
			md.MemberAdmission(id);
		}else{
			System.out.println("������ ��ҵǾ����ϴ�.");
			return;
		}

	}

	public void TimePlus(){

		System.out.print("������ ID : ");
		String id = sc.nextLine();
		System.out.print("������ �ð� : ");
		int time = sc.nextInt();

		md.TimePlus(id, time);


	}

	public void TimePlus(String id, int time){

		md.TimePlus(id, time);


	}

	public int MemberInfo(String id){

		int time = 0;
		
		System.out.println(id + "���� ȸ�������� ����մϴ�.");
		
		time = md.MemberInfo(id);
		
		if(time != -1){
			return time;
		}

		return -1;

	}
	
	public void useTime(String id, int time){
		
		md.useTime(id, time);
		
		
	}

}
