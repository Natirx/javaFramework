package com.opencart.pages;

import com.opencart.data.Currencies;
import org.openqa.selenium.WebDriver;

public class HomePage extends AHeadComponent {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage chooseCurrency(Currencies currency) {
        clickCurrencyByPartialName(currency.toString());
        return new HomePage(driver);
    }

}
