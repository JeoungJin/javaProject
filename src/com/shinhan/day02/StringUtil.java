package com.shinhan.day02;


public class StringUtil {
    public static void hokeyGraphics(char cell, int size, boolean isRect)
    {
        //특정 도형을 출력하는 메소드 구현
    	if(isRect) {
    		System.out.println("사각형모양"); 		 
    	}else {
    		System.out.println("삼각형모양");
    	}
    	for(int row=1; row<=size; row++) {
			for(int col=1; col<=(isRect?size:row); col++) {
				System.out.print(cell);
			}
			System.out.println();
		}
    }

    public static void main(String args[])  {                 
        hokeyGraphics( '@', 10, false); 
        
    }
}
