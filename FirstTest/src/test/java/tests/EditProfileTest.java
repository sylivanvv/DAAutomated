package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class EditProfileTest {
    private LoginPage loginPage;
    private MyProfilePage myProfilePage;
    private WebDriver driver;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/lib/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa2019.itschool.kherson.dataart.com/auth/signin");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        myProfilePage = new MyProfilePage(driver);
    }

    @Test
    public void addLectures(){
        String photopath = "C:\\Users\\OLEKSA\\Desktop\\da\\FirstTest\\src\\lib\\photo.jpg";
        String firstname = "John";
        String lastname = "Doe";
        String phonumber = "94567890";
        String city = "Kherson";
        String skype = "johndoe";
        loginPage.login("sergey2019@mailinator.com", "QASchool2019!")
                .clickUserMenu()
                .clickMyProfile()
                .clickeditProfile()
                .editProfile(photopath, firstname, lastname, city, skype);

    }
}
