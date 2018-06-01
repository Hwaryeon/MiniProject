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
					System.out.println("ID가 중복되어 가입이 취소됩니다.");
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
					System.out.println("찾은 ID : " + str[1]);
					return;
				}
			}
		}
		System.out.println("해당하는 정보를 가진 유저가 없습니다.");
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
					System.out.println("찾은 PASSWORD : " + str[2]);
					return;
				}
			}
		}
		System.out.println("해당하는 정보를 가진 유저가 없습니다.");
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
			//System.out.println("가입 승인 완료...");
		}else{
			//System.out.println("가입 승인 실패...");
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

							System.out.println("가입 승인 상태가 아닙니다.");
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
							System.out.println("가입 승인 상태가 아닙니다.");
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
			//	System.out.println("충전 성공...");
			return;
		}else{
			//	System.out.println("충전 실패...");
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
					System.out.println("이름 : " + str[0]);
					System.out.println("아이디 : " + str[1]);

					System.out.print("충전 시간 : ");
					conversionTime(Integer.parseInt(str[6]));
					System.out.println();
					//System.out.println("충전시간 : " + str[6]);
					//System.out.println("사용시간 : " + str[7]);

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
		System.out.println("ID 조회 실패...");
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
					System.out.println("이름 : " + str[0]);
					System.out.println("아이디 : " + str[1]);
					System.out.print("충전시간 : ");
					conversionTime(Integer.parseInt(str[6]));
					System.out.println();
					System.out.print("누적사용시간 : ");
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
		System.out.println("ID 조회 실패...");
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
			//System.out.println("사용시간  계산 완료...");
			return;
		}else{
			//System.out.println("사용시간  계산 실패...");
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

			// member.txt에 아무 정보없을때 에러처리 ---> 일단 나중에 처리

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
			//	System.out.println("모든 멤버 출력...");
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

			// member.txt에 아무 정보없을때 에러처리 ---> 일단 나중에 처리

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
			//	System.out.println("모든 멤버 출력...");
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

			// member.txt에 아무 정보없을때 에러처리 ---> 일단 나중에 처리

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
			//	System.out.println("모든 멤버 출력...");
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
