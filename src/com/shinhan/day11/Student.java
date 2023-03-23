package com.shinhan.day11;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter@Setter
public class Student implements Comparable<Student> {
	private String name;
	private int score;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student 정보 [name=")
		.append(name)
		.append(", score=")
		.append(score)
		.append("]");
		return builder.toString();
	}
	@Override
	public int compareTo(Student obj) {
		int result = score - obj.score;
		if(result==0) return obj.name.compareTo(name);
		return result;
	}

	

	
	
}
