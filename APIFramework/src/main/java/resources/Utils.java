package resources;
import java.io.IOException;
import java.io.PrintStream;
import java.io.FileInputStream;
import java.util.Properties;

import io.restassured.RestAssured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification req;
	
	public static String getGlobalValues(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\nehad\\eclipse-workspace\\APIFramework\\src\\main\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public RequestSpecification requestSpecification() throws IOException
	{
		if(req==null)
		{
			PrintStream log = new PrintStream("logging.txt");
			req = new RequestSpecBuilder().setBaseUri(getGlobalValues("baseUrl"))
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).
					setContentType(ContentType.JSON).addQueryParam("key", "qaclick123").build();
			return req;
		}
		return req; 
	}
	
	
}
