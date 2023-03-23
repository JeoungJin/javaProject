package com.shinhan.day10;

//----thread.start()하면 run()호출된다. 
//1.Thread상속
class MyThreadA extends Thread {
	MyThreadA(String name) {
		super(name);
	}

	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(getName() + ":" + i);

			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}

//2.이미상속중이라면 Runnable interface구현 
class ThreadB extends Object implements Runnable {

	@Override
	public void run() {
		for (int i = 100; i <= 110; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

public class Review {

	public static void main(String[] args) throws InterruptedException {

		Thread.sleep(5);

		Thread t1 = new MyThreadA("쓰레드A");
		Thread t2 = new Thread(new ThreadB());

		Thread t4 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 300; i <= 310; i++) {
					System.out.println(Thread.currentThread().getName() + ":" + i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});

		Thread t3 = new Thread() {
			public void run() {
				for (int i = 200; i <= 210; i++) {
					System.out.println(getName() + ":" + i);
					try {
						sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		System.out.println("main end");

	}

}
