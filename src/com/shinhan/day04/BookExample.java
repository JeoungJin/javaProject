package com.shinhan.day04;

public class BookExample {

	public static void main(String[] args) {
		System.out.println("책생성전:" + BookVO.count);
		
		BookVO[] b = new BookVO[5];
		b[0] = new BookVO("Java Program",30000);
		b[1] = new BookVO("JSP Program",25000);
		b[2] = new BookVO("SQL Fundamentals",20000);
		b[3] = new BookVO("JDBC Program",32000);
		b[4] = new BookVO("EJB Program",25000);
		
		System.out.println("책생성후:" + BookVO.count);
		
		//final은 읽기만 가능
		System.out.println(b[0].isbn);
		System.out.println(b[0].isbn2);
		System.out.println(b[0].PUBLISHER);
		System.out.println(BookVO.PUBLISHER);
		
		
		//***final은 수정불가 
		//b[0].isbn = "1111";
		//b[0].isbn2 = "1111";
		//b[0].PUBLISHER = "AA";
		//BookVO.PUBLISHER = "AA";
		
	}

}
