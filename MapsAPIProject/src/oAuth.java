import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class oAuth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String response = given().log().all().formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "trust")
		.when().log().all()
		.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asPrettyString();
		
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);
		String accessToken = js.getString("access_token");
		
		String response2 = given().queryParam("access_token", accessToken)
				.when().log().all().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
				.asString();
		
		System.out.println(response2);
	}

}
