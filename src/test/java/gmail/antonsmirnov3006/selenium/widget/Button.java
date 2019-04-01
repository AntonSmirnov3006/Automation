package gmail.antonsmirnov3006.selenium.widget;

import gmail.antonsmirnov3006.selenium.BaseRunner;
import org.openqa.selenium.By;

public class Button extends BaseRunner {
    public void click(String elementPath) {
        app.findElement(By.xpath(elementPath)).click();
    }

    public void availabilityCheck(String elementPath) {
        app.findElement(By.xpath(elementPath)).isEnabled();
    }
}
