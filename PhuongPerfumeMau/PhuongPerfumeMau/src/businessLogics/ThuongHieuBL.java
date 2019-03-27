package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.ThuongHieu;

public class ThuongHieuBL {
	private static Connection ketNoi = CSDL.getKetNoi();
	public static List<ThuongHieu> docTatCa(){
		List<ThuongHieu> dsth = new ArrayList<>();
		try {
			Statement stm = ketNoi.createStatement();
			ResultSet rs = stm.executeQuery("select * from thuonghieu");
			while(rs.next()) {
				ThuongHieu th = new ThuongHieu();
				th.setId(rs.getInt("id"));
				th.setHinhAnh(rs.getString("hinhanh"));
				th.setTenThuongHieu(rs.getString("tenthuonghieu"));
				dsth.add(th);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return dsth;
		
	}
	

}
