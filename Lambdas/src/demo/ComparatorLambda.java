package demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambda {

	public static void main(String[] args) {

		// Old style
//		Comparator<String> comparator = new Comparator<String>() {
//
//			@Override
//			public int compare(String arg0, String arg1) {
//
//				return Integer.compare(arg0.length(), arg1.length());
//			}
//		};

		// Lambda style
		Comparator<String> comparatorLambda = (String arg0, String arg1) -> 
			Integer.compare(arg0.length(), arg1.length());
		

		List<String> list = Arrays.asList("***", "**", "****", "*");
		Collections.sort(list, comparatorLambda);

		for (String s : list) {
			System.out.println(s);
		}
	}

}
