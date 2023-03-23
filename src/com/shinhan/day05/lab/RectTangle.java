package com.shinhan.day05.lab;

public class RectTangle extends Shape 
                      implements Resizable{
	double width;
	double height;

	RectTangle(double width,double height ) {
		super(4);
		this.width = width;
		this.height = height;
	}

	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return width*height;
	}

	@Override
	double getPerimeter() {
		// TODO Auto-generated method stub
		//width*width + height*height
		return  2*(width + height) ;
	}

	@Override
	public void resize(double s) {
		width =  width * s; 
		height =height * s;
		
	}

}
