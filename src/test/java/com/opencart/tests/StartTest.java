package com.opencart.tests;


import com.opencart.data.Currencies;
import com.opencart.pages.HomePage;
import com.opencart.tools.TestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StartTest extends TestRunner {

    @DataProvider//(parallel = true)
    public Object[][] currencyData() {
        return new Object[][]{
                {Currencies.POUND_STERLING, "£"},
                {Currencies.EURO, "€"},
                {Currencies.US_DOLLAR, "$"},
        };
    }

    @Test(dataProvider = "currencyData")
    public void checkCurrency(Currencies currency, String expectedCurrencyText) {
        //
        // Precondition
        HomePage homePage = loadApplication();
        delayExecution(1000);
        //
        // Steps
        homePage = homePage.chooseCurrency(currency);
        delayExecution(1000);
        //
        // Check
        Assert.assertEquals(homePage.getCurrencyText(), expectedCurrencyText);
        delayExecution(2000);
    }


}
