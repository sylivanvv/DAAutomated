package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {


    private WebDriver driver;


    @FindBy(css = "ul[class='navbar-nav']")
    private WebElement userNav;

    @FindBy(linkText = "My Profile")
    private WebElement myProfileLink;

    @FindBy(linkText = "My lectures")
    private WebElement myLecturesLink;

    @FindBy(linkText = "My Tech Interviews")
    private WebElement myTechIntLink;

    @FindBy(linkText = "My Eng Interviews")
    private WebElement myEngIntLink;

    @FindBy(xpath = "/html/body/app-root/div/app-events/div/app-event[2]/div")
    private WebElement eventDetailsLink;

    public MainPage clickUserMenu(){
        userNav.click();
        return new MainPage(driver);
    }
    public LecturesPage clickMyLectures(){
        myLecturesLink.click();
        return new LecturesPage(driver);
    }

    public EngInterviewsPage clickMyEngInt(){
        myEngIntLink.click();
        return new EngInterviewsPage(driver);
    }

    public TechInterviewsPage clickMyTechInt(){
        myTechIntLink.click();
        return new TechInterviewsPage(driver);
    }
    public EventsPage clickEventDetails(){
        eventDetailsLink.click();
        return new EventsPage(driver);
    }

    public MyProfilePage clickMyProfile(){
        myProfileLink.click();
        return new MyProfilePage(driver);
    }

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }



}
