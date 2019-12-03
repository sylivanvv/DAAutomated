package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
    @AfterClass
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void testSignUp(){
        String email = "v.salivan3@gmail.com";
        String password = "qwerty1!";
         registrationPage.sign_up(email,
                "Volodymyr", "Sylivanov", password, "qwerty1!")
                 .login(email, password);
    }


}
