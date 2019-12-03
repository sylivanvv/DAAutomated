package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {
    private WebDriver driver;

    @FindBy(linkText = "EDIT PROFILE")
    private WebElement editProfileBtn;

    public EditProfilePage clickeditProfile(){
        editProfileBtn.click();
        return new EditProfilePage(driver);
    }
    public MyProfilePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

}
