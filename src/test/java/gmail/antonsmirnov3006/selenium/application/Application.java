package gmail.antonsmirnov3006.selenium.application;

import gmail.antonsmirnov3006.selenium.BrowsersFactory;
import gmail.antonsmirnov3006.selenium.page.GoogleMainPage;
import gmail.antonsmirnov3006.selenium.page.GoogleResultPage;
import gmail.antonsmirnov3006.selenium.page.TinkoffTariffPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Иван on 16.04.2018.
 */
public class Application {

    Logger logger = LoggerFactory.getLogger(Application.class);
    private WebDriverWait wait;
    private WebDriver driver;
    public GoogleMainPage google;
    public GoogleResultPage googleResults;
    public TinkoffTariffPage tinkoffTariffs;
    public final String browserName = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");


    public Application() throws MalformedURLException {
        driver = new EventFiringWebDriver(getDriver());
        ((EventFiringWebDriver) driver).register(new BrowsersFactory.MyListener());
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //page
        google = new GoogleMainPage(driver);
        googleResults = new GoogleResultPage(driver);
        tinkoffTariffs = new TinkoffTariffPage(driver);
    }

    public void quit() {
        driver.quit();
        driver = null;
    }

    private WebDriver getDriver() throws MalformedURLException {
        return BrowsersFactory.buildDriver(browserName);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

}