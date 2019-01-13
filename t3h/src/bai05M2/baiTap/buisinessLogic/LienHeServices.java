package bai05M2.baiTap.buisinessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bai05M2.baiTap.DTO.LienHe;

public class LienHeServices {
	
	public static int them(LienHe lienhe) {
		String url = "INSERT INTO lienhe(hoten, dtdd, hinhanh) VALUES (?, ?, ?)";
		try(Connection cnt = KetNoiQLLienHe.getKetNoi()){
			PreparedStatement sta = cnt.prepareStatement(url);
			sta.setString(1, lienhe.getHoTen());
			sta.setString(2, lienhe.getDtdd());
			sta.setString(3, lienhe.getHinhAnh());
			return sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
