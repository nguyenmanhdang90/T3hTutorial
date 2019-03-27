package businessLogics;

import javaBeans.SanPham;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hv
 */
public class SanPhamBL {
    public static List<SanPham> docTatCa(){
        String sql = "select * from sanpham";
        List<SanPham> dssp = taoDanhSach(sql);
        return dssp;
    }

    public static SanPham docTheoID(int idSanPham){
        String sql = "select * from sanpham where id="+idSanPham;
        List<SanPham> dssp = taoDanhSach(sql);
        return dssp.get(0);
    }

    public static List<SanPham> docTheoLoai(int idLoai){
        String sql="select * from sanpham where id_loai = "+idLoai;
        List<SanPham> dssp = taoDanhSach(sql);
        return dssp;
    }
    
    public static List<SanPham> docTheoThuongHieu(int idThuongHieu){
        String sql = "select * from sanpham where id_thuonghieu = "+idThuongHieu;
        List<SanPham> dssp = taoDanhSach(sql);
        return dssp;
    }
    
    public static List<SanPham> docTheoTen(String tenSanPham){
        String sql = "select * from sanpham where tensanpham like '%"+tenSanPham+"%'";
        List<SanPham> dssp = taoDanhSach(sql);
        return dssp;
    }
    public static List<SanPham> sanPhamMoi(int top){
        String sql = "select * from sanpham order by ngaytao desc limit 0,"+top;
        List<SanPham> dssp = taoDanhSach(sql);
        return dssp;
    }

    public static List<SanPham> banChayNhat(int top){
        String sql = "select s.*,sum(c.soluong) as tslb from sanpham s inner join chitietdonhang c " +
                     "on c.id_sanpham = s.id group by 1 order by tslb desc limit 0,"+top;
        List<SanPham> dssp = taoDanhSach(sql);
        return dssp;
    }

    public static List<SanPham> giamGiaNhieu(int top){
        String sql= "select s.*, s.dongia-s.dongiaKM as giamGia from sanpham s order by giamGia desc limit 0,"+top;
        List<SanPham> dssp = taoDanhSach(sql);
        return dssp;
    }

    
    public static int tongSoTrang(int soDongTrang)
    {
        int tongSoDong, tongSoTrang;
        String sql= "select * from sanpham";
        List<SanPham> dssp = taoDanhSach(sql);
        tongSoDong = dssp.size();
        tongSoTrang = tongSoDong/soDongTrang + (tongSoDong%soDongTrang==0?0:1);
        return tongSoTrang;
    }
    
    public static List<SanPham> sanPhamTrang(int trang, int soDongTrang){
        int viTriDau = (trang==1?0:(trang-1)*soDongTrang);
        String sql= "select * from sanpham limit "+viTriDau+","+soDongTrang;
        List<SanPham> dssp = taoDanhSach(sql);
        return dssp;
    }
    
    
    private static List<SanPham> taoDanhSach(String sql){
        List<SanPham> dssp = null;
        try (Connection ketNoi = CSDL.getKetNoi()){
            Statement stm = ketNoi.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            dssp = new ArrayList<>();
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setId(rs.getInt("id"));
                sp.setTenSanPham(rs.getString("tensanpham"));
                sp.setMoTa(rs.getString("mota"));
                sp.setHinhAnh(rs.getString("hinhanh"));
                sp.setDonGia(rs.getDouble("dongia"));
                sp.setDonGiaKM(rs.getDouble("dongiaKM"));
                sp.setSoLuong(rs.getInt("soluong"));
                sp.setNgayTao(rs.getDate("ngaytao"));
                sp.setHienThi(rs.getInt("hienthi"));
                sp.setId_loai(rs.getInt("id_loai"));
                sp.setId_thuongHieu(rs.getInt("id_thuonghieu"));
                dssp.add(sp);
            }
        } catch (Exception e) {
            throw new RuntimeException("Bị lỗi: "+e.getMessage());
        }
        return dssp;
    }
}