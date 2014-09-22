package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import config.*;

// This class is contains the reusable methods like initialize the browser, baseurl, login and isLoggedin
public class TestEssentials{
	
	// initializing the property file reading
	public static String baseurl;
	public static WebDriver driver=null;;
	public static Properties CONFIG=null;
	public static boolean isLoggedIn=false;
	public static String currentUrl=null;
	
	// initalise the Driver based on the browser and get the base url
	public static void initialize() throws Exception
	{
		// read browser name from the CONFIG properties file
		CONFIG= new Properties();
		FileInputStream fn =new FileInputStream(System.getProperty("user.dir")+"//src//config//config.properties");
		CONFIG.load(fn);
		//initialize the browser
	  switch(CONFIG.getProperty("browser").toLowerCase())
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
			//driver= new FirefoxDriver();
			break;
		default: System.out.println("Enter the valid browser name please.."); break;	    
    }
	  // open the url in the browser
	  driver.get(baseurl=CONFIG.getProperty("testSiteName"));
	  Thread.sleep(5000);
      driver.manage().window().maximize();   //maximize the browser window 


    }
	public static void login() throws Exception
	{
		driver.findElement(By.cssSelector("a[href='/login']")).click(); // click the login page
		currentUrl=driver.getCurrentUrl();
		
		System.out.println("Current URL after click on Login:  " +currentUrl);
        System.out.println("Login link working good. Cool....");
        driver.findElement(By.id("emailAddress")).clear();
        driver.findElement(By.id("emailAddress")).sendKeys("anitha.koppula+cooled@gmail.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("abcd123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //System.out.println("Login successful");
        Thread.sleep(5000);
	}
	public static boolean isLoggedIn() throws Exception
	{
		login();
		if(currentUrl.equals(driver.getCurrentUrl()))
			return false;
		else
			return true;		
	}
	
	public static void cleanUp()
	{
		System.out.println("Closing the browser...");
 		driver.quit();
	}
}
