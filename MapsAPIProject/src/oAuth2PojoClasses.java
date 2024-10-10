import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.List;

import PojoClasses.API;
import PojoClasses.Courses;
import PojoClasses.WebAutomation;
import PojoClasses.courseDetails;

public class oAuth2PojoClasses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String response = given().log().all().formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "trust")
		.when().log().all()
		.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
		
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);
		String accessToken = js.getString("access_token");
		
		courseDetails cd  = given().queryParam("access_token", accessToken)
				.when().log().all().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(courseDetails.class);
		
		System.out.println("Value of cd is:"+cd);
		
		System.out.println(cd.getInstructor());
		System.out.println(cd.getUrl());
		System.out.println(cd.getLinkedIn());
		List <WebAutomation> webAutomationCourses = cd.getCourses().getWebAutomation();
		int count = webAutomationCourses.size();
		for (int i=0;i<count;i++)
		{
			if(webAutomationCourses.get(i).getCourseTitle().equals("Cypress"))
			{
				System.out.println("Cypress Course Price is:"+webAutomationCourses.get(i).getPrice());
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		List <API> apiCourses = cd.getCourses().getApi();
		int apiCourseCount = apiCourses.size();
		for (int j=0;j<apiCourseCount;j++)
		{
			if (apiCourses.get(j).getCourseTitle().equalsIgnoreCase("Rest Assured Automation using Java") || apiCourses.get(j).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
			{
				System.out.println("Course name is:"+apiCourses.get(j).getCourseTitle()+" and the Course price is:"+apiCourses.get(j).getPrice());
			}
		}
		
	}

}
