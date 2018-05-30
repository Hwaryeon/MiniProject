package com.kh.miniproject.seat.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.kh.miniproject.member.controller.MemberManager;
import com.kh.miniproject.seat.vo.Seat;

public class SeatDao {


	MemberManager mm = new MemberManager();
	ArrayList<Seat> sl = new ArrayList<Seat>();
	final int MAX_SEAT = 12;


	public void SeatLeset(){
		int num = 1;

		try(DataOutputStream os = new DataOutputStream(
				new FileOutputStream("seat.txt"))){
			for(int i = 0; i < MAX_SEAT; i++){
				sl.add(new Seat(num));
				num++;



				os.writeInt(sl.get(i).getSeatNo());
				os.writeUTF(" ");
				os.writeBoolean(sl.get(i).getUseCheck());




			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void InsertList(){

		sl.clear();

		int seatNo = 0;
		String userId = "";
		boolean check = false;
		int value = 0;

		try(DataInputStream dis = new DataInputStream(
				new FileInputStream("seat.txt"))){

			while(true){

				seatNo = dis.readInt();
				userId = dis.readUTF();
				check = dis.readBoolean();

				sl.add(new Seat(seatNo, userId, check));

			}


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(EOFException e){
			System.out.println("��� �¼� ���...");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println();
	}

	public void printAllSeat(){

		sl.clear();

		int seatNo = 0;
		String userId = "";
		boolean check = false;
		int value = 0;

		try(DataInputStream dis = new DataInputStream(
				new FileInputStream("seat.txt"))){

			while(true){

				seatNo = dis.readInt();
				userId = dis.readUTF();
				check = dis.readBoolean();

				sl.add(new Seat(seatNo, userId, check));

			}


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(EOFException e){
			System.out.println("��� �¼� ���...");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		for(int i = 0; i < MAX_SEAT; i++){
			if(sl.get(i).getUseCheck() == false){
				System.out.print(sl.get(i).getSeatNo() + " : O\t");
			}else{
				System.out.print(sl.get(i).getSeatNo() + " : X\t");
			}
			if(i == 3 || i == 7){
				System.out.println();
			}
		}
		System.out.println();
	}

	public void CheckSeat(int seatNo){


		InsertList();

		for(int i=0; i < MAX_SEAT; i++){
			if(sl.get(i).getSeatNo() == seatNo){

				if(sl.get(i).getUseCheck() == true){

					mm.MemberInfo(sl.get(i).getUserId());
					return;
				}


			}
		}

		System.out.println("�ش� �¼��� ��������� �ʽ��ϴ�.");

	}

	public void UseSeat(int seatNo, String id){

		InsertList();
		try(DataOutputStream os = new DataOutputStream(
				new FileOutputStream("seat.txt"))){

			for(int i=0; i < MAX_SEAT; i++){
				if(sl.get(i).getSeatNo() == seatNo){

					if(sl.get(i).getUseCheck() == true){

						System.out.println("�ش� �¼��� �̿����Դϴ�.");
					}else{
						
						sl.get(i).setUseCheck(true);
						sl.get(i).setUserId(id);
						
					}

				}
				os.writeInt(sl.get(i).getSeatNo());
				os.writeUTF(sl.get(i).getUserId());
				os.writeBoolean(sl.get(i).getUseCheck());

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String exitSeat(int seatNo){

		InsertList();
		
		String userId = "";
		
		try(DataOutputStream os = new DataOutputStream(
				new FileOutputStream("seat.txt"))){

			for(int i=0; i < MAX_SEAT; i++){
				if(sl.get(i).getSeatNo() == seatNo){

					
						sl.get(i).setUseCheck(false);
						userId = sl.get(i).getUserId();
						
				}
				os.writeInt(sl.get(i).getSeatNo());
				os.writeUTF(sl.get(i).getUserId());
				os.writeBoolean(sl.get(i).getUseCheck());

			}
			System.out.println("�¼� ��� ����...");
			return userId;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		return userId;
	
	
	
	}


}
