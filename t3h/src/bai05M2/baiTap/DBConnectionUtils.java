package bai05M2.baiTap;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class DBConnectionUtils {
	
	public static Statement getConnection(String url){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, "root", "").createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
