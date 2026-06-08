package com.orangehrmlive.BaseTest;

import com.orangehrmlive.Driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest {

    @BeforeMethod
    public void setUp() {
        DriverManager.init();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        WebDriver driver = DriverManager.getDriver();
// If test failed, capture screenshot and attach to Allure and write code here for screenshots
        if (driver != null) {
            DriverManager.down();
        }
    }

}
