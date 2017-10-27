package pages;

import com.gargoylesoftware.htmlunit.WebWindow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by aleksandr on 10/25/17.
 */
public class SecondPage extends AbstractPage {
    public SecondPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }
    public void secondPageURLgoTo(){
        driver.get("http://78.154.162.42:8877/second-part");
    }
    @FindBy(name = "phoneOne")
    WebElement phoneOne;

    @FindBy(name = "phoneTwo")
    WebElement phoneTwo;

    @FindBy(name = "personalEmail")
    WebElement persEmail;

    @FindBy(name = "skype")
    WebElement skype;

    @FindBy(name = "position")
    Select positionSelect;

    @FindBy(name = "activated")
    WebElement activatedCheck;

    @FindBy(tagName = "pre")
    WebElement preData;

    public void positionChoice(String choice){
        positionSelect.selectByValue(choice);
    }

    public void enterPhoneOne(String s) {
        phoneOne.sendKeys(s);
        phoneOne.submit();
    }

    public boolean IsActivChecked(){
        return activatedCheck.isSelected();
    }

    public boolean isPositionQA() {
        return positionSelect.getOptions().get(2).isSelected();
    }
}
