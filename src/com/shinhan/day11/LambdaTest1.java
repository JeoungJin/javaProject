package com.shinhan.day11;

public class LambdaTest1 {

	public static void main(String[] args) {
		f5();

	}
	private static void f5() {
		Caculable2 f = (a,b)->a+b;
		Caculable2 f3 = (a,b)->{
			System.out.println("여러문장이라면 {}필요 ");
			System.out.println("반드시 return문을 쓴다 ");
			return a+b;
		};
		
		Caculable2 f2 = new Caculable2() {
			public int caculate(int x, int y) {
				return x+y;
			}
		};
		int result1 = f.caculate(1, 2);
		int result2 = f2.caculate(1, 2);
		int result3 = f3.caculate(1, 2);
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		
	}
	private static void f4() {
		Person p1 = new Person();
		p1.action( new Workable() {
			public void work(String name, String job) {
				System.out.println("이름은 " + name);
				System.out.println("job=" + job);
				System.out.println("------------------");
			}
		});
		p1.action((a,b)->System.out.println(a+"--"+b) );
		p1.action((a,b)->{
		       System.out.println(a+"^^^"+b); 
		       System.out.println(a+"***"+b); 
		      }
		);
		Workable f = (a,b)->{
		       System.out.println(a+"@@@@"+b); 
		       System.out.println(a+"%%%%"+b); 
		      };
		p1.action(f);
		
		
		//p1.action2(s->System.out.println(s+"말하기"));
		Speakable f2=s->s+"!!!!!!!!";
		p1.action2(f2);
		
	}
	private static void work(Runnable r) {
		Thread t1 = new Thread(r);
		t1.start();
	}
	
	private static void f3() {
		work(()->{System.out.println("A1");});
		work(()->{System.out.println("A2");});
		work(()->{System.out.println("A3");});
		work(()->{System.out.println("A4");});
		work(()->{System.out.println("A5");});
		 
		
		
	}

	private static void action(Caculable func) {
		func.caculate(10, 20);
	}
	
	private static void f2() {
		//1.구현class이용...X
		//2.익명구현class이용...O
		/*(new Caculable() {
			public void caculate(int x, int y) {
				System.out.println("-----익명구현class이용-----");
				System.out.println("더하기:" + (x+y));
			}
		}).caculate(10, 20);*/
		Caculable f = new Caculable() {
			public void caculate(int x, int y) {
				System.out.println("-----익명구현class이용-----");
				System.out.println("더하기:" + (x+y));
			}
		};
		Caculable f2 = new Caculable() {
			public void caculate(int x, int y) {
				System.out.println("-----익명구현class이용-----");
				System.out.println("빼기:" + (x-y));
			}
		};
		Caculable f3 = (a,b)->{
			System.out.println("-----람다표현식이용-----");
			System.out.println("곱하기:" + (a*b));
		};
		action(f);
		action(f2);
		action(f3);
	}

	private static void f1() {
		//1.구현class이용
		MyInterface a = new MyClassImplement();
		a.print();
		//2.익명구현class이용
		(new MyInterface() {			
			@Override
			public void print() {
				System.out.println("익명구현class이용1......");				
			}
		}).print();
		
		MyInterface b = new MyInterface() {			
			@Override
			public void print() {
				System.out.println("익명구현class이용2......");				
			}
		};
		b.print();b.print();
		//3.람다식이용...JS:화살표함수=>
		MyInterface c = ()->System.out.println("람다식이용......");	
		c.print();
	}

}
