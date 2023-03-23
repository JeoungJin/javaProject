package com.shinhan.day08;

import java.util.Objects;

class MySum {
    int first;
    int second;
    
    MySum (int first, int second){
        this.first = first;
        this.second = second;
    }
    /* 조건1 Object의 toString은 주소를 문자로return*/
	@Override
	public String toString() {
		//return first+second+"";//방법1
		return String.valueOf(first+second);//방법2
	}
    /* 조건2: Object의 equals는 주소비교 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof MySum)) return false;
		MySum my = (MySum)obj;
		//return first+second == (my.first + my.second);//방법1
		System.out.println(this);
		f1();
		return this.toString().equals(my.toString());//방법2
	}
	void f1() {
		 
	}
	/*
	@Override
	public int hashCode() {
		return Objects.hash(first, second);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MySum other = (MySum) obj;
		return first + second == other.first + other.second;
	}*/


}



class OverridingTest {
    public static void main(String args[]){
        int i = 10;
        int j = 20;
        
        MySum ms1 = new MySum(i, j);
        MySum ms2 = new MySum(5, 25);
        String s1 = "30";
        System.out.println(ms1);//30
        System.out.println(ms2.toString());//30

        if(ms1.equals(ms2))
            System.out.println("ms1과 ms2의 합계는 동일합니다.");
        
        if(ms1.equals(s1))
            System.out.println("ms1과 s1의 합계는 동일합니다.");
        else
        	System.out.println("ms1과 s1의 값은 동일하지 않습니다.");
    }
}
