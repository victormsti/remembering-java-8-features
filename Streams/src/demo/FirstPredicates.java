package demo;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class FirstPredicates {

	public static void main(String[] args) {

		Stream<String> stream = Stream.of("one","two","three","four","five");
		
		Predicate<String> p1 = s -> s.length() > 3;
		Predicate<String> p2 = Predicate.isEqual("two");
		Predicate<String> p3 = Predicate.isEqual("three");
		
		//stream.filter(p1).forEach(s->System.out.println(s));
		stream.filter(p2.or(p3)).forEach(s->System.out.println(s));
		
		//stream.forEach(System.out::println); // Method reference
	}

}
