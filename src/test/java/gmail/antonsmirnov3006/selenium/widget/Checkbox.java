package gmail.antonsmirnov3006.selenium.widget;

import gmail.antonsmirnov3006.selenium.BaseRunner;
import org.openqa.selenium.By;

public class Checkbox extends BaseRunner {
    public void check(String elementPath) {
        app.findElement(By.xpath(elementPath)).click();
    }

    public void getText(String elementPath) {
        app.findElement(By.xpath(elementPath)).getText();
    }

    public void getCurrentState(String elementPath) {
        app.findElement(By.xpath(elementPath)).isSelected();
    }
}
