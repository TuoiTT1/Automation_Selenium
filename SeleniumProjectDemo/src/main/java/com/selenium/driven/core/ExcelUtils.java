package com.selenium.assignment3.core;

import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelUtils {
    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;

    public static Object[][] getTableArray(String FilePath, String SheetName, int startCol, int totalCols) throws Exception {

        String[][] tabArray = null;

        try {

            FileInputStream ExcelFile = new FileInputStream(FilePath);

            // Access the required test data sheet

            ExcelWBook = new XSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheet(SheetName);

            int startRow = 1;

            int ci, cj;

            int totalRows = ExcelWSheet.getLastRowNum();

            tabArray = new String[totalRows][totalCols];

            ci = 0;

            for (int i = startRow; i <= totalRows; i++, ci++) {

                cj = 0;

                for (int j = startCol; j < totalCols + startCol; j++, cj++) {

                    tabArray[ci][cj] = getCellData(i, j);

                    System.out.println("p:" + tabArray[ci][cj]);

                }

            }

        } catch (FileNotFoundException e) {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        } catch (IOException e) {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        }

        return (tabArray);

    }

    public static String getCellData(int RowNum, int ColNum) throws Exception {

        try {

            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

            String CellData = getCellData();

            return CellData;
        } catch (Exception e) {

            System.out.println(e.getMessage());

            throw (e);

        }

    }


    public static void writeExcel(List<TestCase> listTestCase, String excelFilePath) throws IOException {
        ExcelWBook = new XSSFWorkbook();
        ExcelWSheet = ExcelWBook.createSheet();

        int rowCount = 0;

        for (TestCase aTestCase : listTestCase) {
            org.apache.poi.ss.usermodel.Row row = ExcelWSheet.createRow(rowCount++);
            writeTestCase(aTestCase, row);
        }

        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            ExcelWBook.write(outputStream);
        }
    }

    public static void writeExcel(TestCase testCase, String excelFilePath, int rowIndex, int columnIndex) throws IOException {
        FileInputStream fis = new FileInputStream(excelFilePath);
        ExcelWBook = new XSSFWorkbook(fis);
        ExcelWSheet = ExcelWBook.getSheet("TestCase");

        org.apache.poi.ss.usermodel.Row row = ExcelWSheet.getRow(rowIndex);
        writeTestCase(testCase, row, columnIndex);

        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            ExcelWBook.write(outputStream);
            fis.close();
        }
    }

    public static void writeExcel(List<TestCase> listTestCase, String sourceFile, String sheetName, int columnResult, String outputFile) throws IOException {
        FileInputStream fis = new FileInputStream(sourceFile);
        ExcelWBook = new XSSFWorkbook(fis);
        ExcelWSheet = ExcelWBook.getSheet(sheetName);

        int rowCount = 0;

        for (TestCase aTestCase : listTestCase) {
            org.apache.poi.ss.usermodel.Row row = ExcelWSheet.getRow(++rowCount);
            writeTestCase(aTestCase, row, columnResult);
        }

        try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
            ExcelWBook.write(outputStream);
            fis.close();
        }
    }

    private static void writeTestCase(TestCase aTestCase, Row row) {
        org.apache.poi.ss.usermodel.Cell cell = row.createCell(0);
        cell.setCellValue(aTestCase.getTCID());

        cell = row.createCell(1);
        cell.setCellValue(aTestCase.getTCName());


        cell = row.createCell(2);
        cell.setCellValue(aTestCase.getResult());
    }

    private static void writeTestCase(TestCase aTestCase, Row row, int columnResult) {
        org.apache.poi.ss.usermodel.Cell cell = row.getCell(columnResult);
        if(cell == null){
            cell = row.createCell(columnResult);
        }
        cell.setCellValue(aTestCase.getResult());
    }

    public static String getCellData() {
        String value = "";
        try {
            FormulaEvaluator formulaEvaluator = ExcelWBook.getCreationHelper().createFormulaEvaluator();
            switch (Cell.getCellType()) {
                case XSSFCell.CELL_TYPE_NUMERIC:
                    value = Cell.getNumericCellValue() + "";
                    break;
                case XSSFCell.CELL_TYPE_STRING:
                    value = Cell.getStringCellValue();
                    break;
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return value;
    }
}
