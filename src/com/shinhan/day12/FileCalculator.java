package com.shinhan.day12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
public class FileCalculator {
	public static void main(String[] args) {
		try {			 
			new FileCalculator().addCalculateResult("data.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void addCalculateResult(String inputFileName) throws Exception{
		//FileInputStream,FileReader
		//보조stream 이용: BuffereredReader, DataInputStream
		FileReader fi = new FileReader(inputFileName);
		//실패:DataOutputStream으로 저장후 DataInputStream가능 DataInputStream dis = new DataInputStream(fi);
		BufferedReader br = new BufferedReader(fi);
		String s;
		int sum=0, multiply=1;
		while((s = br.readLine())!=null) {
			System.out.println(s);
			sum += Integer.parseInt(s);
			multiply *= Integer.parseInt(s);
		}
		System.out.println(sum + "====" + multiply);
		br.close();
		fi.close();	
		//파일을 출력목적으로 열기 
		FileWriter fw = new FileWriter(inputFileName, true); //append여부 
		BufferedWriter bw = new BufferedWriter(fw);
		bw.newLine();
		bw.write(sum + "");
		bw.newLine();
		bw.write(multiply + "");
		
		bw.close();
		fw.close();
		 
	}
}
