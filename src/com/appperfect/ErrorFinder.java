package com.appperfect;

public class ErrorFinder 
{
	public static String errorMsg;
	public ErrorFinder()
	{
		
	}
	public static void setError(String errorMsg)
	{
		ErrorFinder.errorMsg=errorMsg;
	}
	public String getError()
	{
		return ErrorFinder.errorMsg;
	}
	public static boolean validateRequired(String driver,String url,String username,String password,String query)
	{
		if(driver==null||driver.isEmpty())
		{
			System.out.println("driver name is required");
			setError("driver name is required");
			return false;
		}
		if(url==null||url.isEmpty())
		{
			System.out.println("url is required");
			setError("url is required");
			return false;
		}
		if(username==null||username.isEmpty())
		{
			System.out.println("username is required");
			setError("username is required");
			return false;
		}
		if(password==null||password.isEmpty())
		{
			System.out.println("password is required");
			setError("password is required");
			return false;
		}
		if(query==null||query.isEmpty())
		{
			System.out.println("query cannot be empty");
			setError("query cannot be empty");
			return false;
		}
		return true;
	}
public static void findError(Exception e) {
	//String error=e.toString();
	e.printStackTrace();
	setError(e.getMessage());
	/*if(error.contains("ClassNotFound"))
	{
		setError("Incorrect Driver");
		return;
	
	}
	if(error.contains("No suitable driver found"))
	{
		setError("Something wrong with url, system cannot access it with current driver");
		return;
	}
	if(error.contains("Access denied for user"))
	{
		setError("Something wrong with username or password, Enter correct username, password");
		return;
	}
	if(error.contains("MySQLSyntaxErrorException"))
	{
		setError("Something wrong with your Query check syntax and enter correct query");
		return;
	}
	if(error.contains("No tables used"))
	{
		setError("Mention tables in your query ");
		return;
	}
	else
	{
		setError(e.toString());
	}
	*/

}

}
