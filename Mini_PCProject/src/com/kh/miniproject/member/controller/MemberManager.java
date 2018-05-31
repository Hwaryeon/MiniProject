package com.kh.miniproject.member.controller;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.Iterator;

import com.kh.miniproject.member.dao.MemberDao;
import com.kh.miniproject.member.vo.Member;

public class MemberManager {
	Member m = new Member();
	private MemberDao md = new MemberDao();
	private Scanner sc = new Scanner(System.in);
	public MemberManager(){}
	
	public String searchMemberId(){
		System.out.println("���̵� ã�� ����Դϴ�.");
		System.out.println("�����ϽǶ� �Է��Ͻ� �̸��� �ڵ�����ȣ�� �Է����ּ���");
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("�ڵ�����ȣ : ");
		String phoneNumber = sc.nextLine();
		
		String id = md.searchMemberId(name, phoneNumber);
		return id;
	}
	
	public String searchMemberPwd(){
		System.out.println("��й�ȣ ã�� ����Դϴ�.");
		System.out.println("���̵�� ������ �Է����ּ���");
		System.out.print("���̵� : ");
		String id = sc.nextLine();
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		
		String pwd = md.searchMemberId(id, name);
		return pwd;
	}
	
	public void memberApply(String id){
		System.out.println("�����Ͻðڽ��ϱ�? Y/N");
		char yn = sc.next().charAt(0);
		if(yn == 'y' || yn == 'Y'){
			md.memberApply(id);
		}else{
			return;
		}
	}
	
	public void memberJoin(){
		do{
			
		System.out.println("ȸ�� ����");
		System.out.print("���̵� �Է� : ");
		String id = sc.nextLine();
		boolean idCheck = md.searchOverlap(id);
		System.out.print("��й�ȣ �Է� : ");
		String pwd = sc.nextLine();
		System.out.print("�̸� �Է� : ");
		String name = sc.nextLine();
		System.out.print("�̸��� �Է� : ");
		String email = sc.nextLine();
		System.out.print("������� �Է� ex)900512 : ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.print("�ڵ��� ��ȣ �Է�(���ڸ� �Է�) : ");
		String phoneNumber = sc.nextLine();
		
		if(idCheck == true){
			System.out.println("�Է��Ͻ� ID�� ��� �����մϴ�.");
			Member m = new Member(name, id, pwd, email, age, phoneNumber);
			md.memberJoin(m);
			break;
		}else{
			System.out.println("�Է��Ͻ� ID�� �ߺ��Ǿ� �ٸ� ID�� �Է����ּ���.");
			continue;
		}
		}while(true);
		
	}
	
	public void insertTime(String id, int restTime){
		md.insertTime(id, restTime);
		System.out.println(restTime + " �ð��� �߰��Ǿ����ϴ�.");
	}
	
	public Member memberDisplay(String id) throws Exception{
				if(md.memberDisplay(id) == null){
			throw new Exception();
		}
		return md.memberDisplay(id);
	}
	
	public void memberAllDisplay(){
		
		Iterator iter = md.memberAllDisplay().iterator();
		while(iter.hasNext()){
			System.out.println(iter.next().toString());
		}
		
		
	}
}
