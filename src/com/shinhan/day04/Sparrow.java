package com.shinhan.day04;

public class Sparrow {
	String name;
	int legs;
	int length;
	public Sparrow(String name, int legs, int length) {
		super();
		this.name = name;
		this.legs = legs;
		this.length = length;
	}
	void fly() {
		System.out.println("참새("+ name + ")는 날아다닙니다");
	}
	void sing() {
		System.out.println("참새("+ name + ")는 소리 내어 웁니다");
	}
	void setName(String name){
		this.name = name;
	}
	void display() {
		System.out.println("참새의 이름은 "
				+ name
				+ " 입니다. 다리는 "
				+ legs
				+ " 개이고 길이는 "
				+ length
				+ "입니다.");
	}
}

 
 
  
 
//문자열출력하기 toString를 가지고 있다.
