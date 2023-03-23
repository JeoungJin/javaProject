package com.shinhan.day11;

public class LambdaTest2 {
	String subject="자바";
	public static void main(String[] args) {
		new LambdaTest2().f2(100);

	}
	
	private void f2(int su1) { //파라메터는 지역변수 
		int su2=200;//지역변수
		int su3=300;
		su3++;
		//내부class에서지역변수 사용한다면 final의 특성을 갖는다. (수정불가) 
		//su1++;
		//su2++;
		//1.익명구현class
		Caculable2 f = (a,b)-> {
				System.out.println("람다표현식...." + subject);
				//su1++;
				//su2++;
				return a+b+su1+su2;
			};
	
		int result = f.caculate(1, 2);
		System.out.println(result);
		
	}
	private static void f1(int su1) { //파라메터는 지역변수 
		int su2=200;//지역변수
		int su3=300;
		su3++;
		//내부class에서지역변수 사용한다면 final의 특성을 갖는다. (수정불가) 
		//su1++;
		//su2++;
		//1.익명구현class
		Caculable2 f = new Caculable2() {
			public int caculate(int x, int y) {
				System.out.println("익명구현객체");
				//su1++;
				//su2++;
				return x+y+su1+su2;
			}
		};
		int result = f.caculate(1, 2);
		System.out.println(result);
		
	}

}
