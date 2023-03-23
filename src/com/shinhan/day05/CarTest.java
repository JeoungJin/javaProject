package com.shinhan.day05;

public class CarTest {
	
	void go(Tire tire) {
		System.out.println("----------------");
		tire.roll();
		if(tire instanceof KumhoTire) {
			KumhoTire kum = (KumhoTire)tire;
			System.out.println(kum.intro);
			kum.method2();
		}else if(tire instanceof HankokTire han) {
			System.out.println(han.info);
			han.method1();
		}
	}

}
