package com.shinhan.day02;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

//java.lang패키지에있는 class는 import없이 사용한다. 

public class ScannerTest {

	public static void main(String[] args) throws IOException {
		f1();

	}

	private static void f2() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("점수>>");
		int score = sc.nextInt();
		System.out.print("이름>>");
		String name = sc.next();
		System.out.print("메모>>");
		sc.nextLine();
		String memo = sc.nextLine();
		System.out.println(name + "==>" + score);
		System.out.println(memo);
	}

	private static void f1() throws IOException {
		// 사용자입력받기
		System.out.println("f1 function");
		System.out.print("점수입력>>");
		 
		InputStream is = System.in;
		int i;
		while((i = is.read())!=13) {
			System.out.println((char)i);
		}
		
		
	}

}
