package com.shinhan.day08;

public class ChildPair<K,V> extends Pair<K, V>{

	
	public ChildPair(K key, V value) {
		super(key, value);
		System.out.println("자식...ChildPair");
	}

}
