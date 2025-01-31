package PoJoPracticeSetters;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddPlace {

	public static void main(String[] args) {
				
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		PlaceDetails place = new PlaceDetails();
		Location loc = new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		place.setLocation(loc);
		place.setAccuracy(50);
		place.setAddress("29, side layout, cohen 09");
		place.setLanguage("French-IN");
		place.setName("Frontline house");
		place.setPhone_number("(+91) 983 893 3937");
		place.setWebsite("http://google.com");
		List<String> newList = new ArrayList<String>();
		newList.add("shoe park");
		newList.add("shop");
		place.setTypes(newList);
		String response = given().queryParam("key","qaclick123").body(place)
		.when().post("/maps/api/place/add/json").asString();
		
		System.out.println(response);
		
		

	}

}
