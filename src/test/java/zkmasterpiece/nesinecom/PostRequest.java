package zkmasterpiece.nesinecom;

import static io.restassured.RestAssured.given;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import zkmasterpiece.tests.BaseTest;

public class PostRequest extends BaseTest {

	
	//Method to POST json
	public void request(JsonObject jsonObject) {

//		RestAssured.baseURI = "https://www.nesine.com";
//		Response response = given().queryParam("eventType", 1).body(jsonObject).when().post("/Iddaa/PopularBetsModal");
//		ResponseBody body = response.getBody();
//		System.out.println(body.asString());
	}

}