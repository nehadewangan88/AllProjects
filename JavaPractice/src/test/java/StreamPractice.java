import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class StreamPractice {

	public static void main(String args[])
	{
		List<String> names = Arrays.asList("Henery","John","Daniel","Hope","Rennie","Jason","Mac","Hardy");
		String[] profession = new String[] {"QA","DEV","ARC"};
		List<String> professionList = Arrays.asList(profession);
		
		Long total = names.stream().filter(s->s.contains("e")).count();
		System.out.println(total);
		names.stream().filter(s->s.length()>5).forEach(s->System.out.println(s));
		names.stream().filter(s->s.endsWith("y")).map(s->s.replace('H','M' )).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		names.stream().filter(s->s.startsWith("H")).sorted().forEach(s->System.out.println(s));
		Stream<String> newStream = Stream.concat(names.stream(), professionList.stream());
		//System.out.println(newStream.toList());
		boolean flag = names.stream().anyMatch(s->s.equalsIgnoreCase("Rennie"));
		System.out.println(flag);
		
		List<String> newList = newStream.filter(s->s.contains("e")).collect(Collectors.toList());
		System.out.println(newList.get(2));

	}

	
	}
	

