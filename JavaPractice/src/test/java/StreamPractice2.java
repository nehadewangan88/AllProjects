import java.util.ArrayList;

import org.testng.annotations.Test;

public class StreamPractice2 {
	
	@Test
	public void getResults()
	{
		ArrayList<String> array = new ArrayList();
		array.add("Happy");
		array.add("Beena");
		array.add("Cruise");
		array.add("Benny");
		array.add("Whale");
		array.add("Finn");
		array.add("Dale");
		array.add("Denny");
		array.add("Billy");
		
		Long countWithD = array.stream().filter(s->s.startsWith("B")).count();
		System.out.println(countWithD);
		System.out.println(array.stream().filter(s->s.endsWith("y")).count());
		array.stream().filter(s->s.length()==5).forEach(s->System.out.println(s));
		array.stream().filter(s->s.length()==4).limit(1).forEach(s->System.out.println(s));
		
				}

}
