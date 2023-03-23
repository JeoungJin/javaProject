package com.shinhan.day05.lab;

public class RectTriangle extends Shape{
	int width;
	int height;

	RectTriangle(int width,int height ) {
		super(3);
		this.width = width;
		this.height = height;
	}

	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return width*height/2;
	}

	@Override
	double getPerimeter() {
		// TODO Auto-generated method stub
		//width*width + height*height
		return  width + height + Math.sqrt(width*width + height*height);
	}

}
