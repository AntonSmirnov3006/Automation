package gmail.antonsmirnov3006.selenium;

import gmail.antonsmirnov3006.selenium.page.GooglePage;
import gmail.antonsmirnov3006.selenium.page.TinkoffMobilePage;
import org.junit.Test;

public class WebTesting extends BaseRunner {
    private TinkoffMobilePage mobilePage;

    @Test
    public void openTinkoffMobileSite() {
        GooglePage googlePage = new GooglePage(getDriver());
        googlePage.open();
        googlePage.searchFor("мобайл тинькофф тарифы");
        googlePage.chooseLinkFromSearchResults("https://www.tinkoff.ru/mobile-operator/tariffs/");
        mobilePage = new TinkoffMobilePage(getDriver());
        mobilePage.closePreviousTab();
        mobilePage.checkTabName("Тарифы Тинькофф Мобайла");
    }

    @Test
    public void checkPrice() {
        mobilePage = new TinkoffMobilePage(getDriver());
        mobilePage.open();
        mobilePage.compareDefaultPrices();
        mobilePage.compareMaxPrices();
    }

    @Test
    public void checkButtonActive() {
        mobilePage = new TinkoffMobilePage(getDriver());
        mobilePage.open();
        mobilePage.checkAllCheckboxes(false);
        mobilePage.selectInternetOption("0 ГБ");
        mobilePage.selectCallsOption("0 минут");
        mobilePage.checkPriceInTotal("0");
        mobilePage.checkOrderButtonIsClickable();
    }
}