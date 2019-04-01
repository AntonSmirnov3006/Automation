package gmail.antonsmirnov3006.selenium.widget;

import gmail.antonsmirnov3006.selenium.BaseRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TextInput extends BaseRunner {

    public void inputText(String elementPath, String text) {
        app.findElement(By.xpath(elementPath)).click();
        app.findElement(By.xpath(elementPath)).sendKeys(text, Keys.ENTER);
    }

    public String getValue(String elementPath) {
        return app.findElement(By.xpath(elementPath)).getText();
    }
}