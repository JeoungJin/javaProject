package com.shinhan.day09;

import com.shinhan.day05.Account;

public class ThreadTest4 {

	public static void main(String[] args) throws InterruptedException {
		f10();

	}
	private static void f10() {
		AutoSaveThread t1 = new AutoSaveThread();
		t1.setDaemon(true); //main thread종료시 데몬이 종료 
		t1.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main end");
		
	}
	private static void f9() {
		SafeThread t1 = new SafeThread();
		t1.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.interrupt();
		
	}
	private static void f8() {
		SafeThread t1 = new SafeThread();
		t1.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.interrupt();
		
	}
	private static void f7() {
		SafeThread t1 = new SafeThread();
		t1.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.setStop(true);
		//t1.stop();//사용하지않는것이좋다
		
	}
	//Thread에서 다른쓰레드에 신호보내기 : wait(), notify()
	private static void f6() {
		WorkObject obj = new WorkObject();
		ThreadA t1 = new ThreadA(obj);
		ThreadB t2 = new ThreadB(obj);
		t1.start();
		t2.start();
		
	}
	//동기화
	private static void f5() {
		ShareArea share = new ShareArea(
				new Account("12345", "성춘향", 1000),
				new Account("78896", "이몽룡", 2000));
		TransferThread t1 = new TransferThread(share);
		PrintThread t2 = new PrintThread(share);
		t1.start();t2.start();
		
		
	}
	//동기화
	private static void f4() {
		// 익명thread만들기
		User1Thread t1 = new User1Thread();
		User2Thread t2 = new User2Thread();
		
		
		//Calculator는 2개의 Thread가 공유하는 공유영역
		Calculator cal = new Calculator();
		t1.setCalculator(cal);
		t2.setCalculator(cal);
		
		t1.start();
		t2.start();
		
		 
		
	}

	//동기화(공유영역을 하나의 쓰레드가 사용중일때 다른쓰레드가 접근금지)
	private static void f3() {
		BathRoom bathRoom = new BathRoom();
		BathThread t1 = new BathThread(bathRoom, "김씨");
		BathThread t2 = new BathThread(bathRoom, "박씨");
		BathThread t3 = new BathThread(bathRoom, "정씨");
		BathThread t4 = new BathThread(bathRoom, "최씨");
		t1.start();t2.start();t3.start();t4.start();
		
		
	}


	//join test
	private static void f2() {
		SumThread t1 = new SumThread(1,50);
		SumThread t2 = new SumThread(51,100);
		t1.start();
		t2.start();
		
		try {
			//Thread.sleep(3000);
			t1.join();t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(t1.getSum()+t2.getSum());
		System.out.println("main end.......");
	}



	//yield test
	private static void f1() throws InterruptedException {
		WorkThread t1 = new WorkThread("[쓰레드A]");
		WorkThread t2 = new WorkThread("[쓰레드B]");
		t1.start();
		t2.start();
		//5초간일시정지 
		Thread.sleep(5000);
		//t1의 work를 false....t1쓰레드가 다른쓰레드에 양보하다.
		t1.work = false;
		//10초후
		Thread.sleep(10000);
		//t1의 work를 true
		t1.work = true;
		
	}

}
