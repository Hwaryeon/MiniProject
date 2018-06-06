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

import com.kh.miniproject.IProfit.IProfit;
import com.kh.miniproject.ProductAndProfit.vo.Profit;
import com.kh.miniproject.iTime.ConversionTime;
import com.kh.miniproject.member.vo.Member;
import com.kh.miniproject.seat.dao.SeatDao;

public class MemberDao implements ConversionTime, IProfit {

	ArrayList<Member> ml = new ArrayList<Member>();
	Profit profit = new Profit();
	
	public void memberJoin(Member m){

		insertList();

		for(int i=0; i<ml.size(); i++){
			if(ml.get(i).getId().equals(m.getId())){
				System.out.println("ID�� �ߺ��Ǿ� ������ ��ҵ˴ϴ�.");
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

		System.out.println(ml.get(0).getName());

		for(int i=0; i < ml.size(); i++){
			if(ml.get(i).getName().equals(name) &&
					ml.get(i).getEmail().equals(email)){

				//System.out.println("ã�� ID : " + ml.get(i).getId());
				return ml.get(i).getId();

			}
		}

		return "�߸� �Է��ϼ̽��ϴ�.";
	}

	public String pwSearch(String name, String id){
				insertList();
		
				for(int i=0; i < ml.size(); i++){
					if(ml.get(i).getName().equals(name) &&
							ml.get(i).getId().equals(id)){
		
						/*System.out.println("ã�� PASSWORD : "
								+ ml.get(i).getPwd());*/
						
						
						return ml.get(i).getPwd();
		
		 			}
		 		}
				return "�߸� �Է��ϼ̽��ϴ�.";
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
			//System.out.println("���� ���� �Ϸ�...");
		}else{
			//System.out.println("���� ���� ����...");
		}

	}

	public void timePlus(String id, int time){

		insertList();

		System.out.println("id : " + id);
		
		int check = 0;

		try(DataOutputStream dout
				= new DataOutputStream(
						new FileOutputStream("member.txt"))){

			for(int i = 0; i < ml.size(); i++){
				if(ml.get(i).getId().equals(id)){
					if(ml.get(i).getAdmission() == false){
						System.out.println("���� ���� ���°� �ƴմϴ�.");
					}else{
						ml.get(i).setRestTime(ml.get(i).getRestTime()
								+ (time * 60 * 60) );
						
						Add_Money(time * 1000);
						
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
			//	System.out.println("���� ����...");
			return;
		}else{
			//	System.out.println("���� ����...");
			return;
		}

	}

	public Member memberInfo(String id){

		insertList();

		for(int i=0; i< ml.size(); i++){

			if(ml.get(i).getId().equals(id)){

				System.out.println();
				System.out.println("�̸� : " + ml.get(i).getName());
				System.out.println("���̵� : " + ml.get(i).getId());
				System.out.print("���� �ð� : ");
				conversionTime(ml.get(i).getRestTime());
				System.out.println();
				System.out.print("�������ð� : ");
				conversionTime(ml.get(i).getAccTime());
				System.out.println();
				return ml.get(i);

			}
		}
		System.out.println("ID ��ȸ ����...");
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
			//System.out.println("���ð�  ��� �Ϸ�...");
			return;
		}else{
			//System.out.println("���ð�  ��� ����...");
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

			// member.txt�� �ƹ� ���������� ����ó�� ---> �ϴ� ���߿� ó��

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
			//	System.out.println("��� ��� ���...");
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
	public String conversionTime(int time){
		long cTime = time;

		long second = (long) ((cTime ) % 60);
		long minute = (long) ((cTime / (  60)) % 60);
		long hour = (long) ((cTime / ( 60 * 60)));
		String s = null;
		
		//System.out.printf("%02d:%02d:%02d", hour, minute, second);
		s = String.format("%02d:%02d:%02d", hour, minute, second);
		
		System.out.print(s);
		
		return s;
	}

	public int checkUser(String id){

		insertList();

		for(int i = 0; i < ml.size(); i++){

			if(ml.get(i).getId().equals(id)){
				System.out.println("���̵� Ȯ��");
				return 1;

			}

		}

		System.out.println("���̵� ���� ");
		return 0;

	}


	//������ ����
		@Override
		public void Add_Money(int money){
			
			System.out.println("�̵� + " + money);
			profit.setTime_M(money);

		}

}
