package com.orangehrmlive.Pages.POM;

import com.orangehrmlive.Base.CommonToAllPage;
import com.orangehrmlive.Utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends CommonToAllPage {
    WebDriver driver;

    public  DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By dashboard = By.xpath("//span/h6");

    public String dashboard_Page() {
        WaitHelpers.visibilityOfElement(dashboard);
        return getText(dashboard);
    }
}
