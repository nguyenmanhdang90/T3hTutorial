package javaBeans;

public class SanPhamMua extends SanPham{ // kế thừa từ SanPham nên đã có sẵn các phương thức của SanPham
	private int soLuongMua;

	public int getSoLuongMua() {
		return soLuongMua;
	}

	public void setSoLuongMua(int soLuongMua) {
		this.soLuongMua = soLuongMua;
	}

	public SanPhamMua() {
		super();
	}
	public double thanhTien() {
		return soLuongMua*getDonGiaKM();
	}
	

}
