package com.shinhan.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MySqlConnectionTest2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		 
		 
		
		String sql="select * from book"  ;
		//1.driver load
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("1.driver load성공");
		//2.Connection
	 
		String url="jdbc:mysql://localhost/madang";
		String userid="madang", pass="madang";
		Connection  conn = DriverManager.getConnection(url, userid, pass);
		System.out.println("2.Connection성공");
		//3.Statement를 통해서 SQL전송
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getInt(4));			
			System.out.println("----------------------");
		}
		rs.close();st.close();conn.close();//자원반납

	}

}
