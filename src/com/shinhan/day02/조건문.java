package com.shinhan.day02;

import java.util.Scanner;

public class 조건문 {

	public static void main(String[] args) {
		method4();

	}
	private static void method4() {
		//12 1 2 
		//3 4 5
		//6 7 8
		//9 10 11
		Scanner sc = new Scanner(System.in);
		System.out.print("월>>");
		int month = sc.nextInt();
		String message = "";
		
		switch (month) {
		case 12,1,2: message = "겨울입니다.";break;
		case 3,4,5:message = "봄입니다.";break;
		case 6,7,8:message = "여름입니다.";break;
		case 9,10,11:message = "가을입니다.";break;
		default:message = "월 입력이 잘못되었습니다.";
		}
		 
		System.out.println(message);
		//8버젼은 ,없음 
		switch (month) {
		case 12:
		case 1:
		case 2: message = "겨울입니다.";break;
		case 3:
		case 4:
		case 5:message = "봄입니다.";break;
		case 6:
		case 7:
		case 8:message = "여름입니다.";break;
		case 9:case 10:case 11:message = "가을입니다.";break;
		default:message = "월 입력이 잘못되었습니다.";
		}
		System.out.println(message);
		
	}
	private static void method3() {
		//12 1 2 
		//3 4 5
		//6 7 8
		//9 10 11
		Scanner sc = new Scanner(System.in);
		System.out.print("월>>");
		int month = sc.nextInt();
		String message = "";
		if(month==12 || month==1 || month==2) {
			message = "겨울입니다.";
		}else if(month==3 || month==4 || month==5) {
			message = "봄입니다.";
		}else if(month==6 || month==7 || month==8) {
			message = "여름입니다.";
		}else if(month==9 || month==10 || month==11) {
			message = "가을입니다.";
		}else{
			message = "월 입력이 잘못되었습니다.";
		}
		System.out.println(message);
		
	}

	private static void method2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수>>");
		int score = sc.nextInt();
		String grade="";
		//90~100 A
		//80~89 B
		//70~79 C
		//60~69 D
		//F
		switch (score/10) {
		case 10:  
		case 9:grade = "A";break;
		case 8:grade = "B";break;
		case 7:grade = "C";break;
		case 6:grade = "D";break;
		default:
			grade = "F";
			break;
		}
		System.out.println("!!!결과는 " + score + "==>" + grade);
		
	}
	
	private static void method1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수>>");
		int score = sc.nextInt();
		String grade="";
		if(score>=90) {
			grade = "A";
		}else if(score>=80) {
			grade = "B";
		}else if(score>=70) {
			grade = "C";
		}else if(score>=60) {
			grade = "D";
		}else   {
			grade = "F";
		}
		System.out.println("!!!결과는 " + score + "==>" + grade);
		
	}

}
