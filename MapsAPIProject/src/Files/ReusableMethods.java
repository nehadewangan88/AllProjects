package Files;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReusableMethods {
	
	public static JsonPath rawToJson(String resp)
	{
		JsonPath js = new JsonPath(resp);
		return js;
	}
	
	

	public static JsonPath rawToJson1(String response1)
	{
		
		JsonPath js1 = new JsonPath(response1);
		return js1;
	}
}
