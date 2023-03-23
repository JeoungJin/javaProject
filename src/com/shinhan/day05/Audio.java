package com.shinhan.day05;

//interface 구현class
public class Audio implements RemoteControl,WIFI  {

	@Override
	public void powerOn() {
		System.out.println(getClass().getSimpleName()+"전원켠다");
		
	}

	@Override
	public void powerOff() {
		System.out.println(getClass().getSimpleName()+"전원끈다");
		
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		RemoteControl.super.display();
		System.out.println("default method재정의");
	}
	 
	void display2() {
		System.out.println("!!!!!!!!");
	}

	@Override
	public void wifiTurnOn() {
		System.out.println("wifi turn on!!!!");
		
	}
	

}
