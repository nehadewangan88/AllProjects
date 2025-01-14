package SpecBuilders;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import PoJoPracticeSetters.Location;
import PoJoPracticeSetters.PlaceDetails;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class AddPlaceSpecBuilders {
	
	public static void main(String args[])
	{
		PlaceDetails place = new PlaceDetails();
		Location loc = new Location();
		loc.setLat(-40.383494);
		loc.setLng(23.427362);
		place.setLocation(loc);
		place.setAccuracy(50);
		place.setAddress("29, side layout, cohen 09");
		place.setLanguage("French-IN");
		place.setName("Frontline house USA");
		place.setPhone_number("(+91) 983 893 3937");
		place.setWebsite("http://google.com");
		List<String> newList = new ArrayList<String>();
		newList.add("shoe park");
		newList.add("shop");
		place.setTypes(newList);
		
		
	RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).addQueryParam("key", "qaclick123").build();
	ResponseSpecification res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
	RequestSpecification request = given().spec(req).body(place);
	String response = request.when().post("/maps/api/place/add/json").then().spec(res).extract().response().asString();
	
	System.out.println(response);
	
		
	}

}
