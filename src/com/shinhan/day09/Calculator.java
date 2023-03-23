package com.shinhan.day09;

import lombok.Getter;

@Getter
public class Calculator {

	int memory;

	public  void setMemory(int memory) {
		synchronized(this) {	 
			this.memory = memory;
			System.out.println(
					Thread.currentThread().getName()
					+ "==>메모리저장값:" + this.memory );
		}
	}
	
	/*
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		System.out.println(Thread.currentThread().getName() + "==>메모리저장값:" + this.memory );
	}*/
	
	
	
}
