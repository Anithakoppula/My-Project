package test.Suites;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Sample {

	public static void main(String[] args) {
		WebDriver driver;
		System.out.println("opening the browser, please wait....");
		/*FirefoxBinary binary = new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe")); 
    	driver = new FirefoxDriver(binary, null);*/
		/*System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe"); 
		driver= new ChromeDriver(); */
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\IEDriverServer.exe"); 
		driver= new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.assetavenue.com/");
		driver.manage().window().maximize();
		driver.close();
		}

}
