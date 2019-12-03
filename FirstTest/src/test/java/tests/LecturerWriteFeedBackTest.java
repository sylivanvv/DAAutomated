package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TechInterviewsPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LecturerWriteFeedBackTest {
    private LoginPage loginPage;
    private TechInterviewsPage techInterviewsPage;
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
        techInterviewsPage = new TechInterviewsPage(driver);
    }

    @DataProvider
    public Object[][] putFeedback() {
        return new Object[][] {
                new Object[] {"Hello, I am a robot!", "lectureranton@mailinator.com", "QASchool2019!"}
        };
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test(dataProvider = "putFeedback")
    public void editFeedback(String feedback, String email, String password){
        loginPage.login(email, password)
                .clickUserMenu()
                .clickMyTechInt()
                .showFB()
                .editFb(feedback);
        String editedFb = techInterviewsPage.getEditedFb();
        Assert.assertEquals(feedback, editedFb, "FeedBack wasn't changed");

    }

}
