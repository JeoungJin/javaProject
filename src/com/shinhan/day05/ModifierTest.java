package com.shinhan.day05;

import com.shinhan.day04.Phone;

//다른패키지연습
public class ModifierTest extends Phone{

	private void method() {
		System.out.println(model);
		f2();
	}
	
	public static void main(String[] args) {
		Phone p = new Phone();
		//p.model = "켈럭시22";
		System.out.println(p);
		p.f1();  
	}

}
