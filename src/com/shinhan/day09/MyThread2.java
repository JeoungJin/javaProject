package com.shinhan.day09;

//멀티쓰레드 만드는 방법
//1.extends Thread.....run()메서드 재정의하여 구현한다.  
public class MyThread2 extends Thread{
	public MyThread2() {}
	public MyThread2(String threadName) {
		super(threadName);
	}
	@Override
	public void run() {
		for(int i=1; i<=26; i++) {
			System.out.println("[" +getName() + "] i="+ i);
		}
	}

}
