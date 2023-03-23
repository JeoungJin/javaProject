package com.shinhan.day10.project;

import java.util.List;

//Controller:사용자의 요청을 받아서 Service에 보낸다
//Service의 응답결과를 이용해서 View를 통해 display한다. 
public class DeptController {
	public static void main(String[] args) {
		DeptService service = new DeptService();
		
		DeptVO[] arr = {new DeptVO(10, "개발부", 100, 1700),
				new DeptVO(20, "영업부", 100, 1700),
				new DeptVO(30, "총무부", 100, 1700),
				new DeptVO(40, "R&D", 100, 1700),
				new DeptVO(50, "SI사업부", 100, 1700)};
		 
		for(DeptVO dept:arr) {
			service.insert(dept);
		}
		//조회
		List<DeptVO>  deptlist = service.selectALL();
		//출력
		DeptView.print(deptlist);
		//찾기
		DeptVO searchVO = service.selectById(40);
		//출력
		DeptView.print(searchVO);
	}
}





