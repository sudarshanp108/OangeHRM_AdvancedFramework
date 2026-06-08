package com.orangehrmlive.Tests.TestDashboard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import static com.orangehrmlive.Driver.DriverManager.driver;

public class table_demo_ohr {


    public static void getTableData() {
        // 1. Explicitly wait up to 10 seconds for the table rows to be visible on screen
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[@class='oxd-table-card']")
        ));

        System.out.println("Total data rows found: " + rows.size());

        // 2. Loop through each row element directly
        for (WebElement row : rows) {
            // Find all cells nested strictly inside the current row
            List<WebElement> cells = row.findElements(By.xpath(".//div[@role='cell']"));

            for (WebElement cell : cells) {
                // .getText() grabs all text inside the cell, even if wrapped in spans/divs
                String data = cell.getText().trim();

                // If the cell text is empty (e.g. checkbox column or action buttons), print a placeholder
                if (data.isEmpty()) {
                    data = "[Empty/Action]";
                }
                System.out.print(data + " \t ");
            }
            System.out.println(); // Line break after finishing a row
        }
    }

}
