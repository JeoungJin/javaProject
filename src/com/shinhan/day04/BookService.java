package com.shinhan.day04;

import java.lang.reflect.Array;
import java.util.Arrays;

//Service : Business logic구현 
public class BookService {
	BookVO[] booklist;
	public BookService(BookVO[] booklist){
		this.booklist = booklist;
	}
	public void printBookList(){
		System.out.println("=== 책 목록 ===");
		System.out.println(booklist);
		System.out.println(Arrays.toString(booklist));
		for(BookVO book:booklist) {
			//System.out.println(book.getTitle());
			System.out.println(book);
		}
	}
	public void printTotalPrice() {
		System.out.println("=== 책 가격의 총합 ===");
		int total=0;
		for(BookVO book:booklist) {
			total += book.getPrice();
		}
		System.out.println("전체 책 가격의 합 :" + total);
	}
}
 
 
