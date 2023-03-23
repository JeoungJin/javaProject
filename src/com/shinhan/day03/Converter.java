package com.shinhan.day03;

/*
 * 문자열내의 특정 문자를 지정한 문자로 수정하는 myReplace 메서드를 완성하시오. 
myReplace 메서드의 첫번째 매개변수는 수정대상이 되는 문자열이며 두번째 매개변수는 문자열내에 존재하는 문자이며 
세번째 매개변수는 변경하고자 하는 문자입니다.
myReplace 메서드는 변경한 문자열을 리턴하며 만약 문자열내에 변경대상이 되는 문자가 없을 경우 변경 없이 그대로 리턴해야 합니다.

<<수행결과>>
-------------Sample 1 --------------
he**o wor*d
-------------Sample 2 --------------
hello-world
-------------Sample 3 --------------
hello world

 */
public class Converter {
	public static void main(String[] args) {
		 
		String str1=myReplace("hello world",'l','*');
		System.out.println(str1);
		
		System.out.println("-------------Sample 2 --------------");
		String str2=myReplace("hello world",' ','-');
		System.out.println(str2);
		
		System.out.println("-------------Sample 3 --------------");
		String str3=myReplace("hello world",'a','*');
		System.out.println(str3);
		

	}
	//함수 : 문장의 묶음
	//함수생성이유 : 반복코드없이 함수로 만들어서 재사용한다.  모듈화 
	public static String myReplace(String str, char oldChar, char newChar){
		// 이 부분을 구현하시오.
		String result="";
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)==oldChar) {
				result += newChar; //신규문자 
			}else {
				result += oldChar; //본래문자
			}
		}
		
		return result;
		
			 
	}
}

