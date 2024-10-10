import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Files.ReusableMethods;
import Files.payload;

public class FirstClass
{
	public static void main(String args[])
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		System.out.println("**************************************************************************************");
		System.out.println("*****************************Add Place API**************************************");
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payload.addPlace())
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200)
		.body("scope",equalTo("APP")).header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		JsonPath js = ReusableMethods.rawToJson(response);
		String placeID = js.getString("place_id");
		System.out.println("Place_ID is:"+placeID);
		
		System.out.println("**************************************************************************************");
		System.out.println("*****************************Update Place API**************************************");
		
		String newAddress= "78 Sunshine walk, USA";
		
		given().log().all().header("Content-Type","application/json").queryParam("key", "qaclick123")
		.body("{\r\n"
				+ "\"place_id\":\""+placeID+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "")
		.when().put("/maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200)
		.body("msg", equalTo("Address successfully updated")).extract().response().asString();
			
		
		System.out.println("**************************************************************************************");
		System.out.println("*****************************Get Place API**************************************");
		
		String getPlaceResponse = given().queryParam("key", "qaclick123").queryParam("place_id", placeID)
		.when().get("/maps/api/place/get/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(getPlaceResponse);
				
		JsonPath js1 = ReusableMethods.rawToJson(getPlaceResponse);
		String updatedAddress=js1.getString("address");
		System.out.println("Updated address is:"+updatedAddress);
		
	    Assert.assertEquals(newAddress, updatedAddress);
	}
}