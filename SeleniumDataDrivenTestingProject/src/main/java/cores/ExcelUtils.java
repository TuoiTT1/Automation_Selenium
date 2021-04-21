package cores;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelUtils {

    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFRow row;
    private static XSSFCell cell;
    private static FileInputStream fis;

    public static String getValueCell(int rowNum, int colNum) {
        try {
            row = sheet.getRow(rowNum);
            cell = row.getCell(colNum);
            return getDataCell();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw (e);
        }
    }

    public static String getDataCell() {
        String value = "";
        if (cell != null) {
            try {

                switch (cell.getCellType()) {
                    case XSSFCell.CELL_TYPE_NUMERIC -> value = String.valueOf(cell.getNumericCellValue());
                    case XSSFCell.CELL_TYPE_STRING -> value = cell.getStringCellValue();
                    case XSSFCell.CELL_TYPE_BOOLEAN -> value = String.valueOf(cell.getBooleanCellValue());
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                throw (e);
            }
        }
        return value;
    }

    public static void close() throws IOException {
        if (fis != null) {
            fis.close();
        }
    }

    public static void writeExcel(String filePath, String sheetName, List<TestCase> testCaseList) throws Exception {
        FileOutputStream fos = null;
        try {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet(sheetName);
            writeTitleTestcase();
            for (int i = 0; i < testCaseList.size(); i++) {
                row = sheet.createRow((i + 1));
                writeTestcase(testCaseList.get(i), row);
            }
            fos = new FileOutputStream(filePath);
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                fos.close();
            }
        }

    }

    public static void writeExcel(String filePathInput, String sheetName, String filePathOutput, List<TestCase> testCaseList, int colResult) throws Exception {
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(filePathInput);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
            for (int i = 0; i < testCaseList.size(); i++) {
                row = sheet.getRow((i + 1));
                writeTestcase(testCaseList.get(i), row, colResult);
            }
            fos = new FileOutputStream(filePathOutput);
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                fos.close();
            }
            close();
        }

    }

    private static void writeTitleTestcase() {
        row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("TCID");

        cell = row.createCell(1);
        cell.setCellValue("Test Case Title");

        cell = row.createCell(2);
        cell.setCellValue("Result");

        cell = row.createCell(3);
        cell.setCellValue("Note");
    }

    private static void writeTestcase(TestCase testCase, Row row) {
        Cell cell = row.createCell(0);
        cell.setCellValue(testCase.getTcid());

        cell = row.createCell(1);
        cell.setCellValue(testCase.getTitle());

        cell = row.createCell(2);
        cell.setCellValue(testCase.getResult());

        cell = row.createCell(3);
        cell.setCellValue(testCase.getNote());
    }

    private static void writeTestcase(TestCase testCase, Row row, int colResult) {
        Cell cell = row.getCell(colResult);
        if (cell == null) {
            cell = row.createCell(colResult);
        }
        cell.setCellValue(testCase.getResult());
    }

    public static Object[][] getTableArray(String filePath, String sheetName, int startCol, int totalCols, int startRow) throws Exception {
        String[][] tabArr = null;
        try {
            fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);

            int ci, cj;
            int totalRows = sheet.getLastRowNum();
            int totalColumns = startCol + totalCols;

            tabArr = new String[totalRows][totalCols];
            ci = 0;
            for (int i = startRow; i <= totalRows; i++) {
                cj = 0;
                for (int j = startCol; j < totalColumns; j++) {
                    tabArr[ci][cj] = getValueCell(i, j);
                    System.out.println("p: " + tabArr[ci][cj]);
                    cj++;
                }
                ci++;
            }

        } catch (IOException e) {
            System.out.println("Could not read sheet " + sheetName + " in file " + filePath);
            e.printStackTrace();
        } finally {
            close();
        }
        return tabArr;
    }

    public static void writeExcel(Object[][] objects, String sheetName, String filePath){
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet(sheetName);
        int rowCount = 0;
        int columCount = 0;
        for (Object[] objs: objects) {
            row = sheet.createRow(rowCount++);
            columCount = 0;
            for(Object obj: objs){
                cell = row.createCell(columCount++);
                if(obj instanceof String){
                    cell.setCellValue((String) obj);
                } else if(obj instanceof Integer){
                    cell.setCellValue((Integer) obj);
                }
            }
        }
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(filePath);
            workbook.write(fos);
        }catch (Exception e){
            System.out.println("Error when write excel file");
            e.printStackTrace();
        }finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    System.out.println("Error when write excel file");
                    e.printStackTrace();
                }
            }
        }
    }
}
