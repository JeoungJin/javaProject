package com.shinhan.day05;

//abstract class : 변수+상수+생성자+일반메서드+추상메서드 
//규격서 : 상수 + 추상메서드 + ( default메서드+static메서드+private메서드  )
public interface RemoteControl {
	
	public abstract void powerOn();
	void powerOff();
	default void display() {
		System.out.println("모든구현class에 기능추가");
	}
	static void display2() {
		System.out.println("모든구현class에 기능추가...재정의불가, interface소유");
	}
}
