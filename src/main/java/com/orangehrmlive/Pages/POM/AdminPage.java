package com.orangehrmlive.Pages.POM;

import com.orangehrmlive.Base.CommonToAllPage;
import com.orangehrmlive.Utils.PropertiesReader;
import com.orangehrmlive.Utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminPage extends CommonToAllPage {
    WebDriver driver;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    private By adminTab = By.xpath("//ul[@class='oxd-main-menu']/li[1]");
    private By varifyTab = By.xpath("//span/h6[text()='User Management']");

    // For Table validation
    private By tableRows = By.xpath("//div[@class='oxd-table-card']");
    private By tableCells = By.xpath(".//div[@role='cell']");
    private By singleTableRow = By.xpath("//div[@class=\"oxd-table-card\"][1]/div[@role=\"row\"]/div[@role=\"cell\"]");



    public String adminPage() {
        clickElement(adminTab);
        WaitHelpers.visibilityOfElement(adminTab);
        WaitHelpers.waitJVM(5000);
        return getText(varifyTab);
    }

    // Admin Page Table validation //div[@class="oxd-table-body"]/div
    // full path for single row //div[@class="oxd-table-card"][]/div[@role="row"][]/div[@role="cell"]

    public void getTableData() {
        // To get Full table Data
        // 1. Locate list all table rows in the DOM at once
        List<WebElement> rows = findElements(tableRows);
//        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='oxd-table-card']"));

        System.out.println("--- Printing Full Table Content (" + rows.size() + " rows found) ---");

        // 2. Loop through each row sequentially
        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(tableCells);
//            List<WebElement> cells = rows.get(i).findElements(By.xpath(".//div[@role='cell']"));


            // Single-line text output for the current row
            StringBuilder rowData = new StringBuilder();
            rowData.append("Row ").append(i + 1).append(": [ ");

            for (int j = 0; j < cells.size(); j++) {
                String cellText = cells.get(j).getText().trim();

                // Handle empty cells gracefully (checkbox columns and action buttons)
                if (cellText.isEmpty()) {
                    cellText = "EMPTY";
                }

                rowData.append(cellText);

                // Add separator between columns, except for the last column
                if (j < cells.size() - 1) {
                    rowData.append(" | ");
                }
            }
            rowData.append(" ]");

            //Print the complete row data to the console
            System.out.println(rowData.toString());
        }
        System.out.println("--- End of Table ---");
    }

    // *********************************************************
    // For all cell Data
    // Approach 2
    public void getRowData1() {
    // Define XPath bases using index brackets
        String first_part = "//div[@class='oxd-table-card'][";  // //div[@class="oxd-table-card"][
        String second_part = "]/div[@role='row']/div[@role='cell'][";   // ]/div[@role="row"]/div[@role="cell"]
        String third_part = "]";

        // Find total row count
        Integer row = driver.findElements(By.xpath("//div[@class='oxd-table-card']")).size();
//        Integer row = findElement(tableRows);
        // Find column count by targeting ONLY the cells inside the first row
        Integer column = driver.findElements(By.xpath("//div[@class=\"oxd-table-card\"][1]/div[@role=\"row\"]/div[@role=\"cell\"]")).size();
//        Integer column = findElement(singleTableRow);

        // Iterate through rows and columns using 1-based indexing for XPath
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++)
            {
                // Constructs: //div[@class='oxd-table-card'][i]/div[@role='row']/div[@role='cell'][j]
                String dynamic_xpath = first_part + i + second_part + j + third_part;
//                System.out.println(dynamic_xpath);
                String data = driver.findElement(By.xpath(dynamic_xpath)).getText();
                System.out.println(data);
            }
        }
    }


    // *********************************************************
    // Approach 3 for getting single row data
    public void getRowData2(int rowIndex) {
        // Fetch all rows using List
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='oxd-table-card']"));

        // 2. Bound check to avoid IndexOutOfBoundsException
        if (rowIndex < 0 || rowIndex >= rows.size()) {
            System.out.println("Error: Row index " + rowIndex + " is out of bounds. Total rows: " + rows.size());
            return;
        }

        // Extract cells from the target row
        WebElement targetRow = rows.get(rowIndex);
        List<WebElement> cells = targetRow.findElements(By.xpath(".//div[@role='cell']"));

        // Construct and print the row string
        StringBuilder rowText = new StringBuilder("Row " + (rowIndex + 1) + ": [ ");
        for (int i = 0; i < cells.size(); i++) {
            rowText.append(cells.get(i).getText().trim());
            if (i < cells.size() - 1) {
                rowText.append(" | ");
            }
        }
        rowText.append(" ]");

        System.out.println(rowText.toString());
    }

    // ******************************************************************
    // Search for System Users
    private By username = By.xpath("//form//div/input[contains(@class, 'oxd-input--active')]");
    private By userRole = By.xpath("//div[div/label[normalize-space()='User Role']]//div[@class='oxd-select-wrapper']");
    private By employeeName = By.xpath("//div[contains(@class, 'oxd-autocomplete-text-input--active')]//input");
    private By status = By.xpath("//div[div/label[normalize-space()='Status']]//div[@class='oxd-select-wrapper']");
    private By clickSearchButton = By.xpath("//button[@type='submit']");

    public void searchSystemUsers(String Uname, String Ename) {
        enterInput(username, Uname);
        sendInput(userRole);
        enterInput(employeeName, Ename);
        sendInput(status);
        WaitHelpers.visibilityOfElement(clickSearchButton);
        clickElement(clickSearchButton);

    }

    // ******************************************************************
    // Adding System Users to Admin Tab
    private By addNewUser = By.xpath("//button[normalize-space()= 'Add']");
    // Adding User Details
    private By selectUserRole = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
    private By selectStatus = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
    private By selectEmployeeName = By.xpath("//input[@placeholder='Type for hints...']");
    private By addUsername = By.xpath("//label[text()='Username']/following::input[1]");
    private By addPassword = By.xpath("//div[label[text()='Password']]/following-sibling::div/input"); // (//div[input[@type='password']])[1]
    private By confirmPassword = By.xpath("//div[label[text()='Confirm Password']]/following-sibling::div/input");  // (//div[input[@type='password']])[2]
    private By saveDetails = By.xpath("//button[@type='submit']");

    public void addUserDetails() {
        clickElement(addNewUser);
        WaitHelpers.visibilityOfElement(selectUserRole);
        sendInput(selectUserRole);
//        WaitHelpers.waitJVM(2000);
        sendInput(selectStatus);
//        WaitHelpers.waitJVM(3000);
        sendInput(selectEmployeeName, "a");
//        WaitHelpers.waitJVM(3000);
        enterInput(addUsername, "Sandy");
//        WaitHelpers.waitJVM(3000);
//        WaitHelpers.elementToBeClickable(addPassword);
        enterInput(addPassword, PropertiesReader.readKey("admin_password"));
//        WaitHelpers.waitJVM(2000);
        enterInput(confirmPassword, PropertiesReader.readKey("admin_password"));
        clickElement(saveDetails);
    }

    // ******************************************************************
    // Validating Job tab from Admin Tab
    private By enterJobTab = By.xpath("//div/nav/ul/li[2]/span");
    private By confirmDelete = By.xpath("//div[@class='orangehrm-modal-footer']/button[2]");
    private By deleteStatus = By.xpath("(//i[contains(@class,'bi-trash')])[1]");
    private By deleteSuccessMsg = By.id("oxd-toaster_1");
    private By sectItem = By.xpath("(//li[.//span[normalize-space()='Job']]//ul//li)[3]");
    public String deleteEmploymentStatus() {
        clickElement(enterJobTab);
        clickElement(sectItem);
        WaitHelpers.visibilityOfElement(deleteStatus);
        clickElement(deleteStatus);
        WaitHelpers.visibilityOfElement(confirmDelete);
        clickElement(confirmDelete);
        WaitHelpers.visibilityOfElement(deleteSuccessMsg);
        return getText(deleteSuccessMsg);

    }

}