package com.kh.miniproject.view;

import java.util.Scanner;

import com.kh.miniproject.member.controller.MemberManager;
import com.kh.miniproject.member.dao.MemberDao;

public class MainMenu {

	Scanner sc = new Scanner(System.in);
	
	MemberManager mm = new MemberManager();
	
	MemberDao md = new MemberDao();
	
	
	public void mainMenu(){

		int num = 0;
		String id = "";
		do{
			System.out.println();
			System.out.println("******* PC방 관리 프로그램 *******");
			System.out.println("1. 회원가입");
			System.out.println("2. 아이디 찾기");
			System.out.println("3. 패스워드 찾기");
			System.out.println("4. 회원가입 승인");
			System.out.println("5. 시간 추가");
			System.out.println("6. 회원 정보 출력");
			System.out.println();
			System.out.println("9. 멤버 리스트 출력 (임시 멤버확인용)");
			System.out.println("10. 끝내기"); 
			System.out.print("메뉴 번호 선택 : ");
			num = sc.nextInt();
			sc.nextLine();
			
			switch(num){
			case 1: mm.MemberJoin();	break;
			case 2: mm.IdSearch(); 		break;
			case 3: mm.PwSearch(); 		break;
			case 4:
				System.out.print("승인할 ID 입력 : ");
				id = sc.nextLine();
				mm.MemberAdmission(id); break;
			case 5: mm.TimePlus(); break;
			case 6:
				System.out.print("검색할 ID 입력 : ");
				id = sc.nextLine();
				mm.MemberInfo(id); 
				break;
			case 9: md.MemberList();	break;
			case 10: ; return;
			default :System.out.println(); System.out.println("잘못 입력하셨습니다."); break;
			}

		}while(true);


	}
	
}
