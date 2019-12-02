package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    LoginPage loginPage;
    MainPage mainPage;
    WebDriver driver;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/lib/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa2019.itschool.kherson.dataart.com/auth/signin");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testLogin(){
        mainPage = loginPage.login("lectureralexey@mailinator.com", "QASchool2019!");
        WebElement user_nav = loginPage.get_user_nav();
        Assert.assertTrue(user_nav.isDisplayed(), "Authorisation has failed");
    }


}
