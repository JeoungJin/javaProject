package com.shinhan.day09;

//멀티쓰레드 만드는 방법
//1.extends Thread.....run()메서드 재정의하여 구현한다.  
//2.이미 부모class를 상속받은 경우는 Runnable interface구현한다. 
public class MyThread3 extends Object implements Runnable{
	public MyThread3() {}
	 
	@Override
	public void run() {
		for(char i='a'; i<='z'; i++) {
			System.out.println("[" + Thread.currentThread().getName() + "] i="+ i);
		}
	}

	

}
