package com.luoExpress.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Code_01_HashMap {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("dal", "27");

		System.out.println(map.containsKey("dal"));
		System.out.println(map.containsKey("luo"));
		System.out.println("=========================");

		System.out.println(map.get("dal"));
		System.out.println(map.get("luo"));
		System.out.println("=========================");

		System.out.println(map.isEmpty());
		System.out.println(map.size());
		System.out.println("=========================");

		System.out.println(map.remove("dal"));
		System.out.println(map.containsKey("dal"));
		System.out.println(map.get("dal"));
		System.out.println(map.isEmpty());
		System.out.println(map.size());
		System.out.println("=========================");

		map.put("dal", "27");
		System.out.println(map.get("dal"));
		map.put("dal", "28");
		System.out.println(map.get("dal"));
		System.out.println("=========================");

		map.put("dal", "27");
		map.put("luo", "28");


		for (String key : map.keySet()) {
			System.out.println(key);
		}
		System.out.println("=========================");

		for (String values : map.values()) {
			System.out.println(values);
		}
		System.out.println("=========================");

		map.clear();
		map.put("A", "1");
		map.put("B", "2");
		map.put("C", "3");
		map.put("D", "1");
		map.put("E", "2");
		map.put("F", "3");
		map.put("G", "1");
		map.put("H", "2");
		map.put("I", "3");
		for (Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "," + value);
		}
		System.out.println("=========================");

		// you can not remove item in map when you use the iterator of map
//		 for(Entry<String,String> entry : map.entrySet()){
//			 if(!entry.getValue().equals("1")){
//				 map.remove(entry.getKey());
//			 }
//		 }

		// if you want to remove items, collect them first, then remove them by
		// this way.
		List<String> removeKeys = new ArrayList<String>();
		for (Entry<String, String> entry : map.entrySet()) {
			if (!entry.getValue().equals("1")) {
				removeKeys.add(entry.getKey());
			}
		}
		for (String removeKey : removeKeys) {
			map.remove(removeKey);
		}
		for (Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "," + value);
		}
		System.out.println("=========================");

	}

}
