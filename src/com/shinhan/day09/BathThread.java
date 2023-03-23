package com.shinhan.day09;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BathThread extends Thread{

	BathRoom room;
	String userName;

	@Override
	public void run() {
		for(int i=1; i<=3; i++) {
			room.use(userName);
			try {
				Thread.sleep((int)(Math.random()*100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
