package pages;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class StartPage extends AbstractPage {

    public StartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }
    public String getDomain(){
        return domain;
    }
    @FindBy(name = "firstname")
    WebElement firstName;

    @FindBy(name = "lastname")
    WebElement lastName;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(tagName = "button")
    WebElement submit;

    @FindBy(tagName = "small")
    public WebElement requireAllarm;

    @FindBy(xpath = "/html/body/app/div/div/div[2]/home/div/div[1]/form/div[2]/small")
    public WebElement lastNreq;

    @FindBy(tagName = "pre")
    WebElement pre;

    @FindBy(tagName = "select")
    public Select selectLanguige;

    @FindBy(css = "input[ng-reflect-name=\"role0\"]")
    WebElement roleUser;

    public void chooseEnLang(){
        selectLanguige.selectByValue("en");
    }
    public boolean isLangChoosen(){
        return selectLanguige.equals("en");
    }

    public void emptyLastNameAlarm(){
        Assert.assertEquals(lastNreq.getText(), "lastname-required");
    }
    public void reqFieldsAllarm(){
        Assert.assertEquals(requireAllarm.getText(), "firstname-required");
    }

    public void emptyFieldsTryingSubmit(){
        submit.click();
        Assert.assertEquals(requireAllarm.getText(), "firstname-required");
    }
    public void enterSomeToFirstNameField(String str) throws NoSuchElementException{
        firstName.sendKeys(str);
    }
    public void enterSomeToLastNameField(String str) throws NoSuchElementException{
        lastName.sendKeys(str);
    }

    public void enterEmail(String str){
        email.sendKeys(str);
    }

    public void submitClick(){
        submit.click();
    }

    public void enterReqFields(String fName, String lName, String mail){
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        email.sendKeys(mail);
    }
    public void enterReqFieldsAndSubmit(String fName, String lName, String mail){
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        email.sendKeys(mail);
        submit.submit();
    }

    public void getPreValue(){
         pre.getText();
        Assert.assertTrue(pre != null || pre.getAttribute("firstname").length() != 0);
    }

    public void setRoleToUser(){
        roleUser.click();
    }
    public boolean IsUserRoleChecked(){
        return roleUser.isSelected();
    }
}
