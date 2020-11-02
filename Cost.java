
import java.util.*;

class Pizza_Cost { // 피자 메뉴에 따른 가격을 설정한 클래스
	String menu;
	int Pcost;

	public Pizza_Cost(String menu, int cost) { // 메뉴 설정 생성자
		this.menu = menu;
		this.Pcost = cost;
	}

	public String toString() { // toString 오버라이딩
		return menu + " + " + Pcost + " 원"; 
	}

	public int getPcost() { // 피자 가격 반환
		return Pcost;
	}
	public String getMenu(){ // 피자 이름 반환
		return menu;
	}
}

class Size_Cost { // 피자 사이즈에 따른 가격을 설정한 클래스
	String size;
	int Scost;

	public Size_Cost(String size, int cost) { // 사이즈 설정 생성자
		this.size = size;
		this.Scost = cost;
	}

	public String toString() { // toString 오버라이딩
		return size + " + " + Scost;
	}

	public int getScost() { // 피자 사이즈 가격 반환
		return Scost;
	}
	public String getSize(){ // 피자 사이즈 반환
		return size;
	}
}

class Topping_Cost { // 피자 토핑에 따른 가격을 설정한 클래스
	String topping;
	int Tpcost;

	public Topping_Cost(String topping, int cost) { // 토핑 설정 생성자
		this.topping = topping;
		this.Tpcost = cost;
	}

	public String toString() { // toString 오버라이딩
		return topping + " + " + Tpcost;
	}

	public int getTpcost() { // 토핑의 가격 반환
		return Tpcost;
	}
	public String getTopping(){ // 토핑의 이름 반환
		return topping;
	}
}

public class Cost {

	public static Vector<Pizza_Cost> Pcost = new Vector<Pizza_Cost>(); // 벡터를 이용해 피자의 이름과 가격을 넣을 리스트 생성
	public static Vector<Size_Cost> Scost=new Vector<Size_Cost>(); // 벡터를 이용해 피자의 사이즈와 가격을 넣을 리스트 생성
	public static Vector<Topping_Cost> Tcost=new Vector<Topping_Cost>(); // 벡터를 이용해 토핑에 이름과 가격을 넣을 리스트 생성
	  
	public static Vector<Pizza_Cost> pcost() { // 피자의 종류와 가격을 설정해주는 메소드
		Pcost.add(new Pizza_Cost("스노윙 슈림프", 14000));
		Pcost.add(new Pizza_Cost("트레비앙", 13000));
		Pcost.add(new Pizza_Cost("하프앤하프", 13000));
		Pcost.add(new Pizza_Cost("게살몽땅", 15000));
		Pcost.add(new Pizza_Cost("포테이토 골드", 12000));
		return Pcost;
		//각 값들을 생성후 반환해 준다.
	}
	public static Vector<Size_Cost> scost() { // 피자의 사이즈와 가격을 설정해주는 메소드
		Scost.add(new Size_Cost("스몰사이즈", 4000));
		Scost.add(new Size_Cost("미디움사이즈", 5000));
		Scost.add(new Size_Cost("라지사이즈", 6000));
		return Scost;
		// 각 값들을 생성후 반환해 준다.
	}
	public static Vector<Topping_Cost> tcost() { // 피자의 포핑과 가격을 설정해주는 메소드
		Tcost.add(new Topping_Cost("토핑 없음",0));
		Tcost.add(new Topping_Cost("갈릭",1000));
		Tcost.add(new Topping_Cost("칠리소스",500));
		Tcost.add(new Topping_Cost("트리플치즈",1500));
		Tcost.add(new Topping_Cost("베이컨",1000));
		
		return Tcost;
		// 각 값들을 생성후 반환해 준다.
	}
}
