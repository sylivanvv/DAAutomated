package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ApllyCvPage;
import pages.MainPage;
import pages.LecturesPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class candidateApplyCVTest {
    private LoginPage loginPage;
    private MainPage mainPage;
    private LecturesPage lecturesPage;
    private ApllyCvPage apllyCvPage;
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
        apllyCvPage = new ApllyCvPage(driver);
    }

    @Test
    public void addLectures(){
        loginPage.login("sergey2019@mailinator.com", "QASchool2019!")
                .clickEventDetails()
                .applyCv()
                .fillApplyForm("C:\\Users\\OLEKSA\\Desktop\\da\\FirstTest\\src\\lib\\photo.jpg",
                "Volodymyr", "Sylivanov","qwerty", "22",
                "October", "1999",  "Kherson", "qwerty2019", "Student",
                "KSU", "Qwerty", "May", "2001", "May",
                "2004", "Native");
        Boolean alert = apllyCvPage.getAlert();
        Assert.assertTrue(alert,  "CV wasn't uploaded");

    }
}
