package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.QuangCao;

public class QuangCaoBL {
	private static Connection ketNoi = CSDL.getKetNoi();
	
	public List<QuangCao> docTatCa() throws SQLException{
		List<QuangCao> dsqc = new ArrayList<>();
		try {
			Statement stm = ketNoi.createStatement();
			ResultSet rs = stm.executeQuery("Select * from quangcao");
			while(rs.next()) {
				QuangCao qc = new QuangCao();
				qc.setId(rs.getInt("id"));
				qc.setHinhAnh(rs.getString("hinhanh"));
				qc.setThongDiep(rs.getString("thongdiep"));
				qc.setThongTinChiTiet(rs.getString("thongtinchitiet"));
				qc.setNgayDang(rs.getDate("ngaydang"));
				dsqc.add(qc);
			}
		} catch (SQLException ex) {
		}
		return dsqc;
		
		
	}

}
