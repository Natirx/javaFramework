package com.opencart.tools;

import com.opencart.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestRunner {
    protected WebDriver driver;

    @BeforeClass
    public void beforeClass(ITestContext context) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("http://oppencart.herokuapp.com/index.php?route=common/home");
    }

    protected HomePage loadApplication(){
        return new HomePage(driver);
    }

    protected void delayExecution(long miliseconds){
        try{
            Thread.sleep(miliseconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
