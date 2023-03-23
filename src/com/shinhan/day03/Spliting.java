package com.shinhan.day03;

//class : object를 만드는 틀 (붕어빵틀, 설계도)
//object : class를 이용해서 만든 독립된 개체, instance(실체)

public class Spliting{
	public static void main(String[] args) {
//		Spliting p = new Spliting();
		String addr = "서울시,강남구@역삼동#삼성SDS 멀티캠퍼스";
		
		String[] arr = addr.split(",|@|#| ");
		for(String s:arr) {
			System.out.println(s);
		}
		
//		String[] addrArr = p.split(addr, ',');
//		System.out.println("배열 크기 : " + addrArr.length);
//		for(int i=0; i<addrArr.length; i++){
//			System.out.print(addrArr[i] + " ");
//		}		
	}

	public  String[] split(String str, char separator){
		
		return null;
	}
}
