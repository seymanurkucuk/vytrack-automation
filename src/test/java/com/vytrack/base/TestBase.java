package com.vytrack.base;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUpMethod(){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver,10);

    }

    @AfterMethod
    public void cleanUp() throws InterruptedException {
       // Thread.sleep(3000);
        Driver.closeDriver();
    }
}
