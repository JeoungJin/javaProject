package com.shinhan.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleUtil {

	 //1.DB연결
	public static Connection getConnection() {
		Connection conn = null;
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String userid="hr", password="hr";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, userid, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	 //2.자원반납
	public static void dbDisconnect(ResultSet rs, Statement st, Connection conn) {
		try {
			if(rs!=null)  rs.close();
			if(st!=null) st.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	
}
