package EComApplication;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import io.restassured.RestAssured;

public class E2Eecomprocess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUserEmail("nehadewangan88@gmail.com");
		loginRequest.setUserPassword("Neha@1988");
		RequestSpecification request = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
	//	ResponseSpecification response = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		RequestSpecification loginReq = given().relaxedHTTPSValidation().spec(request).body(loginRequest);
		LoginResponse loginRes = loginReq.when().post("/api/ecom/auth/login").then().extract().response().as(LoginResponse.class);
		String logRes = loginRes.toString();
		String token = loginRes.getToken();
		String user = loginRes.getUserId();
		//System.out.println(loginRes.getUserId());
		//System.out.println(loginRes.getToken());
		Assert.assertEquals("Login Successfully", loginRes.getMessage());
		
	//	********************************************************Add Product*******************************************************
		
		RequestSpecification appProductBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization", token).build();
		
		RequestSpecification addProduct = given().spec(appProductBaseReq).formParam("productName", "Hair Band").formParam("productAddedBy", user)
				.formParam("productCategory", "fashion").formParam("productSubCategory", "Hair Accessories")
				.formParam("productPrice", "200").formParam("productDescription", "HnM Hair Band").formParam("productFor", "Women")
			.multiPart("productImage", new File("C:\\Users\\nehad\\Pictures\\Screenshots\\hairband.png"));
		
		String response = addProduct.when().post("api/ecom/product/add-product").then().extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		System.out.println(response);
		String productId = js.getString("productId");
		
	
		
		//*******************************************************Create Order*****************************************************
		
		RequestSpecification createOrderBaseReq=	new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token).setContentType(ContentType.JSON)
				.build();
		OrderDetails orderDetail = new OrderDetails();
		orderDetail.setCountry("India");
		orderDetail.setProductOrderedId(productId);
		
		List<OrderDetails> orderDetailList = new ArrayList<OrderDetails> ();
		orderDetailList.add(orderDetail);	
		Orders orders = new Orders();
		orders.setOrders(orderDetailList);
		
	RequestSpecification createOrderReq=given().log().all().spec(createOrderBaseReq).body(orders);

	String responseAddOrder = createOrderReq.when().post("/api/ecom/order/create-order").then().log().all().extract().response().asString();
	System.out.println(responseAddOrder);
	JsonPath js1= new JsonPath(responseAddOrder);
	String orderId = js1.getString("productOrderId");
	
	//*************************************************Delete Order***************************************
	
		RequestSpecification deleteOrderRequest = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization", token).build();
		
		String deleteOrderResponse = given().pathParam("orderId",orderId).spec(deleteOrderRequest).when().delete("/api/ecom/order/delete-order/{orderId}").then().extract()
				.response().asString();
		System.out.println(deleteOrderResponse);
	
	//*************************************************Delete Product***************************************

	RequestSpecification deleteProdBaseReq=	new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
	.addHeader("authorization", token).setContentType(ContentType.JSON)
	.build();

	RequestSpecification deleteProdReq =given().log().all().spec(deleteProdBaseReq).pathParam("productId",productId);

	String deleteProductResponse = deleteProdReq.when().delete("/api/ecom/product/delete-product/{productId}").then().log().all().
	extract().response().asString();

	JsonPath js2 = new JsonPath(deleteProductResponse);

	Assert.assertEquals("Product Deleted Successfully",js2.get("message"));
	
	




		
		
		
	}	

}
