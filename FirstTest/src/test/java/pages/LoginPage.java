package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(id = "login")
    private WebElement emailInput;

    @FindBy(id = "lg-password")
    private WebElement passwordInput;

    @FindBy(css = "[type='submit']")
    private WebElement submitButton;

    @FindBy(css = "ul.navbar-nav")
    private WebElement user_nav;

    @FindBy(linkText = "Forgot Your Password?")
    private WebElement resetPassLink;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebElement get_user_nav(){
        return this.user_nav;
    }

    public MainPage login(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitButton.click();
        return new MainPage(driver);
    }
    public ResetPasswordPage clickForgotPass(){
        resetPassLink.click();
        return new ResetPasswordPage(driver);
    }

}
