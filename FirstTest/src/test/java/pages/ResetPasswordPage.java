package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage {

    private WebDriver driver;

    @FindBy(id = "login")
    private WebElement emailInput;
    @FindBy(css = "button[type='submit")
    private WebElement sendResetLink;

    public LoginPage resetPass(String email){
        emailInput.sendKeys(email);
        sendResetLink.click();
        return new LoginPage(driver);
    }

    public ResetPasswordPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


}
