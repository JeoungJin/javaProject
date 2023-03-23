package com.shinhan.day04;

import java.util.Objects;

public class Employee implements Comparable<Employee>{
	private String name;
	private String title;
	private int baseSalary;
	private int totalSalary;
	static final double PI=3.14;
	static void method() {
		 
	}
	public Employee(String name, String title, int baseSalary) {
		this.name = name ;
		this.title = title+"님";
		this.baseSalary = baseSalary;
		
	}	
	private void getTotalSalary() {
		if(title.equals("부장님")) {
			totalSalary = (int)(baseSalary + baseSalary *0.25) ;
			
		}else if(title.equals("과장님")) {
			totalSalary = (int)(baseSalary + baseSalary *0.15);
		}else {
			totalSalary = (int)(baseSalary + baseSalary *0.05);
		}
	}
	public void print() {
		getTotalSalary();
		System.out.println(title+ " 직급의 "+ name	+ "씨의 본봉은 "
				+ baseSalary + " 원이고 총급여는 "+ totalSalary+ " 원입니다.");
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", title=" + title + ", baseSalary=" + baseSalary + ", totalSalary="
				+ totalSalary + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(name, other.name) && Objects.equals(title, other.title);
	}
	@Override
	public int compareTo(Employee emp) {
		int result = name.compareTo(emp.name)*-1;
		int result2 = baseSalary - emp.baseSalary;
		if(result2==0) return title.compareTo(emp.title);
		if(result==0) return result2;
		return result;
	}
	
	
	
	
}
 
 
//부장 직급의 이부장씨의 본봉은 1500000 원이고 총급여는 1875000 원입니다.
//과장 직급의 김과장씨의 본봉은 1300000 원이고 총급여는 1495000 원입니다.
//대리 직급의 최대리씨의 본봉은 1200000 원이고 총급여는 1260000 원입니다.
//사원 직급의 박사원씨의 본봉은 1000000 원이고 총급여는 1050000 원입니다.

//부장 직급의 이부장님씨의 본봉은 1500000 원이고 총급여는 1575000 원입니다.
//과장 직급의 김과장님씨의 본봉은 1300000 원이고 총급여는 1365000 원입니다.
//대리 직급의 최대리님씨의 본봉은 1200000 원이고 총급여는 1260000 원입니다.
//사원 직급의 박사원님씨의 본봉은 1000000 원이고 총급여는 1050000 원입니다.
