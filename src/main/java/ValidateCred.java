package main.java;

public class ValidateCred {
 
	public boolean validate(String username, String password)
	{
		
		if((username.length()>3) && (password.length()>2))
		{
			return true;
		}
		
		return false;
		
		
	}
}
