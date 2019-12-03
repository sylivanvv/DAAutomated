package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.RegistrationPage;

public class RegistrationTest {

    RegistrationPage registrationPage;
    WebDriver driver;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/lib/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa2019.itschool.kherson.dataart.com/auth/signup");
        driver.manage().window().maximize();
        registrationPage = new RegistrationPage(driver);
    }

    @DataProvider
    public Object[][] signUpData() {
        return new Object[][] {
                new Object[] {"v.salivan13@gmail.com", "Volodymyr", "Sylivanov", "Qwerty1.33!", "Qwerty1.33!"}
        };
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test(dataProvider = "signUpData")
    public void testSignUp(String email, String firstName, String lastName, String password, String cpassword){
         registrationPage.sign_up(email, firstName, lastName, password, cpassword)
                 .login(email, password);
    }


}
