package payload;

import java.util.Map;


import dataProvider.ExcelReader;
import pojo.User;
import pojo.UserAddress;
public class CreateUserPayload {

	public User createUserPayLoad(String s, String s1) throws Exception
	{
		User c=new User();
		
	
		 Map<String, String> excelDataMap = null;
		 excelDataMap = ExcelReader.getData(s,s1 );
		 if (null != excelDataMap && excelDataMap.size() > 0)
		 {
		
	     c.setUser_first_name(( excelDataMap).get("FirstName"));
		c.setUser_last_name(excelDataMap.get("LastName"));
		c.setUser_email_id(excelDataMap.get("emailid"));
		c.setUser_contact_number(excelDataMap.get("contactnumber"));
		
		UserAddress a = new UserAddress();
		a.setPlotNumber(excelDataMap.get("plotnumber"));
		a.setCountry(excelDataMap.get("country"));
		a.setState(excelDataMap.get("state"));
	   a.setStreet(excelDataMap.get("street"));
	    a.setZipCode(excelDataMap.get("zipcode"));	
	    c.setUserAddress(a);
		
		
	}
		return c;
}
}