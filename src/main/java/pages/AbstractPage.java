package pages;
import org.openqa.selenium.WebDriver;



public abstract class AbstractPage {
     public static WebDriver driver;
     public String currentUrl;
    public String domain = "http://78.154.162.42:8877";

    public  AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getCurUrl(){
       return currentUrl = driver.getCurrentUrl();
    }

    public void navigateTo(String url) {
        driver.navigate().to(domain + url);
    }

    public String GetTitle() {
        return driver.getTitle();
    }
 }