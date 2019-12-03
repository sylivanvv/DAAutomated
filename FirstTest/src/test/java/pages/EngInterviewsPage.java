package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Set;

public class EngInterviewsPage {


    private WebDriver driver;

    @FindBy(css = "input[type='number']")
    private WebElement intMarkField;

    @FindBy(css = "button.btn")
    private WebElement intMarkSubmit;

    @FindBy(css = "div.modal--success")
    private WebElement intMarkSuccess;

    @FindBy(css = "body.'modal-open'")
    private WebElement closeModal;

    @FindBy(linkText = "Open CV")
    private WebElement openSVlink;

    public EngInterviewCVPage clickOpenCV(){
        openSVlink.click();
        String mainWindow = driver.getWindowHandle();
        Set<String> handle=driver.getWindowHandles();
        for(String handles:handle) {
            if (!mainWindow.equals(handles)) {
                driver.switchTo().window(handles);
            }
        }
        return new EngInterviewCVPage(driver);

    }

    public EngInterviewCVPage putMark(String mark){
        intMarkField.clear();
        intMarkField.sendKeys(mark);
        intMarkSubmit.click();
        if (closeModal.isDisplayed() && closeModal.isEnabled()) {
            closeModal.click();
        }
        return new EngInterviewCVPage(driver);
    }

    public String getMark(){
        return this.intMarkField.getText();
    }

    public EngInterviewsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    

        
}

