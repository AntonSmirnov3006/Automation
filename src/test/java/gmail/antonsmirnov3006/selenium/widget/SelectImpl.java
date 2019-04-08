package gmail.antonsmirnov3006.selenium.widget;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SelectImpl extends AbstractElement implements Select {
    public SelectImpl(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public void clickAndSelectOption(String textToFind) {
        wait.until(ExpectedConditions.visibilityOf(wrappedElement));
        wrappedElement.click();
        logger.info("Открыли селектор");
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//*[(text()='" + textToFind + "')])[2]"))));
            driver.findElement(By.xpath("(//*[(text()='" + textToFind + "')])[2]")).click();
        } catch (Exception ex) {
            driver.findElement(By.xpath("//*[contains(text(), '" + textToFind + "')]")).click();
        }
        logger.info("Выбрали опцию {}", textToFind);
    }

    private void type(String text) {
        wait.until(ExpectedConditions.visibilityOf(wrappedElement));
        wrappedElement.sendKeys(text);
    }


}
