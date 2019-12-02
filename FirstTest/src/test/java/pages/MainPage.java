package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {


    private WebDriver driver;


    @FindBy(css = "ul[class='navbar-nav']")
    private WebElement user_nav;

    @FindBy(linkText = "My lectures")
    private WebElement my_lectures_link;

    @FindBy(css = "a[class='event-img']")
    private WebElement event_details_link;

    public MainPage clickUserMenu(){
        user_nav.click();
        return new MainPage(driver);
    }
    public LecturesPage clickMyLectures(){
        my_lectures_link.click();
        return new LecturesPage(driver);
    }
    public EventsPage clickEventDetails(){
        event_details_link.click();
        return new EventsPage(driver);
    }

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }



}
