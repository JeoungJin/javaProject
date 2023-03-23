package com.shinhan.day05;

//interface : 규격서(정의있고 구현없음) =  추상메서드  + 상수 
//추상class = 일반메서드 + 추상메서드 + 변수,상수 + 생성자 
public interface JDBCInterface {
	// 1.상수(변수는 불가)
	public static final String JDBC = "JAVA Database Connection";
	// 생략가능
	String JDBC2 = "JAVA Database Connection";

	// 2.추상메서드 : public abstract생략가능 
	public abstract void dbConnect(String dbName);

	void dbConnect2(String dbName) ;
 
	
	
	// 3.상위버젼에서 추가됨 default method: public생략가능 
	default void select() {
		System.out.println("default method : 인터페이스를 구현한 모든class의 공통코드");
		System.out.println("구현class에서 재정의 가능하다.");
		insert();
		insert();
		insert();
	}

	// 4.상위버젼에서 추가됨 static method
	static void update() {
		System.out.println("static method : 인터페이스 소유의 코드");
		System.out.println("구현class에서 재정의 불가능하다.");
		insert2();
		insert2();
		insert2();
	}
	//5.private:default에서 호출 
	private void insert() {
		System.out.println("-----------------------------");
	}
	//6.private static:static에서 호출 
	private static void insert2() {
		System.out.println("-----------------------------");
	}

}
