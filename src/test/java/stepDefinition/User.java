package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;



import java.io.IOException;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import payload.CreateUserPayload;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import dataProvider.Utils;
import endpoints.APIResources;
import io.restassured.path.json.JsonPath;

public class User extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	CreateUserPayload cr= new CreateUserPayload();
	static String userid;
	static String userfirstname;
	
	@Given("User able to create new User with fields from {string} with {string}")
	public void user_able_to_create_new_user_with_fields_from_with(String string, String string2) throws Exception {

		res=given().spec(requestSpecification()).body(cr.createUserPayLoad("validpost","post"));
	   
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		
		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if(method.equalsIgnoreCase("POST"))
		 response =res.when().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
			 response =res.when().get(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("DELETE"))
			 response =res.when().delete(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("PUT"))
			 response =res.when().put(resourceAPI.getResource());
		
	   
	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(int int1) {
		response.then().log().all();
		
		int int2= response.getStatusCode();
		assertEquals(int2,int1);

		//assertEquals(response.getStatusCode(),int1);
		
		//userid=getJsonPath(response,"user_id");
		//userfirstname=getJsonPath(response,"user_first_name");
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String string, String string2) {
	    
	}

	@Then("verify user  {string} using {string}")
	public void verify_user_id_using(String resource, String string1) throws IOException {
		
		userid=getJsonPath(response,"user_id");
		 res=given().spec(requestSpecification()).pathParam("userId",userid);
		 user_calls_with_http_request(resource,"GET");
		userfirstname=getJsonPath(response,"user_first_name");
	   
	}

	@Given("User able to delete new User")
	public void user_able_to_create_new_user() throws IOException {
	    
		res=given().spec(requestSpecification()).pathParam("userId",userid);
		 
	}
	
	@Given("User able to update new User")
	public void user_able_to_update_new_user() throws Exception {
	    
		res=given().spec(requestSpecification()).pathParam("userId",userid).body(cr.createUserPayLoad("validput","put"));
		
		 
	}
	@Given("User able to get  User by name")
	public void user_able_to_get_user_by_name() throws Exception {
	    
		res=given().spec(requestSpecification()).pathParam("userFirstName",userfirstname);
		
		 
	}
	@Given("User able to get all User")
	public void user_able_to_get_all_user() throws Exception {
	    
		res=given().spec(requestSpecification());
		
		 
	}

}


