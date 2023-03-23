package com.shinhan.day05;

public class SybaseDB extends Object 
          implements JDBCInterface{

	@Override
	public void dbConnect(String dbName) {
		System.out.println("Sybase..상수접근:" +JDBC );
		System.out.println("Sybase...상수접근:" +JDBC2 );
		//default메서드 호출 
		select();
		//static메서드 호출
		JDBCInterface.update();
		//private는 호출불가 
	}
	 
	public void select() {
		System.out.println("Sybase....select재정의 가능 ");
	} 
	
	

	@Override
	public void dbConnect2(String dbName) {
		System.out.println(dbName + "Sybase dbConnect2");
		
	}

}
