import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

/**
 * Created by aleksandr on 10/27/17.
 */
public class UnitTests {
    @Test
    public void SingletonTest(){
        WebDriver browser1 = BrowserFactory.getBrowser("chrome", "http://google.com");
        WebDriver browser2 = BrowserFactory.getBrowser("chrome", "http://google.com");
        Assert.assertSame(browser1, browser2);
    }

    @Test
    public void SingletonTestTwo(){
        WebDriver browser1 = BrowserFactory.getBrowser("chrome", "http://google.com");
        SessionId session1 = ((RemoteWebDriver)browser1).getSessionId();
        browser1.close();
        WebDriver browser2 = BrowserFactory.getBrowser("chrome", "http://google.com");
        SessionId session2 = ((RemoteWebDriver)browser2).getSessionId();
        Assert.assertNotEquals(session1, session2);
        browser2.close();
    }

    @Test
    public void searchSelect(){
        WebDriver dr = BrowserFactory.getBrowser("chrome","http://78.154.162.42:8877/second-part");
        Select select = new Select(dr.findElement(By.name("position")));
        select.selectByValue("qa");
    }

    @AfterSuite
    public void cleanup(){
        BrowserFactory.closeBrowser();
    }
}
