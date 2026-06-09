package com.orangehrmlive.Base;

import com.orangehrmlive.Utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

import static com.orangehrmlive.Driver.DriverManager.driver;
import static com.orangehrmlive.Driver.DriverManager.getDriver;

public class CommonToAllPage {

    // Common to All Pages
    public void openOHRURL() {
        getDriver().get(PropertiesReader.readKey("ohr_url"));
    }

    // For finding and clicking elements
    public void clickElement(By by){
        getDriver().findElement(by).click();
    }
    public void clickElement(WebElement element){
        element.click();
    }

    public void enterInput(By by, String key) {
        getDriver().findElement(by).sendKeys(key);
    }

    public void enterInput(By by) {
        getDriver().findElement(by).sendKeys();
    }

    public void enterInput(WebElement by, String key) {
        by.sendKeys(key);
    }

    public String getText(By by){
        return getDriver().findElement(by).getText();
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public Integer findElement(By by){
       getDriver().findElement(by);
        return null;
    }

    public List<WebElement> findElements(By by) {
        return getDriver().findElements(by);
    }


    public void sendInput(By by) {
        // 1. Convert the By locator into a WebElement
        WebElement element = driver.findElement(by);

        // 2. Pass the WebElement to the Actions class
        Actions actions = new Actions(driver);
        actions.moveToElement(element)
                .click()
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .build().perform();
    }

    public void sendInput(By by, String ename) {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element)
                .click()
                .sendKeys(ename)
                .pause(Duration.ofMillis(5000))
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .build().perform();
    }

}
