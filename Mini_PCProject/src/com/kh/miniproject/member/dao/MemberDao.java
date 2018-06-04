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

		insertList();

		for(int i=0; i<ml.size(); i++){
			if(ml.get(i).getId().equals(m.getId())){
				System.out.println("ID가 중복되어 가입이 취소됩니다.");
				return;
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
			dout.writeInt(m.getAccTime());
			dout.writeBoolean(m.getAdmission());

		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public void idSearch(String name, String email){

		insertList();

		for(int i=0; i < ml.size(); i++){
			if(ml.get(i).getName().equals(name) &&
					ml.get(i).getEmail().equals(email)){

				System.out.println("찾은 ID : " + ml.get(i).getId());
				return;

			}
		}

		System.out.println("해당하는 정보를 가진 유저가 없습니다.");
	}

	public void pwSearch(String name, String id){
		insertList();

		for(int i=0; i < ml.size(); i++){
			if(ml.get(i).getName().equals(name) &&
					ml.get(i).getId().equals(id)){

				System.out.println("찾은 PASSWORD : "
						+ ml.get(i).getPwd());
				return;

			}
		}
		System.out.println("해당하는 정보를 가진 유저가 없습니다.");
	}

	public void memberAdmission(String id){

		insertList();

		int check = 0;

		try(DataOutputStream dout
				= new DataOutputStream(
						new FileOutputStream("member.txt"))){

			for(int i = 0; i < ml.size(); i++){

				if(ml.get(i).getId().equals(id)){
					ml.get(i).setAdmission(true);
					check = 1;
				}

				dout.writeUTF(ml.get(i).getName());
				dout.writeUTF(ml.get(i).getId());
				dout.writeUTF(ml.get(i).getPwd());
				dout.writeUTF(ml.get(i).getEmail());
				dout.writeInt(ml.get(i).getAge());
				dout.writeUTF(ml.get(i).getpNumber());

				dout.writeInt(ml.get(i).getRestTime());
				dout.writeInt(ml.get(i).getAccTime());
				dout.writeBoolean(ml.get(i).getAdmission());

			}

		}catch(Exception e){
			e.printStackTrace();
		}

		if(check == 1){
			//System.out.println("가입 승인 완료...");
		}else{
			//System.out.println("가입 승인 실패...");
		}

	}

	public void timePlus(String id, int time){

		insertList();

		int check = 0;

		try(DataOutputStream dout
				= new DataOutputStream(
						new FileOutputStream("member.txt"))){

			for(int i = 0; i < ml.size(); i++){
				if(ml.get(i).getId().equals(id)){
					if(ml.get(i).getAdmission() == false){
						System.out.println("가입 승인 상태가 아닙니다.");
					}else{
						ml.get(i).setRestTime(ml.get(i).getRestTime()
								+ (time * 60 * 60) );
						check = 1;
					}

				}

				dout.writeUTF(ml.get(i).getName());
				dout.writeUTF(ml.get(i).getId());
				dout.writeUTF(ml.get(i).getPwd());
				dout.writeUTF(ml.get(i).getEmail());
				dout.writeInt(ml.get(i).getAge());
				dout.writeUTF(ml.get(i).getpNumber());

				dout.writeInt(ml.get(i).getRestTime());
				dout.writeInt(ml.get(i).getAccTime());
				dout.writeBoolean(ml.get(i).getAdmission());

			}

		}catch(Exception e){
			e.printStackTrace();
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

		insertList();

		for(int i=0; i< ml.size(); i++){

			if(ml.get(i).getId().equals(id)){

				System.out.println();
				System.out.println("이름 : " + ml.get(i).getName());
				System.out.println("아이디 : " + ml.get(i).getId());
				System.out.print("충전 시간 : ");
				conversionTime(ml.get(i).getRestTime());
				System.out.println();
				System.out.print("누적사용시간 : ");
				conversionTime(ml.get(i).getAccTime());
				System.out.println();
				return ml.get(i);

			}
		}
		System.out.println("ID 조회 실패...");
		return new Member();

	}

	public void useTime(String id, int time){

		insertList();

		int check = 0;

		try(DataOutputStream dout
				= new DataOutputStream(
						new FileOutputStream("member.txt"))){

			for(int i=0; i < ml.size(); i++){

				if(ml.get(i).getId().equals(id)){
					ml.get(i).setRestTime(ml.get(i).getRestTime()
							- (time / 60 / 60));

					ml.get(i).setAccTime(ml.get(i).getAccTime()
							+ (time / 60 / 60));
					check = 1;
				}

				dout.writeUTF(ml.get(i).getName());
				dout.writeUTF(ml.get(i).getId());
				dout.writeUTF(ml.get(i).getPwd());
				dout.writeUTF(ml.get(i).getEmail());
				dout.writeInt(ml.get(i).getAge());
				dout.writeUTF(ml.get(i).getpNumber());

				dout.writeInt(ml.get(i).getRestTime());
				dout.writeInt(ml.get(i).getAccTime());
				dout.writeBoolean(ml.get(i).getAdmission());
			}

		}catch(Exception e){
			e.printStackTrace();
		}

		if(check == 1){
			//System.out.println("사용시간  계산 완료...");
			return;
		}else{
			//System.out.println("사용시간  계산 실패...");
			return;
		}

	}

	public void insertList(){
		ml.clear();
		String name;
		String id;
		String pwd;
		String email;
		int age;
		String pNumber;

		int restTime;
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
				accTime = din.readInt();
				admission = din.readBoolean();

				ml.add(new Member(name, id, pwd, email, age, pNumber,
						restTime, accTime, admission));

			}
		}catch(EOFException e){
			//	System.out.println("모든 멤버 출력...");
		}
		catch(Exception e){
			//	e.printStackTrace();
		}
	}

	public ArrayList<Member> memberList(){

		insertList();
		int num = 1;

		for(int i = 0; i < ml.size(); i++){

			System.out.print(num +" : " + ml.get(i).getName() + ", " + ml.get(i).getId()
					+ ", " + ml.get(i).getPwd()
					+ ", " + ml.get(i).getEmail() +", " + ml.get(i).getAge()
					+ ", " + ml.get(i).getpNumber() +", " );

			conversionTime(ml.get(i).getRestTime());
			System.out.print(", ");
			conversionTime(ml.get(i).getAccTime());

			System.out.printf(", %b" , ml.get(i).getAdmission());
			System.out.println();

			num++;
		}

		return ml;

	}

	public ArrayList<Member> memberTFList(boolean b){

		insertList();
		int num = 1;

		ArrayList<Member> tf = new ArrayList<Member>();

		for(int i = 0; i < ml.size(); i++){


			if(ml.get(i).getAdmission() == true && b == true){
				System.out.print(num +" : " + ml.get(i).getName() + ", " + ml.get(i).getId()
						+ ", " + ml.get(i).getPwd()
						+ ", " + ml.get(i).getEmail() +", " + ml.get(i).getAge()
						+ ", " + ml.get(i).getpNumber() +", " );

				conversionTime(ml.get(i).getRestTime());

				System.out.print(", ");
				conversionTime(ml.get(i).getAccTime());

				System.out.printf(", %b" , ml.get(i).getAdmission());
				System.out.println();

				/*this.name = name;
				this.id = id;
				this.pwd = pwd;
				this.email = email;
				this.age = age;
				this.pNumber = pNumber;
				this.restTime = restTime;
				this.accTime = accTime;
				this.admission = admission;*/

				tf.add(new Member(ml.get(i).getName(), ml.get(i).getId(),
						ml.get(i).getPwd(),
						ml.get(i).getEmail(), ml.get(i).getAge(),
						ml.get(i).getpNumber(), ml.get(i).getRestTime(),
						ml.get(i).getAccTime(), ml.get(i).getAdmission()
						));
				num++;


			}else if(ml.get(i).getAdmission() == false && b == false){
				System.out.print(num +" : " + ml.get(i).getName() + ", " + ml.get(i).getId()
						+ ", " + ml.get(i).getPwd()
						+ ", " + ml.get(i).getEmail() +", " + ml.get(i).getAge()
						+ ", " + ml.get(i).getpNumber() +", " );

				conversionTime(ml.get(i).getRestTime());

				System.out.print(", ");
				conversionTime(ml.get(i).getAccTime());

				System.out.printf(", %b" , ml.get(i).getAdmission());
				System.out.println();
				tf.add(new Member(ml.get(i).getName(), ml.get(i).getId(),
						ml.get(i).getPwd(),
						ml.get(i).getEmail(), ml.get(i).getAge(),
						ml.get(i).getpNumber(), ml.get(i).getRestTime(),
						ml.get(i).getAccTime(), ml.get(i).getAdmission()
						));
				num++;
			}


		}
		return tf;

	}

	@Override
	public void conversionTime(int time){
		long cTime = time;

		long second = (long) ((cTime ) % 60);
		long minute = (long) ((cTime / (  60)) % 60);
		long hour = (long) ((cTime / ( 60 * 60)));

		System.out.printf("%02d:%02d:%02d", hour, minute, second);
	}

	public int checkUser(String id){

		insertList();

		for(int i = 0; i < ml.size(); i++){

			if(ml.get(i).getId().equals(id)){
				System.out.println("아이디 확인");
				return 1;

			}

		}

		System.out.println("아이디 없음 ");
		return 0;

	}

}
