package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventsPage {


    private WebDriver driver;


    @FindBy(css = "div[class=\"event-control\"] a")
    private WebElement applyCvLink;

    public CvPage applyCv(){
        applyCvLink.click();
        return new CvPage(driver);
    }

    public EventsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }



}
