package com.shinhan.day06;

import com.shinhan.day06.Button.ClickListener;

public class CancelListener implements ClickListener {

	@Override
	public void onClick() {
		System.out.println("Cancel Button클릭시 수행되는 로직입니다.");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

}
