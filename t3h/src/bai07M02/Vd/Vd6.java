package bai07M02.Vd;

interface HinhAnh {
	void Xuat();
}

class HinhThuc implements HinhAnh {
	private String hinh;

	public HinhThuc(String hinh) {
		this.hinh = hinh;
		TaiHinh();
	}

	@Override
	public void Xuat() {
		System.out.println("Dang xuat hinh " + hinh);
	}

	public void TaiHinh() {
		System.out.println("Dang tai hinh " + hinh);
	}
}

class HinhUyQuyen implements HinhAnh {
	private String hinh;
	private HinhThuc hinhThuc = null;

	public HinhUyQuyen(String hinh) {
		this.hinh = hinh;
	}

	@Override
	public void Xuat() {
		if (hinhThuc == null)
			hinhThuc = new HinhThuc(hinh);
		hinhThuc.Xuat();
	}
}

public class Vd6 {
	public static void main(String[] args) {
		//HinhAnh h1 = new HinhThuc("abc.jpg");
		//h1.Xuat();
		
		HinhAnh h2 = new HinhUyQuyen("abc.jpg");
		h2.Xuat();
	}
}
