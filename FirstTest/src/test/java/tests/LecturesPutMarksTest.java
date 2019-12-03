package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CheckHomeworkPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LecturesPutMarksTest {
        LoginPage loginPage;
        CheckHomeworkPage checkHomeworkPage;
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
            checkHomeworkPage = new CheckHomeworkPage(driver);
        }
        @DataProvider
        public Object[][] putMarkData() {
            return new Object[][] {
                    new Object[] {"5", "lectureralexey@mailinator.com", "QASchool2019!"}
            };
        }

        @AfterClass
        public void tearDown(){
        driver.quit();
    }



        @Test(dataProvider = "putMarkData")
        public void putMark(String mark, String email, String password){
            loginPage.login(email, password)
            .clickEventDetails()
            .checkHomework()
            .putMarks(mark);
            String editedMark = checkHomeworkPage.getMark();
            Assert.assertEquals(editedMark, mark, "Mark wasn't changed");
        }


}
