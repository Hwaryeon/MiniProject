package com.kh.miniproject.ProductAndProfit.vo;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;



public class Profit{

   private int all_M=0;      //총 누적수입
   private int day_M=0;      //하루 수입
   private int item_M=0;      //재고 수입
   private int time_M=0;      //시간 수입
   private String day = new SimpleDateFormat("dd").format(new Date());   //수익관리 매니저객체를 생성시의 시간을 가져옴

   public Profit() {
      date_Calculator();
   }   

   public void date_Calculator(){
      /* "Profit.dat"에서 값을 가져온후 필드변수들을 초기화

      date값을 사용해 day값이 변동시 (하루가 지날시)   
         day_M값을 0으로 초기화 후 all_M에 더해준다.
       */

      try(FileInputStream fos = new FileInputStream("Profit.dat");
            DataInputStream dis = new DataInputStream(fos);)
      {

         this.all_M = dis.readInt();
         this.day_M = dis.readInt();
         this.item_M = dis.readInt();
         this.time_M = dis.readInt();
         /*   this.day = dis.readUTF();*/

         if(!dis.readUTF().equals(day) )
         {

            this.all_M += day_M;   
            this.day_M = 0;
            this.item_M = 0;
            this.time_M = 0;
            profit_Save();
         }
          
         
      }catch(Exception e){
         System.out.println("error");
      }      

   }





   //총 누적수익 출력
   public int getAll_M() {

      return all_M;
   }

   //하루 누적 수익출력
   public int getDay_M() {
      return day_M;
   }

   //재고 수익 가산
   public int getItem_M() {
      return item_M;
   }
   public void setItem_M(int item_M) {
      this.item_M += item_M;   //재고수익 가산
      this.day_M += item_M;   //하루수익에다도 더해준다.
      profit_Save();         //수익이 변동됨과 동시에 바로 데이터에 저장해준다.

   }

   //시간수익 가산
   public int getTime_M() {
      return time_M;
   }
   public void setTime_M(int time_M) {
      this.time_M += time_M;   //시간수익 가산
      this.day_M += time_M;   //하루수익에다도 더해준다.

      profit_Save();         //수익이 변동됨과 동시에 바로 데이터에 저장해준다.
   }

   //저장메소드
   public void profit_Save(){
      /*Profit.dat 에 지금 필드값을 저장한다.(덮어쓴다.)*/
      //그후에 날짜를 다시 재확인한다.

      try(FileOutputStream fos = new FileOutputStream("Profit.dat");
            DataOutputStream dis = new DataOutputStream(fos);)
      {


         
         dis.writeInt(all_M);
         dis.writeInt(day_M);
         dis.writeInt(item_M);
         dis.writeInt(time_M);
         dis.writeUTF(day);






      }catch (Exception e){

         e.getMessage();
      }

      //date_Calculator();
   }


}
