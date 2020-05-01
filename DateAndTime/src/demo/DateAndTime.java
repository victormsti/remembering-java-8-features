package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DateAndTime {

	public static void main(String[] args) {

		List<Person> people = new ArrayList<Person>();

		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(
						DateAndTime.class.getResourceAsStream("people.txt")));

				Stream<String> stream = reader.lines();
			) {
			
			stream.map(line -> {
				String[] s = line.split(" ");
				String name = s[0].trim();
				int year = Integer.parseInt(s[1]);
				Month month = Month.of(Integer.parseInt(s[2]));
				int day = Integer.parseInt(s[3]);
				Person p = new Person(name, LocalDate.of(year, month, day));
				people.add(p);
				return p;
			}).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		ZonedDateTime zone = LocalDateTime.now().atZone(ZoneId.of("America/Fortaleza"));
		LocalDate localdate = LocalDate.parse(formatter.format(zone), formatter);

		System.out.println(localdate);
//		LocalDate now = LocalDate.now();
//		
//		
//		people.stream().forEach(p -> {
//			Period period = Period.between(p.getDateOfBirth(), now);
//					System.out.println(p.getName() + " was born " + 
//			period.get(ChronoUnit.YEARS) + " years and " +
//			period.get(ChronoUnit.MONTHS) + " months ago [" + 
//			p.getDateOfBirth().until(now, ChronoUnit.MONTHS)
//			+ "] months");
//		});
		
	}

}
