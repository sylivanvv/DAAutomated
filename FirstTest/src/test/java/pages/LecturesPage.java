package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LecturesPage {

    private WebDriver driver;

    @FindBy(css = "div.dx-datagrid-group-closed")
    private WebElement lectureExpand_td;

    @FindBy(css = "input[type='file']")
    private WebElement selectFilePath;

    @FindBy(css = "span.dx-datagrid-nodata")
    private WebElement lectureNodata;

    public LecturesPage selectLectureFile(String lecturepath){
        lectureExpand_td.click();
        selectFilePath.sendKeys(lecturepath);
        return new LecturesPage(driver);
    }
    public String getLectureAlert(){
        return this.lectureNodata.getText();
    }

    public LecturesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

}

