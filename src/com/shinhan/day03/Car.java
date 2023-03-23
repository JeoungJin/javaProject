package com.shinhan.day03;

//class:설계도, object를 만드는 틀
//Object는 class를 이용해서 만든 독립된 개체(실체 instance)
public class Car {
	//1.field(속성,멤버변수)
	String model;
	String color;
	int price;
	//2.생성자메서드(생성시 초기화가 목적)
	//컴파일시에 자동으로 .class에 파라메터없는 default생성자가 만들어진다.
    //즉, 생성자를 정의하는 것은 필수가 아닌다.
	//생성자정의하면 default생성자가 자동으로 만들어지지는 않는다.
	//생성자는 return정의가 없다.
	public Car(){
		System.out.println("3.Car의 default생성자");
	}
	
	//3.일반메서드(method, 기능, 동작)
	void go() {
		System.out.println("자동차가간다.");
	}
	
	
	//4.block(instance block, static block)
	{
		System.out.println("2.instance block...생성시마다실행");
	}
	static {
		System.out.println("1.static block...class load시 1수행");
	}
	//5.inner class

}
