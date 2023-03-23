package com.shinhan.day04;

//자바의 최상위 class : Object (toString, equals, ...... )

public class Duck {
	String name;
	int legs;
	int length;
	public Duck(String name, int legs, int length) {
		super();
		this.name = name;
		this.legs = legs;
		this.length = length;
	}
	void fly() {
		System.out.println("오리("+ name + ")는 날지 않습니다");
	}
	void sing() {
		System.out.println("오리("+ name + ")는 소리 내어 웁니다");
	}
	void setName(String name){
		this.name = name;
	}
	void display() {
		System.out.println("오리의 이름은 "
				+ name
				+ " 입니다. 다리는 "
				+ legs
				+ " 개이고 길이는 "
				+ length
				+ "입니다.");
	}
	//override(덮어쓰기, 재정의) : 이미 가지고있는 기능을 재정의한다. 
	//이름, 매개변수, return모두 같아야한다. 
	//단, 접근제한자는 같거나 더 넓어져야한다. public>protected>생략>private
	@Override
	public String toString() {
		return "Duck(오리) [name=" + name + ", legs=" + legs + ", length=" + length + "]";
	}
	
	
}

 
 
  
 
//문자열출력하기 toString를 가지고 있다.
