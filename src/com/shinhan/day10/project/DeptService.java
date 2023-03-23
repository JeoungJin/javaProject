package com.shinhan.day10.project;

import java.util.List;

//Service : Controller가 요청한 정보를 DAO로 전달
//          DAO에서 응답받은 내용을 Controller에게 전달 
// DB상관없는 Business logic수행 

public class DeptService {
	private DeptDAO dao = new DeptDAO();
	
	public List<DeptVO> selectALL() { 
		//
		return dao.selectALL();
	}
	public DeptVO selectById(int deptid){
		return dao.selectById(deptid);
	}
	public void insert(DeptVO dept) {
		dao.insert(dept);
	}
}
