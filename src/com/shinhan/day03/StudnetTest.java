package com.shinhan.day03;

public class StudnetTest {

	public static void main(String[] args) {
		f1();

	}

	private static void f1() {
		Student student1 = new Student();
		Student student2 = 
				new Student("임채희","56789","WEB",200);
		student1.name = "김경윤";
		student1.stdId = "12345";
		student1.subject = "자바";
		student1.score = 200;
		display(student1);
		display(student2);
		
	 
	
	}
	private static void display(Student std) {
		System.out.println("---------------");
		System.out.println(std.name);
		System.out.println(std.stdId);
		System.out.println(std.subject);
		System.out.println(std.score);
		std.study();
	}
}
