package PoJoPracticeGetters;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.*;

import java.lang.reflect.Array;
import java.util.*;

import org.testng.Assert;

public class AllCourses {
	
	static String[] api_course_names = {"Rest Assured Automation using Java","SoapUI Webservices testing"};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String Response = given().formParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
				.formParams("grant_type","client_credentials")
				.formParams("scope","trust")
				.when().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
		JsonPath js = new JsonPath(Response);
		
		String accessToken = js.getString("access_token");
		
		AllDetails cd = given().queryParam("access_token",accessToken)
				.when()
				.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(AllDetails.class);
		System.out.println(cd.getExpertise());
		List <API> api_courses = cd.getCourses().getApi();
		int count = api_courses.size();
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		for(int i=0;i<count;i++)
		{
			if(api_courses.get(i).getCourseTitle().equals("Protractor"))
			{
				System.out.println("Price is:"+api_courses.get(i).getPrice());
			}
			arrayList.add(api_courses.get(i).getCourseTitle());
		}
		
	
		System.out.println(arrayList);
		List<String> newList = Arrays.asList(api_course_names);
		Assert.assertTrue(arrayList.equals(newList));
			
		
	}

}
