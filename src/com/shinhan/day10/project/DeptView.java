package com.shinhan.day10.project;

import java.util.List;

//View : display담당
public class DeptView {

	public static void print(String message) {
		System.out.println("알림:" + message);
	}
	public static void print(DeptVO dept) {
		System.out.println("dept정보:" + dept);
	}
	public static void print(List<DeptVO> deptlist) {
		System.out.println("=====dept list=======");
		for(DeptVO dept:deptlist) {
			System.out.println(dept);
		}
	}
	
}
