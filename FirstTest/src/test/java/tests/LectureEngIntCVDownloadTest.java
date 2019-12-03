package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.EngInterviewsPage;
import pages.LoginPage;

import java.nio.file.Path;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LectureEngIntCVDownloadTest {
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
        String MainWindow=driver.getWindowHandle();
        engInterviewsPage = new EngInterviewsPage(driver);
    }
    @DataProvider
    public Object[][] englishCVData() {
        return new Object[][] {
                new Object[] {"lectureranton@mailinator.com", "QASchool2019!"}
        };
    }

    @Test(dataProvider = "englishCVData")
    public void testLogin(String email, String password){
        loginPage.login(email, password)
                .clickUserMenu()
                .clickMyEngInt()
                .clickOpenCV()
                .downloadCV();
    }

}
