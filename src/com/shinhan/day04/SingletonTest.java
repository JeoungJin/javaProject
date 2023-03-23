package com.shinhan.day04;

import java.util.Calendar;

public class SingletonTest {

	public static void main(String[] args) {
		MyServlet a = MyServlet.getInstance();
		MyServlet b = MyServlet.getInstance();
		
		System.out.println(a==b);
	 
		
		Calendar cal = Calendar.getInstance();
	 
		System.out.println(cal);
		
		

	}

}
