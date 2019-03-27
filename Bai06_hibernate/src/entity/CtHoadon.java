package entity;
// Generated Mar 27, 2019 7:30:32 PM by Hibernate Tools 5.1.10.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CtHoadon generated by hbm2java
 */
@Entity
@Table(name = "ct_hoadon", catalog = "qlbansua")
public class CtHoadon implements java.io.Serializable {

	private CtHoadonId id;
	private HoaDon hoaDon;
	private Sua sua;
	private int soLuong;
	private int donGia;

	public CtHoadon() {
	}

	public CtHoadon(CtHoadonId id, HoaDon hoaDon, Sua sua, int soLuong, int donGia) {
		this.id = id;
		this.hoaDon = hoaDon;
		this.sua = sua;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "soHoaDon", column = @Column(name = "So_hoa_don", nullable = false, length = 5)),
			@AttributeOverride(name = "maSua", column = @Column(name = "Ma_sua", nullable = false, length = 6)) })
	public CtHoadonId getId() {
		return this.id;
	}

	public void setId(CtHoadonId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "So_hoa_don", nullable = false, insertable = false, updatable = false)
	public HoaDon getHoaDon() {
		return this.hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Ma_sua", nullable = false, insertable = false, updatable = false)
	public Sua getSua() {
		return this.sua;
	}

	public void setSua(Sua sua) {
		this.sua = sua;
	}

	@Column(name = "So_luong", nullable = false)
	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Column(name = "Don_gia", nullable = false)
	public int getDonGia() {
		return this.donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

}
