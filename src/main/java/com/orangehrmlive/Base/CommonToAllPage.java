package com.orangehrmlive.Base;

import com.orangehrmlive.Utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

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



}
