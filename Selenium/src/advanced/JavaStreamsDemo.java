package advanced;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

	
public class JavaStreamsDemo {

//	@Test
	public void withoutStream() {
		
		// normal way of finding the names that starts with "A"
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("Sagar");
		al.add("Ammu");
		al.add("Appu");
		al.add("Virat");
		al.add("Sachin");
		al.add("Dhoni");
		al.add("Palmer");
		al.add("Hazard");
		al.add("Amorim");
		
		int count = 0;
		
		for(String name:al) {
			if (name.startsWith("A")){
				count++;
			}
		}
		System.out.println("No.of names that starts with 'A': "+count);
		System.out.println("----------------------------------------------------");
	}
	
//	@Test
	public void withStreamFilter() {
		
		// Finding the names that starts with 'A' using stream
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("Sagar");
		al.add("Ammu");
		al.add("Appu");
		al.add("Virat");
		al.add("Sachin");
		al.add("Dhoni");
		al.add("Palmer");
		al.add("Hazard");
		al.add("Amorim");
		
		long count = al.stream().filter(s-> s.startsWith("A")).count();
		System.out.println("No.of names that starts with 'A': " +count);
		
		//Find and print all the names which has length more than 4	
		al.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		System.out.println("----------------------------------------------------");
		//Print only 2 names from the above stream
		al.stream().filter(s->s.length()>4).limit(2).forEach(s->System.out.println(s));
		System.out.println("----------------------------------------------------");
	}
	
//	@Test
	public void streamMap() {
		
		// print names which have last letter as 'u' and print them in uppercase
		// this can be achieved in any of the 2 ways below.
		
		Stream.of("Sagar","Ammu","Appu","Palmer").filter(s->s.endsWith("u")).forEach(s->System.out.println(s.toUpperCase()));
		System.out.println("---");
		Stream.of("Sagar","Ammu","Appu","Palmer").filter(s->s.endsWith("u")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		System.out.println("---------------");
		
		// print the names starting with 'A' in uppercase. Also sort them
		//simply convert an array into arraylist
		List<String> Namelist = Arrays.asList("sagar","ammu","aadi","ajmal","cole","Noni");
		Namelist.stream().filter(s->s.startsWith("a")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		System.out.println("---------------");
		
		//merge 2 different lists
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("australia");
		arrList.add("India");
		arrList.add("China");
		arrList.add("Indonesia");
		
		Stream<String> combined = Stream.concat(Namelist.stream(), arrList.stream());
//		combined.sorted().forEach(s->System.out.println(s)); //print the combined stream
		// check if a particular string is present in the combined stream
		Boolean flag = combined.anyMatch(s->s.equalsIgnoreCase("AUSTRALIA"));
		System.out.println("value of Flag: "+flag);
		Assert.assertTrue(flag);
		System.out.println("---------------");
	}
	
	@Test
	public void streamCollect() {
		
		// converting stream to list
		List<String> streamToList = Stream.of("sagar","ammu","aadi","ajmal","cole","Noni").filter(s->s.endsWith("i")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
		streamToList.forEach(s->System.out.println(s));
		System.out.println("----------------------------------------------------");
		
//		int[] array = {1,2,3,3,44,12,5,8,2,7,1,9,5};
//		print unique numbers from the array
//		sort it and get the 3rd index
		
		List<Integer> arrayToList = Arrays.asList(1,2,3,3,44,12,5,8,2,7,1,9,5);
		arrayToList.stream().distinct().sorted().forEach(s->System.out.println(s));
		int thirdIndex = arrayToList.stream().collect(Collectors.toList()).get(2);
		System.out.println("Index 3 in the list: " +thirdIndex);
		
		
	}
}
