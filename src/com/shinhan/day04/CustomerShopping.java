package com.shinhan.day04;

public class CustomerShopping {
	public static void main(String[] args) {
	    BookVO[] b = new BookVO[5];
		b[0] = new BookVO("Java Program",30000);
		b[1] = new BookVO("JSP Program",25000);
		b[2] = new BookVO("SQL Fundamentals",20000);
		b[3] = new BookVO("JDBC Program",32000);
		b[4] = new BookVO("EJB Program",25000);
		
		BookService bm = new BookService(b);
		bm.printBookList();
		bm.printTotalPrice();
	}
}
