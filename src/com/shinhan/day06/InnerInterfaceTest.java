package com.shinhan.day06;

public class InnerInterfaceTest {

	public static void main(String[] args) {
		Button b1 = new Button();
		Button b2 = new Button();
		OKListener listener1 = new OKListener();
		Button.ClickListener listener2 = new CancelListener();
		test(b1, listener1);
		test(b2, listener2);
		
	}
	static void test(Button bb, Button.ClickListener listener) {
		bb.setListener(listener);
		bb.buttonClick();
	}
	
	
	
}
