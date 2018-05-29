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
			System.out.println("******* PC�� ���� ���α׷� *******");
			System.out.println("1. ȸ������");
			System.out.println("2. ���̵� ã��");
			System.out.println("3. �н����� ã��");
			System.out.println("4. ȸ������ ����");
			System.out.println("5. �ð� �߰�");
			System.out.println("6. ȸ�� ���� ���");
			System.out.println();
			System.out.println("9. ��� ����Ʈ ��� (�ӽ� ���Ȯ�ο�)");
			System.out.println("10. ������"); 
			System.out.print("�޴� ��ȣ ���� : ");
			num = sc.nextInt();
			sc.nextLine();
			
			switch(num){
			case 1: mm.MemberJoin();	break;
			case 2: mm.IdSearch(); 		break;
			case 3: mm.PwSearch(); 		break;
			case 4:
				System.out.print("������ ID �Է� : ");
				id = sc.nextLine();
				mm.MemberAdmission(id); break;
			case 5: mm.TimePlus(); break;
			case 6:
				System.out.print("�˻��� ID �Է� : ");
				id = sc.nextLine();
				mm.MemberInfo(id); 
				break;
			case 9: md.MemberList();	break;
			case 10: ; return;
			default :System.out.println(); System.out.println("�߸� �Է��ϼ̽��ϴ�."); break;
			}

		}while(true);


	}
	
}
