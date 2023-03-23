package com.shinhan.day06;

 

public class Button {
	// field
	int a;
	private ClickListener listener;

	// method
	void f1(int a) {
		this.a = a;
	}
	void setListener(ClickListener listener) {
		this.listener = listener;
	}

	public void buttonClick() {
		listener.onClick();
	}

	// 내부interface...규격서
	static interface ClickListener {
		void onClick();
	}
}
