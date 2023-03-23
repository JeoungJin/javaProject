package com.shinhan.day05;

public class Rectangle extends Shape {
	int width;
	int height;
	public Rectangle(String color, int width, int height) {
		super(color, "Rectangle");
		this.width = width;
		this.height = height;
	}
	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return width*height;
	}
	@Override
	public double calculatePerimeter() {
		// TODO Auto-generated method stub
		return 2*(width + height);
	}

}
