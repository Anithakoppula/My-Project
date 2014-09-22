package test.Suites;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.apache.bcel.generic.Select;
import org.openqa.selenium.support.ui.Select;
import org.junit.*;

import testBase.TestEssentials;

public class MainPageTest  extends TestEssentials
{	
	
	@BeforeClass
	public static void beforeTest() throws Exception
	{
		System.out.println("Initializing the system");
		initialize();
	}
	     
	     @Test
	     public void AllLinksTest() throws Exception // except sign Ups and Logn lins
	     {
  	 		 driver.findElement(By.cssSelector("a[href='/how-it-works']")).click(); // click on how it works navigation.
		     System.out.println("How it Works link is working good. Cool....");
	    	 Thread.sleep(4000);
	    	 driver.findElement(By.cssSelector("div>a[class='navbar-brand']")).click();
	    	 // click on Assetavenue 
	    	 driver.findElement(By.cssSelector("a[href='/about']")).click(); // About AssetAvenue
	    	 System.out.println("About AssetAvenue link is working good. Cool....");
	    	 Thread.sleep(4000);
	         
	     } 
	     
	     @Test
	     public void SignupAndLoginLinksTest() throws Exception  // all sign up links
	     {
	    	    
	    	 driver.findElement(By.cssSelector("div>a[class='navbar-brand']")).click(); // click home page 
	         // Sign up link in header
	         driver.findElement(By.cssSelector("a[href='/signup']")).click();
	         System.out.println("Sign Up link in header is working good. Cool....");
	         Thread.sleep(4000);	    	  
	        driver.findElement(By.cssSelector("div>a[class='navbar-brand']")).click(); // click home page
   	 		// Sign up link on the main page
        	driver.findElement(By.xpath("/html/body/div[4]/section[1]/div/div[2]/div[1]/a")).click();
        	System.out.println("Sign Up link on the main page is working good. Cool....");
        	Thread.sleep(4000);
        	driver.findElement(By.cssSelector("div>a[class='navbar-brand']")).click(); // click home page
   	 		// Sign up link at the bottom of main page
        	driver.findElement(By.xpath("/html/body/div[4]/section[6]/a")).click();
        	System.out.println("Sign Up link at the bottom of the main page is working good. Cool....");
        	Thread.sleep(4000); 
        	driver.findElement(By.cssSelector("div>a[class='navbar-brand']")).click();
	        driver.findElement(By.cssSelector("a[href='/login']")).click(); // click the login page 
	         System.out.println("Login link working good. Cool....");
	         Thread.sleep(4000);
	         driver.findElement(By.cssSelector("div>a[class='navbar-brand']")).click(); // click home page

	     }  
	     @AfterClass
	     public static void close() throws Exception 
	 	{
	 	  cleanUp();
	 	} 
	 	/*public void closeBrowser() throws Exception{
	 		cleanUp();
	 	}*/
	     
	     
	    }