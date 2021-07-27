package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import junit.framework.Assert;
import static org.junit.Assert.*;
import pojo.AddPlace;
import pojo.Location;
import resources.TestDataBuild;
import resources.Utils;

public class stepDefination extends Utils {

	
	RequestSpecification res;
	ResponseSpecification resSpec;
	Response response;
	TestDataBuild data = new TestDataBuild();

	@Given("Add Place Payload")
	public void add_Place_Payload() throws IOException {		
		res = given().spec(requestSpecification()).body(data.AddPlacePayload());

	}

	@When("User calls {string} with Post Http Request")
	public void user_calls_with_Post_Http_Request(String string) {
		resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		response = res.when().post("/maps/api/place/add/json").then().spec(resSpec).extract().response();
	}

	@SuppressWarnings("deprecation")
	@Then("The API call got success with Status Code {int}")
	public void the_API_call_got_success_with_Status_Code(Integer int1) {
		Assert.assertEquals(response.getStatusCode(), 200);
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String KeyValue, String ExpectedValue) {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		System.out.println(js.getString(KeyValue).toString());
		assertEquals(js.getString(KeyValue).toString(), ExpectedValue);
	}

}
