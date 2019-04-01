package gmail.antonsmirnov3006.selenium;

import gmail.antonsmirnov3006.selenium.page.GoogleMainPage;
import gmail.antonsmirnov3006.selenium.page.GoogleResultPage;
import gmail.antonsmirnov3006.selenium.page.TinkoffTariffPage;
import gmail.antonsmirnov3006.selenium.widget.Button;
import gmail.antonsmirnov3006.selenium.widget.Checkbox;
import gmail.antonsmirnov3006.selenium.widget.Select;
import gmail.antonsmirnov3006.selenium.widget.TextInput;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TabChangeTest extends BaseRunner {

    private Select select = new Select();
    private TextInput textInput = new TextInput();
    private Button button = new Button();
    private Checkbox checkbox = new Checkbox();

    @Test
    public void FirstTest() {
        GoogleMainPage googleMainPage = app.google;
        googleMainPage.open();
        googleMainPage.openSearchResultsPageByRequest("мобайл тинькофф тарифы");

        GoogleResultPage googleResultPage = app.googleResults;
        googleResultPage.clickSearchResultsByLinkContains("https://www.tinkoff.ru/mobile-operator/tariffs/");

        TinkoffTariffPage tinkoffTariffs = app.tinkoffTariffs;
        tinkoffTariffs.switchToWindow("Тарифы Тинькофф Мобайла");

        assertEquals("Тарифы Тинькофф Мобайла", tinkoffTariffs.getTitle());
//        tinkoffTariffs.closeCurrentTab();
        assertEquals("https://www.tinkoff.ru/mobile-operator/tariffs/", tinkoffTariffs.getUrl());

//        tinkoffTariffs.typeNameField("Иванов Иван Иванович");
//
//        tinkoffTariffs.getPage("https://www.tinkoff.ru/career/vacancies/");
//        tinkoffTariffs.switchToWindow("Вакансии");
//        tinkoffTariffs.typeNameField("Иванова");
//        tinkoffTariffs.checkPopularNameRequest("Иванова");
//        tinkoffTariffs.closeCurrentTab();
//        tinkoffTariffs.switchToMainTab();
//
//        googleResultPage.inputBySearchField("Проба");
    }

    @Test
    public void ThirdTest() {
        TinkoffTariffPage tinkoffTariffs = app.tinkoffTariffs;
        tinkoffTariffs.switchToMainTab();
        select.setValue("//div[contains(@class, 'ui-select__title ui-select__title_columned')]//*[contains (text(), \"Интернет\")]", "//div[contains(@class, 'ui-dropdown-field-list ui-dropdown-field-list__opened')]/div[contains(@class, 'ui-dropdown-field-list__item')]", 1);
        select.setValue("//div[contains(@class, 'ui-select__title ui-select__title_columned')]//*[contains (text(), \"Звонки\")]", "//div[contains(@class, 'ui-dropdown-field-list ui-dropdown-field-list__opened')]/div[contains(@class, 'ui-dropdown-field-list__item')]", 1);
        checkbox.check("(//div[contains(@class, 'CheckboxSet__root_')]//*[contains(@class, 'Checkbox__inputOuter')])[1]");
        checkbox.check("(//div[contains(@class, 'CheckboxSet__root_')]//*[contains(@class, 'Checkbox__inputOuter')])[2]");
        assertEquals("Общая цена: 0 \u20BD", textInput.getValue("//h3[contains(@class, 'mobileOperatorProductCalculatorSchema__amountTitle')]"));
        button.availabilityCheck("//div[contains(@class, 'LoadingButton')]");
    }

}
