package bai08M2.Vd;

class TieuTrinh12 extends Thread {
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

class TieuTrinh22 extends Thread {
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

public class Vd3 {

	public static void main(String[] args) {
		Thread tt1 = new Thread(new TieuTrinh12());
		Thread tt2 = new Thread(new TieuTrinh22());
		tt1.start();
		tt2.start();
	}
}
