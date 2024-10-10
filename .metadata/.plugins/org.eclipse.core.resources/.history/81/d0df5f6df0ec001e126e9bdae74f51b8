package Files;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class SumOfCoursePrices {
	
	@Test
	public void TotalCoursePrice()
	{
		JsonPath js = new JsonPath(payload.coursePrice());
		System.out.println("*************************************Total Course Price***********************************");
		int sum =0;
		for(int j=0;j<js.getInt("courses.size()");j++)
		{
			int copies = js.getInt("courses["+j+"].copies");
			int price = js.getInt("courses["+j+"].price");
			sum = sum+(copies*price);
		}
		System.out.println(sum);
		Assert.assertEquals(910, sum);
		
		
	}
	
	
}
