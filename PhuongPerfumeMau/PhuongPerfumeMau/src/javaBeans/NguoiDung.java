package javaBeans;

import java.io.Serializable;

public class NguoiDung implements Serializable{
	private int id;
	private String email, password, hoTen, diaChi, dtdd;
	private int idVaiTro;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getDtdd() {
		return dtdd;
	}
	public void setDtdd(String dtdd) {
		this.dtdd = dtdd;
	}
	public int getIdVaiTro() {
		return idVaiTro;
	}
	public void setIdVaiTro(int idVaiTro) {
		this.idVaiTro = idVaiTro;
	}
	public NguoiDung() {
		super();
	}
	

}
