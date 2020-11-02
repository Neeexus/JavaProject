
class SyncPizza {
	boolean pizzaWaiting = false;

	public void set() {
		pizzaWaiting=true;
		synchronized (this) {
			notifyAll();
		}// ����ȭ �����ش�
	}

	public void getPizzainfo() {
		if (pizzaWaiting == false) {
			try {
				synchronized (this) {
					wait();
				}// pizzaWaiting �� ������ ��쿡 ��ٸ���
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class Producer implements Runnable {
	SyncPizza pizza;
	public String toString() {
		return "���ڸ� �����ϴ� ���Դϴ�...  " + Cost.Pcost.get(GUI.pizza_style.getSelectedIndex()).getMenu() + "\n";
	} // toString �������̵�

	public void run() { // run �޼ҵ� �������̵�

		try {
			pizza.set();
			Thread.sleep((int) (Math.random() * 5000)); // 5�� �̳��� �ð��� �������� ����
			GUI.text.append(toString()); // gui�� �ؽ�Ʈ ���ڿ� ��Ÿ�����Ѵ�
		} catch (InterruptedException e) {

		}
	}
}

class Consumer implements Runnable {
	SyncPizza pizza;
	public String toString() {
		return "���ڰ� �Һ�Ǿ����ϴ�  " + Cost.Pcost.get(GUI.pizza_style.getSelectedIndex()).getMenu() + "\n";
	}// toString �������̵�

	public void run() { // run �޼ҵ� �������̵�
		
		try {
			pizza.getPizzainfo();
			Thread.sleep((int) (Math.random() * 6000)); // 6�� �̳��� �ð��� �������� ����
			GUI.text.append(toString()); // gui �ؽ�Ʈ ���ڿ� ��Ÿ���� �Ѵ�.
		} catch (InterruptedException e) {

		}
	}
}

