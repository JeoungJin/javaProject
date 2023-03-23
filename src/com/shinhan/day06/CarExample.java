package com.shinhan.day06;


class Car{
	class Tire{}
	static class Engine{} 
	void go(int score2) {
		int score=100;//지역변수는 내부class에서 사용되면 final특성
		//score=300;
		//score2=400;
		class LocalClass{
			void f1() {
				//score=300;
				//score2=400;
				System.out.println(score);
				System.out.println(score2);
			}
		}
		LocalClass v1 = new LocalClass();
		System.out.println(v1);
		v1.f1();
	}
}
public class CarExample {
	public static void main(String[] args) {
		Car c1 = new Car();
		c1.go(200);
		
		Car.Tire v2 = new Car().new Tire();
		Car.Engine v3 = new Car.Engine();
		

	}

}
