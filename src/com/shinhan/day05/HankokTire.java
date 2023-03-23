package com.shinhan.day05;

public class HankokTire extends Tire{
	String info = "한국타이최고";
	void method1() {
		System.out.println("HankokTire만 가지는기능");
	}
	//재정의 
	public void roll() {
		System.out.println("HankokTire...타이어가 굴러갑니다.");
	}
}
