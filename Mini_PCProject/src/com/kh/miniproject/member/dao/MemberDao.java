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

import com.kh.miniproject.member.vo.Member;

public class MemberDao {

	ArrayList<Member> ml = new ArrayList<Member>();

	public void MemberJoin(Member m){

		ml.clear();
		ListInsert();

		
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

	public void IdSearch(String name, String email){

		ml.clear();
		ListInsert();

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

	public void PwSearch(String name, String id){
		ml.clear();
		ListInsert();

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


	public void MemberAdmission(String id){

		ml.clear();
		ListInsert();
		
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
			System.out.println("가입 승인 완료...");
		}else{
			System.out.println("가입 승인 실패...");
		}
		

	}



	public void TimePlus(String id, int time){
		ml.clear();
		ListInsert();

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
						str[6] = (Integer.parseInt(str[6]) + time) + "";
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
			System.out.println("충전 성공...");
			return;
		}else{
			System.out.println("충전 실패...");
			return;
		}

	}

	
	public boolean MemberInfo(String id){
		
		ml.clear();
		ListInsert();

		
		for(int i=0; i<ml.size(); i++){

			Iterator iter = ml.iterator();

			String str[];

			while(iter.hasNext()){

				str = (iter.next().toString()).split(", ");

				if(str[1].equals(id)){
					System.out.println();
					System.out.println("이름 : " + str[0]);
					System.out.println("아이디 : " + str[1]);
					System.out.println("잔여시간 : " + str[6]);
					System.out.println("사용시간 : " + str[7]);
					System.out.println();
					return true;
				}
			}

		}
		
		System.out.println("ID 조회 실패...");
		return false;
		
	}

	public void useTime(String id, int time){
		
		
		ml.clear();
		ListInsert();

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
						str[6] = (Integer.parseInt(str[6]) - time) + "";
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
			System.out.println("사용시간  계산 완료...");
			return;
		}else{
			System.out.println("사용시간  계산 실패...");
			return;
		}

		
		
		
	}
	
	
	
	
	public void ListInsert(){
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
			System.out.println("모든 멤버 출력...");
		}
		catch(Exception e){
			e.printStackTrace();
		}


	}




	public void MemberList(){
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


				System.out.println(i +" : " + name + ", " + id + ", " + pwd
						+", " +email+", " +age+", " +pNumber+", " + restTime
						+", " + useTime+", " +accTime+", " +admission);
				i++;
			}
		}catch(EOFException e){
			System.out.println("모든 멤버 출력...");
		}
		catch(Exception e){
			e.printStackTrace();
		}


	}

}
