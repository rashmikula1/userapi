package stepDefinition;

import io.cucumber.java.Before;



public class Hooks {

	
	
	@Before("@Delete")
	public void beforeScenario() throws Exception
	{		//execute this code only when place id is null
		//write a code that will give you place id
		
		User m =new User();
		if(User.userid==null)
		{
		
		m.user_able_to_create_new_user_with_fields_from_with("validpost","post");
		m.user_calls_with_http_request("CreateUserAPI", "POST");
		m.verify_user_id_using("GetuseridAPI", "GET");
		}
		
}

}