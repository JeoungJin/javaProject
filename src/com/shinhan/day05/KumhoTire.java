package com.shinhan.day05;

public class KumhoTire extends Tire{
	String intro = "최고!!!!!";
	void method2() {
		System.out.println("KumhoTire 우리만!!!");
	}
	@Override
	public void roll() {
		System.out.println("KumhoTire roll() Override");
		
	}


}
