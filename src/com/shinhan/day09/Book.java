package com.shinhan.day09;

import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"title","price"}) //동등비교(기본:주소, 재정의:내용) 
public class Book<T> extends Object implements Comparable<Book>{
	private T title;
	private int price;
	private String publisher;
	private String[] author;
	private static int count;
	private static final String COMPANY="신한출판사";
	
	//static <T>에서 <T>의 의미: 이 메서드에서 <T>는 제네릭타입이다.
	//사용할때 결정한다. 
	//static가 없다면 instance method가 되므로 이미 new시에 T의 타입이 결정되었다
	//그러므로 <T>는 무의미하다. 
	public static <T> Book<T>  makeBook(T title, int price) {
		//new Book();
		return new Book<>(title, price, "홍대출판사", new String[] {"김경윤","양유진"});
	}
	
	//public Book() {	}
	
	public Book(T title, int price, String publisher, String[] author) {
		super();
		this.title = title;
		this.price = price;
		this.publisher = publisher;
		this.author = author;
		count++;
	}
	/*
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String[] getAuthor() {
		return author;
	}
	public void setAuthor(String[] author) {
		this.author = author;
	}
	
	public static void setCount(int count) {
		Book.count = count;
	}
	public static String getCompany() {
		return COMPANY;
	}
	*/
	/*
	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", publisher=" + publisher + ", author="
				+ Arrays.toString(author) + "]";
	}*/
	/*
	@Override
	public int hashCode() {
		return Objects.hash(price, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return price == other.price && Objects.equals(title, other.title);
	}*/
	@Override
	public int compareTo(Book obj) {
		// TODO Auto-generated method stub
		return price - obj.price;
	}
	
	public static int getCount() {
		return count;
	}
	
}
