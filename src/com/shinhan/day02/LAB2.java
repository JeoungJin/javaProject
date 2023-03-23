package com.shinhan.day02;

import java.util.Scanner;

public class LAB2 {

	public static void main(String[] args) {
		numDay(1900, 2);
	}
	//void : return값이 없다.
	//static : class가 메모리에 load될때 method영역에 올라간다. 
	//public : 모든 패키지에서 이 함수를 호출할수 있다. 
	public static void numDay(int year, int month){
		int lastDay=0;
		switch (month) {
		case 1,3,5,7,8,10,12:lastDay=31;break;
		case 4,6,9,11:lastDay=30;break;
		case 2:lastDay = method9(year)?29:28;break;
		}
		System.out.println(lastDay==0?"잘못된 월":lastDay);
	}
	private static boolean method9(int year) {
		// 윤년 leap year	 
		boolean result = false;
		if(year%4==0) {
			if(year%100!=0 || year%400==0) result = true;
		} 
		return result;
		//System.out.println(result?"윤년":"윤년아님");
		//System.out.println(year%400);
	}

	private static void method8() {
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수를 입력하세요 : ");
		int input = sc.nextInt();
		int cnt = 1000 / input;
		System.out.println(input + "의 배수 개수 = " + cnt);
		System.out.println("7의 배수 합 = " + (1+1000)*cnt /2);
		int count = 0, sum=0;
		for (int i = input; i <= 1000; i+=input) {		 
				count += 1;
				sum += i;		 
		}
		System.out.println(input + "의 배수 개수 = " + count);
		System.out.println("7의 배수 합 = " + sum);
		
	}

	private static void method7() {
		// 1부터 1,000까지의 수 중에서 입력 받은 정수의 배수의 개수와 배수들의 합을 계산하십시오
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수를 입력하세요 : ");
		int input = sc.nextInt();
		int cnt = 1000 / input;
		System.out.println("7의 배수 개수 = " + cnt);

		int sum = 0;
		for (int i = 1; i <= cnt; i++) {
			sum += input * i;
		}
		System.out.println("7의 배수 합 = " + sum);
		System.out.println(((1+1000)*cnt) /2);
	}

	private static void method6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수를 입력하세요: ");
		int num = sc.nextInt(); // 7
		int count = 0; // 배수의 개수
		int sum = 0; // 배수의 합

		for (int i = 1; i <= 1000; i++) {
			if (i < num | i % num != 0) {
				continue;
			} else {
				count += 1;
				sum += i;
			}
		}

		System.out.printf("%d의 배수 개수 = %d\n", num, count);
		System.out.printf("%d의 배수 합= %d\n", num, sum);
	}

	private static void method5() {
		Scanner sc = new Scanner(System.in);

		System.out.print("양의 정수를 입력하세요 :"); // 7
		int num = sc.nextInt();
		int total = 0, sum = 0; // total갯수
		for (int j = 1; j <= 1000; j++) {
			if (j % num == 0) {
				total++;
				sum += j;
			}
		}
		System.out.printf("%d의 배수 개수 = %d\n%d의 배수 합 = %d", num, total, num, sum);

		sc.close();
		return;

	}

	private static void method4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요.: ");
		int num = sc.nextInt();

		if (num >= 1 & num < 10) {

			for (int i = 1; i <= num; i++) {
				int result = 1;
				for (int j = 1; j <= i; j++) {
					result *= j;
				}
				System.out.printf("%d ! = %d\n", i, result);
			}
		} else {
			System.out.println("잘못된 숫자가 입력되었습니다.");
		}
	}

	private static void method3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요.: ");
		int num = sc.nextInt();
		if (num < 2 || num > 9) {
			System.out.println("잘못된 숫자가 입력되었습니다.");
			sc.close();
			return;
		}
		int answer = 1;
		for (int i = 1; i <= num; ++i) {
			answer *= i;
			System.out.println(i + "! = " + answer);
		}

		sc.close();
	}

	private static void method2() {
		// 소수란 자신과 1외의 다른 수로는 나누어 떨어지지 않는 정수입니다.
		// 아래와 같이 2~100 사이의 숫자를 입력하면 소수인지 여부를 판별하는 프로그램을 작성하십시오.
		Scanner sc = new Scanner(System.in);
		System.out.print("2 ~ 100사이의 정수를 입력하세요. : ");
		int number = sc.nextInt();
		boolean isPrime = true;

		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				isPrime = !isPrime;
				break; // 반복문빠지기
			}
		}
		System.out.println(number + (isPrime ? " :소수" : " :소수아니다"));
	}

	private static void method1() {
		// 입력받은 숫자의 구구단 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요. : ");
		int dan = sc.nextInt();
		if (dan < 2 || dan >= 10) {
			System.out.println("잘못된 숫자가 입력되었습니다.");
			return; // 함수빠지기, 호출한곳으로 돌아간다.
		}
		// break : switch빠지기, 반복문장빠지기
		for (int gop = 1; gop <= 9; gop++) {
			System.out.printf(" %d * %d = %d\n", dan, gop, dan * gop);
		}

	}

}
