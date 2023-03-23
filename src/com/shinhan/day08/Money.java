package com.shinhan.day08;


public class Money implements Comparable<Money> {
    int amount;
    public Money(int amount) {
        this.amount = amount;
    }
    public Money add(Money money) {
        //더하기 구현....나의 amount + 들어온money의 amount를 더해서 Money만들어서 return
    	return new Money(amount+money.amount);
    }
    public Money minus(Money money) {
        //빼기 구현
    	return new Money(amount-money.amount);
    }
    public Money multiply(Money money) {
        //곱하기 구현
    	return new Money(amount*money.amount);
    }
    public Money devide(Money money) {
        //나누기 구현
    	return new Money(amount/money.amount);
    } 
    @Override
    public boolean equals(Object object) {
        //Object equals 메쏘드 재정의
    	if(this==object) return true; //주소같으면 같다.
    	if(object==null || getClass()!=object.getClass()) return false;
    	return amount == ((Money)object).amount;
    }
    @Override
	public String toString() {
		return amount+"머니머니!!!!!";
	}
	public static void main(String[] args){
        Money five  = new Money(5);
        Money two   = new Money(2);
        Money three = new Money(3);
        Money ten   = new Money(10);
      
        System.out.println(five.equals(ten));
        
        
        System.out.println(five);
        System.out.println(two.add(three));
        
        
        if( five.equals(two.add(three))
            && three.equals(five.minus(two))
            && ten.equals(five.multiply(two))
            && two.equals(ten.devide(five)) )  {
            System.out.println("Money Class 구현을 완료 하였습니다.");
        }
    }
	@Override
	public int compareTo(Money obj) {
		// TODO Auto-generated method stub
		return  amount - obj.amount; //-1 0, 1
	}


}
