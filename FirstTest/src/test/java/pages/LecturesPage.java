package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LecturesPage {

    private WebDriver driver;

    @FindBy(css = "div.dx-datagrid-group-closed")
    private WebElement lecture_expand_td;

    @FindBy(css = "input[type='file']")
    private WebElement selectFilePath;

    @FindBy(css = "span.dx-datagrid-nodata")
    private WebElement lecture_nodata;

    public LecturesPage selectLectureFile(String lecturepath){
        lecture_expand_td.click();
        selectFilePath.sendKeys(lecturepath);
        return new LecturesPage(driver);
    }
    public String getLectureAlert(){
        return this.lecture_nodata.getText();
    }

    public LecturesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

}

