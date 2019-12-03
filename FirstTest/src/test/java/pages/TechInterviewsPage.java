package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class TechInterviewsPage {


    private WebDriver driver;


    @FindBy(linkText = "Open CV")
    private WebElement openCV;

    @FindBy(css = "div.fluid-container")
    private WebElement cvAlert;

    @FindBy(css = "div.btn")
    private WebElement editFB;

    @FindBy(id = "tech_feedback")
    private WebElement fbField;

    @FindBy(css = "button[type='submit']")
    private WebElement fbSubmitBtn;

    @FindBy(xpath = "/html/body/modal-container/div/div/app-modal-content/div/div[1]/img")
    private WebElement fbcloseModal;

    @FindBy(css = "div.modal--success")
    private WebElement fbAlert;

    public TechInterviewsPage showCv(){
        openCV.click();
        String mainWindow = driver.getWindowHandle();
        Set<String> handle=driver.getWindowHandles();
        for(String handles:handle) {
            if (!mainWindow.equals(handles)) {
                driver.switchTo().window(handles);
            }
        }
        return new TechInterviewsPage(driver);
    }
    public TechInterviewsPage showFB(){
        editFB.click();
        return new TechInterviewsPage(driver);
    }
    public TechInterviewsPage editFb(String fbTXt){
        fbField.clear();
        fbField.sendKeys(fbTXt);
        fbSubmitBtn.click();
        fbcloseModal.click();
        return new TechInterviewsPage(driver);
    }
    public Boolean isCVDispayed(){
        return cvAlert.isDisplayed();
    }
    public String getEditedFb(){
        editFB.click();
        return fbField.getText();
    }
    public TechInterviewsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


}
