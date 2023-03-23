package com.shinhan.day08;

public class ContainerExample {

	public static void main(String[] args) {
		f3();
	}
	private static void f4() {
		//2번문제
		Container<String> container1 = containerFactory("Book");
		String s = container1.get();
		System.out.println(s);	
		Container<Integer> container2 = containerFactory(100);
		int i = container2.get();
		System.out.println(i);
		Container<Money> container3 = containerFactory(new Money(200));
		Money m = container3.get();
		System.out.println(m);	
	}
	private static <T> Container<T> containerFactory(T data) {
		return new Container<T>(data);
	}
	
	private static <K,V> Container2<K,V> makeContainer(K key, V value) {
		return new Container2<K,V>(key,value);
	}
	
	private static void f3() {
		//3번문제
		Container2<String,Integer> container1 = makeContainer("aa",100);
		//container1.set("홍", 100);
		 
		System.out.println("key=" + container1.getKey());
		System.out.println("value=" + container1.getValue());
		
		Container2<String,Money> con2 = makeContainer("홍",new Money(100));
		//con2.set("홍", new Money(100));
		 
		System.out.println("key=" + con2.getKey());
		System.out.println("value=" + con2.getValue());
		
	}

	private static void f2() {
		//2번문제
		Container<String> container1 = new Container<String>();
		container1.set("홍");
		String s = container1.get();
		System.out.println(s);
		
		Container<Integer> container2 = new Container<Integer>();
		container2.set(100);
		int i = container2.get();
		System.out.println(i);
		
		
		Container<Money> container3 = new Container<>();
		container3.set(new Money(10));
		Money m = container3.get();
		System.out.println(m);
		
	}

}
