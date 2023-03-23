package com.shinhan.oracle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.shinhan.dbutil.OracleUtil;

public class JDBCPrograming {

	public static void main(String[] args) {
		f2();

	}

	private static void f2() {
		System.out.print("상사의 이름을 입력하세요>>");
		Scanner sc = new Scanner(System.in);
		String ceo = sc.nextLine();
		Connection conn = null;
		PreparedStatement st = null;   //Statement<----PreparedStatement
		ResultSet rs = null;
		String sql="""
			select employee_id, first_name, salary, hire_date
			from employees
			where manager_id =ANY(
		            select employee_id
		            from employees
		            where last_name = initCap(?) )	
				""";
		conn = OracleUtil.getConnection();
		try {
			st = conn.prepareStatement(sql);//prepareStatement:?를 지원
			st.setString(1, ceo);//첫번째 ?에 값을 setting 
			rs = st.executeQuery(); //  prepared된 sql문을 실행한다. 
			
			while(rs.next()) { //row로 이동 
				int empid = rs.getInt(1);
				String fname = rs.getString(2);
				int sal = rs.getInt("salary");
				Date hdate = rs.getDate("hire_date");
				System.out.println(empid+"\t"+fname+"\t"+sal+"\t"+hdate);
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}
		
	}

	private static void f1() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		String sql="""
			select  first_name,department_id, department_name , city 
			from employees JOIN departments using(department_id)
                            join locations using(location_id) 
			where job_id in (
			        	select job_id 
			        	from jobs
			        	where substr(job_title,-7) = initCap('MANAGER')
             )
				""";
		try {
			conn = OracleUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				String fname = rs.getString(1);
				int deptid = rs.getInt(2);
				String deptname = rs.getString(3);
				String city = rs.getString(4);
				System.out.printf("%s\t%d\t%10s\t%s\t\n", fname, deptid,deptname, city );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);  
		}
		
		//1.Driver load
		//2.DB연결
		//3.SQL문 보낼 통로만들기
		//4.SQL문실행
		//5.결과받아서 이용한다.
		//6.자원반납 
		
	}

}
