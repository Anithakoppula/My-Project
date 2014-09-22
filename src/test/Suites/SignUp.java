package test.Suites;
//import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUp {
  private WebDriver driver;
  private String baseUrl;
 // private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://release.assetavenue.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testIDEWebDriver() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Sign Up")).click();
    driver.findElement(By.id("first-name")).clear();
    driver.findElement(By.id("first-name")).sendKeys("anitha");
    driver.findElement(By.id("last-name")).clear();
    driver.findElement(By.id("last-name")).sendKeys("QAPass");
    driver.findElement(By.id("emailAddress")).clear();
    driver.findElement(By.id("emailAddress")).sendKeys("anitha.Qa@sample.com");
    driver.findElement(By.id("country")).clear();
    driver.findElement(By.id("country")).sendKeys("USA");
    new Select(driver.findElement(By.cssSelector("select.form-control.input-lg"))).selectByVisibleText("Accredited - Individual");
    driver.findElement(By.name("individual")).click();
    driver.findElement(By.name("institutionalInvestor")).click();
    driver.findElement(By.name("institutionalInvestor")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("Chandu143ani");
    driver.findElement(By.id("passwordConfirm")).clear();
    driver.findElement(By.id("passwordConfirm")).sendKeys("Chandu143Ani");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

 /*  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }*/
  
}
