package com.shinhan.day08;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Car implements Comparable<Car>{

	String model;
	int price;
	@Override
	public int compareTo(Car obj) {
		int result = model.compareTo(obj.model);
		if(result==0) return obj.model.compareTo(model);
		return result; //-1, 0, 1
	}
	
	void f1() {
		Car c1 = new Car("",1);
		Car c2 = new Car("",2);
		c1.compareTo(c2);
	}
	
}
