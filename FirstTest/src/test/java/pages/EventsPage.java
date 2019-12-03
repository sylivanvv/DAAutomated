package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventsPage {


    private WebDriver driver;

    @FindBy(css = "div[class='event-control'] a")
    private WebElement applyCvLink;

    @FindBy(linkText = "Check homeworks")
    private WebElement checkHwbtn;

    public ApllyCvPage applyCv(){
        applyCvLink.click();
        return new ApllyCvPage(driver);
    }
    public CheckHomeworkPage checkHomework(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeAsyncScript("arguments[0].click();", checkHwbtn);
        return new CheckHomeworkPage(driver);
    }
    public EventsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

}