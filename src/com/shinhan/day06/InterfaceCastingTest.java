package com.shinhan.day06;

interface A{ void method1();}
class B implements A{public void method1(){System.out.println("B에서 메서드 재정의");}}
class C implements A{public void method1(){System.out.println("C에서 메서드 재정의");}}
class D extends B{
	public void method1(){
		System.out.println("D에서 메서드 재정의");
	}
	public void method2(){
		System.out.println("D에서 메서드2 추가");
	}
}
class E extends C{public void method1(){System.out.println("E에서 메서드 재정의");}}

public class InterfaceCastingTest {
	public static void main(String[] args) {
		//System.out.println(new String("자바"));
		//System.out.println(new TV());
		
		A v1 = new D();
		B v2 = new D();
		D v3 = new D();
		//v1.method1();v2.method1();v3.method1();
		
		D aa = (D)v1;
		((D)v1).method2();
		
		
		
		((D)v1).method2();
		((D)v2).method2();
		((D)v3).method2();
		
		//실행오류 
		//E e = (E)v1;
		//e.method1();
	}

}
