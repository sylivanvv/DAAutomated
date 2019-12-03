package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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

    @DataProvider
    public Object[][] signInData() {
        return new Object[][] {
                new Object[] {"lectureralexey@mailinator.com", "QASchool2019!"}
        };
    }

    @Test(dataProvider = "signInData")
    public void testLogin(String email, String password){
        mainPage = loginPage.login(email, password);
        WebElement userNav = loginPage.getUserNav();
        Assert.assertTrue(userNav.isDisplayed(), "Authorisation has failed");
    }


}
