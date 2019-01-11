package bai05M2.thucHanh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// buoc 1: nap trinh dieu khien
		Class.forName("com.mysql.jdbc.Driver");
		
		// buoc 2: tao chuoi ket noi
		String url = "jdbc:mysql://localhost:3306/qlsv?useUnicode=true&characterEncoding=UTF-8";
		
		// buoc 3: tao ket noi
		Connection ketNoi = DriverManager.getConnection(url, "root", "");
		
		// buoc 4: tao phat bieu
		Statement stm = ketNoi.createStatement();
		
		// buoc 5: thuc hien truy van
		ResultSet rs = stm.executeQuery("select * from khoa");
		
		// buoc 6: xu ly
		String ten, id;
		while (rs.next()) {
			ten = rs.getString("ten");
			id = rs.getString("id");
			System.out.println(id + " - " + ten);
		}
		
		// buoc 7: dong ket noi
		ketNoi.close();

	}
}
