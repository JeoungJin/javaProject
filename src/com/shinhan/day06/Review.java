package com.shinhan.day06;

/*
1.변수:data를 저장하기위한 기억장소이름 , 값수정가능
2.상수:data를 저장하기위한 기억장소이름 , 값수정불가능
3.enum : 상수묶음 
4.method : 문장들을 묶음 
5.class : object를 만드는 틀 변수+상수+method
6.object:class로 new한 실체 
7.interface : 규격서 , 상수+추상메서드+default method+static method
*/
abstract class ParentClass{
	abstract void method1();
}
interface MyInterface{
	void method2();
}
interface MyInterface2{
	void method2_1();
}
interface MyInterface3 extends MyInterface, MyInterface2{
	void method3_1();
}
class MyClass1 extends ParentClass implements MyInterface3{
	void method1() {}
	public void method2() {}
	public void method2_1() {}
	public void method3_1() {}
	
}
class MyClass2 extends ParentClass implements MyInterface{
	void method1() {}
	public void method2() {}
}

public class Review {

	public static void main(String[] args) {
		ParentClass v1 = new MyClass1();
		work(v1);

	}
	static void work(ParentClass aa) {
		aa.method1();
		System.out.println(aa instanceof MyClass1);
		System.out.println(aa instanceof ParentClass);
		System.out.println(aa instanceof MyInterface);
		System.out.println(aa instanceof MyInterface2);
		System.out.println(aa instanceof MyInterface3);
		
		if(aa instanceof MyInterface3 my) {
			//MyInterface3 my = (MyInterface3)aa;
			my.method2();
			my.method2_1();
			my.method3_1();
		}
	}

}






