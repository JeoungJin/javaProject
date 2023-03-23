package com.shinhan.day03;

//class = 변수 + 메서드 
public class Student {
	 
	//1.field(변수,속성,특징)
	String name;
	String stdId;
	String subject;
	int score;
	//2.Constructor(생성자)메서드...Compile시에 자동으로 default생성자가 제공된다.
	//정의가능하다.
	//생성자가 정의되면 default생성자가 만들어지지않는다. 
	//생성자의 Overloading...이름은 같고 매개변수 사양이다르다.
	public Student(){
		System.out.println("3default생성자에 의해 Student가 만들어짐");
	}
	Student(String name, String stdId, String subject, int score){
		System.out.println("arg4개 생성자에 의해 Student가 만들어짐");
	    //멤버변수(Field)와 매개변수(argument)가 충돌
		//구별필요하다. 이 클래스로 만든 현재객체를 this라고한다. 
		this.name =name;
		this.stdId = stdId;
		this.subject = subject;
		this.score = score;
	}
	 
	
	//3.일반메서드(행위)
	void study(){
		System.out.println(name + "학생이 공부합니다.");
	}
	
	//4.block(instance block-생성시마다수행, static block-load시1회수행)
	{
		System.out.println("****");
		System.out.println("2instance block");
	}
	static {
		System.out.println("1static block");
	}
	//5.inner class
	class Phone{
		
	}
}
