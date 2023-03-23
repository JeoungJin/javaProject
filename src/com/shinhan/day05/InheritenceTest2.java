package com.shinhan.day05;

//Child2 ch = new Child2(): Object생성 - Parent2생성 - Child2생성 
//ch.a
//ch.method1()

//final class : 상속불가 
//final field : 값수정불가 
//final method : 재정의불가 
class Parent2 extends Object{
	int a=10;
	Parent2(){
		//super()
		//a=20;값수정불가 
		System.out.println("부모생성자");
	}
	 void method1() {
		System.out.println("부모method");
	}
}
class Child2 extends Parent2{
	//String a = "자바"; //덮어쓰기 (
	int b=20;
	Child2(){
		//super();
		System.out.println("자식생성자");
	}

	void method1() { //덮어쓰기 (Override)
		System.out.println("자식method");
	}
	/*
	void method1(String b) { //추가(Overloading)
		System.out.println("자식method");
	}*/
	void method2() {
		System.out.println("자식 method2");
	}
}



public class InheritenceTest2 {

	public static void main(String[] args) {
		f4();

	}
	private static void f4() {
		Parent2 ch = new Child2();
		System.out.println(ch.a);// + ch.b);
		ch.method1();
		//ch.method2();
		
	}
	private static void f3() {
		//부모를 통해서 자식을 본다......부모의 변수와 메서드만 호출가능 
		Parent2 ch = new Child2();
		System.out.println(ch.a);// + ch.b);
		ch.method1();
		//ch.method2();
		
	}
	private static void f2() {
		Child2 ch = new Child2();
		System.out.println(ch.a + ch.b);
		ch.method1();
		ch.method2();
		
	}

	private static void f1() {
		Student st1 = new Student("123", "홍길동");
		Student st2 = new Student("124", "박길동", "컴공");
		Student st3 = new Student("125","양길동","화학", 99);
		ExchangeStudent st4 = new ExchangeStudent("126", "은빈", new String[] {"영어","프랑스"});
		System.out.println(st1);
		System.out.println(st2);
		System.out.println(st3);
		System.out.println(st4);
		System.out.println(Student.count + "명");
		
	}

}
