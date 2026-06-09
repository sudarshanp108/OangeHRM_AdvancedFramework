package com.orangehrmlive.Driver;

import com.orangehrmlive.Utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        driver.manage().window().maximize();
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    public static void init() {
        String browser = PropertiesReader.readKey("browser");
        if (browser == null) {
            throw new RuntimeException("Browser key is missing in your properties file!");
        }
        browser = browser.toLowerCase();
        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start maximized");
                chromeOptions.addArguments("--lang=en-US");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--guest");
                driver = new EdgeDriver(edgeOptions);
                break;

            default:
//                System.out.println("No browser Supported!");
                throw new IllegalArgumentException("Browser type not supported: " + browser);
        }

    }

    public static void down() {
        if (getDriver() != null) {
            driver.quit();
            driver = null;
        }
    }
}
