package gmail.antonsmirnov3006.selenium.widget;

import gmail.antonsmirnov3006.selenium.BaseRunner;
import org.openqa.selenium.By;

public class Select extends BaseRunner {

    public void setValue(String parentElementPath, String elementPath, int value) {
        app.findElement(By.xpath(parentElementPath)).click();
        app.findElement(By.xpath(elementPath + "[" + value + "]")).click();
    }

    public String getValue(String elementPath) {
        return app.findElement(By.xpath(elementPath)).getText();
    }
}
