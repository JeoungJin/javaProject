package com.shinhan.day11;

public class Person {

	public void action(Workable workable) {
		workable.work("홍길동", "프로그램");
	}
	public void action2(Speakable speakable) {
		String result = speakable.speak("안녕하세요");
		System.out.println(result);
	}
}
