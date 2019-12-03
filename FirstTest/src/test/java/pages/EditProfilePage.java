package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProfilePage {
    private WebDriver driver;

    @FindBy(css = "input[type = 'file']")
    private WebElement photoInput;

    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "phone_number")
    private WebElement phoneNumberInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "skype")
    private WebElement skypeInput;

    @FindBy(css = "button[type='submit']")
    private WebElement submitBtn;

    @FindBy(css = "body.'modal-open'")
    private WebElement modal;


    public  MyProfilePage editProfile(String photopath, String firstname, String lastname,
                                      String city, String skype){
        photoInput.sendKeys(photopath);
        firstNameInput.clear();
        firstNameInput.sendKeys(firstname);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastname);
        cityInput.clear();
        cityInput.sendKeys(city);
        skypeInput.clear();
        skypeInput.sendKeys(skype);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeAsyncScript("arguments[0].click();", submitBtn);
        return new MyProfilePage(driver);
    }

    public Boolean getTestResult(){
        return this.modal.isDisplayed();
    }
    public EditProfilePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

}
