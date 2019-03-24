import org.junit.Test;
import org.openqa.selenium.By;

import static junit.framework.TestCase.assertEquals;

public class WebTesting extends BaseRunner {

    @Test
    public void testWebTesting() {
        driver.get(baseUrl);
        driver.findElement(By.name("fio")).click();
        driver.findElement(By.name("phone_mobile")).click();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Не имею гражданства РФ'])[2]/following::div[8]")).click();

        assertEquals("Укажите ваше ФИО",
                driver.findElement(By.cssSelector("div[class='ui-form-field-error-message ui-form-field-error-message_ui-form']")).getText());

    }

}


