package com.shinhan.day08;

public class Util {
	 
	 
	public static <K,V, T> V getValue(Pair<K, V> pair, String key) {
		if(pair.getKey().equals(key)) return pair.getValue();
		 return pair.getValue();
	}
	public static <P extends Pair<K,V>,K,V> V getValue2(P pair, String key) {
		if(pair.getKey().equals(key)) return pair.getValue();
		return null;
	}

}
