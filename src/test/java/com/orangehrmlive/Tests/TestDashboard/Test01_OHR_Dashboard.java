package com.orangehrmlive.Tests.TestDashboard;

import com.orangehrmlive.BaseTest.CommonToAllTest;
import com.orangehrmlive.Driver.DriverManager;
import com.orangehrmlive.Pages.POM.DashboardPage;
import com.orangehrmlive.Pages.POM.LoginPage;
import com.orangehrmlive.Utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test01_OHR_Dashboard extends CommonToAllTest {
    @Owner("SUDARSAHN")
    @Description("Verify login successfully and user is on Dashboard")
    @Test

    public void test_dashboard() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.logintoValidCreds(PropertiesReader.readKey("ohr_username"), PropertiesReader.readKey("ohr_password"));
        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());

        String varifydashboard = dashboardPage.dashboard_Page();
        assertThat(varifydashboard).isNotNull().isNotEmpty().isNotBlank();
        Assert.assertEquals(varifydashboard, PropertiesReader.readKey("text_assertion"));

    }
}
