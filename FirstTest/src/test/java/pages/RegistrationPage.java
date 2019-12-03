package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage  {

    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "conf_password")
    private WebElement confPasswordInput;

    @FindBy(css = "[type='submit']")
    private WebElement submitButton;

    public RegistrationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoginPage sign_up(String email, String first_name, String last_name, String password, String cpassword){
        emailInput.sendKeys(email);
        firstNameInput.sendKeys(first_name);
        lastNameInput.sendKeys(last_name);
        passwordInput.sendKeys(password);
        confPasswordInput.sendKeys(cpassword);
        submitButton.click();
        return new LoginPage(driver);

    }


}
