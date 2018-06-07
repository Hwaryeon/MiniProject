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

   private int all_M=0;      //�� ��������
   private int day_M=0;      //�Ϸ� ����
   private int item_M=0;      //��� ����
   private int time_M=0;      //�ð� ����
   private String day = new SimpleDateFormat("dd").format(new Date());   //���Ͱ��� �Ŵ�����ü�� �������� �ð��� ������

   public Profit() {
      date_Calculator();
   }   

   public void date_Calculator(){
      /* "Profit.dat"���� ���� �������� �ʵ庯������ �ʱ�ȭ

      date���� ����� day���� ������ (�Ϸ簡 ������)   
         day_M���� 0���� �ʱ�ȭ �� all_M�� �����ش�.
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





   //�� �������� ���
   public int getAll_M() {

      return all_M;
   }

   //�Ϸ� ���� �������
   public int getDay_M() {
      return day_M;
   }

   //��� ���� ����
   public int getItem_M() {
      return item_M;
   }
   public void setItem_M(int item_M) {
      this.item_M += item_M;   //������ ����
      this.day_M += item_M;   //�Ϸ���Ϳ��ٵ� �����ش�.
      profit_Save();         //������ �����ʰ� ���ÿ� �ٷ� �����Ϳ� �������ش�.

   }

   //�ð����� ����
   public int getTime_M() {
      return time_M;
   }
   public void setTime_M(int time_M) {
      this.time_M += time_M;   //�ð����� ����
      this.day_M += time_M;   //�Ϸ���Ϳ��ٵ� �����ش�.

      profit_Save();         //������ �����ʰ� ���ÿ� �ٷ� �����Ϳ� �������ش�.
   }

   //����޼ҵ�
   public void profit_Save(){
      /*Profit.dat �� ���� �ʵ尪�� �����Ѵ�.(�����.)*/
      //���Ŀ� ��¥�� �ٽ� ��Ȯ���Ѵ�.

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
