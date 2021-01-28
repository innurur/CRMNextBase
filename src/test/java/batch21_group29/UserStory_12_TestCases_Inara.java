package batch21_group29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import utility.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class UserStory_12_TestCases_Inara {

    WebDriver driver;

   @BeforeClass
    public void start(){
    driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.get("https://nextbasecrm.com");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

   }


   @BeforeMethod
   public void logIn()  {
       WebElement login = driver.findElement(By.xpath("//a[@href=\"https://login.nextbasecrm.com/\"]"));
       login.click();


       WebElement userName = driver.findElement(By.xpath("//input[@name=\"USER_LOGIN\"]"));
       userName.sendKeys("helpdesk58@cybertekschool.com");

       WebElement password = driver.findElement(By.xpath("//input[@name=\"USER_PASSWORD\"]"));
       password.sendKeys("UserUser");

       sleep(3);

       WebElement loginButton = driver.findElement(By.xpath("//input[@class=\"login-btn\"]"));
       loginButton.click();
   }




   @Test
   public void testing_US1_TC1(){

       WebElement searchButton = driver.findElement(By.xpath("//input[@id='LIVEFEED_search']"));
       searchButton.sendKeys("Automation");

       String keyword = driver.findElement(By.xpath("//div[@id=\"blog_post_body_621\"]")).getText();

       Assert.assertTrue(keyword.contains("Automation"));

   }

   @Test
   public void testing_US1_TC2(){
       WebElement searchFilterButton = driver.findElement(By.xpath("//input[@id='LIVEFEED_search']"));
       searchFilterButton.click();

       WebElement findByDate = driver.findElement(By.xpath("//div[@data-name='DATE_CREATE_datesel']"));
       findByDate.click();

       WebElement buttonThisWeek = driver.findElement(By.xpath("//span[.='This week']"));
       buttonThisWeek.click();

       WebElement searchButton = driver.findElement(By.xpath("//button[@class='ui-btn ui-btn-primary ui-btn-icon-search main-ui-filter-field-button  main-ui-filter-find']"));
       searchButton.click();
   }




   @AfterMethod
   public void lastPart() {

       sleep(3);
      // driver.close();
   }




   @AfterClass
    public void finish(){

   }


   public void sleep(int seconds) {

       try {
           Thread.sleep(seconds * 1000);
       } catch (InterruptedException e){
       e.printStackTrace();
       }

   }

   // still working on userStory 12
    //still practicing branches
}
