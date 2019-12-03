package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckHomeworkPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"gridContainer\"]/div/div[6]/div/table/tbody/tr[1]/td[7]")
    private WebElement fieldForMarks;

    @FindBy(xpath = "//*[@id=\"gridContainer\"]/div/div[4]/div/div/div[3]/div[1]/div")
    private WebElement saveBtn;

    public CheckHomeworkPage putMarks(String mark){
        fieldForMarks.sendKeys(mark);
        saveBtn.click();
        return new CheckHomeworkPage(driver);
    }
    public String getMark(){
        return fieldForMarks.getText();
    }
    public CheckHomeworkPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

}
