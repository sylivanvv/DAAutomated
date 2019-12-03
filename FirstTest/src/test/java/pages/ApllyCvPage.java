package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.PageFactory;

public class ApllyCvPage {

    private WebDriver driver;

    @FindBy(css = "div[role='alert']")
    private WebElement alert;

    @FindBy(css = "input[type=file]")
    private WebElement photoCv;

    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "phone_number")
    private WebElement phoneNumberInput;

    @FindBy(id = "skype")
    private WebElement skypeInput;

    @FindBy (css = "div[class=\"cv-select birthdate-day select-control-wrapper\"] select")
    private WebElement bDay;

    @FindBy (css = "div[class=\"cv-select birthdate-month select-control-wrapper\"] select")
    private WebElement bMonth;

    @FindBy (css = "div[class=\"cv-select birthdate-year\"] select")
    private WebElement bYear;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "goal")
    private WebElement goalInput;

    @FindBy (id = "edu_level")
    private WebElement eduLevel;

    @FindBy(id = "institution")
    private WebElement institutionInput;

    @FindBy(id = "spec")
    private WebElement specInput;

    @FindBy (xpath = "//*[@id=\"educations\"]/app-cv-array/div/div/app-education/div/div[4]/app-cv-datepicker/div/div[1]/select")
    private WebElement eduStartMonth;

    @FindBy (xpath = "//*[@id=\"educations\"]/app-cv-array/div/div/app-education/div/div[4]/app-cv-datepicker/div/div[2]/select")
    private WebElement eduStartYear;

    @FindBy (xpath = "//*[@id=\"educations\"]/app-cv-array/div/div/app-education/div/div[5]/app-cv-datepicker/div/div[1]/select")
    private WebElement eduSEndMonth;

    @FindBy (xpath = "//*[@id=\"educations\"]/app-cv-array/div/div/app-education/div/div[5]/app-cv-datepicker/div/div[2]/select")
    private WebElement eduEndYear;

    @FindBy(id = "lang_level")
    private WebElement langLevel;

    @FindBy(css = "button.cv-submit-margin")
    private WebElement submitButton;

    public  Boolean getAlert(){
        return this.alert.isDisplayed();
    }
    public EventsPage fillApplyForm(String photopath, String firstname, String lastname, String skype,
                                     String bday,
                                     String bmonth,
                                     String byear, String city, String goal, String edulevel, String institution,
                                     String spec, String edustartmonth, String edustartyear, String eduendmonth,
                                     String eduendyear, String langlvl){
        photoCv.sendKeys(photopath);
        firstNameInput.clear();
        firstNameInput.sendKeys(firstname);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastname);
        skypeInput.clear();
        skypeInput.sendKeys(skype);
        Select selectBDay = new Select (bDay);
        selectBDay.selectByVisibleText(bday);
        Select selectBMonth = new Select (bMonth);
        selectBMonth.selectByVisibleText(bmonth);
        Select selectBYear = new Select (bYear);
        selectBYear.selectByVisibleText(byear);
        cityInput.clear();
        cityInput.sendKeys(city);
        goalInput.clear();
        goalInput.sendKeys(goal);
        Select selectEduLevel = new Select (eduLevel);
        selectEduLevel.selectByVisibleText(edulevel);
        institutionInput.sendKeys(institution);
        specInput.sendKeys(spec);
        Select selectEduStartMonth = new Select (eduStartMonth);
        selectEduStartMonth.selectByVisibleText(edustartmonth);
        Select selectEduStartYear = new Select (eduStartYear);
        selectEduStartYear.selectByVisibleText(edustartyear);
        Select selectEduEndMonth = new Select (eduSEndMonth);
        selectEduEndMonth.selectByVisibleText(eduendmonth);
        Select selectEduEndYear = new Select (eduEndYear);
        selectEduEndYear.selectByVisibleText(eduendyear);
        Select selectLangLvl = new Select (langLevel);
        selectLangLvl.selectByVisibleText(langlvl);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeAsyncScript("arguments[0].click();", submitButton);
        return new EventsPage(driver);
    }

    public ApllyCvPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

}
