package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IntermediaryAndFinal {

	public static void main(String[] args) {
		Stream<String> stream = Stream.of("one", "two", "three", "four", "five");

		Predicate<String> p1 = s -> s.length() > 3;
		Predicate<String> p2 = Predicate.isEqual("two");
		Predicate<String> p3 = Predicate.isEqual("three");

		List<String> list = new ArrayList<String>();
		
		//stream.filter(p2.or(p3)).forEach(s -> System.out.println(s));
		
		//stream.peek(System.out::println).filter(p2.or(p3)).peek(list::add); // will print nothing
		
		stream.peek(System.out::println).filter(p2.or(p3)).forEach(list::add); // will print, as the forEach is a final operator
		
		System.out.println("Done");
		
		System.out.println("List size: " + list.size());
	}

}
