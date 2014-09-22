package test.Suites;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.apache.bcel.generic.Select;
import org.openqa.selenium.support.ui.Select;
import org.junit.*;

public class MainPageSample {
	
			 private static WebDriver driver;
			 private static String baseUrl;
			 private static String browser;
			 
	     @BeforeClass
	     public static void setUp() throws Exception 
	     {
			    
			// read the browser name from console
			System.out.println("Enter the browser you want to test : ");
			Scanner scanIn = new Scanner(System.in); 
			browser = scanIn.nextLine();
		    scanIn.close();
		    baseUrl = "https://www.assetavenue.com/";
		    		    
		    //convert browser string to lower case to pass to switch stmt 
		    browser=browser.toLowerCase();
		    
		    //initialize the driver dynamically 
		    System.out.println("Please wait for the browser....");
		    switch(browser)
		    {
		    case "chrome":
		    	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe"); 
				driver= new ChromeDriver(); 
				break;
		    case "ie":
		    case "internet explorer": 
		    	System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\IEDriverServer.exe"); 
				driver= new InternetExplorerDriver();
				break;
		    case "firefox":
		    	FirefoxBinary binary = new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe")); 
		    	driver = new FirefoxDriver(binary, null);
		    	break;
		    default: System.out.println("Enter the valid browser name please.."); break;	    
		    }
		    // wait 20 sec for the browser to load and to find each element
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	     }
	     /* 
	     @Test
	     public void mainPageTest() throws Exception 
	     {
	       driver.get(baseUrl); //open the baseUrl site
	       driver.manage().window().maximize();   //maximize the browser window 
	       
	    	 
	       driver.switchTo().defaultContent();
	       
	       Following is the code that scrolls through the page
	        for (int second = 0;; second++) {
	            if(second >=60){
	                break;
	            }
	                driver.executeScript("window.scrollBy(0,200)", "");
	                Thread.sleep(3000);
	            }
	            
	     } 
	     /*
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

	     } */ 
	     
	     @Test
	     public void RegisterTest() throws Exception
	     {
	    	 driver.get(baseUrl); //open the baseUrl site
		     driver.manage().window().maximize();   //maximize the browser window 
	     	 driver.findElement(By.cssSelector("div>a[class='navbar-brand']")).click(); //main page
	    	 driver.findElement(By.cssSelector("a[href='/signup']")).click(); //sign up
	    	 driver.findElement(By.id("first-name")).clear();
	    	 driver.findElement(By.cssSelector("input[id='first-name']")).sendKeys("My First Name");
	    	 driver.findElement(By.id("last-name")).clear();
	    	 driver.findElement(By.cssSelector("input[id='last-name']")).sendKeys("My Last Name");
	    	 driver.findElement(By.id("emailAddress")).clear();
	    	 driver.findElement(By.cssSelector("input[id='emailAddress']")).sendKeys("anitha.koppula+4@assetavenue.com");
	    	 driver.findElement(By.id("password")).clear();
	    	 driver.findElement(By.cssSelector("input[id='password']")).sendKeys("aaa111");
	    	 driver.findElement(By.id("passwordConfirm")).clear();
	    	 driver.findElement(By.cssSelector("input[id='passwordConfirm']")).sendKeys("aaa111");
	    	 driver.findElement(By.cssSelector("input[id='phone']")).sendKeys("1234567890");
	    	 Select droplist = new Select(driver.findElement(By.cssSelector("div>select[id='country']")));   
	    	 droplist.selectByVisibleText("Germany");
	    	// new Select(driver.findElement(By.id("country"))).selectByVisibleText("Belarus");
	    	// driver.findElement(By.id("optionsRadios3")).click();  //Non Accredited.
	    	 driver.findElement(By.cssSelector("input[type=\"checkbox\"]")).click();
	    	 //Select radio=new Select(driver.findElement(By.cssSelector("select.form-control.input-lg")));
	    	 //radio.selectByVisibleText("Accredited - Individual");
	         Thread.sleep(4000);
	     }
	     /*
	     @Test 
	     public void userLoginTest()throws Exception
	     {
	    	 //driver.findElement(By.cssSelector("div>a[class='navbar-brand']")).click(); // click home page 
	    	 //Thread.sleep(3000);
		     driver.findElement(By.cssSelector("a[href='/login']")).click(); // click the login page 
		     driver.findElement(By.cssSelector("div>input[id='emailAddress']")).clear(); // click the login page
	         System.out.println("Login link working good. Cool....");

	    	 Thread.sleep(3000);
	    	 //driver.findElement(By.cssSelector("div>input[id='emailAddress']")).clear();
	    	 driver.findElement(By.cssSelector("div>input[id='emailAddress']")).sendKeys("anitha.koppula@assetavenue.com");
	    	 driver.findElement(By.id("password")).clear();
	    	 driver.findElement(By.id("password")).sendKeys("aaa111");
	    	 driver.findElement(By.xpath("//button[@type='submit']")).click();
	    	 Thread.sleep(6000);
  	 	  }
	     */
	    @AfterClass
	     public static void cleanUp() throws Exception 
	     {
	       driver.quit();
	     }
    
    private boolean isElementPresent(By by) {
    try {
    		driver.findElement(by);
    		return true;
        } 
    catch (NoSuchElementException e) {
      return false;
    }
}
}