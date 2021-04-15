package com.selenium.assignment3.data_test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class DataTestProduct {

    @Test
    public void genDataProductsAmazon() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Products");

        Object[][] bookData = {
                {"TCID", "URL", "SearchKey", "Product Title", "Pass/Fail"},
                {"1", "www.amazon.com", "Selenium", "Selenium Testing Tools Cookbook", ""},
                {"2", "www.amazon.com", "Java", "Effective Java", ""},
                {"3", "www.amazon.com", "Appium", "Appium Essential", ""}
        };

        int rowCount = 0;

        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(rowCount++);

            int columnCount = 0;

            for (Object field : aBook) {
                Cell cell = row.createCell(columnCount++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }

        }


        try (FileOutputStream outputStream = new FileOutputStream("test_data\\Products.xlsx")) {
            workbook.write(outputStream);
        }
    }

    @Test
    public void genDataProductsMyStore() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Products");

        Object[][] bookData = {
                {"TCID","Product Title", "Product Price", "Pass/Fail"},
                {"1", "Faded Short Sleeve T-shirts", "16.51", ""},
                {"2", "Blouse", "27", ""},
                {"3", "Printed Dress", "26", ""}
        };

        int rowCount = 0;

        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(rowCount++);

            int columnCount = 0;

            for (Object field : aBook) {
                Cell cell = row.createCell(columnCount++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }


        try (FileOutputStream outputStream = new FileOutputStream("test_data\\ProductsMyStore.xlsx")) {
            workbook.write(outputStream);
        }
    }

    @Test
    public void genDataAccount() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Accounts");

        Object[][] bookData = {
                {"TCID","Email Address", "Password", "Result"},
                {"1", "exercises7@gmail.com", "Exercises7", ""}, //Valid
                {"2", "test1996", "12345", ""},                  //Invalid email
                {"3", "exercises7@gmail.com", "123456", ""},     //Invalid
                {"4", "", "", ""},                               //email address is require
                {"5", "", "12345", ""},                          //email address is require
                {"6", "2366623@gmail.com", "", ""}                   //password is require
        };

        int rowCount = 0;

        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(rowCount++);

            int columnCount = 0;

            for (Object field : aBook) {
                Cell cell = row.createCell(columnCount++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }


        try (FileOutputStream outputStream = new FileOutputStream("test_data\\Accounts.xlsx")) {
            workbook.write(outputStream);
        }
    }
}
