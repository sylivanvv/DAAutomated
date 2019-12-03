package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.ConcurrentHashMap;

public class EngInterviewCVPage {


    private WebDriver driver;


    @FindBy(xpath = "/html/body/app-root/div/app-candidate-cv/div/div/div/div/div/div/div[1]/div[2]/button")
    private WebElement downloadBtn;
    @FindBy(css = "body")
    private WebElement body;
    public EngInterviewsPage downloadCV(){
        downloadBtn.click();
        return new EngInterviewsPage(driver);
    }

    public EngInterviewCVPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


}
