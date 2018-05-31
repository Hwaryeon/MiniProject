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
			System.out.println("PC�� ȸ�� ���� ���α׷�");
			System.out.println("1. ȸ�� ���̵� ã��");
			System.out.println("2. ȸ�� ��й�ȣ ã��");
			System.out.println("3. ȸ�� ����");
			System.out.println("4. ȸ�� ����");
			System.out.println("5. �ð� �߰�");
			System.out.println("6. ȸ�� ���� ����");
			System.out.println("7. ȸ�� ��ü ����Ʈ");
			System.out.print("�޴��� �����ϼ��� : ");
			int sel = sc.nextInt();

			switch(sel){
			case 1 : System.out.println(m.searchMemberId());	break;
			case 2 : System.out.println(pwd = m.searchMemberPwd());	break;
			case 3 : System.out.print("������ ���̵� �Է� : ");
			sc.nextLine();
			m.memberApply(sc.nextLine());


			break;
			case 4 : m.memberJoin();	break;
			case 5 : System.out.println("�ð� �߰��� ID �Է� : ");
			id = sc.nextLine();
			sc.nextLine();
			System.out.println("�ð� �Է� : ");
			restTime = sc.nextInt();
			m.insertTime(id, restTime);	break;
			case 6 : 
			try {
				System.out.print("��ȸ�� ID �Է� : ");
				id = sc.nextLine();
				sc.nextLine();
				m.memberDisplay(id);
			} catch (Exception e) {
				System.out.println("�Է��Ͻ� ID�� �����ϴ�.");
			}	break;
			case 7 : m.memberAllDisplay(); break;
			default : continue;

			}





		}while(true);

	}

}
