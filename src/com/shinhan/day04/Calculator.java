package com.shinhan.day04;

//Class : Object를 만들기위한 틀(설계도)
//Object : class를 이용해서 만들어진 실체(instance)
public class Calculator {
	//1.Field(특징,속성,변수):static(class변수), non-static(instance변수)
	private String color;
	private int price;
	private String model;
	static String company="신한";
	//2.생성자(new할때 자동실행되는 메서드)..컴파일시 자동으로 default생성자가 제공
	//생성자는 초기화가 목적 
	//생성자를 정의하면 default생성자가 제공안됨
	//this : 이 class를 이용해서 만든 현재객체 
	//1.매개변이름과 멤버변수이름이 충돌(구분이 필요하다) 
	//2.하나의 생성자가 다른생성자를 호출할때 사용
	//생성자 Overloading : 이름은 같고 매개변수사양이 다르다. 
	Calculator(String color){
		this(null, color, 0);
	}
	Calculator(String model, String color){
		this(model,color,1000);
	}
	Calculator(String model, String color,int price){
		this.model = model;
		this.color = color;
		this.price = price;
	}
	//3.method(일반메서드)...기능(동사) : static, non-static
	//void : return값이 없다
	
	//private로 정보은닉되어있는 멤버변수들을 읽기하는 기능만들기 getter 
	//private로 정보은닉되어있는 멤버변수들을 수정 기능만들기 setter 
	//static에서 this사용불가 , instance생성없이 사용되는 메서드이므로 instance변수 사용불가 
	public static void powerOn(){
		System.out.println(company + " 회사의 계산기 전원을 켠다.");
		//return;
		//불가return 100;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	void powerOff(){
		System.out.println(this.color + "," + model + "모델의 계산기 전원을 끈다.");
	}
	int add(int a, int b){
		return a+b;
	}
	int sub(int a, int b){
		return a-b;
	}
	//4.block (instance, static)
	{
		System.out.println("1instance생성시마다 수행된다.");
		System.out.println("---------------------");
	}
	{
		System.out.println("2instance생성시마다 수행된다.");
		System.out.println("---------------------");
	}
	static{
		System.out.println("1class load시에 1회 수행된다.");
		System.out.println("***********************");
	}
	static{
		System.out.println("2class load시에 1회 수행된다.");
		System.out.println("***********************");
	}
	//5.inner class
	class AA{
		
	}
}








