package ch01.verify;


//자바 class이름은 대문자시작 
//public class이름과 .java이름같다. 
public class ExampleShinhan {
	//변수, 함수이름은 소문자시작이 관례
	//class이름은 대문자시작이 관례이다. 
	public static void displayJava() {
		String s = "A";
		char ch = s.charAt(0);
		System.out.println(ch);
	}
	
	public static void main(String[] args) {
		displayJava();
		int _class=10;
		int $class=10;
		int studentScore=10;
		//변수이름은 소문자작성이 관례이다. 
		//int 4class=10; 숫자시작, $,_이외의 특수문자안됨
		//예약어안됨 
		System.out.println(_class);
		System.out.println("개발자가 되기 위한 필수언어 자바");
		System.out.print("개발자가 \t");
		System.out.print("되기\t");
		System.out.print("위한\t");
		System.out.print("필수언어\t");
		System.out.print("자바 \n");
	}

}
