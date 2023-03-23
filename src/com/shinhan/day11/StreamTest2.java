package com.shinhan.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class StreamTest2 {

	public static void main(String[] args) {
		List<Student> data = Arrays.asList(
				new Student("홍1",100),
				new Student("홍5",70),
				new Student("홍3",80),
				new Student("홍2",40),
				new Student("홍4",90) 
				);
		//data.forEach(st->System.out.println(st));
		//mapToInt:중간처리 
		//map:변형한다의 의미 
		//average:최종처리 ...평균구함 
		double avg = data.stream().mapToInt(st->st.getScore()).average().getAsDouble();
		System.out.println(avg);
		
		OptionalDouble opAvg = data.stream().mapToInt(st->st.getScore()).average();
		opAvg.ifPresentOrElse(a->{
			System.out.println("평균:" + a);
		}, ()->{System.out.println("평균계산할수없음");});

	}

}
