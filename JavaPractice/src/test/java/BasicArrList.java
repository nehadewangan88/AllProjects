import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class BasicArrList {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

		ArrayList<String> arr = new ArrayList<String>();
		
		arr.add("Course 1 : Java");
		arr.add("Course 2 : Selenium");
		System.out.println(arr);
		arr.remove(1);
		System.out.println(arr);
		arr.add("Course 2 : C++");
		arr.add("Course 3 : C#");
		arr.add("Course 4 : Python");
		arr.add("Course 5 : Basic");
		arr.add("Course 6 : Selenium");
		for (int i=0;i<arr.size();i++)
		{
			System.out.println(arr.get(i));
		}
		
		for (String val : arr)
		{
			System.out.println(val);
		}
		String [] a = {"Hello","Hi","Morning"};
		List<String> newArr = Arrays.asList(a);
		System.out.println(newArr.contains("Morning"));
		
		BasicArrList bal = new BasicArrList();
		String methodName= bal.stringMethod();
		System.out.print(methodName);
		
	}
	
	public String stringMethod()
	{
		System.out.print( "Hello World!!!");
		return "stringMethod Method!!";
	}






}