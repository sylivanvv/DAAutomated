package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EngInterviewCVPage {

    private WebDriver driver;

    @FindBy(css = "button[class = 'btn text-uppercase acs-btn']")
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
