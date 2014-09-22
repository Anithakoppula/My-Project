package test.Suites;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import testBase.*;

public class LoginTest extends TestEssentials 
{	
	
	@BeforeClass
	public static void beforeTest() throws Exception
	{
		System.out.println("Initializing the system");
		initialize();
	}
	
	
	@Test
    public void loginTest()throws Exception
    {
		
       if(isLoggedIn())
    	    System.out.println("Login successful:");
       else
    	   System.out.println("Login Failied:");
    }
		
	@Test
    public void logoutTest()throws Exception
    {	
			//if(isLoggedIn)
				driver.findElement(By.linkText("Logout")).click();
		System.out.println("Logout Successful");
		Thread.sleep(5000);

    }
	
	@AfterClass
	public static void close() 
	{
	  cleanUp();
	}  
	

}
