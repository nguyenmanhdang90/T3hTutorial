package bai07M02.Vd;

import java.util.ArrayList;
import java.util.List;

abstract class Observer {
	protected TaiKhoan taiKhoan;

	public abstract void thongBao(String tb);
}

class Message extends Observer {

	public Message(TaiKhoan tk) {
		this.taiKhoan = tk;
		this.taiKhoan.addObserver(this);
	}

	@Override
	public void thongBao(String tb) {
		System.out.println("Message sent" + tb);
	}

}

class Email extends Observer {

	public Email(TaiKhoan tk) {
		this.taiKhoan = tk;
		this.taiKhoan.addObserver(this);
	}

	@Override
	public void thongBao(String tb) {
		System.out.println("Email sent " + tb);
	}

}

class TaiKhoan {
	private List<Observer> observers = new ArrayList<>();
	private int soDu;

	public int getSoDu() {
		return soDu;
	}

	public void setSoDu(int soDu) {
		this.soDu = soDu;
		observers.forEach(ob -> ob.thongBao("money changed " + this.soDu));

	}

	public void addObserver(Observer Ob) {
		observers.add(Ob);
	}

}

public class Vd4 {

	public static void main(String[] args) {
		TaiKhoan tk1 = new TaiKhoan();
		Email em1 = new Email(tk1);
		Message ms1 = new Message(tk1);
		tk1.setSoDu(100000);

	}

}
