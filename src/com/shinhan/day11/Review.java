package com.shinhan.day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Review {

	 
	{System.out.println();}
	
	
	public static void main(String[] args) {
		f2();
		System.out.println();
	}

	private static void f2() {
		List<Integer> data1 = new ArrayList<>();
		Set<Integer> data2 = new HashSet<>();
		Map<String, Integer> data3 = new HashMap<>();
		data1.add(100);
		data2.add(200);
		//data2.add(123);
		data3.put("aa", 300);
		
		System.out.println(data1.get(0));
		for(Integer a:data2) {
			System.out.println(a);
		}
		//내부반복자를 생성 
		Iterator<Integer> it = data2.iterator();
		System.out.println(it.next());
		System.out.println(it.hasNext()?it.next():"not found");
		
		//Map은 키가 있으면 값을 읽을수있다.
		int value = data3.get("aa");
		System.out.println(value);
		Set<String> keys = data3.keySet();
		for(String key:keys) {
			System.out.println(key);
			int val = data3.get(key);
			System.out.println(val);
		}
		
		Set<Entry<String, Integer>>  entrys = data3.entrySet();
		for(Entry<String, Integer> entry:entrys) {
			System.out.println(entry.getKey() + entry.getValue());
		}
		Iterator<Entry<String, Integer>>   it2 =  entrys.iterator();
		while(it2.hasNext()) {
			Entry<String, Integer> en = it2.next();
			System.out.println(en.getKey() + en.getValue());
		}
		
	}

	private static void f1() {
		//Collection:List(순서있고 중복가능),Set(순서없고 중복불가)
		//Map
		//List구현class : ArrayList, LinkedList, Vector
		//Set구현class:HashSet(중복Check:equals(),hashcode()), 
		// data가 추가시 순서정해짐(크기비교 compareTo())TreeSet
		//Map구현class:HashMap, TreeMap, Properties
		//키와값의 쌍 Entry(Key:set이다, Value)
		
	}
}
