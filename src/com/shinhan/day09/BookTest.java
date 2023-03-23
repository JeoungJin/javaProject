package com.shinhan.day09;

class Box{}

public class BookTest {

	public static void main(String[] args) {
		
		Book<String> b1 = new Book<String>("이것이자바다", 30000, 
				 "퍼스트존", new String[] {"신용권","임경균"});
		Book<String> b6 = new Book<String>("이것이자바다", 30000, 
				 "퍼스트존", new String[] {"신용권","임경균"});				
		Book<Integer> b2 = new Book<>(999, 35000, 
				 "퍼스트존", new String[] {"신용권","임경균"});		
		Book<Box> b3 = new Book<>(new Box(), 20000, 
				 "퍼스트존", new String[] {"신용권","임경균"});
		
		Book<String> b4 = Book.makeBook("자바웹구현", 25000);
		Book<Box> b5 = Book.makeBook(new Box(), 27000);
		
		int result = b1.compareTo(b4);
		System.out.println(result);
		
		System.out.println(b1.equals(b6));
		System.out.println(Book.getCount() + "권");
		
		 
		
	}

}





