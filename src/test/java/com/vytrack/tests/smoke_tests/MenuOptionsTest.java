package com.vytrack.tests.smoke_tests;

import com.vytrack.base.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MenuOptionsTest extends TestBase {

    @Test(description = "Menu options, driver")
    public void test1(){
        driver.get(ConfigurationReader.getProperty("url"));

        WebElement usernameBox = driver.findElement(By.id("prependedInput"));
        usernameBox.sendKeys(ConfigurationReader.getProperty("driver_username"));

        WebElement passwordBox = driver.findElement(By.id("prependedInput2"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("driver_password")+Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.linkText("Fleet")).click();
        driver.findElement(By.linkText("Vehicles")).click();

        wait.until(ExpectedConditions.titleContains("Car"));

        String expectedTitle = "Car - Entities - System - Car - Entities - System";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

        String expectedPageName = "Cars";
        String actualPageName = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(actualPageName,expectedPageName);

        /*
         WebElement webElement = driver.findElement(By.cssSelector("div[class*="loadingWhiteBox"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
         */
        WebElement customers = driver.findElement(By.linkText("Customers"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", customers);

        /*
         WebElement ele = driver.findElement(By.xpath("element_xpath"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", ele);
         */
        WebElement accounts = driver.findElement(By.xpath("(//span[@class='title title-level-2'])[8]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", accounts);

        String expectedTitleOfAccounts = "Accounts - Customers";
        String actualTitleOfAccounts = driver.getTitle();
        Assert.assertEquals(actualPageName,expectedPageName);

        String expectedPageNameOfAccounts = "Accounts";
        String actualPageNameOfAccounts = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(actualPageName,expectedPageName);

        customers = driver.findElement(By.linkText("Customers"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", customers);

        WebElement contacts = driver.findElement(By.xpath("(//span[@class='title title-level-2'])[9]"));
        //executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", contacts);

        wait.until(ExpectedConditions.titleContains("Contacts"));

        String expectedTitleOfContacts = "Contacts - Customers";
        String actualTitleOfContacts = driver.getTitle();
        Assert.assertEquals(actualTitleOfContacts,expectedTitleOfContacts);

        String expectedPageNameOfContacts = "Contacts";
        String actualPageNameOfContacts = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(actualPageNameOfContacts,expectedPageNameOfContacts);


        WebElement activities = driver.findElement(By.linkText("Activities"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", activities);

        WebElement calenderEvents = driver.findElement(By.xpath("(//span[@class='title title-level-2'])[10]"));
        executor.executeScript("arguments[0].click();", calenderEvents);

        wait.until(ExpectedConditions.titleContains("Calendar"));

        String expectedTitleOfCalenderEv = "Calendar Events - Activities";
        String actualTitleOfCalenderEv = driver.getTitle();
        Assert.assertEquals(actualTitleOfCalenderEv,expectedTitleOfCalenderEv);

        String expectedPageNameOfCalenderEv = "Calendar Events";
        String actualPageNameOfCalenderEv = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(actualPageNameOfCalenderEv,expectedPageNameOfCalenderEv);

    }

    @Test(description = "Menu options, store manager")
    public void test2(){
        driver.get(ConfigurationReader.getProperty("url"));

        WebElement usernameBox = driver.findElement(By.id("prependedInput"));
        usernameBox.sendKeys(ConfigurationReader.getProperty("store_manager_username"));

        WebElement passwordBox = driver.findElement(By.id("prependedInput2"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("store_manager_password")+Keys.ENTER);

        //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        WebElement dashboard = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dashboard);

        WebElement dashboards = driver.findElement(By.xpath("(//span[@class='title title-level-2'])[1]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", dashboards);

        wait.until(ExpectedConditions.titleIs("Dashboard - Dashboards"));

        String expectedTitleOfDashboard = "Dashboard - Dashboards";
        String actualTitleOfDashboard = driver.getTitle();
        Assert.assertEquals(actualTitleOfDashboard,expectedTitleOfDashboard);

        String expectedPageNameOfDashboard = "Dashboard";
        String actualPageNameOfDashboard = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(actualPageNameOfDashboard,expectedPageNameOfDashboard);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.linkText("Fleet")));

        WebElement vehicles = driver.findElement(By.xpath("(//span[@class='title title-level-2'])[3]"));
        executor.executeScript("arguments[0].click();", vehicles);

        wait.until(ExpectedConditions.titleContains("Car"));

        String expectedTitleOfVehicles = "All - Car - Entities - System - Car - Entities - System";
        String actualTitleOfVehicles = driver.getTitle();
        Assert.assertEquals(actualTitleOfVehicles,expectedTitleOfVehicles);

        String expectedPageNameOfVehicles = "All Cars";
        String actualPageNameOfVehicles = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(actualPageNameOfVehicles,expectedPageNameOfVehicles);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.linkText("Customers")));

        WebElement accounts = driver.findElement(By.xpath("(//span[@class='title title-level-2'])[10]"));
        executor.executeScript("arguments[0].click();", accounts);

        wait.until(ExpectedConditions.titleContains("All"));

        String expectedTitleOfAccounts = "All - Accounts - Customers";
        String actualTitleOfAccounts = driver.getTitle();
        Assert.assertEquals(actualTitleOfAccounts,expectedTitleOfAccounts);

        String expectedPageNameOfAccounts = "All Accounts";
        String actualPageNameOfAccounts = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(actualPageNameOfAccounts,expectedPageNameOfAccounts);

// step 3
    }

}
