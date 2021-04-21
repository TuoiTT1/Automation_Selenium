package data_tests;

import cores.ExcelUtils;
import org.testng.annotations.Test;

public class GenerationData {

    @Test
    public void genDataForSearchWarehouseById(){
        Object[][] keyResults = {
                {"TCID", "Key", "Warehouse ID", "Warehouse Name", "Warehouse Type", "Owner", "Description", "Result"},
                {"1", "ScipioShopWarehouse", "ScipioShopWarehouse", "Web Store Warehouse", "Warehouse", "Company", "Warehouse exclusively for the Web Store", ""},
                {"2", "MajorLeagueWarehouse", "ScipioShopWarehouse", "Web Store Warehouse", "Warehouse", "Company", "Warehouse exclusively for the Web Store", ""}
        };
        ExcelUtils.writeExcel(keyResults, "Warehouse", "test_data\\WarehouseSearch.xlsx");
    }
}
