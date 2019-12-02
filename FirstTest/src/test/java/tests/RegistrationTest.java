package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import pages.MainPage;

public class RegistrationTest {

    RegistrationPage registrationPage;
    MainPage mainPage;
    WebDriver driver;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/lib/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa2019.itschool.kherson.dataart.com/auth/signup");
        driver.manage().window().maximize();
        registrationPage = new RegistrationPage(driver);
    }


    @Test
    public void testSignUp(){
        mainPage = registrationPage.sign_up("v.salivan3@gmail.com", "Volodymyr", "Sylivanov", "qwerty1!", "qwerty1!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa2019.itschool.kherson.dataart.com/events",
                "Page title is incorrect");

    }


}
