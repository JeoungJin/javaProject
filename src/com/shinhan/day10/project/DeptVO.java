package com.shinhan.day10.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//VO(Value Object)
//DTO(Data Transfer Object)
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class DeptVO {
	 private int department_id;
	 private String department_name;
	 private int manager_id;
	 private int location_id;
	@Override
	public String toString() {
		return "DeptVO부서 [department_id=" + department_id + ", department_name=" + department_name + ", manager_id="
				+ manager_id + ", location_id=" + location_id + "]";
	}
	 
	 
	 
}
