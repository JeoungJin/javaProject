package com.shinhan.day02;

public class 정진 {

	public static void main(String[] args) {
		method4_2();
		int a=10;
		System.out.println(a>=10?"aaa":"bbb");
		
		 
	}
    //switch statement를 switch expression(12부터지원)으로 변경
	private static void method4_2() {
		String grade = "B";
		int score = switch (grade) {
		case "A"->100;
		case "B"->{
			int result = 100-20; 
			yield result;
		    }
		default->60;		
		};	
		System.out.println(score);
		/////////////////////////////
		switch (grade) {
			case "A":score=100;break;
			case "B":int result = 100-20;score=result;break;
			default:score=60;break;
		}
		
	}
 

	private static void method4_1() {
		//2
		
	}

	private static void method7() {
		double x=5.0;
		double y=0.0;
		double z=x%y;
		if(Double.isNaN(z)) {
			System.out.println("0으로 나눌수없음");
		}else {
			double result = z+10;
			System.out.println("결과는 " + result);
			
		}
	}

	private static void method6() {
		int x=10;
		int y=5;
		System.out.println((x>7 && y <=5)); 
		System.out.println(x%3==2 || y%2 != 1);
	}

	private static void method5() {
		int top=5;
		int bottom = 10;
		int height=7;
		double area = (top+bottom)* height / 2;
		System.out.println(area);
	}

	private static void method4() {
		int value = 356;
		System.out.println(356/100*100);
	}

	private static void method3() {
		int pencils = 534;
		int students = 30;
		int pencilsPerStudent = pencils/students;
		System.out.println(pencilsPerStudent);
		int pencilsLeft =pencils%students ;
		System.out.println(pencilsLeft);
	}

	private static void method2() {
		int score = 85;
		String result = (!(score > 90)) ? "가" : "나";
		System.out.println(result);// "가"

	}

	private static void method1() {
		int x = 10;
		int y = 20;
		int z = (++x) + (y--); // 11 + 20
		System.out.println(z); // 31...y는 20

	}

}
