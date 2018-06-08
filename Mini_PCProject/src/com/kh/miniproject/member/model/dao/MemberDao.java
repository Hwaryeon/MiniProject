package com.kh.miniproject.member.model.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.kh.miniproject.IProfit.IProfit;
import com.kh.miniproject.ProductAndProfit.model.vo.Profit;
import com.kh.miniproject.iTime.ConversionTime;
import com.kh.miniproject.member.model.vo.Member;

public class MemberDao implements ConversionTime, IProfit {

	ArrayList<Member> ml = new ArrayList<Member>();
	Profit profit = new Profit();
	
	public void memberJoin(Member m){
		insertList();
		for(int i=0; i<ml.size(); i++){
			if(ml.get(i).getId().equals(m.getId())){
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

	public String idSearch(String name, String email){
		insertList();
		for(int i=0; i < ml.size(); i++){
			if(ml.get(i).getName().equals(name) &&
					ml.get(i).getEmail().equals(email)){
				return ml.get(i).getId();
			}
		}
		return "잘못 입력하셨습니다.";
	}

	public String pwSearch(String name, String id){
				insertList();
				for(int i=0; i < ml.size(); i++){
					if(ml.get(i).getName().equals(name) &&
							ml.get(i).getId().equals(id)){
						return ml.get(i).getPwd();
		 			}
		 		}
				return "잘못 입력하셨습니다.";
		 	}

	public void memberAdmission(String id){

		insertList();
		try(DataOutputStream dout
				= new DataOutputStream(
						new FileOutputStream("member.txt"))){
			for(int i = 0; i < ml.size(); i++){
				if(ml.get(i).getId().equals(id)){
					ml.get(i).setAdmission(true);
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
	}

	public void timePlus(String id, int time){

		insertList();
		try(DataOutputStream dout
				= new DataOutputStream(
						new FileOutputStream("member.txt"))){
			for(int i = 0; i < ml.size(); i++){
				if(ml.get(i).getId().equals(id)){
					if(ml.get(i).getAdmission() == false){
					}else{
						ml.get(i).setRestTime(ml.get(i).getRestTime()
								+ (time * 60 * 60) );
						Add_Money(time * 1000);
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

	}

	public Member memberInfo(String id){

		insertList();
		for(int i=0; i< ml.size(); i++){
			if(ml.get(i).getId().equals(id)){
				conversionTime(ml.get(i).getRestTime());
				conversionTime(ml.get(i).getAccTime());
				return ml.get(i);
			}
		}
		return new Member();
	}

	public void useTime(String id, int time){

		insertList();
		try(DataOutputStream dout
				= new DataOutputStream(
						new FileOutputStream("member.txt"))){
			for(int i=0; i < ml.size(); i++){
				if(ml.get(i).getId().equals(id)){
					ml.get(i).setRestTime(ml.get(i).getRestTime()
							- (time / 60 / 60));
					ml.get(i).setAccTime(ml.get(i).getAccTime()
							+ (time / 60 / 60));
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
		}
		catch(Exception e){
		}
	}

	public ArrayList<Member> memberList(){
		insertList();
		return ml;
	}

	public ArrayList<Member> memberTFList(boolean b){

		insertList();
		ArrayList<Member> tf = new ArrayList<Member>();
		for(int i = 0; i < ml.size(); i++){
			if(ml.get(i).getAdmission() == true && b == true){
				tf.add(new Member(ml.get(i).getName(), ml.get(i).getId(),
						ml.get(i).getPwd(),
						ml.get(i).getEmail(), ml.get(i).getAge(),
						ml.get(i).getpNumber(), ml.get(i).getRestTime(),
						ml.get(i).getAccTime(), ml.get(i).getAdmission()
						));
			}else if(ml.get(i).getAdmission() == false && b == false){

				tf.add(new Member(ml.get(i).getName(), ml.get(i).getId(),
						ml.get(i).getPwd(),
						ml.get(i).getEmail(), ml.get(i).getAge(),
						ml.get(i).getpNumber(), ml.get(i).getRestTime(),
						ml.get(i).getAccTime(), ml.get(i).getAdmission()
						));
			}
		}
		return tf;
	}

	@Override
	public String conversionTime(int time){
		long cTime = time;
		long second = (long) ((cTime ) % 60);
		long minute = (long) ((cTime / (  60)) % 60);
		long hour = (long) ((cTime / ( 60 * 60)));
		String s = null;
		s = String.format("%02d:%02d:%02d", hour, minute, second);
		return s;
	}

	public int checkUser(String id){

		insertList();
		for(int i = 0; i < ml.size(); i++){
			if(ml.get(i).getId().equals(id)){
				System.out.println("아이디 확인");
				return 1;
			}
		}
		return 0;
	}
	
		@Override
		public void Add_Money(int money){
			profit.setTime_M(money);
		}

}
