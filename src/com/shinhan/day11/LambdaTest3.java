package com.shinhan.day11;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.shinhan.day05.Account;

public class LambdaTest3 {

	public static void main(String[] args) {
		f8();

	}
	private static void f8() {
		BiFunction<String, String, Account> func2 = (no,owner)->{
			System.out.println("계좌번호:" + no);
			System.out.println("owner:" + owner);
			return new Account(no, owner);
		};
		Account acc = func2.apply("1234", "KIM");
		System.out.println(acc);
		
		BiFunction<String, String, Account> func3 = Account::new;
		Account acc3 = func3.apply("1234", "KIM");
		System.out.println(acc3);
		
	}
	private static void f7() {
		//BiFunction<Integer, Integer, Integer> func1 = (a,b)-> Math.max(a, b);
		BiFunction<Integer, Integer, Integer> func1 = Math::max;
		int result = func1.apply(10, 20);
		System.out.println("큰값:" + result);
		
	}
	
	private static void f6() {
		BiFunction<Integer, Integer, Integer> func1 = (a,b)->{
			if(a>b) return a;
			return b;
		};
		int result = func1.apply(10, 20);
		System.out.println("큰값:" + result);
		
	}
	private static void f5() {
		Predicate<Integer> func1 = (a)->a>10;
		boolean result = func1.test(2);
		System.out.println(result);
		
		Predicate<Account> func2 = (a)->{
			System.out.println("--------Account의 잔고조사하기----------");
			System.out.println(a);
			return a.getBalance()>=100;
		};
		result = func2.test(new Account("1234", "Hong", 1000));
		System.out.println(result);
	}
	private static void f4() {
		BinaryOperator<Integer> func1 = (a,b)->a+b;
		BinaryOperator<Integer> func2 = (a,b)->a-b;
		System.out.println(func1.apply(1, 2));
		System.out.println(func2.apply(1, 2));
		
	}
	private static void f3() {
		//매개값이있고 return는 경우 
		Function<String, Account> func1 = (a)->new Account(a, null, 100);
		BiFunction<String, String, Account> func2 = (no,owner)->{
			System.out.println("계좌번호:" + no);
			System.out.println("owner:" + owner);
			return new Account(no, owner, 100);
		};
		Account acc1 = func1.apply("1234");
		Account acc2 = func2.apply("5555", "홍길동");
		System.out.println(acc1);
		System.out.println(acc2);
		
	}
	//생산자 
	private static void f2() {
		Supplier<String> a =  ()->"자바";
		Supplier<String> b =  ()->{
			System.out.println("-------------");
			return "자바2";
		};
		Supplier<Account> c = ()->new Account();
		String ret1 = a.get();
		String ret2 = b.get();
		System.out.println(ret1);
		System.out.println(ret2);
		System.out.println(c.get());
		
		
	}
	//
	
	//소비자 Consumer
	private static void f1() {
		Consumer<Integer> f = (a)->System.out.println(a+200);
		Consumer<String> f2 = (a)->System.out.println(a+200);
		Consumer<Account> f4 = (a)->{
			System.out.println(a);
			a.deposit(1000);
			int result = a.withdraw(100);
			System.out.println(result + "출금완료");
		};
		
		f.accept(100);
		f2.accept("100");
		BiConsumer<String, Integer> f3 = (a,b)->{
			System.out.println("a=" + a);
			System.out.println("b=" + b);
		};
		f3.accept("자바시험", 100);
		f4.accept(new Account("123", "jin", 1000));
	}

}
