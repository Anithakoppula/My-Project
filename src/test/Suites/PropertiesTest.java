package test.Suites;
import java.io.IOException;
import java.util.Scanner;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import testBase.*;
public class PropertiesTest extends TestEssentials{
																										// scroll down screen slowly with JS code
	@BeforeClass																					// Navigate to the previous page using selenium
																								// remove read data from console, but implement click all the links
	public static void beforeTest() throws IOException
	{
		System.out.println("Initializing the system");
		initialize();
	}
	
	@Test
	public void singlePropertyTest()throws Exception
	{
		 if(isLoggedIn())
		{
			 System.out.println("Property Locations:\n\tNew York\n\tChicago\n\tHouston\n\tAustin \nEnter the location of the Property you want to see ::");
				Scanner scanIn = new Scanner(System.in);
				String selectProperty = scanIn.nextLine();
			    scanIn.close();    
			    switch(selectProperty.toUpperCase())
			    {
			    		case "NEW YORK": 
			    			driver.findElement(By.cssSelector("a[href='/property#!/Trump-Palace-Medical-Office-Loan']")).click();
			    			Thread.sleep(5000);
			    			break;
			    		case " CHICAGO":
			    			driver.findElement(By.cssSelector("a[href='/property#!/Chicago-Apartment-Building-Loan']")).click();
			    			Thread.sleep(5000);
			    			break;
			    		case " HOUSTON":
			    			driver.findElement(By.cssSelector("a[href='/property#!/Houston-Commercial-Office-Loan']")).click();
			    			Thread.sleep(5000);
			    			break;
			    		case " AUSTIN":
			    			driver.findElement(By.cssSelector("a[href='/property#!/Austin-Flex-Industrial-Building-Loan']")).click();
			    			Thread.sleep(5000);
			    			break;
			    }
          }
		 else
				System.out.println("Please Login first to see the properties...");
	}
	
	@After
	public void cleanUp() throws Exception 
	{
		logout();
	  System.out.println("Closing the browser...");
		driver.quit();
	} 
}
