package com.kh.miniproject.member.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import com.kh.miniproject.iTime.ConversionTime;
import com.kh.miniproject.member.vo.Member;
import com.kh.miniproject.seat.dao.SeatDao;

public class MemberDao implements ConversionTime {

	ArrayList<Member> ml = new ArrayList<Member>();

	public void memberJoin(Member m){

		ml.clear();
		listInsert();

		for(int i=0; i<ml.size(); i++){

			Iterator iter = ml.iterator();

			String str[];

			while(iter.hasNext()){

				str = (iter.next().toString()).split(", ");

				if(str[1].equals(m.getId())){
					System.out.println("ID�� �ߺ��Ǿ� ������ ��ҵ˴ϴ�.");
					return;
				}
			}
		}

		try(DataOutputStream dout
				= new DataOutputStream(
						new FileOutputStream("member.txt", true))){

			dout.writeUTF(m.getName());
			dout.writeUTF(m.getId());
			dout.writeUTF(m.getPwd());
			dout.writeUTF(m.getEmail());
			dout.writeInt(m.getAge());
			dout.writeUTF(m.getpNumber());

			dout.writeInt(m.getRestTime());
			dout.writeInt(m.getUseTime());
			dout.writeInt(m.getAccTime());
			dout.writeBoolean(m.getAdmission());

		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public void idSearch(String name, String email){

		ml.clear();
		listInsert();

		for(int i=0; i<ml.size(); i++){

			Iterator iter = ml.iterator();

			String str[];


			while(iter.hasNext()){


				str = (iter.next().toString()).split(", ");

				if(str[0].equals(name) && str[3].equals(email)){
					System.out.println("ã�� ID : " + str[1]);
					return;
				}
			}
		}
		System.out.println("�ش��ϴ� ������ ���� ������ �����ϴ�.");
	}

	public void pwSearch(String name, String id){
		ml.clear();
		listInsert();

		for(int i=0; i<ml.size(); i++){

			Iterator iter = ml.iterator();

			String str[];

			while(iter.hasNext()){

				str = (iter.next().toString()).split(", ");

				if(str[0].equals(name) && str[1].equals(id)){
					System.out.println("ã�� PASSWORD : " + str[2]);
					return;
				}
			}
		}
		System.out.println("�ش��ϴ� ������ ���� ������ �����ϴ�.");
	}

	public void memberAdmission(String id){

		ml.clear();
		listInsert();

		int check = 0;

		for(int i=0; i<ml.size(); i++){

			Iterator iter = ml.iterator();

			String str[];

			try(DataOutputStream dout
					= new DataOutputStream(
							new FileOutputStream("member.txt"))){
				while(iter.hasNext()){

					str = (iter.next().toString()).split(", ");

					if(str[1].equals(id)){
						str[9] = "true";
						check = 1;
					}

					Member m = new Member(str[0], str[1], str[2],
							str[3], Integer.parseInt(str[4]), str[5],
							Integer.parseInt(str[6]), Integer.parseInt(str[7]),
							Integer.parseInt(str[8]), Boolean.parseBoolean(str[9]));

					dout.writeUTF(m.getName());
					dout.writeUTF(m.getId());
					dout.writeUTF(m.getPwd());
					dout.writeUTF(m.getEmail());
					dout.writeInt(m.getAge());
					dout.writeUTF(m.getpNumber());

					dout.writeInt(m.getRestTime());
					dout.writeInt(m.getUseTime());
					dout.writeInt(m.getAccTime());
					dout.writeBoolean(m.getAdmission());

				}

			}catch(Exception e){
				e.printStackTrace();
			}

		}

		if(check == 1){
			//System.out.println("���� ���� �Ϸ�...");
		}else{
			//System.out.println("���� ���� ����...");
		}

	}

	public void timePlus(String id, int time){
		ml.clear();
		listInsert();

		int check = 0;

		for(int i=0; i<ml.size(); i++){

			Iterator iter = ml.iterator();

			String str[];


			try(DataOutputStream dout
					= new DataOutputStream(
							new FileOutputStream("member.txt"))){
				while(iter.hasNext()){

					str = (iter.next().toString()).split(", ");

					/*if(str[1].equals(id)){

						if(Boolean.getBoolean(str[9]) == false){

							System.out.println("���� ���� ���°� �ƴմϴ�.");
						}else if(Boolean.getBoolean(str[9]) == true){
							str[6] = ((Integer.parseInt(str[6])
									+ (time * 60 * 60)) + "");
							check = 1;
						}

					}*/

					Member m = new Member(str[0], str[1], str[2],
							str[3], Integer.parseInt(str[4]), str[5],
							Integer.parseInt(str[6]), Integer.parseInt(str[7]),
							Integer.parseInt(str[8]), Boolean.parseBoolean(str[9]));

					if(m.getId().equals(id)){


						if(m.getAdmission() == false){
							System.out.println("���� ���� ���°� �ƴմϴ�.");
						}else{

							m.setRestTime(

									Integer.parseInt(str[6])
									+ (time * 60 * 60));

							check = 1;
						}


					}

					dout.writeUTF(m.getName());
					dout.writeUTF(m.getId());
					dout.writeUTF(m.getPwd());
					dout.writeUTF(m.getEmail());
					dout.writeInt(m.getAge());
					dout.writeUTF(m.getpNumber());

					dout.writeInt(m.getRestTime());
					dout.writeInt(m.getUseTime());
					dout.writeInt(m.getAccTime());
					dout.writeBoolean(m.getAdmission());
				}

			}catch(Exception e){
				e.printStackTrace();
			}

		}
		if(check == 1){
			//	System.out.println("���� ����...");
			return;
		}else{
			//	System.out.println("���� ����...");
			return;
		}

	}

	public Member memberInfo(String id){

		ml.clear();
		listInsert();

		Member m;

		for(int i=0; i<ml.size(); i++){

			Iterator iter = ml.iterator();

			String str[];

			while(iter.hasNext()){

				str = (iter.next().toString()).split(", ");

				if(str[1].equals(id)){
					System.out.println();
					System.out.println("�̸� : " + str[0]);
					System.out.println("���̵� : " + str[1]);

					System.out.print("���� �ð� : ");
					conversionTime(Integer.parseInt(str[6]));
					System.out.println();
					//System.out.println("�����ð� : " + str[6]);
					//System.out.println("���ð� : " + str[7]);

					m = new Member(str[0], str[1], str[2],
							str[3], Integer.parseInt(str[4]), str[5],
							Integer.parseInt(str[6]),
							Integer.parseInt(str[7]),
							Integer.parseInt(str[8]), 
							Boolean.parseBoolean(str[9]));

					return m;
					//return Integer.parseInt(str[6]);
				}
			}

		}
		System.out.println("ID ��ȸ ����...");
		return (m = new Member());

	}

	public Member memberInfo_time(String id){

		ml.clear();
		listInsert();

		Member m;


		for(int i=0; i<ml.size(); i++){

			Iterator iter = ml.iterator();

			String str[];

			double dTime = 0;

			while(iter.hasNext()){

				str = (iter.next().toString()).split(", ");

				if(str[1].equals(id)){
					System.out.println();
					System.out.println("�̸� : " + str[0]);
					System.out.println("���̵� : " + str[1]);
					System.out.print("�����ð� : ");
					conversionTime(Integer.parseInt(str[6]));
					System.out.println();
					System.out.print("�������ð� : ");
					conversionTime(Integer.parseInt(str[8]));
					System.out.println();

					m = new Member(str[0], str[1], str[2],
							str[3], Integer.parseInt(str[4]), str[5],
							Integer.parseInt(str[6]),
							Integer.parseInt(str[7]),
							Integer.parseInt(str[8]), 
							Boolean.parseBoolean(str[9]));

					return m;
				}
			}

		}
		System.out.println("ID ��ȸ ����...");
		return (m = new Member());

	}

	public void useTime(String id, int time){

		ml.clear();
		listInsert();

		int check = 0;

		for(int i=0; i<ml.size(); i++){

			Iterator iter = ml.iterator();

			String str[];

			try(DataOutputStream dout
					= new DataOutputStream(
							new FileOutputStream("member.txt"))){
				while(iter.hasNext()){

					str = (iter.next().toString()).split(", ");

					if(str[1].equals(id)){
						str[6] = (Integer.parseInt(str[6]) - (time / 60 / 60)) + "";
						str[8] = (Integer.parseInt(str[8]) + (time / 60 / 60)) + "";
						check = 1;
					}

					Member m = new Member(str[0], str[1], str[2],
							str[3], Integer.parseInt(str[4]), str[5],
							Integer.parseInt(str[6]), Integer.parseInt(str[7]),
							Integer.parseInt(str[8]), Boolean.parseBoolean(str[9]));

					dout.writeUTF(m.getName());
					dout.writeUTF(m.getId());
					dout.writeUTF(m.getPwd());
					dout.writeUTF(m.getEmail());
					dout.writeInt(m.getAge());
					dout.writeUTF(m.getpNumber());

					dout.writeInt(m.getRestTime());
					dout.writeInt(m.getUseTime());
					dout.writeInt(m.getAccTime());
					dout.writeBoolean(m.getAdmission());
				}
			}catch(Exception e){
				e.printStackTrace();
			}

		}

		if(check == 1){
			//System.out.println("���ð�  ��� �Ϸ�...");
			return;
		}else{
			//System.out.println("���ð�  ��� ����...");
			return;
		}

	}

	public void listInsert(){
		ml.clear();
		String name;
		String id;
		String pwd;
		String email;
		int age;
		String pNumber;

		int restTime;
		int useTime;
		int accTime;
		boolean admission;

		try(DataInputStream din 
				= new DataInputStream(
						new FileInputStream("member.txt"));
				){

			// member.txt�� �ƹ� ���������� ����ó�� ---> �ϴ� ���߿� ó��

			while(true){
				name = din.readUTF();
				id = din.readUTF();
				pwd = din.readUTF();
				email = din.readUTF();
				age = din.readInt();
				pNumber = din.readUTF();

				restTime = din.readInt();
				useTime = din.readInt();
				accTime = din.readInt();
				admission = din.readBoolean();

				ml.add(new Member(name, id, pwd, email, age, pNumber,
						restTime, useTime, accTime, admission));

			}
		}catch(EOFException e){
			//	System.out.println("��� ��� ���...");
		}
		catch(Exception e){
			//	e.printStackTrace();
		}
	}

	public void memberList(){
		ml.clear();
		String name;
		String id;
		String pwd;
		String email;
		int age;
		String pNumber;

		int restTime;
		int useTime;
		int accTime;
		boolean admission;

		int i = 1;

		try(DataInputStream din 
				= new DataInputStream(
						new FileInputStream("member.txt"));
				){

			// member.txt�� �ƹ� ���������� ����ó�� ---> �ϴ� ���߿� ó��

			while(true){
				name = din.readUTF();
				id = din.readUTF();
				pwd = din.readUTF();
				email = din.readUTF();
				age = din.readInt();
				pNumber = din.readUTF();

				restTime = din.readInt();
				useTime = din.readInt();
				accTime = din.readInt();
				admission = din.readBoolean();

				System.out.print(i +" : " + name + ", " + id + ", " + pwd
						+", " +email+", " +age+", " +pNumber+", " );

				conversionTime(restTime);

				System.out.printf(", %d, " ,useTime);

				conversionTime(accTime);

				System.out.printf(", %b" ,admission);
				System.out.println();
				
				i++;
			}
		}catch(EOFException e){
			//	System.out.println("��� ��� ���...");
		}
		catch(Exception e){
			//	e.printStackTrace();
		}

	}

	public void memberTFList(boolean b){

		ml.clear();
		String name;
		String id;
		String pwd;
		String email;
		int age;
		String pNumber;

		int restTime;
		int useTime;
		int accTime;
		boolean admission;

		int i = 1;


		try(DataInputStream din 
				= new DataInputStream(
						new FileInputStream("member.txt"));
				){

			// member.txt�� �ƹ� ���������� ����ó�� ---> �ϴ� ���߿� ó��

			while(true){
				name = din.readUTF();
				id = din.readUTF();
				pwd = din.readUTF();
				email = din.readUTF();
				age = din.readInt();
				pNumber = din.readUTF();

				restTime = din.readInt();
				useTime = din.readInt();
				accTime = din.readInt();
				admission = din.readBoolean();

				if(b == true){

					if(admission == false){
						continue;
					}

					System.out.print(i +" : " + name + ", " + id + ", " + pwd
							+", " +email+", " +age+", " +pNumber+", " );

					conversionTime(restTime);

					System.out.printf(", %d, " ,useTime);

					conversionTime(accTime);

					System.out.printf(", %b" ,admission);
					System.out.println();
					
					i++;

				}else{

					if(admission == true){
						continue;
					}

					System.out.print(i +" : " + name + ", " + id + ", " + pwd
							+", " +email+", " +age+", " +pNumber+", " );

					conversionTime(restTime);

					System.out.printf(", %d, " ,useTime);

					conversionTime(accTime);

					System.out.printf(", %b" ,admission);
					System.out.println();
					
					i++;

				}
			}
		}catch(EOFException e){
			//	System.out.println("��� ��� ���...");
		}
		catch(Exception e){
			//	e.printStackTrace();
		}

	}
	
	@Override
	public void conversionTime(int time){
		long cTime = time;

		long second = (long) ((cTime ) % 60);
		long minute = (long) ((cTime / (  60)) % 60);
		long hour = (long) ((cTime / ( 60 * 60)));

		System.out.printf("%02d:%02d:%02d", hour, minute, second);
	}

}
