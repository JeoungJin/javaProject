package com.shinhan.day03;

import java.util.Arrays;

public class ArrayLab {
	
 
	
	public static void main(String[] args) {
	 	
		int[][] arr1 = {{30, 30, 30, 30},{40, 40, 40, 40},{50, 50, 50, 50}};
		int[][] arr2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int[][] arr3 = new int[3][4];
		int[][] arr4 = sub(arr1, arr2, arr3);
		prn(arr1);	
		prn(arr2);	
		prn(arr3);	
		prn(arr4);
		
		
	}
 			
	public static int[][] sub(int[][] a, int[][] b, int[][] c){
		for(int i=0;i<a.length;i++) {
			for(int j=0; j<a[i].length;j++) {
				c[i][j] = a[i][j] - b[i][j];
			}
		}
		return c;
	}
	public static void prn(int[][] a) {
		System.out.println("----------------");
		for(int i=0;i<a.length;i++) {
			for(int j=0; j<a[i].length;j++) {
				 System.out.print(a[i][j] + "\t");
			}
			System.out.println("");
		}
	}
	private static void method1() {
		int[] arr = {3, 24, 1, 55, 17, 43, 5};
		System.out.println("원본:" + Arrays.toString(arr));
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i] > arr[j]) {
					//바꾸기
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("Ascending Sort:" + Arrays.toString(arr));
	}

}
