package stepDefinition;

import java.io.IOException;

import dataProvider.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetUserByUserID {
	Response response;
	RequestSpecification requestSpec;
	 String baseurl = "https://userapi-8877aadaae71.herokuapp.com/uap";
	@Given("User creates GET Request for user by userid")
	public void user_creates_get_request_for_user_by_userid() {
		
		RestAssured.baseURI= baseurl;
		this.requestSpec = RestAssured.given();
	}

	@When("User sends HTTPS Request with  valid userid")
	public void user_sends_https_request_with_valid_userid() throws IOException {
		this.response = this.requestSpec.when().get(ConfigReader.getProperty("GetAllUsersvalid"));
	}

	

	@Then("User receives {int} status with response body")
	public void user_receives_status_with_response_body(Integer int1) {
		this.response.then().log().all().extract().response();
		response.then().log().all().assertThat().statusCode(int1);
		System.out.println(response.getBody());
	   
	}

	@When("User sends HTTPS Request  with {int}")
	public void user_sends_https_request_with(Integer int1) {
	    
	}

	@When("User sends HTTPS Request  with ")
	public void user_sends_https_request_with() {
	    
	}

	@When("User sends HTTPS Request with  invalid enddpoint")
	public void user_sends_https_request_with_invalid_enddpoint() {
	    
	}

}
