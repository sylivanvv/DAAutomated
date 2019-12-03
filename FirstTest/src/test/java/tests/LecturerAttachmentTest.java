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
import pages.LecturesPage;


import java.util.concurrent.TimeUnit;

public class LecturerAttachmentTest {
    private LoginPage loginPage;
    private MainPage mainPage;
    private LecturesPage lecturesPage;
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
        lecturesPage = new LecturesPage(driver);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void addLectures(){
        loginPage.login("lectureranton@mailinator.com", "QASchool2019!")
                .clickUserMenu()
                .clickMyLectures()
                .selectLectureFile("C:\\Users\\OLEKSA\\Desktop\\da\\FirstTest\\src\\lib\\lecture.pptx");
        String lectures_alert = lecturesPage.getLectureAlert();
        Assert.assertNotEquals(lectures_alert, "No data", "Lectures wasn't updated");
    }

}
