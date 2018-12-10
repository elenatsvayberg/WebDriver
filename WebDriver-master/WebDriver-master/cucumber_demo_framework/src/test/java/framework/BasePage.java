package framework;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import stepdefinition.SharedSD;
import sun.security.util.Length;

import java.sql.Driver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static stepdefinition.SharedSD.getDriver;

/**
 * Created by mohammadmuntakim on 6/9/17.
 */
public class BasePage {

    public void clickOn(By locator) {
        try {
            getDriver().findElement(locator).click();
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found with this locator: " + locator.toString());
            e.printStackTrace();
        }
    }

    public void sendText(By locator, String text) {
        try {
            getDriver().findElement(locator).sendKeys(text);
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found with this locator: " + locator.toString());
            e.printStackTrace();
        }
    }

    public String getTextFromElement(By locator) {
        String text = null;
        try {
            text = getDriver().findElement(locator).getText();
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found with this locator: " + locator.toString());
            e.printStackTrace();
        }

        return text;
    }

    public void clickOnBrowserBackArrow() {
        getDriver().navigate().back();
    }

    public void clickOnBrowserForwardArrow() {
        getDriver().navigate().forward();
    }

    public void refreshBrowser() {
        getDriver().navigate().refresh();
    }

    public void clearField(By locator) {
        getDriver().findElement(locator).clear();
    }

    public static void scrollOnPage() throws InterruptedException {
        Thread.sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        //vertical scroll - down by 500 pixels
        js.executeAsyncScript("window.scrollBy(0,500)");
        getDriver().manage().timeouts().setScriptTimeout(35000,TimeUnit.SECONDS);
    }

    public void getMessage(By locator) {
        try {
            WebElement email = getDriver().findElement(locator);
            String foundError = email.getAttribute("required");
            System.out.println("Error messge is" + foundError);
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found with this locator: " + locator.toString());
            e.printStackTrace();
        }
    }

    public String currentDate(String format){
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        String today = dateFormat.format(date);
        return today;
    }



}
