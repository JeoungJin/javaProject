package com.shinhan.day05;

import java.util.Arrays;

public class ExchangeStudent extends Student{
	String[] language;
	public ExchangeStudent(String stdId, String name, String[] language) {
		super(stdId, name);//1.부모에서default생성자를 정의 2.명시적으로 부모생성자를 호출(o) 
		//this.setStdId(stdId);
		//this.name = name;
		this.language = language;
	}
	void display() {
		System.out.println(getClass().getSimpleName() + "에서 추가된 메서드");
	}
	@Override
	public String toString() {
		
		return  "ExchangeStudent [language=" + Arrays.toString(language) + ", name=" + name + ", major=" + major
				+ ", score=" + score + ", schoolName=" + schoolName + "]";
	}


	
	
	
}
