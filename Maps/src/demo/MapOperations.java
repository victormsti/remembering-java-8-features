package demo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapOperations {

	public static void main(String[] args) {

		// This map has name as key and age as value
		Map<String, Integer> singleMap = new HashMap<String, Integer>();
		singleMap.put("Victor", 27);
		singleMap.put("Ludmila", 26);
		singleMap.put("Migson", 4);
		singleMap.put("Cida", 4);
		singleMap.put("Mille", 2);
		
		// prints the key of each map object
		singleMap.forEach((name,age) -> System.out.println(name));
		
		System.out.println("---");
		singleMap.putIfAbsent("Victor", 27);
		
		// Shoukld have the same size
		singleMap.forEach((name,age) -> System.out.println(name));
	}

}
