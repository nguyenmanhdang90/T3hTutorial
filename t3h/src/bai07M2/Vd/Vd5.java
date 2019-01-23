package bai07M2.Vd;

interface Hinh {
	void xuat();
}

class HT implements Hinh {
	@Override
	public void xuat() {
		System.out.println("Hinh tron");
	}
}

class HCN implements Hinh {
	@Override
	public void xuat() {
		System.out.println("Hinh chu nhat");
	}
}

class TG implements Hinh {
	@Override
	public void xuat() {
		System.out.println("Hinh tam giac");
	}
}

class HTDVD extends HT {
	@Override
	public void xuat() {
		super.xuat();
		System.out.println("Duong vien do");
	}
}

abstract class Decorator implements Hinh {
	private Hinh hinh;

	protected Decorator(Hinh hinh) {
		this.hinh = hinh;
	}

	@Override
	public void xuat() {
		hinh.xuat();
	}
}

class DVD extends Decorator {
	protected DVD(Hinh hinh) {
		super(hinh);
	}

	@Override
	public void xuat() {
		super.xuat();
		System.out.println("Duong vien do");
	}
}

public class Vd5 {
	public static void main(String[] args) {
		// Hinh h = new HT();
		// Hinh h = new HTDVD();

		Hinh h = new DVD(new HT());
		h.xuat();
	}
}
