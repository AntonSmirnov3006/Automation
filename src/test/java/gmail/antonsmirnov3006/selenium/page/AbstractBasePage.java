package gmail.antonsmirnov3006.selenium.page;

import gmail.antonsmirnov3006.selenium.BrowsersFactory;
import gmail.antonsmirnov3006.selenium.widget.ExtendedFieldDecorator;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public abstract class AbstractBasePage {

    Logger logger = LoggerFactory.getLogger(BrowsersFactory.class);

    public final SoftAssertions softly = new SoftAssertions();

    private WebDriver driver;
    protected WebDriverWait wait;

    protected WebDriver getDriver() {
        return driver;
    }

    protected void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void init() {
        PageFactory.initElements(new ExtendedFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 10);
    }

    public abstract void open();

    public void wait(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForPageToLoad() {
        wait.until(d -> !d.getTitle().isEmpty());
    }

    Integer getInteger(String str) {
        str = str.replaceAll("\\D", "");
        return Integer.parseInt(str);
    }
}
