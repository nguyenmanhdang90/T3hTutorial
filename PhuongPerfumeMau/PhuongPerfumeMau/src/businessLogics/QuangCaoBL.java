package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import javaBeans.QuangCao;

public class QuangCaoBL {
	private static Connection ketNoi = CSDL.getKetNoi();
public static List<QuangCao> docTatCa(){
	List<QuangCao> dsqc = new ArrayList<>();
	try {
		Statement stm = ketNoi.createStatement();
		ResultSet rs = stm.executeQuery("select * from quangcao");
		while(rs.next()) {
			QuangCao qc = new QuangCao();
			qc.setId(rs.getInt("id"));
			qc.setHinhAnh(rs.getString("hinhanh"));
			qc.setThongDiep(rs.getString("thongdiep"));
			qc.setThongTinChiTiet(rs.getString("thongtinchitiet"));
			qc.setNgayDang(rs.getDate("ngaydang"));
			dsqc.add(qc);
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
			return dsqc;
	
}

	
}
