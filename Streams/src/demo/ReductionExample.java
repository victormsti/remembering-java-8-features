package demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionExample {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(10, 10, 10);
		
		Integer sum = list.stream().reduce(0,Integer::sum);
		Integer max = list.stream().reduce(0,Integer::max);
		Optional<Integer> optionalMax = list.stream().reduce(Integer::max);
		//list.stream().reduce(0,(i1,i2) -> i1 + i2)
		
		System.out.println("Red: " + sum);
		System.out.println("Max: " + max);
		System.out.println("Does optionalMax has result? " + optionalMax.isPresent());
	}

}
