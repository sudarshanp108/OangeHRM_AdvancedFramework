package com.orangehrmlive.Tests.TestDashboard;

import com.orangehrmlive.BaseTest.CommonToAllTest;
import com.orangehrmlive.Driver.DriverManager;
import com.orangehrmlive.Pages.POM.AdminPage;
import com.orangehrmlive.Pages.POM.LoginPage;
import com.orangehrmlive.Utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Test02_OHR_AdminPage extends CommonToAllTest {
    @Owner("SUDARSHAN")
    @Description("Verify Admin Page")
    @Test

    public void test_admin_page() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.logintoValidCreds(PropertiesReader.readKey("ohr_username"), PropertiesReader.readKey("ohr_password"));
        AdminPage admin_Page = new AdminPage(DriverManager.getDriver());
        String verifyAdmin = admin_Page.adminPage();

//        admin_Page.getTableData();
        admin_Page.getRowData1();
        assertThat(verifyAdmin).isNotEmpty().isNotBlank().isNotNull();
        Assert.assertEquals(verifyAdmin, PropertiesReader.readKey("assert_admin"));


    }
}
