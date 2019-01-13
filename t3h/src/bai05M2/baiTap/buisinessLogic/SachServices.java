package bai05M2.baiTap.buisinessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bai05M2.baiTap.DTO.Sach;

public class SachServices {
	
	public static int them(Sach sach) {
		String url = "INSERT INTO sach(ten, tacgia, nxb, giabia) VALUES (?, ?, ?, ?)";
		try(Connection cnt = KetNoiQLLienHe.getKetNoiSach()){
			PreparedStatement sta = cnt.prepareStatement(url);
			sta.setString(1, sach.getTen());
			sta.setString(2, sach.getTacgia());
			sta.setString(3, sach.getNxb());
			sta.setDouble(4, sach.getGiaBia());
			return sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
