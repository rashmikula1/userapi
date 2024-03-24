package endpoints;

public enum APIResources {
	
	CreateUserAPI("/createusers"),
	GetuseridAPI("/user/{userId}"),
	DeleteUserAPI("/deleteuser/{userId}"),
	UpdateUserAPI("/updateuser/{userId}"),
	GetUserNameAPI("/users/username/{userFirstName}"),
	GetUserAPI("/users");
	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}

}
