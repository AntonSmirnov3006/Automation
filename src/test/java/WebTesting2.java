import org.junit.Test;
import org.openqa.selenium.By;

import static junit.framework.TestCase.assertEquals;

public class WebTesting2 extends BaseRunner {

    @Test
    public void testWebTesting2() {
        driver.get(baseUrl);
        driver.findElement(By.name("fio")).click();
        driver.findElement(By.name("fio")).clear();
        driver.findElement(By.name("fio")).sendKeys("апрол");
        driver.findElement(By.name("phone_mobile")).click();
        driver.findElement(By.name("phone_mobile")).clear();
        driver.findElement(By.name("phone_mobile")).sendKeys("+7(567) 89");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Не имею гражданства РФ'])[2]/following::div[8]")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("dfyguhjk");

        assertEquals("Недостаточно информации. Введите фамилию, имя и отчество через пробел (Например: Иванов Иван Алексеевич)",
                driver.findElement(By.cssSelector("div[class='ui-form-field-error-message ui-form-field-error-message_ui-form']")).getText());
    }

}