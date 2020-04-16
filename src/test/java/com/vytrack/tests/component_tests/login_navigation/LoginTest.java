package com.vytrack.tests.component_tests.login_navigation;

import com.vytrack.base.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test(description = "Login test (positive)")
    public void positiveTest(){
        driver.get(ConfigurationReader.getProperty("url"));

        WebElement usernameBox = driver.findElement(By.id("prependedInput"));
        usernameBox.sendKeys(ConfigurationReader.getProperty("store_manager_username"));

        WebElement passwordBox = driver.findElement(By.id("prependedInput2"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("store_manager_password")+ Keys.ENTER);

        String nameofStoreManager = driver.findElement(By.xpath("(//a[@href='javascript: void(0);'])")).getText();


        Assert.assertEquals(nameofStoreManager,"Geovany Jenkins");
        Assert.assertEquals(driver.getTitle(),"Dashboard");

        WebElement storemanagerName =driver.findElement(By.xpath("(//a[@href='javascript: void(0);'])"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", storemanagerName);

        WebElement logOut = driver.findElement(By.linkText("Logout"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logOut);

         usernameBox = driver.findElement(By.id("prependedInput"));
        usernameBox.sendKeys(ConfigurationReader.getProperty("sales_manager_username"));

         passwordBox = driver.findElement(By.id("prependedInput2"));
         passwordBox.sendKeys(ConfigurationReader.getProperty("sales_manager_password")+ Keys.ENTER);

        Assert.assertEquals(driver.getTitle(),"Dashboard");

        String nameofSalesManager = driver.findElement(By.xpath("(//a[@href='javascript: void(0);'])")).getText();
        Assert.assertEquals(nameofSalesManager,"Peyton Harber");

        WebElement salesmanagerName =driver.findElement(By.xpath("(//a[@href='javascript: void(0);'])"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", salesmanagerName);
        logOut = driver.findElement(By.linkText("Logout"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logOut);

        usernameBox = driver.findElement(By.id("prependedInput"));
        usernameBox.sendKeys(ConfigurationReader.getProperty("driver_username"));

        passwordBox = driver.findElement(By.id("prependedInput2"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("driver_password")+ Keys.ENTER);

        Assert.assertEquals(driver.getTitle(),"Dashboard");
        String nameofDriver = driver.findElement(By.xpath("(//a[@href='javascript: void(0);'])")).getText();
        Assert.assertEquals(nameofDriver,"John Doe");





    }

    @Test(description = "Login test (negative)")
    public void negativeTest(){
        driver.get(ConfigurationReader.getProperty("url"));

        String pageTitle = driver.getTitle();
        String pageUrl = driver.getCurrentUrl();

        WebElement usernameBox = driver.findElement(By.id("prependedInput"));
        usernameBox.sendKeys(ConfigurationReader.getProperty("driver_username"));

        WebElement passwordBox = driver.findElement(By.id("prependedInput2"));
        passwordBox.sendKeys("abc");
        driver.findElement(By.id("_submit")).click();

        String actualMessage = driver.findElement(By.xpath("//div[@class='alert alert-error']")).getText();
        String expectedMessage= "Invalid user name or password.";

        Assert.assertEquals(actualMessage,expectedMessage);
        Assert.assertEquals(driver.getTitle(),pageTitle);
        Assert.assertEquals(driver.getCurrentUrl(),pageUrl);

    }

}
