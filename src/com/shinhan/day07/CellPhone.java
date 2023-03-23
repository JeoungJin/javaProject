package com.shinhan.day07;

public class CellPhone  {
	String model;	// 핸드폰 모델 번호
	double battery;	// 남은 배터리 양
	 CellPhone(String model){
		
		this.model = model+"~";
	}
	void  call(int time ) throws  IllegalArgumentException{
		 
		//강제Exception발생, 처리는 안함, RuntimeException에속한 Exception은 자동으로 throws (던져진다)
		if(time < 0) throw new IllegalArgumentException("통화시간입력오류");
		battery -= time * 0.5;
		if(battery < 0) battery=0;
		System.out.println("통화 시간 : " + time + "분");
	}
	void  charge(int time) {
		if(time < 0) throw new IllegalArgumentException("충전시간입력오류");
		battery += time * 3;
		if(battery > 100) battery = 100;
		System.out.println("충전 시간 :" + time + "분");
	}
	void  printBattery() {
		System.out.println("남은 배터리 양 : " + battery);
	}
	//override : 함수이름, 매개타입과 갯수, return타입이 모두 같아야하고 , 접근제한자는 같거나 더 넓어져야한다.
	//overloading :  매개타입과 갯수가 다르면 Overloading이다.
	
	@Override
	public boolean  equals(Object otherObject) {
		/*if(obj instanceof CellPhone p) {
			return this.model.equals(p.model);
		}
		//CellPhone p = (CellPhone)obj;
		return false; */
		if (otherObject instanceof CellPhone pp && 
				this.model.equals(pp.model)){
			return true;
		}
		System.out.println(otherObject instanceof CellPhone pp);
		return false;
		
	}
	@Override
	public String toString() {
		return "CellPhone [model=" + model + ", battery=" + battery + "]";
	}
	
	
	
	
}

/*
 
void  printBattery()	// 남은 배터리 양을 출력한다.
boolean  equals(Object otherObject)	// Object 타입의 객체를 입력받고, 입력받은 객체가CellPhone 타입의 클래스이면서 모델 번호가 같은 경우에 true를 리턴한다.
*/
