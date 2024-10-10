package Files;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {
	
	public static JsonPath rawToJson(String response)
	{
		JsonPath js = new JsonPath(response);
		return js;
	}
	
	

	public static JsonPath rawToJson1(String response1)
	{
		
		JsonPath js1 = new JsonPath(response1);
		return js1;
	}
}
