package com.shinhan.day09;

import lombok.AllArgsConstructor;

//@AllArgsConstructor
public class PrintThread extends Thread {

	ShareArea share;

	public PrintThread(ShareArea share) {
		this.share = share;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 3; i++) {
			 share.printBalance();
		}
	}
}
