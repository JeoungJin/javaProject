package com.shinhan.day08;

import lombok.Data;
import lombok.Getter;

@Getter
public class Container2<K, V> {
	K key;
	V value;

	public Container2(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	void set(K key, V value) {
		this.key = key;
		this.value = value;
	}

}
