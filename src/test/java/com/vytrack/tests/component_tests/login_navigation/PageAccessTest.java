package com.vytrack.tests.component_tests.login_navigation;

import com.vytrack.base.TestBase;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PageAccessTest extends TestBase {

    LoginPage loginPage ;

    @BeforeMethod
    public void setUp(){
        loginPage = new LoginPage();
        driver.get(ConfigurationReader.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(description = "Vehicle contracts test store manager")
    public void testStoreManager()  {

        String username = ConfigurationReader.getProperty("store_manager_username");
        String password = ConfigurationReader.getProperty("store_manager_password");
        loginPage.login(username,password);

        WebElement fleetModule =driver.findElement(By.linkText("Fleet"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", fleetModule);

        WebElement vehicleContract = driver.findElement(By.xpath("(//span[@class='title title-level-2'])[6]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", vehicleContract);


        wait.until(ExpectedConditions.textToBe((By.className("oro-subtitle")),"All Vehicle Contract"));
        String pageName = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(pageName,"All Vehicle Contract");

    }

    @Test(description = "Vehicle contracts test sales manager")
    public void testSalesManager(){
        String username = ConfigurationReader.getProperty("sales_manager_username");
        String password = ConfigurationReader.getProperty("sales_manager_password");
        loginPage.login(username,password);

        WebElement fleetModule =driver.findElement(By.linkText("Fleet"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", fleetModule);

        WebElement vehicleContract = driver.findElement(By.xpath("(//span[@class='title title-level-2'])[6]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", vehicleContract);


        wait.until(ExpectedConditions.textToBe((By.className("oro-subtitle")),"All Vehicle Contract"));
        String pageName = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(pageName,"All Vehicle Contract");

    }

    @Test(description = "Vehicle contracts test driver")
    public void testDriver(){
        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");
        loginPage.login(username,password);

        WebElement fleetModule =driver.findElement(By.linkText("Fleet"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", fleetModule);

        WebElement vehicleContract = driver.findElement(By.xpath("(//span[@class='title title-level-2'])[4]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", vehicleContract);

        wait.until(ExpectedConditions.textToBe(By.xpath("(//div[@class='message'])[2]"),"You do not have permission to perform this action."));
        String actualMessage = driver.findElement(By.xpath("(//div[@class='message'])[2]")).getText();
        String expectedMessage = "You do not have permission to perform this action.";


        Assert.assertEquals(actualMessage,expectedMessage);

    }

}
