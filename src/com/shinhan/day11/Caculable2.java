package com.shinhan.day11;

//함수형표현 ...람다식...람다표현식으로 표현가능한가?@FunctionalInterface
//interface에 1개의 메서드만 존재해야한다.
@FunctionalInterface
public interface Caculable2 {

	//추상메서드정의
	int caculate(int x, int y);
	//void caculate2(int x, int y);
}
