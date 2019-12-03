package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {


    private WebDriver driver;


    @FindBy(css = "ul[class='navbar-nav']")
    private WebElement user_nav;

    @FindBy(linkText = "My Profile")
    private WebElement my_profile_link;

    @FindBy(linkText = "My lectures")
    private WebElement my_lectures_link;

    @FindBy(linkText = "My Tech Interviews")
    private WebElement my_tech_int_link;

    @FindBy(linkText = "My Eng Interviews")
    private WebElement my_eng_int_link;

    @FindBy(xpath = "/html/body/app-root/div/app-events/div/app-event[2]/div")
    private WebElement event_details_link;

    public MainPage clickUserMenu(){
        user_nav.click();
        return new MainPage(driver);
    }
    public LecturesPage clickMyLectures(){
        my_lectures_link.click();
        return new LecturesPage(driver);
    }

    public EngInterviewsPage clickMyEngInt(){
        my_eng_int_link.click();
        return new EngInterviewsPage(driver);
    }

    public TechInterviewsPage clickMyTechInt(){
        my_tech_int_link.click();
        return new TechInterviewsPage(driver);
    }
    public EventsPage clickEventDetails(){
        event_details_link.click();
        return new EventsPage(driver);
    }

    public MyProfilePage clickMyProfile(){
        my_profile_link.click();
        return new MyProfilePage(driver);
    }

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }



}
