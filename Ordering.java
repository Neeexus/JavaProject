
class SyncPizza {
	boolean pizzaWaiting = false;

	public void set() {
		pizzaWaiting=true;
		synchronized (this) {
			notifyAll();
		}// 동기화 시켜준다
	}

	public void getPizzainfo() {
		if (pizzaWaiting == false) {
			try {
				synchronized (this) {
					wait();
				}// pizzaWaiting 이 거짓일 경우에 기다린다
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class Producer implements Runnable {
	SyncPizza pizza;
	public String toString() {
		return "피자를 생성하는 중입니다...  " + Cost.Pcost.get(GUI.pizza_style.getSelectedIndex()).getMenu() + "\n";
	} // toString 오버라이딩

	public void run() { // run 메소드 오버라이딩

		try {
			pizza.set();
			Thread.sleep((int) (Math.random() * 5000)); // 5초 이내의 시간중 랜덤으로 재운다
			GUI.text.append(toString()); // gui에 텍스트 상자에 나타나게한다
		} catch (InterruptedException e) {

		}
	}
}

class Consumer implements Runnable {
	SyncPizza pizza;
	public String toString() {
		return "피자가 소비되었습니다  " + Cost.Pcost.get(GUI.pizza_style.getSelectedIndex()).getMenu() + "\n";
	}// toString 오버라이딩

	public void run() { // run 메소드 오버라이딩
		
		try {
			pizza.getPizzainfo();
			Thread.sleep((int) (Math.random() * 6000)); // 6초 이내의 시간중 랜덤으로 재운다
			GUI.text.append(toString()); // gui 텍스트 상자에 나타나게 한다.
		} catch (InterruptedException e) {

		}
	}
}

