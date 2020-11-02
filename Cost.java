
import java.util.*;

class Pizza_Cost { // ���� �޴��� ���� ������ ������ Ŭ����
	String menu;
	int Pcost;

	public Pizza_Cost(String menu, int cost) { // �޴� ���� ������
		this.menu = menu;
		this.Pcost = cost;
	}

	public String toString() { // toString �������̵�
		return menu + " + " + Pcost + " ��"; 
	}

	public int getPcost() { // ���� ���� ��ȯ
		return Pcost;
	}
	public String getMenu(){ // ���� �̸� ��ȯ
		return menu;
	}
}

class Size_Cost { // ���� ����� ���� ������ ������ Ŭ����
	String size;
	int Scost;

	public Size_Cost(String size, int cost) { // ������ ���� ������
		this.size = size;
		this.Scost = cost;
	}

	public String toString() { // toString �������̵�
		return size + " + " + Scost;
	}

	public int getScost() { // ���� ������ ���� ��ȯ
		return Scost;
	}
	public String getSize(){ // ���� ������ ��ȯ
		return size;
	}
}

class Topping_Cost { // ���� ���ο� ���� ������ ������ Ŭ����
	String topping;
	int Tpcost;

	public Topping_Cost(String topping, int cost) { // ���� ���� ������
		this.topping = topping;
		this.Tpcost = cost;
	}

	public String toString() { // toString �������̵�
		return topping + " + " + Tpcost;
	}

	public int getTpcost() { // ������ ���� ��ȯ
		return Tpcost;
	}
	public String getTopping(){ // ������ �̸� ��ȯ
		return topping;
	}
}

public class Cost {

	public static Vector<Pizza_Cost> Pcost = new Vector<Pizza_Cost>(); // ���͸� �̿��� ������ �̸��� ������ ���� ����Ʈ ����
	public static Vector<Size_Cost> Scost=new Vector<Size_Cost>(); // ���͸� �̿��� ������ ������� ������ ���� ����Ʈ ����
	public static Vector<Topping_Cost> Tcost=new Vector<Topping_Cost>(); // ���͸� �̿��� ���ο� �̸��� ������ ���� ����Ʈ ����
	  
	public static Vector<Pizza_Cost> pcost() { // ������ ������ ������ �������ִ� �޼ҵ�
		Pcost.add(new Pizza_Cost("������ ������", 14000));
		Pcost.add(new Pizza_Cost("Ʈ�����", 13000));
		Pcost.add(new Pizza_Cost("����������", 13000));
		Pcost.add(new Pizza_Cost("�Ի����", 15000));
		Pcost.add(new Pizza_Cost("�������� ���", 12000));
		return Pcost;
		//�� ������ ������ ��ȯ�� �ش�.
	}
	public static Vector<Size_Cost> scost() { // ������ ������� ������ �������ִ� �޼ҵ�
		Scost.add(new Size_Cost("����������", 4000));
		Scost.add(new Size_Cost("�̵�������", 5000));
		Scost.add(new Size_Cost("����������", 6000));
		return Scost;
		// �� ������ ������ ��ȯ�� �ش�.
	}
	public static Vector<Topping_Cost> tcost() { // ������ ���ΰ� ������ �������ִ� �޼ҵ�
		Tcost.add(new Topping_Cost("���� ����",0));
		Tcost.add(new Topping_Cost("����",1000));
		Tcost.add(new Topping_Cost("ĥ���ҽ�",500));
		Tcost.add(new Topping_Cost("Ʈ����ġ��",1500));
		Tcost.add(new Topping_Cost("������",1000));
		
		return Tcost;
		// �� ������ ������ ��ȯ�� �ش�.
	}
}
