package com.shinhan.day03;

 
public class Person{
	//멤버변수:instance변수, static변수(instance변수공유변수) 
	private static int numberOfPersons;// 전체 인구 수
						//Person 객체가 생성될 때마다 증가
	int age;	
	String name;
	Person(){
		this(12, "Anonymous");	
	}
	Person(int age, String name){
		this.name = name;
		this.age = age;
		numberOfPersons++;
	}
	void selfIntroduce(){
		System.out.println("내 이름은 "
				+ name
				+ " 이며, 나이는 "
				+ age
				+ "살 입니다.");
	}
	static int getPopulation(){
		return numberOfPersons;
	}
	
	
	
} //class end


 

 