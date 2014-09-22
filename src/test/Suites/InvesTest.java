package test.Suites;

import java.io.IOException;

import testBase.*;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvesTest extends TestEssentials{
	
	@BeforeClass																					// page objects pattern  --implement this
	public static void beforeTest() throws IOException
	{
		System.out.println("Initializing the system");
		initialize();
	}

	@Test
	public void investTest()throws Exception
	{
		 if(isLoggedIn())
		{
			
		//click on the Huston properties 
	   	driver.findElement(By.cssSelector("a[href='/property#!/Houston-Commercial-Office-Loan']")).click();
	   	Thread.sleep(1000);
	   	// click invest
	   	driver.findElement(By.cssSelector("a[class='btn btn-primary btn-block btn-lg']")).click();
	   	//Thread.sleep(1000);	
	   	//driver.findElement(By.cssSelector("Select [class='form-control input-lg']"));
	   	
	   	// Select the option from drop down-Who own this investment	
	   	//Select droplist = new Select(driver.findElement(By.cssSelector("select [class='form-control input-lg']")));   
	   	///html/body/div[4]/section/div/div[2]/div[1]/div[1]/div/span/span[2]/span[1]/select"
	   	Select droplist = new Select(driver.findElement(By.cssSelector("span > select.form-control.input-lg")));
	   	droplist.selectByValue("individual");
	   	Thread.sleep(1000);
	   	droplist = new Select(driver.findElement(By.xpath("//span[2]/select")));
	   	droplist.selectByVisibleText("Anitha QA / checking / ********3456");
	   	
	   	
	   	
	   	// Handle the invisible element --- investment Amount
	   	//Thread.sleep(1000);
	   	// Explicit wait 15sec for element to be visible 
	   	int amount=6000;
	   	WebDriverWait wait = new WebDriverWait(driver, 30);
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='invest']")));
	   	driver.findElement(By.cssSelector("input[id='invest']")).sendKeys(""+amount);
	   	
	   	/* Javascript code to handle hidden text elements.---First of all to change the value of type attribute as text from hidden
	   	JavascriptExecutor jse = (JavascriptExecutor)driver;
	   	jse.executeScript("document.getElementsByName('body')[0].setAttribute('type', 'text');");  // this changes the type='hidden' to type='text'
	   	driver.findElement(By.xpath("//input[@name='body']")).clear();
	   	driver.findElement(By.xpath("//input[@name='body']")).sendKeys("Ripon"); */
	   	
	   	
	   	System.out.println("Good upto investment Amount...hoping best");
	   	// Add electronic signature code later
	   	
	   	  driver.findElement(By.cssSelector("div.col-sm-6 > div.checkbox > label > input[type=\"checkbox\"]")).click();
	   	 // driver.findElement(By.cssSelector("input[type='checkbox')).click();
	   	 
	   	 driver.findElement(By.id("password")).clear();
	   	 driver.findElement(By.id("password")).sendKeys("aaa111");
		 Thread.sleep(1000);	

	   	// button[class='btn-complete btn btn-primary btn-lg']    or button[type='submit']
		 driver.findElement(By.xpath("(//button[@type='submit'])[5]")).click();

	   	 //driver.findElement(By.cssSelector("button[type='submit']")).click();

	   	Thread.sleep(3000);
		}
		else
		System.out.println("Please Login first to Investing on any property...");
		 //cleanUp();
	}
	
	// quit the browser 	
	@After
	public void cleanUp() throws Exception 
	{
		logout();
	  System.out.println("Closing the browser...");
		driver.quit();
	} 
}
