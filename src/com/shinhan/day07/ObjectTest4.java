package com.shinhan.day07;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

 

public class ObjectTest4 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		f15();

	}
	private static void f15() {
		Date d1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
		String result = sdf.format(d1);
		System.out.println(result);
		System.out.println(d1);
	}
	private static void f14() {
		//DecimalFormat df = new DecimalFormat("000,000,000");
		DecimalFormat df = new DecimalFormat("###,###");
		long money=10000;
		String result = df.format(money);
		System.out.println(result);
		
	}
	private static void f13() {
		Date d1 = new Date();
		System.out.println(d1);
		System.out.println(d1.getTime());
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt);
		System.out.println(dt.getYear());
		System.out.println(dt.getMonthValue());
		
		
	 
		
	}
	private static void f12() {
		//Math.max(10, 20)
		int a=10;
		int b=20;
		int max;
		//1.
		if(a>b) max=a; else max=b;
		//2.
		max = Math.max(a,b);
		
		//round, ceil(무조건 정수로올림), floor(무조건버림)
		double c = 3.9;
		System.out.println(Math.ceil(c));
		System.out.println(Math.floor(c));
		
		
		
	}
	private static void f11() {
		Integer a=10;
		Integer b=10;
		System.out.println(a == b);
		System.out.println(a.intValue() == b.intValue());
		
	}
	private static void f10() {
		//다음의 문자열에서 숫자들만 추출 
		String s = "이것이자바다 12345 This is 6789 Java 55";
		StringBuilder result=new StringBuilder();
		char[] arr = s.toCharArray();
		for(char ch:arr) {
			if(Character.isDigit(ch)) {
				result.append(ch);
			}
		}
		System.out.println(result);
	}
	private static void f9() {
		String s = "이것이자바다 This is Java";
		//System.out.println(s.substring(0, 1));
		//System.out.println(s.charAt(0));
		
		char[] arr = s.toCharArray();
		for(char ch:arr) {
			if(Character.isUpperCase(ch)) {
				System.out.println(ch + " ---대문자");
			}else {
				System.out.println(ch + " ---대문자아님");
			}
		}
		
	}
	private static void f8() {
		String score="100";
		int score2 = Integer.parseInt(score);
		System.out.println(score2 + 200);
		
		int su = 7;	
		System.out.println(Integer.toBinaryString(su));
		System.out.println(Integer.bitCount(su));
		
		
	}
	private static void f7() {
		int a=10; //기본형(용도:값저장, 연산, 비교)
		Integer b= 20;//참조형(객체:기본형+기능)  AutoBoxing : new Integer(20)
		
		System.out.println(a+b+200); //Unboxing:b.intValue()
		
		
		float f = b.floatValue();
		
		System.out.println(Integer.MAX_VALUE);
		int su = Integer.compare(10, 5); //< = >  //-1 0 1 
		System.out.println(su);
		
		int[] arr = {10,90,20,70,50};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		
		
	}
	private static void f6() {
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt.toString());
		System.out.println(dt);
		
		String s = dt.toString();
		String[] arr = s.split("T");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
		System.out.println(dt.getYear());
		
		StringTokenizer st = new StringTokenizer(s, "T-:");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
	}
	private static void f5() {
		String fruits = "010-1234-5678 010-789-4561";
		StringTokenizer st = new StringTokenizer(fruits, "- ");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}	
	}
	private static void f4() {
		String fruits = "사과!,오렌지!/키위! 수박!,참외!";
		StringTokenizer st = new StringTokenizer(fruits, ",/ ");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}	
	}
	private static void f3() {
		String fruits = "사과,오렌지/키위 수박,참외";
		String[] arr = fruits.split(",|/| ");
		for(String f:arr) {
			System.out.println(f);
		}
	}

	private static void f2() throws UnsupportedEncodingException {
		String s1 = "자바"; //가장일반적, String은 고정문자열
		System.out.println(s1 + "프로그램");
		s1 = s1 + "프로그램"; //메모리낭비 
		System.out.println(s1);
		
		StringBuilder sb = new StringBuilder("자바stringbuilder");
		StringBuffer sf = new StringBuffer("자바StringBuffer");
		//sb = sb + "aaa";
		sb.append("프로그램");
		System.out.println(sb);
		sf.append("프로그램");
		System.out.println(sf);
		
		String s2 = new String(sf);
		String s3 = new String(sb);
		
		String s4 = "자바프로그램";
		byte[] arr1 = s4.getBytes("utf-8");//한글1자->3byte
		byte[] arr2 = s4.getBytes("euc-kr");//한글2자->2byte
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(arr1.length);
		System.out.println(arr2.length);
		
	}

	private static void f1() throws UnsupportedEncodingException {
		String s1 = "자바"; //가장일반적 
		String s2 = new String("자바");
		byte[] arr1 = new byte[] {49,50,51,52,53};
		char[] arr2 = new char[] {'A','B','C','a','b','c'};
		String s3 = new String(arr1);
		String s4 = new String(arr2);
		System.out.println(s1+s2+s3+s4);
		String s5 = new String(arr1, "utf-8");
		System.out.println(s5);
		System.out.println(s5.length());
		
		System.out.println((byte)'ㄱ');
		
		
		
	}

}
