package com.shinhan.day04;

//Servlet: JAVA(주인공) + HTML , 서버에서 수행되는 자바프로그램 
//JSP : HTML(주인공) + JAVA , 서버가JSP->Servlet변경해서실행 
//Servlet은 싱글톤으로 동작한다. new를 1회만한다. 
public class MyServlet {

	private static MyServlet  my ;
	
	//생성자 : new시에 자동으로 실행되는 메서드 
	private MyServlet(){
		System.out.println("MyServlet이 생성됨");
	}

	public static  MyServlet getInstance(){
		if(my == null)	my = new MyServlet();
		return my;
	 }
	
}
