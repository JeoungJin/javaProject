package com.shinhan.day02;

public class LAB3 {
    //public : 모든패키지에서 접근가능 
	//static : >java LAB3실행하면 실행하기전에 
	//LAB3 class의 byte code가 method영역에 올라간다.
	//static붙은 method, variable들도 올라간다. 
	//void : return값이 없다. 함수수행후 돌아갈때 값을 가지고가지않는다. 
	public static void main(String[] args) {
		int a=10;
		gcd(2,5);
		gcd(5,15);
		gcd(250,30);
		
		//double result = sum(1,100);
		//System.out.println(result);
	}

	private static void gcd(int i, int j) {
		int min = i>j?j:i;
		int result=1;
		for(int su=min; su>=1; su--) {
			if(i%su==0 && j%su==0) {
				result=su;break;
			}
		}
		System.out.println(result);
	}

	private static double sum(int i, int j) {
		int total = 0;
		for(int loop=i;loop<=j;loop++) {
			total += loop;
		}
		return total;
	}

	 
	 
	

}
