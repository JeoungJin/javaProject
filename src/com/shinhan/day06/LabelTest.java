package com.shinhan.day06;

public class LabelTest {

	public static void main(String[] args) {
		Label v1 = new Label("이름입력", 20, 5, "black", "large");
		Resizable v2 = new Label("이름입력", 20, 5, "black", "large");
		Colorable v3 = new Label("이름입력", 20, 5, "black", "large");
		Changeable v4 = new Label("이름입력", 20, 5, "black", "large");		
		
		Changeable aa = (Changeable)v3;
		
		work(v1);
		//work(v2);
		//work(v3);
		work(v4);
	}
	//자동형변환 : 부모의타입 객체참조변수 = 자식객체 
	static void work(Changeable aa) {
		if(aa instanceof Label label) {
			label.setBackground(null);
			label.setForeground(null);
			label.setFont(null);
			label.size(0, 0);
			 
		}
	}
	
	

}
