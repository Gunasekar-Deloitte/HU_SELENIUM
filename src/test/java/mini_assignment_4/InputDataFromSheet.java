package pages;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputDataFromSheet {
    WebDriver driver;
    LoginPage lg = new LoginPage();
    By userName = By.xpath("//*[@id='user-name']");
    By password = By.xpath("//*[@id='password']");
    By loginButton = By.xpath("//*[@id='login-button']");
    By logout = By.xpath("//*[@id='logout_sidebar_link']");

    public void login(WebDriver driver) throws IOException, InterruptedException {
        String filePath = "C:\\Users\\gunass\\Mini_Assignment_4\\src\\Mini_assignment_4_data.xlsx";
        FileInputStream file = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);

        XSSFRow row = null;
        XSSFCell cell = null;
        String userNames = null;
        String passwords = null;

        for(int i =1; i<=sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                cell = row.getCell(j);
                if (j == 0) {
                    userNames = cell.getStringCellValue();
                }
                if (j == 1) {
                    passwords = cell.getStringCellValue();
                }
            }
            System.out.println("***********Reading Data From Excel Sheet**********");

            this.driver.findElement(userName).sendKeys(userNames);
            this.driver.findElement(lg.password).sendKeys(passwords);
            Thread.sleep(3000);
            this.driver.findElement(lg.loginButton).click();
            String result = null;

            String actualUrl1 = this.driver.getCurrentUrl();
            Boolean isLoggedin = actualUrl1.equals("https://www.saucedemo.com/inventory.html");

            if (isLoggedin == true) {
                result = "Login successful";

            } else {
                result = "Login fail";
            }
        }
            System.out.println("____________Write data into the sheet__________________");

            FileOutputStream fos = new FileOutputStream("C:\\Users\\gunass\\Mini_Assignment_4\\src\\Mini_assignment_4_data.xlsx");
            cell = row.createCell(2);
            cell.setCellType(CellType.STRING);
            cell.setCellValue(result);
            workbook.write(fos);
            fos.close();
        }
    }
}
