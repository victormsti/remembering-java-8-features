package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExample {

	public static void main(String[] args) {

		List<Person> people = new ArrayList<Person>();
		
		try (
				BufferedReader reader = 
				new BufferedReader(new InputStreamReader(
						CollectorsExample.class.getResourceAsStream("people.txt")));
				
				Stream<String> stream = reader.lines();
				){
			stream.map(line -> {
				String[] s = line.split(" ");
				Person p = new Person(s[0].trim(), Integer.parseInt(s[1]));
				people.add(p);
				return p;
			}).filter(p -> p.getAge() >= 20).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Stream<Person> stream = people.stream();
		
		Optional<Person> opt = 
		stream.filter(p -> p.getAge() >= 20)
		.min(Comparator.comparing(Person::getAge));
		
		System.out.println(opt);
		System.out.println();
		
		Optional<Person> opt2 =
				people.stream().max(Comparator.comparing(Person::getAge));
		
		System.out.println(opt2);
		System.out.println();
		
		Map<Integer, List<Person>> map = 
		people.stream().collect(Collectors.groupingBy(
				Person::getAge));
		
		System.out.println(map);
		System.out.println();
		
		// Downstream collector
		Map<Integer, Long> map2 = 
				people.stream().collect(Collectors.groupingBy(
						Person::getAge, Collectors.counting()));
				
		System.out.println(map2);
		System.out.println();
		
		// Downstream collector 2
		Map<Integer, List<String>> map3 = 
				people.stream().collect(Collectors.groupingBy(
						Person::getAge, Collectors.mapping(
								Person::getName, Collectors.toList())));
				
		System.out.println(map3);
		System.out.println();		
	
		// Downstream collector 3
		Map<Integer, Set<String>> map4 = 
				people.stream().collect(Collectors.groupingBy(
						Person::getAge, Collectors.mapping(
								Person::getName, Collectors.toCollection(TreeSet::new))));
					
		System.out.println(map4);
		System.out.println();
		
		// Downstream collector 4
		Map<Integer, String> map5 = 
				people.stream().collect(Collectors.groupingBy(
						Person::getAge, Collectors.mapping(
								Person::getName, Collectors.joining(", "))));
							
		System.out.println(map5);
		System.out.println();
	}

}
