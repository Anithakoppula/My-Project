package test.Suites;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

import testBase.TestEssentials;
public class RegisterTest  extends TestEssentials
{

	@BeforeClass
	public static void beforeTest() throws IOException
	{
		System.out.println("Initializing the system");
		initialize();
	}
	
	@Test
	public void signUpTest() throws Exception
    {
   	 //driver.get(baseurl); //open the baseUrl site
	     driver.manage().window().maximize();   //maximize the browser window 
    	 driver.findElement(By.cssSelector("div>a[class='navbar-brand']")).click(); //main page
   	 driver.findElement(By.cssSelector("a[href='/signup']")).click(); //sign up
   	 driver.findElement(By.id("first-name")).clear();
   	 driver.findElement(By.cssSelector("input[id='first-name']")).sendKeys("Anitha");
   	 driver.findElement(By.id("last-name")).clear();
   	 driver.findElement(By.cssSelector("input[id='last-name']")).sendKeys("Automate SignUp");
   	 driver.findElement(By.id("emailAddress")).clear();
   	 driver.findElement(By.cssSelector("input[id='emailAddress']")).sendKeys("anitha.qa+6@assetavenue.com");
   	 driver.findElement(By.id("password")).clear();
   	 driver.findElement(By.cssSelector("input[id='password']")).sendKeys("aaa111");
   	 driver.findElement(By.id("passwordConfirm")).clear();
   	 driver.findElement(By.cssSelector("input[id='passwordConfirm']")).sendKeys("aaa111");
   	 driver.findElement(By.cssSelector("input[id='phone']")).sendKeys("1234567890");
   	 
   	 Select droplist = new Select(driver.findElement(By.cssSelector("select[id='country']")));   
   	 droplist.selectByVisibleText("Germany");
   	// new Select(driver.findElement(By.id("country"))).selectByVisibleText("Belarus");
   	driver.findElement(By.id("optionsRadios3")).click();  //Non Accredited.
   	
   	 driver.findElement(By.cssSelector("input[type=\"checkbox\"]")).click();
   	 //Select radio=new Select(driver.findElement(By.cssSelector("select.form-control.input-lg")));
   	 //radio.selectByVisibleText("Accredited - Individual");
        Thread.sleep(10000);
    }
	@After
	public void cleanUp() throws Exception 
	{
	  System.out.println("Closing the browser...");
		driver.quit();
	} 
}
