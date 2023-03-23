package com.shinhan.day09;

public class WorkThread extends Thread{
	public boolean work=true;
	
	public WorkThread(String name){
		//super(name);
		setName(name);
	}	
	@Override
	public void run() {
		while(true) {
			if(work) {
				System.out.println( getName() + ".....작업처리");
			}else {
				Thread.yield();//나의쓰레드가 잠깐멈춤...다른쓰레드에 양보...계속진행 
			}
		}
	}

}
