import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StartPage;
import pages.SecondPage;
import static org.testng.Assert.assertTrue;

public class someTest extends BaseUiTest {


    StartPage startPage = new StartPage(driver);
    SecondPage sPage = new SecondPage(driver);

    @Test
    public void Can_Go_To_Home_Page(){
        startPage.navigateTo("/first-part");
        Assert.assertEquals(startPage.getCurUrl(), (startPage.getDomain()+ "/first-part"));
    }

    @Test
    public void mustBeRequiredFieldsAlarmWithIncorrectInput(){
        startPage.navigateTo("/first-part");
        startPage.enterReqFields("A","B","z");
        Assert.assertTrue(startPage.requireAllarm.isDisplayed());
    }
    @Test
    public void EmptyFieldsVerify(){
        startPage.navigateTo("/first-part");
        startPage.emptyFieldsTryingSubmit();
        Assert.assertTrue(startPage.requireAllarm.isDisplayed());
    }

    @Test
    public void emptyLastName(){
        startPage.navigateTo("/first-part");
        startPage.enterSomeToFirstNameField("xxx");
        startPage.enterEmail("zzz");
        startPage.submitClick();
        startPage.emptyLastNameAlarm();
    }

    @Test()
    public void TitleVerification() {
        startPage.navigateTo("/first-part");
        String title = startPage.GetTitle();
        String expectedTitle = "Angular2 Webpack Starter";
        assertTrue(title.contains(expectedTitle), ("Title should contain " + "'" + expectedTitle + "'"));
    }


    @Test
    public void submitWithEnteredRequiredFields(){
        startPage.navigateTo("/first-part");
        startPage.enterSomeToFirstNameField("A");
        startPage.enterSomeToLastNameField("b");
        startPage.enterEmail("zzz");
        startPage.getPreValue();
        startPage.submitClick();
        Assert.assertEquals(startPage.getCurUrl(),"http://78.154.162.42:8877/second-part");

    }

    @Test //don't get a select element yet!!!
    public void qaPositionInSecPageSelect() throws NullPointerException{
        sPage.secondPageURLgoTo();
        sPage.enterPhoneOne("+380686868755");
        sPage.positionChoice("qa");
        Assert.assertTrue(sPage.isPositionQA());
    }

    @Test
    public void ChooseEnLanguigeTest(){
        startPage.navigateTo("/first-part");
        startPage.chooseEnLang();
        Assert.assertTrue(startPage.isLangChoosen());
    }
    @Test
    public void secondPagePositionTest(){
        driver.get("http://78.154.162.42:8877/second-part");
        WebElement phoneOne = driver.findElement(By.name("phoneOne"));
        phoneOne.sendKeys("1213123213****************");
        Select select = new Select(driver.findElement(By.name("position")));
        select.selectByValue("qa");
        WebElement actCheck = driver.findElement(By.name("activated"));
        actCheck.click();
        Assert.assertTrue(actCheck.isEnabled());
    }
    @Test
    public void foo(){}
}
