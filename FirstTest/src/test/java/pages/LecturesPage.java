package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LecturesPage {

    private WebDriver driver;

    @FindBy(css = "div[class='dx-datagrid-group-closed']")
    private WebElement lecture_expand_td;

    @FindBy(css = "div[class='dx-button-content']")
    private WebElement selectFileButton;

    @FindBy(css = "input[type='file']")
    private WebElement selectFilePath;

    @FindBy(css = "div[class='dx-scrollable-container']")
    private WebElement lecture_container;

    public MainPage selectLectureFile(){
        lecture_expand_td.click();
        selectFileButton.click();
        selectFilePath.sendKeys("C:\\Users\\Compyter\\Desktop\\da\\FirstTest\\src\\lib\\Lecture 13 - Automation - Part2 - Remnyova.pptx");
        return new MainPage(driver);
    }
    public String checkLecturesUpdates(){
        return lecture_container.getText();
    }
    public LecturesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

}

