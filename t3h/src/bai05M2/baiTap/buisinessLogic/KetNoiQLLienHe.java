package bai05M2.baiTap.buisinessLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoiQLLienHe {
	
	private static Connection ketNoi;
	private static Connection ketNoiSach;

	public static Connection getKetNoi() {
		if(ketNoi != null ) return ketNoi;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/qlidangnhap?useUnicode=true&characterEncoding=UTF-8";
			ketNoi = DriverManager.getConnection(url, "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ketNoi;
	}
	
	public static Connection getKetNoiSach() {
		if(ketNoiSach != null ) return ketNoiSach;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/quanlysach?useUnicode=true&characterEncoding=UTF-8";
			ketNoiSach = DriverManager.getConnection(url, "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ketNoiSach;
	}


}
