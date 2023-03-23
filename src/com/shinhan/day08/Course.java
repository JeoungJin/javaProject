package com.shinhan.day08;

public class Course {

	public static void registerCourse(Applicant<?> appicant) {
		System.out.println(appicant.kind.getClass().getSimpleName() +"가 등록한과정임...모두");
	}
	public static void registerCourse2(Applicant<? extends Student> appicant) {
		System.out.println(appicant.kind.getClass().getSimpleName() +"가 등록한과정임...Student, HighStudent, MiddleStudent");
	}
	public static void registerCourse3(Applicant<? super Worker> appicant) {
		System.out.println(appicant.kind.getClass().getSimpleName() +"가 등록한과정임...Worker,Person");
	}
}
