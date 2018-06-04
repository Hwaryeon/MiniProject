package dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import IProfit.IProfit;
import vo.Product;
import vo.Profit;

public class InventoryDao implements IProfit{

	ArrayList<Product> warehouse = new ArrayList<Product>();	//모든 상품들이 담긴 객체
	Profit profit = null;
	public InventoryDao() {
		/* "Inventory.dat"로 부터 기록을 warehouse 변수로 가져온다.*/

		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Inventory.dat"));){

			warehouse = (ArrayList<Product>)ois.readObject();

		}catch(FileNotFoundException e){
			System.out.println("파일이 없으므로 불러올수없습니다.");
		}catch(EOFException e){
			System.out.println("EOF예외");
		}catch(IOException e){
			System.out.println("IO예외발생");
		}catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을수가 없다고함");
		}


		profit = new Profit();
	}

	//카테고리 조회
	public ArrayList<Product> product_Record(String kind){
		
		ArrayList<Product> category_box = new ArrayList<Product>();
		
		for(int i=0; i<warehouse.size() ; i++){
			if(warehouse.get(i).getKind().equals(kind)){
				category_box.add(warehouse.get(i));
			}
		}

		if(category_box.isEmpty()){
			System.out.println("해당하는 종류에 상품이 존재하지않습니다. null반환");
		}
		
		return category_box;
		
		/*카테고리 조회 선택시 매개변수kind 카테고리에 있는 모든 재고를 출력
			warehouse에서  전체적으로 읽어온다.*/
	}

	//재고 이름 검색
	public ArrayList<Product> product_Seach(String name){
		
		ArrayList<Product> seach_box = new ArrayList<Product>();
		
		for(int i=0; i<warehouse.size() ; i++){
			if(warehouse.get(i).getNames().contains(name)){
				seach_box.add(warehouse.get(i));
			}
		}
		
		return seach_box;
		/*warehouse에서 name재고의 객체 반환*/
	}
	
	//재고 판매
	public void product_Sale(Product pro, int Quantity){

		System.out.println("이름 : "+ pro.getNames());
		System.out.println("종류 : "+ pro.getKind());
		System.out.println("판매갯수 : "+ Quantity);

		//이름과 종류가 동시에 같은 제품을 찾는다.
		for(int i=0; i<warehouse.size(); i++){
			if(pro.getKind().equals(warehouse.get(i).getKind()) &&
					pro.getNames().equals(warehouse.get(i).getNames())){
				//현재 가지고있는 재고수에서 판매된 갯수를 차감한다.
				//그 이후 저장한다.
				warehouse.get(i).setCount(warehouse.get(i).getCount()-Quantity);	//재고차감
				Add_Money(Quantity*warehouse.get(i).getPrice());					//수익가산
				//저장
				product_Save();
				System.out.println("판매가 정상적으로 이루어졌습니다.");
				return;
			}
		}

		System.out.println("그 재고는 존재하지않음!");
		
		/*
		 * 객체를 만들어준다 그러면 이 객체에는 방금전까지 넣었던 값들이 생긴다.
		 * */
		//product_Save(); 그후 저장한다.
	}

	//재고 추가
	public void product_Add(Product pro){

		for(int i=0; i<warehouse.size() ; i++){
			if(warehouse.get(i).getNames().equals(pro.getNames())){
				warehouse.get(i).setCount(warehouse.get(i).getCount()+pro.getCount());
				product_Save();
				JOptionPane.showMessageDialog(null, "같은 이름의 제품이 있으므로\n제고에 "+pro.getCount()+"개 가 추가됩니다.", "입력 오류", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		
		System.out.println(pro);
		warehouse.add(pro);
		product_Save();
		/*매개변수 product를 warehouse.add 으로 추가*/
		//product_Save(); 그후 저장한다.
	}



	//저장메소드
	private void product_Save(){
		/*변환된 warehouse를 저장한다.*/

		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Inventory.dat"));){

			oos.writeObject(warehouse);
			System.out.println("저장완료!");
		}catch(FileNotFoundException e){
			System.out.println("파일이 없으므로 불러올수없습니다.");
		}catch(EOFException e){
			System.out.println("EOF예외");
		}catch(IOException e){
			System.out.println("IO예외발생");
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	//정산후 저장
	@Override
	public void Add_Money(int money){
		
		System.out.println("이득 + " + money);
		profit.setItem_M(money);

		/*
		 * inven_S.Add_Money()에 접근하여 저장되어있는 
		 * 총금액을 profit.setItem()에 저장한다. 
		 * 
		 */
	}

}
