package com.shinhan.day08;

import java.util.ArrayList;

public class UtilExample {

	public static void main(String[] args) {
		 
		Pair<String, Integer> pair = new Pair<>("홍길동", 25);
		Integer age = Util.getValue(pair, "홍길동");
		System.out.println("pair 나이는 " + age);
		System.out.println("-----------------------------------------");
		ChildPair<String, Integer> childpair = new ChildPair<>("홍삼원", 20);
		Integer age2 = Util.getValue(childpair, "홍삼순");
		System.out.println("childpair 나이는 " + age2);
		
		//오류 
		/*OtherPair<String, Integer> otherpair = new OtherPair<>("홍삼원", 20);
		Integer age3 = Util.getValue2(otherpair, "홍삼순");
		System.out.println("otherpair 나이는 " + age3);
		 */

	}

}
