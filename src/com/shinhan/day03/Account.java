package com.shinhan.day03;

public class Account {
	private String accNo;
	private int balance;
	
	//this : 객체자신
	//1.매개변수와 멤버변수이름이 충돌시 구분을 위해....멤버변수를 접근하기위해 this
	//2.생성자가 overloading되어있는 경우 ...다른생성자 호출시 
	Account(String accNo, int balance){
		this.accNo = accNo;
		this.balance = balance;
	}
	
	
	void test(int...aa) {
		
	}
	void test(String aa, String bb) {
		
	}
	void deposit(int amount) {
		balance +=amount; 
		print("계좌에 "
				+ amount
				+ "원이 입금되었습니다.");
	}
	void withdraw(int amount) {
		this.balance -=amount; 
		print("계좌에 "
				+ amount
				+ "원이 출금되었습니다.");
	}
	//getter
	public int getBalance(){
		return balance;
	}
	public String getAccNo(){
		return accNo;
	}
	
	private void print(String message) {
		System.out.println(accNo + message);
		System.out.println(accNo + " 계좌의 잔고는 "
				+ balance
				+ "원입니다.");
	}
	
	
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", balance=" + balance + "]";
	}


	public static void main(String[] args) {
		Account acc = new Account("078-3762-293", 1000000);
		acc.deposit(2000000); //300
		acc.withdraw(500000); //250
		 
		 System.out.println(acc);
	}

	
	
}

class AA{
	
}

//  잔고를 확인하는 getBalance 함수와 계좌 번호를 확인하는 getAccNo 함수를 가지고 있습니다. TestAccount 클래스를 이용하여 Account 클래스의 함수를 호출시켰을 때 콘솔에 출력되는 결과는 다음과 같습니다.
//
//[TestAccount 실행결과]
//078-3762-293 계좌가 개설되었습니다.
//078-3762-293 계좌의 잔고는 1000000원입니다.
//078-3762-293 계좌에 2000000원이 입금되었습니다.
//078-3762-293 계좌의 잔고는 3000000원입니다.
//078-3762-293 계좌에 500000원이 출금되었습니다.
//078-3762-293 계좌의 잔고는 3500000원입니다.

