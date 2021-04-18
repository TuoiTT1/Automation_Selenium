package tests;

import cores.BaseTest;
import cores.ExcelUtils;
import cores.TestCase;
import cores.TestListener;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

import java.util.ArrayList;
import java.util.List;

@Listeners(TestListener.class)
public class WarehouseTest extends BaseTest {
    private static List<TestCase> testCaseList = new ArrayList<>();

    //Verify Warehouses page
    @Test
    public void verifyWarehousePage(){
        try {
            LoginPage loginPage = new LoginPage(getDriver());
            loginPage.navigate("https://ce.scipioerp.com/facility/");
            Assert.assertEquals(loginPage.verifyLoginPage(), true, "Fail to navigate to scipioerp login page.");

            loginPage.login("admin", "scipio");
            Thread.sleep(3000);
            HeaderPage headerPage = new HeaderPage(getDriver());
            Assert.assertEquals(headerPage.verifyLoginSuccessfully(), true, "Fail to login.");

            NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver());
            navigationBarPage.clickWarehouse();
            Thread.sleep(3000);

            WarehousePage warehousePage = new WarehousePage(getDriver());
            if (warehousePage.verify()) {
                testCaseList.add(new TestCase("TC_01", "Verify Warehouses page", "PASSED", ""));
            } else {
                testCaseList.add(new TestCase("TC_01", "Verify Warehouses page", "Fail", ""));
                Assert.fail("Fail to Verify Warehouses page");
            }
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail("Fail to Verify Warehouses page");
        }finally {
            getDriver().manage().deleteAllCookies();
        }

    }

    //Verify Warehouses Search Results
    @Test
    public void verifyWarehousesSearchResults(){
        try {
            LoginPage loginPage = new LoginPage(getDriver());
            loginPage.navigate("https://ce.scipioerp.com/facility/");
            Assert.assertEquals(loginPage.verifyLoginPage(), true, "Fail to navigate to scipioerp login page.");

            loginPage.login("admin", "scipio");
            Thread.sleep(3000);
            HeaderPage headerPage = new HeaderPage(getDriver());
            Assert.assertEquals(headerPage.verifyLoginSuccessfully(), true, "Fail to login.");

            NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver());
            navigationBarPage.clickWarehouse();
            Thread.sleep(3000);

            WarehousePage warehousePage = new WarehousePage(getDriver());
            Assert.assertEquals(warehousePage.verify(), true, "Fail to verify Warehouses page");

            warehousePage.searchByWarehouseId("ScipioShopWarehouse");
            Thread.sleep(3000);
            if (warehousePage.verifySearchResult("ScipioShopWarehouse",
                    "Web Store Warehouse",
                    "Warehouse", "Company",
                    "Warehouse exclusively for the Web Store")) {
                testCaseList.add(new TestCase("TC_02", "Verify Warehouses Search Results", "PASSED", ""));
            } else {
                testCaseList.add(new TestCase("TC_02", "Verify Warehouses Search Results", "Fail", ""));
                Assert.fail("Fail to Verify Warehouses Search Results");
            }
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail("Fail to Verify Warehouses Search Results");
        }finally {
            getDriver().manage().deleteAllCookies();
        }

    }

    //Verify Create New Warehouses
//    @Test
//    public void verifyCreateNewWarehouses(){
//        try {
//            LoginPage loginPage = new LoginPage(getDriver());
//            loginPage.navigate("https://ce.scipioerp.com/facility/");
//            Assert.assertEquals(loginPage.verifyLoginPage(), true, "Fail to navigate to scipioerp login page.");
//
//            loginPage.login("admin", "scipio");
//            Thread.sleep(3000);
//            HeaderPage headerPage = new HeaderPage(getDriver());
//            Assert.assertEquals(headerPage.verifyLoginSuccessfully(), true, "Fail to login.");
//
//            NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver());
//            navigationBarPage.clickWarehouse();
//            Thread.sleep(3000);
//
//            WarehousePage warehousePage = new WarehousePage(getDriver());
//            Assert.assertEquals(warehousePage.verify(), true, "Fail to verify Warehouses page");
//
//            warehousePage.clickCreateNew();
//            Thread.sleep(4000);
//
//
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            getDriver().manage().deleteAllCookies();
//        }
//    }

    //Verify Inventory page
    @Test
    public void verifyInventoryPage(){
        try {
            LoginPage loginPage = new LoginPage(getDriver());
            loginPage.navigate("https://ce.scipioerp.com/facility/");
            Assert.assertEquals(loginPage.verifyLoginPage(), true, "Fail to navigate to scipioerp login page.");

            loginPage.login("admin", "scipio");
            Thread.sleep(3000);
            HeaderPage headerPage = new HeaderPage(getDriver());
            Assert.assertEquals(headerPage.verifyLoginSuccessfully(), true, "Fail to login.");

            NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver());
            navigationBarPage.clickWarehouse();
            Thread.sleep(3000);

            WarehousePage warehousePage = new WarehousePage(getDriver());
            Assert.assertEquals(warehousePage.verify(), true, "Fail to verify Warehouses page");

            warehousePage.searchByWarehouseId("ScipioShopWarehouse");
            Thread.sleep(3000);

            Assert.assertEquals(warehousePage.verifySearchResult("ScipioShopWarehouse",
                    "Web Store Warehouse",
                    "Warehouse", "Company",
                    "Warehouse exclusively for the Web Store"), true, "Fail to search by Warehouse ID");
            warehousePage.clickToFirstRsl();
            Thread.sleep(3000);

            navigationBarPage.clickInventory();
            Thread.sleep(3000);

            InventoryPage inventoryPage = new InventoryPage(getDriver());
            if (inventoryPage.verify()) {
                testCaseList.add(new TestCase("TC_04", "Verify Inventory page", "PASSED", ""));
            } else {
                testCaseList.add(new TestCase("TC_04", "Verify Inventory page", "Fail", ""));
                Assert.fail("Fail to Verify Inventory page");
            }
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail("Fail to Verify Inventory page");
        }finally {
            getDriver().manage().deleteAllCookies();
        }

    }
            @AfterSuite
    @Override
    public void afterSuite() {
        super.afterSuite();
        try {
            ExcelUtils.writeExcel("output\\WarehouseTestCaseResult.xlsx", "TestCase", testCaseList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
