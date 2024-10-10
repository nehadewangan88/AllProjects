package stepDefinations;
import static org.junit.Assert.*;
import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import PojoClasses.Location;
import PojoClasses.PlaceDetails;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinations extends Utils{
	//RequestSpecification req;
	ResponseSpecification res;
	RequestSpecification request ;
	Response response;
	TestDataBuild data = new TestDataBuild();
	@Given("Add Place Payload with {double} {double} {string} {string}")
	public void add_place_payload_with(double lat, double lng, String name, String address) throws IOException {
		
		request = given().spec(requestSpecification()).body(data.addPlacePayload(lat,lng,name,address));
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_api_with_http_request(String resource, String method) {
		
		APIResources requiredResource = APIResources.valueOf(resource);
		System.out.println(requiredResource.returnResource());
		
		res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
		if(method.equalsIgnoreCase("POST"))
			response = request.when().post(requiredResource.returnResource());
		else if (method.equalsIgnoreCase("GET"))
			response = request.when().get(requiredResource.returnResource());
		else if (method.equalsIgnoreCase("DELETE"))
			response = request.when().delete(requiredResource.returnResource());
			}

	@Then("API call got success with status code {int}")
	public void api_call_got_success_with_status_code(Integer int1) {
	   assertEquals(response.getStatusCode(),200);	
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {
	    String resp = response.asString();
	    JsonPath js = new JsonPath(resp);
	    assertEquals(js.get(keyValue).toString(),expectedValue);
	}



}
