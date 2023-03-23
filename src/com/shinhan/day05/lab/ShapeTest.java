package com.shinhan.day05.lab;

 

public class ShapeTest {

	public static void main(String[] args) {
	   Shape[] arr = new Shape[2];
	   arr[0] = new RectTangle(5, 6);
	   arr[1] = new RectTriangle(6, 2);
	   
	   for(Shape s : arr) {
		   System.out.println("area: " + s.getArea());
		   System.out.println("perimeter:" + s.getPerimeter());
		   if(s instanceof Resizable re) {
			   re.resize(0.5);
			   System.out.println("new area: " + s.getArea());
			   System.out.println("new perimeter:" + s.getPerimeter());
		   }
	   }
	}

}
