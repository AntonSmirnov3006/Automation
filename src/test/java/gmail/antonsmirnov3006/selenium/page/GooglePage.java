package gmail.antonsmirnov3006.selenium.page;

import gmail.antonsmirnov3006.selenium.widget.Button;
import gmail.antonsmirnov3006.selenium.widget.ButtonImpl;
import gmail.antonsmirnov3006.selenium.widget.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends AbstractBasePage {

    public GooglePage(WebDriver driver) {
        setDriver(driver);
        init();
    }

    @Override
    public void open() {
        getDriver().navigate().to("https://google.ru");
        waitForPageToLoad();
    }

    @FindBy(xpath = "//input[@title='Поиск']")
    private TextInput queryLine;

    public void searchFor(String option) {
        queryLine.type(option);
//        logger.info("Ввели текст {} в строку поиска", option);
        wait(1);
        getDriver().findElement(By.xpath("//*[contains(text(),'" + option + "')]")).click();
//        logger.info("Выбрали опцию {} из выпадающего списка", option);
    }

    public void chooseLinkFromSearchResults(String link) {
        Button linkTo = new ButtonImpl(getDriver().findElement(By.xpath("//a[contains(@href,'" + link + "')]")));
        linkTo.click();
//        logger.info("Перешли по ссылке {}", link);
        wait(2);
    }
}
