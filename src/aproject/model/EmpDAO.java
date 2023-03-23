package aproject.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.dbutil.OracleUtil;

import aproject.vo.EmpVO;

//DAO(Data Access Object):DB업무 ..CRUD..Insert,Select,Update,Delete 
public class EmpDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;// ?지원
	CallableStatement cst;//SP지원 
	ResultSet rs;
	int resultCount;// insert, update, delete건수

	
	//여러문장 한번에 수행
	//구매:insert 재고:update
	public int insertUpdate() {
		String sqlInsert = """
				insert into employees
				values(seq_employee.nextval,?,?,?,?,?,?,?,?,?,?)
				""";
		String sqlUpdate = """
				update employees
				set EMAIL = ?, DEPARTMENT_ID =?,
				    JOB_ID=?, SALARY=?,
				    hire_date=?, MANAGER_ID=?
				where EMPLOYEE_ID = ?
					""";
		//기본설정이 autocommit;
		//모두 성공하면 commit해야한다.
		conn = OracleUtil.getConnection();
		try {
			conn.setAutoCommit(false);
			pst = conn.prepareStatement(sqlInsert);
			pst.setString(1, "aaa");
			int a = pst.executeUpdate();
			
			PreparedStatement pst2 = conn.prepareStatement(sqlUpdate);
			pst2.setString(1, "wed0406@daum.net");
			int b = pst2.executeUpdate();
			conn.commit();
			
			resultCount = a+b;
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return resultCount;
	}
	
	
	

	//같은문장 한꺼번에 수행.....addBatch, executeBatch
	public int[] insertAll(List<EmpVO> emplist) {
		int[] arr = new int[emplist.size()];
		String sql = """
				insert into employees
				values(seq_employee.nextval,?,?,?,?,?,?,?,?,?,?)
				""";
		try {
			conn = OracleUtil.getConnection();
			conn.setAutoCommit(false);
			pst = conn.prepareStatement(sql);
			for(EmpVO emp:emplist) {
				pst.setString(1, emp.getFirst_name());
				pst.setString(2, emp.getLast_name());
				pst.setString(3, emp.getEmail());
				pst.setString(4, emp.getPhone_number());
				pst.setDate(5, emp.getHire_date());
				pst.setString(6, emp.getJob_id());
				pst.setDouble(7, emp.getSalary());
				pst.setDouble(8, emp.getCommission_pct());
				pst.setInt(9, emp.getManager_id());
				pst.setInt(10, emp.getDepartment_id());
				
				pst.addBatch();
			}
			arr = pst.executeBatch();
			/*
			 * 0~n: 성공한 row count 수
				-2: 성공은 하였으나 row count 수를 알 수 없음
				-3: 실패
			 */
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
		
		
	}
	
	
	
	
	//SP 호출 
	public EmpVO getSalary(int empid) {
		System.out.println("[DAO] getSalary");
		String sql = "{call sp_salary(?,?,?)}";
		conn = OracleUtil.getConnection();
		EmpVO emp = new EmpVO();		
		try {
			cst = conn.prepareCall(sql);
			cst.setInt(1, empid);
			cst.registerOutParameter(2, Types.DOUBLE);
			cst.registerOutParameter(3, Types.VARCHAR);
			cst.execute();  //resultset있으면 true이고 없으면 false
			//executeQuery(), executeUpdate()
			emp.setSalary( cst.getDouble(2));	
			emp.setFirst_name( cst.getString(3));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}
	
	
	public List<EmpVO> selectAll() {
		String sql = """
					select  EMPLOYEE_ID,
							 FIRST_NAME,
							 LAST_NAME,
							 EMAIL,
							 PHONE_NUMBER,
							 HIRE_DATE,
							 JOB_ID,
							 f_tax(SALARY) SALARY,
						 
							 COMMISSION_PCT,
							 MANAGER_ID,
							 DEPARTMENT_ID
					from employees 
					order by 1	
					""";
		List<EmpVO> emplist = new ArrayList<>();
		conn = OracleUtil.getConnection();
		try {
			st = conn.createStatement();
			if(st.execute(sql)) {
				rs=st.getResultSet();
			}
			//rs = st.executeQuery(sql);
			
			ResultSetMetaData meta = rs.getMetaData();
			int count = meta.getColumnCount();
			for(int i=1; i<=count; i++) {
				System.out.println("칼럼이름:" + meta.getColumnName(i));
			}
			
			
			while (rs.next()) {
				EmpVO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}
		return emplist;
	}

	// 자신의 속한 부서의 평균 급여보다 더 적은 급여를 받는 직원들을 조회하시오
	public List<EmpVO> selectLAB() {
		String sql = """
				select employee_id, first_name, salary, employees.department_id
				from employees,
				                             (select department_id, avg(salary) sal
				                            from employees
				                            group by  department_id )  inlineview_emp
				where employees.department_id = inlineview_emp.department_id
				and employees.salary < inlineview_emp.sal
				""";
		List<EmpVO> emplist = new ArrayList<>();
		conn = OracleUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				EmpVO emp = makeEmp2(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}
		return emplist;
	}

	// 특정직원 조회
	public EmpVO selectById(int empid) {
		EmpVO emp = null;
		String sql = "select * from employees where employee_id = " + empid;
		conn = OracleUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				emp = makeEmp(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}
		return emp;
	}

	// 특정부서의 직원조회
	public List<EmpVO> selectByDept(int deptid) {
		String sql = "select * from employees where department_id = " + deptid;
		List<EmpVO> emplist = new ArrayList<>();
		conn = OracleUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				EmpVO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, st, conn);
		}
		return emplist;
	}

	// 특정부서, jobid, salary이상 직원조회
	public List<EmpVO> selectByCondition(int deptid, String jobid, double salary) {
		String sql = "select * " + " from employees " + " where department_id = ? " + " and job_id = ? "
				+ " and salary >= ? ";
		List<EmpVO> emplist = new ArrayList<>();
		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, deptid);
			pst.setString(2, jobid);
			pst.setDouble(3, salary);
			rs = pst.executeQuery();
			while (rs.next()) {
				EmpVO emp = makeEmp(rs);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(rs, pst, conn);
		}
		return emplist;
	}

	// 신규직원등록 (insert)
	public int empInsert(EmpVO emp) {
		String sql = """
				insert into employees
				values(seq_employee.nextval,?,?,?,?,?,?,?,?,?,?)
				""";
		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, emp.getFirst_name());
			pst.setString(2, emp.getLast_name());
			pst.setString(3, emp.getEmail());
			pst.setString(4, emp.getPhone_number());
			pst.setDate(5, emp.getHire_date());
			pst.setString(6, emp.getJob_id());
			pst.setDouble(7, emp.getSalary());
			pst.setDouble(8, emp.getCommission_pct());
			pst.setInt(9, emp.getManager_id());
			pst.setInt(10, emp.getDepartment_id());

			resultCount = pst.executeUpdate();// DML문장실행한다. 

		} catch (SQLException e) {
			resultCount = -1;
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(null, pst, conn);
		}
		return resultCount;
	}

	// 직원정보 수정하기
	public int empUpdate(EmpVO emp) {
		String sql = """
				update employees
				set EMAIL = ?, DEPARTMENT_ID =?,
				    JOB_ID=?, SALARY=?,
				    hire_date=?, MANAGER_ID=?
				where EMPLOYEE_ID = ?
					""";
		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, emp.getEmail());
			pst.setInt(2, emp.getDepartment_id());
			pst.setString(3, emp.getJob_id());
			pst.setDouble(4, emp.getSalary());
			pst.setDate(5, emp.getHire_date());
			pst.setInt(6, emp.getManager_id());
			pst.setInt(7, emp.getEmployee_id());

			resultCount = pst.executeUpdate();// DML문장실행한다.영향받은건수가 return
			//

		} catch (SQLException e) {
			resultCount = -1;
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(null, pst, conn);
		}
		System.out.println("update결과:" + resultCount);
		return resultCount;
	}

	// 한건의 직원를 삭제하기 
	public int empDelete(int empid) {
		String sql = """
				delete from employees
				where EMPLOYEE_ID = ?
					""";
		conn = OracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, empid);

			resultCount = pst.executeUpdate();// DML문장실행한다.영향받은건수가 return
			//

		} catch (SQLException e) {
			resultCount = -1;
			e.printStackTrace();
		} finally {
			OracleUtil.dbDisconnect(null, pst, conn);
		}
		System.out.println("delete결과:" + resultCount);
		return resultCount;
	}

	private EmpVO makeEmp(ResultSet rs) throws SQLException {
		EmpVO emp = new EmpVO();
		emp.setCommission_pct(rs.getDouble("Commission_pct"));
		emp.setDepartment_id(rs.getInt("Department_id"));
		emp.setEmail(rs.getString("Email"));
		emp.setEmployee_id(rs.getInt("Employee_id"));
		emp.setFirst_name(rs.getString("First_name"));
		emp.setHire_date(rs.getDate("Hire_date"));
		emp.setJob_id(rs.getString("Job_id"));
		emp.setLast_name(rs.getString("Last_name"));
		emp.setManager_id(rs.getInt("Manager_id"));
		emp.setPhone_number(rs.getString("Phone_number"));
		emp.setSalary(rs.getDouble("Salary"));

		return emp;
	}

	private EmpVO makeEmp2(ResultSet rs) throws SQLException {
		EmpVO emp = new EmpVO();
		emp.setDepartment_id(rs.getInt("Department_id"));
		emp.setEmployee_id(rs.getInt("Employee_id"));
		emp.setFirst_name(rs.getString("First_name"));
		emp.setSalary(rs.getDouble("Salary"));

		return emp;
	}

}
