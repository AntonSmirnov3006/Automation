package gmail.antonsmirnov3006.selenium.widget;

import gmail.antonsmirnov3006.selenium.BaseRunner;
import gmail.antonsmirnov3006.selenium.BrowsersFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class AbstractElement implements BaseElement {
    final WebElement wrappedElement;
    protected WebDriver driver;
    WebDriverWait wait;

    Logger logger = LoggerFactory.getLogger(BrowsersFactory.class);

    AbstractElement(final WebElement wrappedElement) {
        this.driver = BaseRunner.getInstance();
        wait = new WebDriverWait(driver, 3);
        this.wrappedElement = wrappedElement;
    }

    @Override
    public boolean isDisplayed() {
        return wrappedElement.isDisplayed();
    }

    @Override
    public void click() {
        wait.until(ExpectedConditions.visibilityOf(wrappedElement));
        wrappedElement.click();
    }

    @Override
    public String getBy() {
        String[] arr = wrappedElement.toString().split("->");
        String xpath = arr[1].split(":")[1].trim();
        xpath = xpath.split("]")[0] + "]";
        return xpath;
    }


}