package batch21_group29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class UserStory_1_TestCase_1 {

    WebDriver driver;

    @BeforeMethod
    public void start (){
    driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.get("https://nextbasecrm.com");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }



    @Test
    public void testing_US1_TC1() throws InterruptedException {
        WebElement login = driver.findElement(By.xpath("//a[@href=\"https://login.nextbasecrm.com/\"]"));
        login.click();

        String expectedResult = "Authorization";
        String actualResult = driver.findElement(By.xpath("//div[.='Authorization']")).getText();

        Assert.assertEquals(expectedResult,actualResult, "Login page is not displayed");


        ///////////////////////////////////////////////////////////////////////////////////////


        WebElement userName = driver.findElement(By.xpath("//input[@name=\"USER_LOGIN\"]"));
        userName.sendKeys("helpdesk58@cybertekschool.com");

        WebElement password = driver.findElement(By.xpath("//input[@name=\"USER_PASSWORD\"]"));
        password.sendKeys("UserUser");

        Thread.sleep(3000);

        WebElement loginButton = driver.findElement(By.xpath("//input[@class=\"login-btn\"]"));
        loginButton.click();


        String expectedCRMpage = "CRM" ;
        String actualCRMpage = driver.findElement(By.xpath("//span[@class='logo-text']")).getText();

        Assert.assertEquals(expectedCRMpage,actualCRMpage, "CRM page is not displayed");
    }




    @AfterMethod
    public void finish () throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
