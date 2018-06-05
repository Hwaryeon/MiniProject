package com.kh.miniproject.view;

import java.util.Scanner;

import com.kh.miniproject.member.controller.MemberManager;
import com.kh.miniproject.member.dao.MemberDao;
import com.kh.miniproject.seat.controller.SeatManager;
import com.kh.miniproject.seat.dao.SeatDao;

public class MainMenu {

	Scanner sc = new Scanner(System.in);
	
	MemberManager mm = new MemberManager();
	
	MemberDao md = new MemberDao();
	
	SeatManager sm = new SeatManager();
	SeatDao sd = new SeatDao();
	
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
			System.out.println("7. 승인된 멤버 리스트 출력");
			System.out.println("8. 비승인된 멤버 리스트 출력");
			System.out.println("9. 전체 멤버 리스트 출력");
			System.out.println();
			System.out.println("10. 좌석관리 메뉴로 이동");
			System.out.println("15. 끝내기"); 
			System.out.print("메뉴 번호 선택 : ");
			num = sc.nextInt();
			sc.nextLine();
			
			switch(num){
			case 1: //mm.memberJoin();	break;
		//	case 2: mm.idSearch(); 		break;
		//	case 3: mm.pwSearch(); 		break;
			case 4:
				System.out.print("승인할 ID 입력 : ");
				id = sc.nextLine();
				mm.memberAdmission(id); break;
			case 5: mm.timePlus(); break;
			case 6:
				System.out.print("검색할 ID 입력 : ");
				id = sc.nextLine();
				mm.memberInfo(id); 
				break;
			case 7: md.memberTFList(true); break;
			case 8: md.memberTFList(false); break;
			case 9: md.memberList();	break;
			case 10: seatMenu(); break;
			case 15: ; return;
			default :System.out.println(); System.out.println("잘못 입력하셨습니다."); break;
			}

		}while(true);


	}
	
	public void seatMenu(){

		int num = 0;
		String id = "";
		do{
			System.out.println();
			System.out.println("******* 좌석 관리 프로그램 *******");
			System.out.println("1. 전체 좌석 출력");
			System.out.println("2. 좌석 선택 출력");
			System.out.println("3. 좌석 이용 하기");
			System.out.println("4. 시간 추가 하기");
			System.out.println("5. 좌석 사용 종료");
			System.out.println();
			System.out.println("10. 이전 메뉴로"); 
			System.out.println("00. 좌석 초기화");
			System.out.print("메뉴 번호 선택 : ");
			num = sc.nextInt();
			sc.nextLine();
			
			switch(num){
			case 1: sm.printAllSeat(); break;
			case 2: 
				System.out.print("확인할 좌석 : ");
				num = sc.nextInt();
				if(!(num >= 1 && num <=12)){
					System.out.println("없는 좌석입니다.");
					break;
				}
				sm.checkSeat(num);
				break;
			case 3: 
				System.out.print("사용할 좌석 : ");
				num = sc.nextInt();
				if(!(num >= 1 && num <=12)){
					System.out.println("없는 좌석입니다.");
					break;
				}
				sm.useSeat(num);
				break;
			case 4:
				System.out.print("추가할 회원ID : ");
				String str = sc.nextLine();
				
				sm.plusTime(str);
				break;
			case 5:
				
				System.out.print("종료할 좌석 : ");
				int seatNo = sc.nextInt();
				/*System.out.print("사용 시간 : ");
				int time = sc.nextInt();*/
				
				sm.exitSeat(seatNo/*, time*/); break;
			case 10: ; return;
			case 00: sd.seatLeset(); break;
			default :System.out.println(); System.out.println("잘못 입력하셨습니다."); break;
			}

		}while(true);


	}
	
}
