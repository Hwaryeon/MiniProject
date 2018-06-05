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
			System.out.println("******* PC�� ���� ���α׷� *******");
			System.out.println("1. ȸ������");
			System.out.println("2. ���̵� ã��");
			System.out.println("3. �н����� ã��");
			System.out.println("4. ȸ������ ����");
			System.out.println("5. �ð� �߰�");
			System.out.println("6. ȸ�� ���� ���");
			System.out.println("7. ���ε� ��� ����Ʈ ���");
			System.out.println("8. ����ε� ��� ����Ʈ ���");
			System.out.println("9. ��ü ��� ����Ʈ ���");
			System.out.println();
			System.out.println("10. �¼����� �޴��� �̵�");
			System.out.println("15. ������"); 
			System.out.print("�޴� ��ȣ ���� : ");
			num = sc.nextInt();
			sc.nextLine();
			
			switch(num){
			case 1: //mm.memberJoin();	break;
		//	case 2: mm.idSearch(); 		break;
		//	case 3: mm.pwSearch(); 		break;
			case 4:
				System.out.print("������ ID �Է� : ");
				id = sc.nextLine();
				mm.memberAdmission(id); break;
			case 5: mm.timePlus(); break;
			case 6:
				System.out.print("�˻��� ID �Է� : ");
				id = sc.nextLine();
				mm.memberInfo(id); 
				break;
			case 7: md.memberTFList(true); break;
			case 8: md.memberTFList(false); break;
			case 9: md.memberList();	break;
			case 10: seatMenu(); break;
			case 15: ; return;
			default :System.out.println(); System.out.println("�߸� �Է��ϼ̽��ϴ�."); break;
			}

		}while(true);


	}
	
	public void seatMenu(){

		int num = 0;
		String id = "";
		do{
			System.out.println();
			System.out.println("******* �¼� ���� ���α׷� *******");
			System.out.println("1. ��ü �¼� ���");
			System.out.println("2. �¼� ���� ���");
			System.out.println("3. �¼� �̿� �ϱ�");
			System.out.println("4. �ð� �߰� �ϱ�");
			System.out.println("5. �¼� ��� ����");
			System.out.println();
			System.out.println("10. ���� �޴���"); 
			System.out.println("00. �¼� �ʱ�ȭ");
			System.out.print("�޴� ��ȣ ���� : ");
			num = sc.nextInt();
			sc.nextLine();
			
			switch(num){
			case 1: sm.printAllSeat(); break;
			case 2: 
				System.out.print("Ȯ���� �¼� : ");
				num = sc.nextInt();
				if(!(num >= 1 && num <=12)){
					System.out.println("���� �¼��Դϴ�.");
					break;
				}
				sm.checkSeat(num);
				break;
			case 3: 
				System.out.print("����� �¼� : ");
				num = sc.nextInt();
				if(!(num >= 1 && num <=12)){
					System.out.println("���� �¼��Դϴ�.");
					break;
				}
				sm.useSeat(num);
				break;
			case 4:
				System.out.print("�߰��� ȸ��ID : ");
				String str = sc.nextLine();
				
				sm.plusTime(str);
				break;
			case 5:
				
				System.out.print("������ �¼� : ");
				int seatNo = sc.nextInt();
				/*System.out.print("��� �ð� : ");
				int time = sc.nextInt();*/
				
				sm.exitSeat(seatNo/*, time*/); break;
			case 10: ; return;
			case 00: sd.seatLeset(); break;
			default :System.out.println(); System.out.println("�߸� �Է��ϼ̽��ϴ�."); break;
			}

		}while(true);


	}
	
}
