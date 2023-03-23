package com.shinhan.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleConnectTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String sql="select * from EMPLOYEES ";
		//1.driver load
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("1.driver load성공");
		//2.Connection
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String userid="hr", pass="hr";
		Connection  conn = DriverManager.getConnection(url, userid, pass);
		System.out.println("2.Connection성공");
		//3.Statement를 통해서 SQL전송
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getInt("salary"));
			System.out.println("----------------------");
		}
		rs.close();st.close();conn.close();//자원반납

	}

}
