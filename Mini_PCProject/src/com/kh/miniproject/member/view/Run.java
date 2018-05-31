package com.kh.miniproject.member.view;

import java.util.Scanner;

import com.kh.miniproject.member.controller.MemberManager;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MemberManager m = new MemberManager();
		String id = "";
		String pwd = "";
		int restTime = 0;

		do{
			System.out.println("PC방 회원 관리 프로그램");
			System.out.println("1. 회원 아이디 찾기");
			System.out.println("2. 회원 비밀번호 찾기");
			System.out.println("3. 회원 승인");
			System.out.println("4. 회원 가입");
			System.out.println("5. 시간 추가");
			System.out.println("6. 회원 정보 보기");
			System.out.println("7. 회원 전체 리스트");
			System.out.print("메뉴를 선택하세요 : ");
			int sel = sc.nextInt();

			switch(sel){
			case 1 : System.out.println(m.searchMemberId());	break;
			case 2 : System.out.println(pwd = m.searchMemberPwd());	break;
			case 3 : System.out.print("승인할 아이디 입력 : ");
			sc.nextLine();
			m.memberApply(sc.nextLine());


			break;
			case 4 : m.memberJoin();	break;
			case 5 : System.out.println("시간 추가할 ID 입력 : ");
			id = sc.nextLine();
			sc.nextLine();
			System.out.println("시간 입력 : ");
			restTime = sc.nextInt();
			m.insertTime(id, restTime);	break;
			case 6 : 
			try {
				System.out.print("조회할 ID 입력 : ");
				id = sc.nextLine();
				sc.nextLine();
				m.memberDisplay(id);
			} catch (Exception e) {
				System.out.println("입력하신 ID가 없습니다.");
			}	break;
			case 7 : m.memberAllDisplay(); break;
			default : continue;

			}





		}while(true);

	}

}
