package data_tests;

import cores.ExcelUtils;
import org.testng.annotations.Test;

public class GenerationData {

    @Test
    public void genDataForCreateNewWarehouses() {
        Object[][] keyResults = {
                {"TCID", "Warehouse Type ID", "Parent Warehouse ID", "Owner Party ID","Default Weight Unit", "Default Inventory Item Type", "Name", "Area Unit", "Product Description", "Result"},
                {"1", "Floor", "ACCOUNTING", "ACCOUNTING", "Gram (g)", "Serialized", "Test_demo", "Square Millimeter (mm2)", "Test Automation", ""},
                {"2", "Floor", "", "ACCOUNTING", "Gram (g)", "Serialized", "Test_demo", "Square Millimeter (mm2)", "Test Automation", ""},
                {"3", "", "ACCOUNTING", "ACCOUNTING", "Gram (g)", "Serialized", "Test_demo", "Square Millimeter (mm2)", "Test Automation", ""}
        };
        ExcelUtils.writeExcel(keyResults, "Warehouse", "test_data\\NewWarehouse.xlsx");
    }

    @Test
    public void genDataForSearchWarehouseById() {
        Object[][] keyResults = {
                {"TCID", "Key", "Warehouse ID", "Warehouse Name", "Warehouse Type", "Owner", "Description", "Result"},
                {"1", "ScipioShopWarehouse", "ScipioShopWarehouse", "Web Store Warehouse", "Warehouse", "Company", "Warehouse exclusively for the Web Store", ""},
                {"2", "MajorLeagueWarehouse", "ScipioShopWarehouse", "Web Store Warehouse", "Warehouse", "Company", "Warehouse exclusively for the Web Store", ""}
        };
        ExcelUtils.writeExcel(keyResults, "Warehouse", "test_data\\WarehouseSearch.xlsx");
    }
}