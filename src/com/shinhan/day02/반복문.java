package com.shinhan.day02;

public class 반복문 {

	public static void main(String[] args) {
		forTest4();

	}

	private static void forTest4() {
		// 1~10합계
		int su = 1;
		int total = 0;
		/*
		for (; su <= 10; ++su) {
			if (su % 2 != 0)continue; //반복문을 빠지지않고 아래문장들무시, 계속진행		
			total += su;
			System.out.print(su);
			System.out.print(su == 10 ? "" : "+");

		}*/
		for (; su <= 10; ++su) {
			if (su % 2 == 0) { //짝수일때만 문장들을 수행하겠다의미 
				total += su;
				System.out.print(su);
				System.out.print(su == 10 ? "" : "+");
			}
		}
		System.out.println("=" + total);

	}

	private static void whileTest3() {
		// 1~10까지 출력한다.
		int i = 100;
		do {
			System.out.println(i);
			System.out.println("------------");
			i++;
		} while (i <= 10);
		System.out.println("method end..." + i);
	}

	private static void whileTest2() {
		// 1~10까지 출력한다.
		int i = 1;
		while (i <= 10) {
			System.out.println(i);
			System.out.println("------------");
			i++;
		}
		System.out.println("method end..." + i);
	}

	private static void whileTest() {
		// 1~10까지 출력한다.
		int i = 1;
		while (true) {
			if (i > 10)
				break;
			System.out.println(i);
			System.out.println("------------");
			i++;
		}
		System.out.println("method end..." + i);
	}

	private static void forTest2() {
		// 1~10까지 출력한다.
		int i = 1;
		for (;;) {
			if (i > 10)
				break;
			System.out.println(i);
			System.out.println("------------");
			i++;
		}
		System.out.println("method end..." + i);
	}

	private static void forTest() {
		// 1~10까지 출력한다.
		int i;
		for (i = 1; i <= 10; i++) {
			System.out.println(i);
			System.out.println("------------");
		}
		System.out.println("method end..." + i);
	}

}
