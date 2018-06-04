package com.kh.miniproject.seat.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.miniproject.iTime.ConversionTime;
import com.kh.miniproject.member.controller.MemberManager;
import com.kh.miniproject.seat.vo.Seat;
import com.kh.miniproject.view.Timer;
import com.kh.miniproject.view.TimerMake;

public class SeatDao extends Thread implements ConversionTime{


	Scanner sc = new Scanner(System.in);

	MemberManager mm = new MemberManager();
	//TimerMake tm = new TimerMake();
	ArrayList<Seat> sl = new ArrayList<Seat>();

	final static int MAX_SEAT = 12;

	public static Thread[] tList = new Thread[MAX_SEAT];
	public static int[] iList = new int[MAX_SEAT];


	public void seatLeset(){
		int num = 1;

		try(DataOutputStream os = new DataOutputStream(
				new FileOutputStream("seat.txt"))){
			for(int i = 0; i < MAX_SEAT; i++){
				sl.add(new Seat(num));
				num++;
				os.writeInt(sl.get(i).getSeatNo());
				os.writeUTF(" ");
				os.writeBoolean(sl.get(i).getUseCheck());
				os.writeInt(sl.get(i).getUserTime());

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void insertList(){

		sl.clear();

		int seatNo = 0;
		String userId = "";
		boolean check = false;
		int time = 0;
		int value = 0;

		try(DataInputStream dis = new DataInputStream(
				new FileInputStream("seat.txt"))){

			while(true){

				seatNo = dis.readInt();
				userId = dis.readUTF();
				check = dis.readBoolean();
				time = dis.readInt();

				sl.add(new Seat(seatNo, userId, check, time));

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(EOFException e){
			//System.out.println("모든 좌석 출력...");
		}catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println();
	}

	public void printAllSeat(){

		sl.clear();

		int seatNo = 0;
		String userId = "";
		boolean check = false;
		int time = 0;
		int value = 0;

		try(DataInputStream dis = new DataInputStream(
				new FileInputStream("seat.txt"))){

			while(true){

				seatNo = dis.readInt();
				userId = dis.readUTF();
				check = dis.readBoolean();
				time = dis.readInt();
				sl.add(new Seat(seatNo, userId, check, time));

			}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(EOFException e){
			//System.out.println("모든 좌석 출력...");
		} catch (IOException e) {
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

	public String checkSeat(int seatNo){

		insertList();

		for(int i=0; i < MAX_SEAT; i++){
			if(sl.get(i).getSeatNo() == seatNo){

				if(sl.get(i).getUseCheck() == true){


					
					/*mm.memberInfo(sl.get(i).getUserId());
					System.out.println();

					System.out.print("사용시간 : ");
					conversionTime(iList[seatNo-1]);
					System.out.println();*/
					
					/*tm.threadNumber = seatNo-1;
					tm.visibleFrame();*/
					
					return sl.get(i).getUserId();
				}
			}
		}

		return null;/*System.out.println("해당 좌석은 사용중이지 않습니다.");*/

	}

	
	public void useSeat(int seatNo, String id, int time){

		insertList();

		int check = 0;
		try(DataOutputStream os = new DataOutputStream(
				new FileOutputStream("seat.txt"))){

			for(int i=0; i < MAX_SEAT; i++){
				if(	sl.get(i).getUserId().equals(id) ){
					System.out.println("사용자가 좌석 이용중입니다.");
					check = 1;
				}

				if(sl.get(i).getSeatNo() == seatNo && time <= 0){
					System.out.println("사용자의 잔여시간이 없습니다. ");
					check = 1;
				}

				if(sl.get(i).getSeatNo() == seatNo){

					if(sl.get(i).getUseCheck() == true){

						System.out.println("해당 좌석은 이용중입니다.");
					}

					else if(check != 1){
						sl.get(i).setUseCheck(true);
						sl.get(i).setUserId(id);
						sl.get(i).setUserTime(time);					
					}

				}
				os.writeInt(sl.get(i).getSeatNo());
				os.writeUTF(sl.get(i).getUserId());
				os.writeBoolean(sl.get(i).getUseCheck());
				os.writeInt(sl.get(i).getUserTime());

				// thread 시작
				if(seatNo == sl.get(i).getSeatNo() && check != 1){

					if(sl.get(i).getUserTime() > 0){

						Timer timer = new Timer(sl.get(i).getSeatNo(),
								sl.get(i).getUserId(),
								sl.get(i).getUserTime());
						Thread t1 = timer;

						tList[sl.get(i).getSeatNo()-1] = t1;

						t1.start();
					}
				}
				// thread 끝
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String exitSeat(int seatNo){

		insertList();

		String userId = "";

		try(DataOutputStream os = new DataOutputStream(
				new FileOutputStream("seat.txt"))){

			for(int i=0; i < MAX_SEAT; i++){
				if(sl.get(i).getSeatNo() == seatNo){

					if(sl.get(i).getUseCheck() == false){
						System.out.println("해당 좌석은 사용중이지 않습니다.");
					}else{

						sl.get(i).setUseCheck(false);
						userId = sl.get(i).getUserId();
						sl.get(i).setUserId("");
						sl.get(i).setUserTime(0);
						System.out.println("좌석 사용 종료...");
						tList[seatNo-1].interrupt();
						
					}
				}
				os.writeInt(sl.get(i).getSeatNo());
				os.writeUTF(sl.get(i).getUserId());
				os.writeBoolean(sl.get(i).getUseCheck());
				os.writeInt(sl.get(i).getUserTime());
			}
			return userId;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userId;
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
