package com.shinhan.day09;

class MovieThread extends Thread {
	public void run() {
		for (int i = 1; i <= 3; i++) {
			System.out.println("동영상을 재생합니다.");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class MusicThread implements Runnable {
	public void run() {
		for (int i = 1; i <= 3; i++) {
			System.out.println("Music을 재생합니다.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class ThreadExample {
	public static void main(String[] args) {
		Thread t1 = new MovieThread();
		t1.start();
		Thread t2 = new Thread(new MusicThread());
		t2.start();
		
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
		t3.start();
		
	}
}








