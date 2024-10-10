import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.ReusableMethods;
import Files.payload;

public class AddBook {
	@Test(dataProvider="BooksData")
	public void addBook(String isbn, String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
		String resp = given().log().all().header("Content-Type","application/json")
		.body(payload.addBook(isbn,aisle))
		.when()
		.post("Library/Addbook.php")
		.then().log().all().statusCode(200).extract().response().asString();
		
		
		JsonPath js =ReusableMethods.rawToJson(resp);
		String bookID = js.getString("ID");
		String msg = js.getString("Msg");
		System.out.println("Book Id is:"+bookID);
		Assert.assertEquals(msg, "successfully added");
		
	}
	public void deleteBook(String bookID)
	{
		
		String response = given().header("Content-Type","application/json")
				.body(payload.delBook(bookID))
				.when().post("/Library/DeleteBook.php")
				.then().log().all().statusCode(200).extract().response().asString();
	
		
	}
	
	
	@DataProvider(name="BooksData")
	public Object[][] getData()
	{
		return new Object[][] {{"ab1dd","7839"},{"t3dyi","8490"},{"udiwp","11210"}};
	}
	

	
}
