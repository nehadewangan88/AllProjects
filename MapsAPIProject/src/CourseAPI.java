import org.testng.Assert;

import Files.payload;
import io.restassured.path.json.JsonPath;

public class CourseAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js2 = new JsonPath(payload.coursePrice());
		System.out.println("*************************************Course Count***********************************");
		int courseCount = js2.getInt("courses.size()");
		System.out.println("Number of Courses offered is:"+ courseCount);
		int totalAmount = js2.getInt("dashboard.purchaseAmount");
		System.out.println("Total Purchase Amount is:"+totalAmount);
		String firstCourse =js2.getString("courses[0].title");
		System.out.println("First Course Name is:"+firstCourse);
		System.out.println();
		System.out.println("*************************************Title and Price of all the Courses***********************************");
		for (int i=0;i<courseCount;i++)
		{
			String title = js2.getString("courses["+i+"].title");
			int price = js2.getInt("courses["+i+"].price");
			System.out.println("Title of Course No."+(i+1)+" is:"+title);
			System.out.println("Price of Course No."+(i+1)+" is:"+price);
		}
		
		System.out.println();
		System.out.println("*************************************Total Course Price***********************************");
		int sum =0;
		for(int j=0;j<courseCount;j++)
		{
			int copies = js2.getInt("courses["+j+"].copies");
			int price = js2.getInt("courses["+j+"].price");
			sum = sum+(copies*price);
		}
		System.out.println(sum);
		Assert.assertEquals(totalAmount, sum);
	}

}
