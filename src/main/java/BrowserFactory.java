
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.server.handler.html5.ClearSessionStorage;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    private static WebDriver driver = getBrowser("chrome","http://78.154.162.42:8877") ;

    public static WebDriver getBrowser(String browserName, String url) {
        if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {
            if (browserName.equals("firefox")) {
                driver = new FirefoxDriver();
            } else if (browserName.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/tools/chromedriver");
                driver = new ChromeDriver();
            }
        }
//
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }
    public static void closeBrowser(){
        driver.quit();
        driver = null;
    }
}