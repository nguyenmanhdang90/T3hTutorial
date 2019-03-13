package javaBeans;

import java.io.Serializable;
/*
 * Java bean la mot lop Java don gian thoa 4 yeu cau
 * 1. thuc thi giao tiep Serializable
 * 2. cac thanh phan du lieu private
 * 3. cac phuong thuc dang getter va setter
 * 4. co phuong thuc khoi tao khong tham so
 */
public class LoaiSua implements Serializable {
	private String maLoai;
	private String tenLoai;
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public LoaiSua() {
		super();
	}
}
