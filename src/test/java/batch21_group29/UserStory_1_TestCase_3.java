package batch21_group29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import utility.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class UserStory_1_TestCase_3 {
    WebDriver driver;

    @BeforeClass
    public void start(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://nextbasecrm.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @BeforeMethod
    public void login() throws InterruptedException {
        WebElement login = driver.findElement(By.xpath("//a[@href=\"https://login.nextbasecrm.com/\"]"));
        login.click();

        String expectedResult = "Authorization";
        String actualResult = driver.findElement(By.xpath("//div[.='Authorization']")).getText();

        Assert.assertEquals(expectedResult,actualResult, "Login page is not displayed");


        ///////////////////////////////////////////////////////////////////////////////////////


        WebElement userName = driver.findElement(By.xpath("//input[@name=\"USER_LOGIN\"]"));
        userName.sendKeys("helpdesk58@cybertekschool.com");

    }


    @Test
    public void testing() throws InterruptedException {
        Thread.sleep(3000);


        WebElement forgotPasswordButton = driver.findElement(By.xpath("//a[@class=\"login-link-forgot-pass\"]"));
        forgotPasswordButton.click();


        WebElement actualResult = driver.findElement(By.xpath("//button[.='Reset password']"));

        Assert.assertTrue(actualResult.isDisplayed());


    }

    @AfterMethod
    public void logout(){

    }

    @AfterClass
    public void finish () throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
