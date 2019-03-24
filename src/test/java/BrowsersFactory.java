import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

class BrowsersFactory {

    static WebDriver buildDriver(String browserName) {
        switch (browserName) {
            case "firefox":
                return new FirefoxDriver();
            case "opera":
                return new OperaDriver();
            default:
                return new ChromeDriver();
        }
    }
}

