package core;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;

    public static Object[][] getTableArray(String FilePath, String SheetName, int startCol,int totalCols) throws Exception {

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

                for (int j = startCol; j < totalCols+startCol; j++, cj++) {

                    tabArray[ci][cj] = getCellData(i, j);

                    System.out.println("p:"+tabArray[ci][cj]);

                }

            }

        }

        catch (FileNotFoundException e) {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        }

        catch (IOException e) {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        }

        return (tabArray);

    }

    public static String getCellData(int RowNum, int ColNum) throws Exception {

        try {

            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

            String CellData = Cell.getStringCellValue();

            return CellData;
        } catch (Exception e) {

            System.out.println(e.getMessage());

            throw (e);

        }

    }


    public static void writeExcel(List<TestCase> listTestCase, String excelFilePath, String sheetName) throws IOException {
        FileInputStream ExcelFile = new FileInputStream(excelFilePath);

        // Access the required test data sheet

        ExcelWBook = new XSSFWorkbook(ExcelFile);
        ExcelWSheet = ExcelWBook.getSheet(sheetName);

        int rowCount = 0;

        for (TestCase aTestCase : listTestCase) {
            org.apache.poi.ss.usermodel.Row row = ExcelWSheet.getRow(++rowCount);
            writeTestCase(aTestCase, row);
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            ExcelWBook.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeTestCase(TestCase aTestCase, Row row) {
        org.apache.poi.ss.usermodel.Cell cell = row.createCell(4);
        cell.setCellValue(aTestCase.getResult());
    }
}
