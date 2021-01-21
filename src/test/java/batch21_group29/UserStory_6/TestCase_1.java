package batch21_group29.UserStory_6;


import batch21_group29.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase_1 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://nextbasecrm.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void login() {
        WebElement login = driver.findElement(By.xpath("//a[@href=\"https://login.nextbasecrm.com/\"]"));
        login.click();

        WebElement userName = driver.findElement(By.xpath("//input[@class='login-btn']"));
        userName.sendKeys("helpdesk58@cybertekschool.com");

        WebElement passWord = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passWord.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginButton.click();


    }


    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);
        driver.close();
    }
}
