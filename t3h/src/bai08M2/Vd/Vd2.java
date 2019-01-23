package bai08M2.Vd;

class TieuTrinh1 extends Thread {
	@Override
	public void run() {
		for (int i = 1; i < 50; i++) {
			System.out.print(i + " ");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class TieuTrinh2 extends Thread {
	@Override
	public void run() {
		for (int i = 50; i < 100; i++) {
			System.out.print(i + " ");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Vd2 {
	public static void main(String[] args) {
		Thread tt1 = new TieuTrinh1();
		Thread tt2 = new TieuTrinh2();
		tt1.start();
		tt2.start();

	}
}
