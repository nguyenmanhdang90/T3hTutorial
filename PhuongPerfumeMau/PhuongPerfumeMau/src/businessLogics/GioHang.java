package businessLogics;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import javaBeans.SanPham;
import javaBeans.SanPhamMua;

public class GioHang  {
private static Hashtable<Integer, Integer> dsh; // key: id sản phẩm, value : số lượng sản phẩm
public GioHang() {
	dsh = new Hashtable<>();
	
}
public void them(int idsp, int slm) {
	if(dsh.containsKey(idsp))
		dsh.replace(idsp, dsh.get(idsp)+slm);
		else
			dsh.put(idsp, slm);	
}
public int soMatHang() {
	return dsh.size();
	
} public double tongTien() {
	double tt= 0;
	
	for(Integer idsp:dsh.keySet()) {
		SanPham sp = SanPhamBL.docTheoID(idsp);
		tt+= dsh.get(idsp)*sp.getDonGiaKM();
	}
	return tt;
}
// bổ sung thêm phương thức liệt kê hàng đã mua
public List<SanPhamMua> danhSachHang(){
	List<SanPhamMua> dsspm = new ArrayList<>();
	for(Integer idsp:dsh.keySet()) {
		SanPham sp = SanPhamBL.docTheoID(idsp);
		SanPhamMua spm = new SanPhamMua();
		spm.setTenSanPham(sp.getTenSanPham());
		spm.setDonGia(sp.getDonGia());
		spm.setDonGiaKM(sp.getDonGiaKM());
		spm.setHienThi(sp.getHienThi());
		spm.setHinhAnh(sp.getHinhAnh());
		spm.setId(sp.getId());
		spm.setId_loai(sp.getId_loai());
		spm.setId_thuongHieu(sp.getId_thuongHieu());
		spm.setMoTa(sp.getMoTa());
		spm.setNgayTao(sp.getNgayTao());
		spm.setSoLuong(sp.getSoLuong());
		
		spm.setSoLuongMua(dsh.get(idsp));
		
		dsspm.add(spm);
	}
	return dsspm;
}

}
