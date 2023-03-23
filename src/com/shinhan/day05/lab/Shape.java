package com.shinhan.day05.lab;

public abstract class Shape {
	int numSides;
	Shape(int numSides){
		this.numSides = numSides;
	}
	int getNumSides(){
		return numSides;
	}
	abstract double getArea(); // 넓이
	abstract double getPerimeter(); // 둘레 길이
}
