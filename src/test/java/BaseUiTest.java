import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public abstract class BaseUiTest {
    protected WebDriver driver = BrowserFactory.getBrowser("chrome", "http://78.154.162.42:8877");;

    @BeforeSuite
    public void Setup() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @AfterTest
    public void Cleanup() throws NullPointerException{
        BrowserFactory.closeBrowser();
    }
}