package com.shinhan.day06;

public class ExceptionTest2 {

	public static void main(String[] args) {
		
		//0<=~ <1사이의 실수 
		double a = Math.random();
		//1~8정수 
		int b = (int)(a*8)+1; //1<=~<=8
		System.out.println(a);
		System.out.println(b);
		
		
		
		//Exception:자동발생 ,강제발생 
		//int a=10/0;//자동 
		String pass = "123456";
		
		char ch = pass.charAt(0);
		try {
			if(ch<'A' || ch>'Z') {
				throw new LoginException("대문자시작해야한다.");
			}
		}catch(LoginException ex) {
			System.out.println(ex.getMessage());
			ex.printMessage();
		}
		System.out.println("main end");
	}

}
