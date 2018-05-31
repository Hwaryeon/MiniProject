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
		System.out.println("아이디 찾기 기능입니다.");
		System.out.println("가입하실때 입력하신 이름과 핸드폰번호를 입력해주세요");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("핸드폰번호 : ");
		String phoneNumber = sc.nextLine();
		
		String id = md.searchMemberId(name, phoneNumber);
		return id;
	}
	
	public String searchMemberPwd(){
		System.out.println("비밀번호 찾기 기능입니다.");
		System.out.println("아이디와 성함을 입력해주세요");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		String pwd = md.searchMemberId(id, name);
		return pwd;
	}
	
	public void memberApply(String id){
		System.out.println("승인하시겠습니까? Y/N");
		char yn = sc.next().charAt(0);
		if(yn == 'y' || yn == 'Y'){
			md.memberApply(id);
		}else{
			return;
		}
	}
	
	public void memberJoin(){
		do{
			
		System.out.println("회원 가입");
		System.out.print("아이디 입력 : ");
		String id = sc.nextLine();
		boolean idCheck = md.searchOverlap(id);
		System.out.print("비밀번호 입력 : ");
		String pwd = sc.nextLine();
		System.out.print("이름 입력 : ");
		String name = sc.nextLine();
		System.out.print("이메일 입력 : ");
		String email = sc.nextLine();
		System.out.print("생년월일 입력 ex)900512 : ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.print("핸드폰 번호 입력(숫자만 입력) : ");
		String phoneNumber = sc.nextLine();
		
		if(idCheck == true){
			System.out.println("입력하신 ID는 사용 가능합니다.");
			Member m = new Member(name, id, pwd, email, age, phoneNumber);
			md.memberJoin(m);
			break;
		}else{
			System.out.println("입력하신 ID는 중복되어 다른 ID를 입력해주세요.");
			continue;
		}
		}while(true);
		
	}
	
	public void insertTime(String id, int restTime){
		md.insertTime(id, restTime);
		System.out.println(restTime + " 시간이 추가되었습니다.");
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
