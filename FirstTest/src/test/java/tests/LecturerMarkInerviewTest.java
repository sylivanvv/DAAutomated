package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.EngInterviewsPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LecturerMarkInerviewTest {
    LoginPage loginPage;
    EngInterviewsPage engInterviewsPage;
    WebDriver driver;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/lib/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa2019.itschool.kherson.dataart.com/auth/signin");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        engInterviewsPage = new EngInterviewsPage(driver);
    }

    @DataProvider
    public Object[][] markInterviewData() {
        return new Object[][] {
                new Object[] {"5", "lectureranton@mailinator.com", "QASchool2019!"}
        };
    }


    @Test(dataProvider = "markInterviewData")
    public void markInterview(String expectedMark, String email, String password){
        loginPage.login(email, password)
                .clickUserMenu()
                .clickMyEngInt()
                .putMark(expectedMark);
        String mark = engInterviewsPage.getMark();
        Assert.assertEquals(mark, expectedMark, "Mark wasn't changed");
    }

}
