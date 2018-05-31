package com.kh.miniproject.member.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.kh.miniproject.member.vo.Member;

public class MemberDao {
	private ArrayList<Member> list = new ArrayList<Member>();
	
	public MemberDao(){
		
		try(ObjectInputStream ois = new ObjectInputStream
				(new FileInputStream("member.dat"))){
			list = (ArrayList<Member>) ois.readObject();
			
			
		} catch (FileNotFoundException e) {
			try {
				FileWriter fw = new FileWriter("member.dat");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch(EOFException e){
			System.out.println("회원 리스트가 없습니다.");
		}
		catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String searchMemberId(String name, String phoneNumber){
		for(int i = 0; i < list.size(); i++){
			if(name.equals(list.get(i).getName()) == true && 
					phoneNumber.equals(list.get(i).getPhoneNumber()) == true){
				return list.get(i).getId();
			}
		}
		return "입력하신 정보가 맞지 않습니다.";
	}
	
	public String searchMemberPwd(String id, String name){
		for(int i = 0; i < list.size(); i++){
			if(id.equals(list.get(i).getId()) == true && 
					name.equals(list.get(i).getName()) == true){
				return list.get(i).getPwd();
			}
		}
		return "입력하신 정보가 맞지 않습니다.";
	}
	
	public void memberApply(String id){
		for(int i = 0; i < list.size(); i++){
			if(id.equals(list.get(i).getId())){
				list.get(i).setAdmission(true);
				System.out.println("승인되었습니다.");
			}
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("member.dat"))){
			oos.writeObject(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void memberJoin(Member m){
		this.list.add(m);
		
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("member.dat"))){
			oos.writeObject(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void insertTime(String id, int restTime){
		for(int i = 0; i < list.size(); i++){
			if(id.equals(list.get(i).getId())){
				list.get(i).setRestTime(list.get(i).getRestTime() + restTime);
			}
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("member.dat"))){
			oos.writeObject(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Member memberDisplay(String id){
		for(int i = 0; i < list.size(); i++){
			if(id.equals(list.get(i).getId())){
				return list.get(i);
			}
		}
		
		return null;
	}
	
	public ArrayList<Member> memberAllDisplay(){
		return list;
	}
	
	
	
	public boolean searchOverlap(String id){
		boolean idCheck = true;
		for(int i = 0; i < list.size(); i++){
			if(id.equals(list.get(i).getId())){
				idCheck = false;
			}
		}
		
		return idCheck;
	}
}
