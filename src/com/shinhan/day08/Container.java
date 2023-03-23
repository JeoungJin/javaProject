package com.shinhan.day08;

public class Container<T> {
	T data;	
	Container(){
		
	}
	Container(T data){
		this.data = data;
	}
	
	public void set(T data) {
		this.data = data;		
	}
	public T get() {
		// TODO Auto-generated method stub
		return data;
	}

}
