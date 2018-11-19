package com.opencart;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.opencart.tools.RegexUtils;

public class AppTest {

    private static final String CARTBUTTON_BYXPATH = "//div[contains(@class,'product-layout')]//a[text()='%s']/../../following-sibling::div/button[contains(@onclick,'cart')]";


    @Test
    public void cartAdd() throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://atqc-shop.epizy.com/");
        //
        WebElement cart = driver.findElement(By.cssSelector("#cart-total"));
        System.out.println("cart-total = " + cart.getText());
        //
        int number = RegexUtils.extractFirstNumber(cart.getText());
        System.out.println("number = " + number + "  number == 0 : " + (number == 0));
        //
        double price = RegexUtils.extractFirstDouble(cart.getText());
        System.out.println("price = " + price);
        Thread.sleep(2000); // DO NOT USE
        //
        String dataTest1 = "MacBook";
        String dataTest2 = "iPhone";
        //
        driver.findElement(By.xpath(String.format(CARTBUTTON_BYXPATH, dataTest1))).click();
        //Thread.sleep(2000); // DO NOT USE
        //
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        //(new WebDriverWait(driver, 10)).until(
        //		ExpectedConditions.stalenessOf(cart));
        //
        //(new WebDriverWait(driver, 10)).until(
        //		ExpectedConditions.invisibilityOfElementLocated(
        //				By.xpath("//span[contains(text(), '0 item')]")));
        //
        //(new WebDriverWait(driver, 10)).until(
        //		ExpectedConditions.elementToBeClickable(By.xpath(String.format(CARTBUTTON_BYXPATH, dataTest2))));
        //
        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-success")));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //
        //driver.navigate().refresh();
        //Thread.sleep(1000); // DO NOT USE
        //
        driver.findElement(By.xpath(String.format(CARTBUTTON_BYXPATH, dataTest2))).click();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-success")));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //
        driver.findElement(By.xpath(String.format(CARTBUTTON_BYXPATH, dataTest2))).click();
        Thread.sleep(2000); // DO NOT USE
        //
        cart = driver.findElement(By.cssSelector("#cart-total"));
        System.out.println("cart-total = " + cart.getText());
        //
        number = RegexUtils.extractFirstNumber(cart.getText());
        System.out.println("number = " + number + "  number == 0 : " + (number == 0));
        //
        price = RegexUtils.extractFirstDouble(cart.getText());
        System.out.println("price = " + price);
        Thread.sleep(2000); // DO NOT USE
        //
        driver.quit();
    }
}
