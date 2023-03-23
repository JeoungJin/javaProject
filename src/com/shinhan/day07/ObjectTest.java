package com.shinhan.day07;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Car{
	private String model;
	private int price;
	public Car(String model, int price) {
		super();
		this.model = model;
		this.price = price;
	}
	//재정의
	@Override
	public String toString() {
		return "Car [model=" + model + ", price=" + price + "]";
	}
	//동등비교 (예, HashSet은 중복불가 ):hashCode(), equals()가 같아야 같은객체로 판별 
	@Override
	public int hashCode() {
		return Objects.hash(model, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(model, other.model) && price == other.price;
	}
	
	
	
}



public class ObjectTest {

	public static void main(String[] args) {
		f5();
		 

	}
	private static void f5() {
		Set<Car> data = new HashSet<Car>();
		data.add(new Car("A", 100));
		data.add(new Car("B", 100));
		data.add(new Car("C", 100));
		data.add(new Car("D", 100));
		data.add(new Car("A", 100));
		data.add(new Car("A", 100));
		for(Car s:data) {
			System.out.println(s);
			System.out.println(s.hashCode());
			System.out.println("---------------");
		}
		
	}
	private static void f6() {
		//Set : 순서가없다. 중복허용안함 
		Set<String> data = new HashSet<String>();
		data.add("월");
		data.add("화");
		data.add("수");
		data.add("월");
		data.add("월");
		for(String s:data) {
			System.out.println(s);
		}
		
	}

	

	private static void f4() {
		Car obj1 = new Car("A", 100);		 
		Car obj2 = new Car("B", 100);
		
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj1.equals(obj2)?"내용같다":"내용다르다"); //Car equals() : 내용비교로 재정의됨  
		
	}
	
	private static void f3() {
		Date obj1 = new Date();
		Date obj2 = new Date();
		
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
		System.out.println(obj1 == obj2?"주소같다":"주소다르다"); //== 객체는 주소비교 
		System.out.println(obj1.equals(obj2)?"내용같다":"내용다르다"); //Date equals() : 내용비교로 재정의됨  
		
	}
	
	private static void f2() {
		String obj1 = new String("자바");
		String obj2 = new String("자바!!!");
		
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
		System.out.println(obj1 == obj2?"주소같다":"주소다르다"); //== 객체는 주소비교 
		System.out.println(obj1.equals(obj2)?"내용같다":"내용다르다"); //String equals() : 내용비교로 재정의됨  
		
	}
	
	private static void f1() {
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
		System.out.println(obj1 == obj2?"주소같다":"주소다르다"); //== 객체는 주소비교 
		System.out.println(obj1.equals(obj2)?"주소같다":"주소다르다"); //Object equals() : 주소비교 
		
	}

}
