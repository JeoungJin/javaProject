package com.shinhan.day02;

import java.util.Scanner;

public class LAB1 {

	public static void main(String[] args) {
		method4();

	}

	public static void method4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("직각 역삼각형을 출력할 줄 수: ");
		int rowCount = sc.nextInt();
		for(int row=1; row<=rowCount; row++) {
			for(int col=1; col<=rowCount+1-row; col++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

	private static void method3() {
	    //10을 입력받으면 2+4+6+8+10
		//11          1+3+5+7+9+11 
		int  end, total=0;
		Scanner sc = new Scanner(System.in);
		System.out.print("마지막 값을 정수로 입력하세요. :");
		end = sc.nextInt();
		int start = end%2==0?2:1;
		for(int i=start;i<=end;i+=2) {
			total += i;
			System.out.println(i  );
		}
		System.out.printf("총합은 %d 입니다.", total);
		sc.close();
	}
	
	private static void method2() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력하세요. : ");
		String inputString = sc.nextLine();
		inputString = inputString.toUpperCase();
		for(int i=1;i<=inputString.length(); i++) {
			System.out.println(inputString.substring(0, i));
		}
		
		
		//System.out.println(inputString.length());
		//System.out.println(inputString.substring(0, 2));//<=  <
		//System.out.println(inputString.toUpperCase());
		sc.close();
		
		/*
		 * 문제2. 문자열을 입력 받아서 아래와 같은 실행결과가 나타나도록 
		 * ForTest클래스의 main 메쏘드를 완성하십시오. 
		 * 입력 받은 문자열을 한 글자씩 증가시키며 출력하는 프로그램입니다. 
		 * (단, 대문자로 출력해야 합니다.
		 */
		
	}

	private static void method1() {
		//문제1. 초기 값, 마지막 값, 증가분을 입력 받아서, 
		//초기값부터 마지막 값까지, 증가분씩 값을 증가시키면서 
		//각 값들의 총합을 구하는 프로그램을 작성하세요. 
		//단, 합을 구한 결과가 1000을 넘으면, 결과에 2000을 한번 더 더하여 출력합니다. 
		//2000/01/01이전, 이후 
		int start, end, increment, total=0;
		Scanner sc = new Scanner(System.in);
		System.out.print("초기값을 정수로 입력하세요. :");
		start = sc.nextInt();
		System.out.print("마지막 값을 정수로 입력하세요. :");
		end = sc.nextInt();
		System.out.print("증가분을 정수로 입력하세요. :");
		increment = sc.nextInt();
		for(int i=start;i<=end;i+=increment) {
			total += i;
		}
		System.out.printf("총합은 %d 입니다.", total);
		sc.close();
	}

}
