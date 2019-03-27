package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javaBeans.NguoiDung;

public class NguoiDungBL {
	private static Connection ketNoi = CSDL.getKetNoi();
	public static NguoiDung docTheoEmailPassword(String email, String password) {
		NguoiDung nd = null;
		String sql = "select * from nguoidung where email='"+email+"' and password='"+password+"'";
		try {
			Statement stm = ketNoi.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()) {
				nd = new NguoiDung();
				nd.setId(rs.getInt("id"));
				nd.setEmail(rs.getString("email"));
				nd.setPassword(rs.getString("password"));
				nd.setHoTen(rs.getString("hoten"));
				nd.setDiaChi(rs.getString("diachi"));
				nd.setDtdd(rs.getString("dtdd"));
				nd.setIdVaiTro(rs.getInt("id_vaitro"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nd;
	}
}