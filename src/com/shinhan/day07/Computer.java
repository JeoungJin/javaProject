package com.shinhan.day07;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@EqualsAndHashCode(of = {"model","price"})
//@ToString

//@EqualsAndHashCode(exclude = {"maker"})
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Computer {
	@NonNull
	private String model;
	
	private int price;
	private String maker;
}
