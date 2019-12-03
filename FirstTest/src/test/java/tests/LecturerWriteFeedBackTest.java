package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.TechInterviewsPage;
import pages.LecturesPage;
import pages.LoginPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class LecturerWriteFeedBackTest {
    private LoginPage loginPage;
    private MainPage mainPage;
    private LecturesPage lecturesPage;
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

    @Test
    public void editFeedback(){
        String fb = "Hello, I am a robot!";
        loginPage.login("lectureranton@mailinator.com", "QASchool2019!")
                .clickUserMenu()
                .clickMyTechInt()
                .showFB()
                .editFb(fb);
        String editedFb = techInterviewsPage.getEditedFb();
        Assert.assertEquals(fb, editedFb, "FeedBack wasn't changed");

    }

}
