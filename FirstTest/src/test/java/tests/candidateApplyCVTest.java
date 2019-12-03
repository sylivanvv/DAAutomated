package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ApllyCvPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class candidateApplyCVTest {
    private LoginPage loginPage;
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

    @DataProvider
    public Object[][] CVData() {
        return new Object[][] {
                new Object[] {"sergey2019@mailinator.com", "QASchool2019!",
                        "C:\\Users\\OLEKSA\\Documents\\GitHub\\DAAutomated\\FirstTest\\src\\lib\\photo.jpg",
                        "Volodymyr", "Sylivanov", "sylivanvv", "22", "October", "1999", "Kherson", "qwerty2019",
                        "Student", "KSU", "Qwerty", "May", "2001", "May", "2004", "Native"}

        };
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test(dataProvider = "CVData")
    public void addLectures(String email, String password, String phothPath, String firstName, String lastName,
                            String skype, String bDay, String bMonth,
                            String bYear, String city, String goal, String eduLevel, String institution,
                            String spec, String edustartmonth,
                            String edustartyear, String eduendmonth,
                            String eduendyear, String langlvl){

        loginPage.login(email, password)
                .clickEventDetails()
                .applyCv()
                .fillApplyForm(phothPath,  firstName,  lastName,
                         skype,  bDay,  bMonth,
                         bYear,  city,  goal,  eduLevel,  institution,
                         spec,  edustartmonth,
                         edustartyear,  eduendmonth,
                         eduendyear,  langlvl);
        Boolean alert = apllyCvPage.getAlert();
        Assert.assertFalse(alert,  "CV wasn't uploaded");

    }
}
