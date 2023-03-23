package com.shinhan.day04;

public class EmployeeExam {

	public static void main(String[] args) {
		Employee[] emps = new Employee[4];//배열생성
		emps[0] = new Employee("이부장", "부장", 1500000);//Employee생성 
		emps[1] = new Employee("김과장", "과장", 1300000);
		emps[2] = new Employee("최대리", "대리", 1200000);
		emps[3] = new Employee("박사원", "사원", 1000000);	
		for(Employee emp:emps) {	 
			emp.print();
		}

	}

}
//부장 직급의 이부장씨의 본봉은 1500000 원이고 총급여는 1875000 원입니다.
//과장 직급의 김과장씨의 본봉은 1300000 원이고 총급여는 1495000 원입니다.
//대리 직급의 최대리씨의 본봉은 1200000 원이고 총급여는 1260000 원입니다.
//사원 직급의 박사원씨의 본봉은 1000000 원이고 총급여는 1050000 원입니다.

