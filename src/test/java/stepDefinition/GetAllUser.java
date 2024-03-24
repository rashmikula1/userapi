package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

import java.io.FileNotFoundException;
import java.io.IOException;

import dataProvider.ConfigReader;
public class GetAllUser  {
	Response response;
	RequestSpecification requestSpec;
	 String baseurl = "https://userapi-8877aadaae71.herokuapp.com/uap";
	//static final String baseUrl = ConfigReader.getProperty("base.url");
	
	@Given("User sets basic Authorization")
	public void user_sets_basic_authorization() throws IOException {
	    
		 
		        // Set base URI
		      
		        // Set up basic authentication
		        BasicAuthScheme authScheme = new BasicAuthScheme();
		        authScheme.setUserName(ConfigReader.getProperty("Username")); 
		        authScheme.setPassword(ConfigReader.getProperty("Passwod"));
		        RestAssured.authentication = authScheme;
	}

	@Given("User creates GET Request")
	public void user_creates_get_request() throws FileNotFoundException {
		//RestAssured.baseURI =ConfigReader.getProperty("base.url");
		RestAssured.baseURI= baseurl;
		this.requestSpec = RestAssured.given();
	   
	}

	

	@When("User sends HTTPS Request")
	public void user_sends_https_request() throws IOException {
	  
		this.response = this.requestSpec.when().get(ConfigReader.getProperty("GetAllUsers"));
	}

	@Then("User receives {int} Status with response body")
	public void user_receives_status_with_response_body(Integer int1) {
		
		this.response.then().log().all().extract().response();
		response.then().log().all().assertThat().statusCode(int1);
		System.out.println(response.getBody());
		
	}

	
	@When("User sends HTTPS Request for the user  invalid API endpoint")
	public void user_sends_https_request_for_the_user_invalid_api_endpoint() throws IOException {
		
		this.response = this.requestSpec.when().get(ConfigReader.getProperty("GetAllUsersInvalid"));
	}

	@Then("User receives a {int} status with the response body")
	public void user_receives_a_status_with_the_response_body(Integer int1) {
		
		this.response.then().log().all().extract().response();
		response.then().log().all().assertThat().statusCode(int1);
		System.out.println(response.getBody());
	}
}
