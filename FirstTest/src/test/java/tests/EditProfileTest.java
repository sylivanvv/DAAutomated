package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class EditProfileTest {
    private LoginPage loginPage;
    private EditProfilePage editProfilePage;
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
        editProfilePage = new EditProfilePage(driver);
    }

    @DataProvider
    public Object[][] editProfileData() {
        return new Object[][] {
                new Object[] {"lectureranton@mailinator.com", "QASchool2019!",
                        "C:\\Users\\OLEKSA\\Documents\\GitHub\\DAAutomated\\FirstTest\\src\\lib\\photo.jpg",
                        "John", "Doe", "Kherson", "johndoe"}
        };
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test(dataProvider = "editProfileData")
    public void addLectures(String email, String password, String photoPath, String firstName, String lastName,
                            String city, String skype){

        loginPage.login(email, password)
                .clickUserMenu()
                .clickMyProfile()
                .clickeditProfile()
                .editProfile(photoPath, firstName, lastName, city, skype);
        Boolean testResult = editProfilePage.getTestResult();
        Assert.assertTrue(testResult);

    }
}
