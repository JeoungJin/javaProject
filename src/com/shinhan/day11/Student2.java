package com.shinhan.day11;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter@Setter
public class Student2 implements Comparable<Student2>{
	private String name;
	private int score;
	private String gender;
	


	
	
	
	@Override
	public int compareTo(Student2 obj) {
		int result = score - obj.score;
		if(result==0) return obj.name.compareTo(name);
		return result;
	}






	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student2 [name=").append(name).append(", score=").append(score).append(", gender=")
				.append(gender).append("]");
		return builder.toString();
	}

	

	
	
}
