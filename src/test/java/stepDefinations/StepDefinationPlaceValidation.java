package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import resouces.APIResouces;
import resouces.TestDataBuild;
import resouces.Utils;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StepDefinationPlaceValidation extends Utils{
	
	RequestSpecification response;
	ResponseSpecification resspec;
	Response res;
	TestDataBuild data = new TestDataBuild();
	static String place_id;

	@Given("Add Place Payload {string} {string} {string}")
	public void add_place_payload(String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		
		 response = given().spec(requestSpecification()).body(data.getAddPlacePayload(name,language, address));
		
				
		
		
	   // throw new io.cucumber.java.PendingException();
	}
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
	    // Write code here that turns the phrase above into concrete actions
		APIResouces resourceAPI = APIResouces.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		System.out.println("Adding this line for git commit from APPlaceFramework");
		 resspec = new ResponseSpecBuilder().expectStatusCode(200)
				 .expectContentType(ContentType.JSON).build();
		 if(method.equalsIgnoreCase("POST")) 
		 res = response.when().post(resourceAPI.getResource());
		 else if(method.equalsIgnoreCase("GET")) 
			 res = response.when().get(resourceAPI.getResource());

			 
		 
	   // throw new io.cucumber.java.PendingException();
	}
	@Then("api call should get success with status code of {int}")
	public void api_call_should_get_success_with_status_code_of(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(res.getStatusCode(), 200);
	   // throw new io.cucumber.java.PendingException();
	}
	@Then("{string} in response body is {string}")
	public void status_in_response_body_is_ok(String keyValue, String expectedValue) {
	    // Write code here that turns the phrase above into concrete actions
		
		assertEquals(getJsonPath(res, keyValue), expectedValue);
		System.out.println(keyValue);
		System.out.println(expectedValue);
		
	   // throw new io.cucumber.java.PendingException();
	}


@Then("verify place_Id created maps to {string} using {string}")
public void verify_place_id_created_maps_to_using(String expectedName, String resourse) throws IOException {
    // Write code here that turns the phrase above into concrete actions
	 place_id = getJsonPath(res, "place_id");
	response = given().spec(requestSpecification()).queryParam("place_id", place_id);
	user_calls_with_http_request(resourse, "GET");
	String actualnName = getJsonPath(res, "name");
	assertEquals(actualnName, expectedName);

}

@Given("DeletePlace Payload")
public void delete_place_payload() throws IOException {
    // Write code here that turns the phrase above into concrete actions
	response = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
}


}
