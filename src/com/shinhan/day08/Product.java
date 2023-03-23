package com.shinhan.day08;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = {"kind"})
@Getter
@Setter
public class Product<T,M> {

	T kind;
	M model;
	
}
