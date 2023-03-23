package com.shinhan.day03;

//JavaBeans기술 규격서 : field는 private(정보은닉)
public class Computer {
	String model;
	String os;
	int price;
	static int count; //변수:instance변수, static변수(class변수, object공유변수 ) 
	//생성자Overloading:생성자이름은 같고 매개변수 사양이다르다.
	//하나의 생성자가 다른모양의 생성자를 호출할수 있다. 
	public Computer(){
		this("AA모델", "Mac", 500);	
	}
	public Computer(String model){
		this(model, null, 0);
	}
	public Computer(String os, int price){
		this(null, os, price);
	}
	public Computer(String model, String os, int price){
		System.out.println("*****arg3생성자로 생성********");
		this.model = model;
		this.os = os;
		this.price = price;
		count++;
	}
	//일반메서드
	public void computerInfoPrint() {
		System.out.println("model:" + model);
		System.out.println("os:" + os);
		System.out.println("price:" + price);
	}
	public String getModel() {
		return model;
	}
	public String getos() {
		return os;
	}
	public int getPrice() {
		return price;
	}
}




