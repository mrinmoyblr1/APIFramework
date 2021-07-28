package stepDefinations;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;
import static org.junit.Assert.*;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;
public class stepDefination extends Utils {
	RequestSpecification res;
	ResponseSpecification resSpec;
	Response response;
	TestDataBuild data = new TestDataBuild();
	
	
	@Given("Add Place Payload {string} {string} {string}")
	public void add_Place_Payload(String name, String language, String address) throws IOException {
		res = given().spec(requestSpecification()).body(data.AddPlacePayload(name, language, address));
	}
	
		
	
	@When("User calls {string} with {string} http Request")
	public void user_calls_with_http_Request(String resource, String method) {
		// Constructor will be called with the value of resource which I will pass
		APIResources resourceAPI = APIResources.valueOf(resource);		
		System.out.println(resourceAPI.getResource());
		
		
		resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if (method.equalsIgnoreCase("POST")) {
			response = res.when().post(resourceAPI.getResource());
		} else if (method.equalsIgnoreCase("GET")) {
			response = res.when().get(resourceAPI.getResource());
		}
		// .then().spec(resSpec).extract().response();
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
