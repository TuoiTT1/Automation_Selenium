package tests;

import cores.BaseTest;
import cores.ExcelUtils;
import cores.TestCase;
import cores.TestListener;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

import java.util.ArrayList;
import java.util.List;

@Listeners(TestListener.class)
public class WarehouseTest extends BaseTest {
    private static final List<TestCase> testCaseList = new ArrayList<>();
    private static final List<TestCase> testcaseSearchList = new ArrayList<>();

    //TC_01: Verify Warehouses page
    @Test
    public void verifyWarehousePage() {
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
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Fail to Verify Warehouses page");
        } finally {
            getDriver().manage().deleteAllCookies();
        }

    }

    //TC_02: Verify Warehouses Search Results
    @Test(dataProvider = "search_warehouse")
    public void verifyWarehousesSearchResults(String key, String warehouseIdRsl, String warehouseNameRsl, String warehouseTypeRsl, String ownerRsl, String descriptionRsl) {
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

            warehousePage.searchByWarehouseId(key);
            Thread.sleep(3000);
            if (warehousePage.verifySearchResult(warehouseIdRsl,
                    warehouseNameRsl,
                    warehouseTypeRsl, ownerRsl,
                    descriptionRsl)) {
                testCaseList.add(new TestCase("TC_02", "Verify Warehouses Search Results", "PASSED", ""));
                testcaseSearchList.add(new TestCase("", "", "PASS", ""));
            } else {
                testCaseList.add(new TestCase("TC_02", "Verify Warehouses Search Results", "Fail", ""));
                testcaseSearchList.add(new TestCase("", "", "FAIL", ""));
                Assert.fail("Fail to Verify Warehouses Search Results");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Fail to Verify Warehouses Search Results");
        } finally {
            getDriver().manage().deleteAllCookies();
        }

    }

    //    TC_03: Verify Create New Warehouses
    @Test
    public void verifyCreateNewWarehouses() {
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

            warehousePage.clickCreateNew();
            Thread.sleep(3000);

            warehousePage.createNewWarehouse("Floor", "ACCOUNTING", "ACCOUNTING",
                    "Gram (g)", "Serialized", "Test_demo",
                    "Square Millimeter (mm2)", "Test Automation");
            Thread.sleep(3000);

            if (warehousePage.verifyFailToCreate()) {
                testCaseList.add(new TestCase("TC_03", "Verify Create New Warehouses", "PASSED", ""));
            } else {
                testCaseList.add(new TestCase("TC_03", "Verify Create New Warehouses", "Fail", ""));
                Assert.fail("Fail to Verify Create New Warehouses");
            }

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Fail to Verify Create New Warehouses");
        } finally {
            getDriver().manage().deleteAllCookies();
        }
    }

    //TC_04: Verify Inventory page
    @Test
    public void verifyInventoryPage() {
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
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Fail to Verify Inventory page");
        } finally {
            getDriver().manage().deleteAllCookies();
        }

    }

    //TC_05: Verify Create New Inventory page
    @Test
    public void verifyCreateNewInventoryPage() {
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
            Assert.assertEquals(inventoryPage.verify(), true, "Fail to Verify Inventory page");

            inventoryPage.clickCreateNew();
            Thread.sleep(3000);
            inventoryPage.inputCreate("Serialized", "VH-9943", "ACCOUNTING",
                    "ACCOUNTING", "Available", "2021-04-29 22:31:18.982",
                    "2021-04-28 22:31:22.380", "2021-04-16 22:31:24.617",
                    "Web Store Warehouse", "TLTLTLLL01");
            Thread.sleep(3000);

            if (inventoryPage.verifyCreateNewInventory()) {
                testCaseList.add(new TestCase("TC_05", "Verify Create New Inventory page", "PASSED", ""));
            } else {
                testCaseList.add(new TestCase("TC_05", "Verify Create New Inventory page", "Fail", ""));
                Assert.fail("Fail to Verify Create New Inventory page");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Fail to Verify Create New Inventory page");
        } finally {
            getDriver().manage().deleteAllCookies();
        }

    }

    //TC_06: Verify Settings Page
    @Test
    public void verifySettingsPage() {
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

            navigationBarPage.clickSettings();
            Thread.sleep(3000);

            navigationBarPage.clickContactInfo();
            Thread.sleep(3000);

            ContactInfoPage contactInfoPage = new ContactInfoPage(getDriver());
            contactInfoPage.clickCreateNew();
            Thread.sleep(3000);
            Assert.assertEquals(contactInfoPage.verifyAfterClickNew(), true, "Fail to verify after click new");

            contactInfoPage.selectTypeContact("Postal Address");
            contactInfoPage.clickCreateBtn();
            Assert.assertEquals(contactInfoPage.verifyAfterClickCreate("Contact Purposes *", "To Name", "Attention Name",
                    "Address Line 1 *", "Address Line 2", "City *", "State/Province", "Zip/Postal Code *", "Country"),
                    true, "Fail to verify After Click Create");
            contactInfoPage.createNewContactInfo("Primary Address", "", "",
                    "So nha 21", "", "Ha Noi", "", "12500", "");
            Thread.sleep(3000);

            if (contactInfoPage.verifyCreateSuccess()) {
                testCaseList.add(new TestCase("TC_06", "Verify Settings Page", "PASSED", ""));
            } else {
                testCaseList.add(new TestCase("TC_06", "Verify Settings Page", "Fail", ""));
                Assert.fail("Fail to Verify Settings Page");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Fail to Verify Settings Page");
        } finally {
            getDriver().manage().deleteAllCookies();
        }

    }

    @DataProvider(name = "search_warehouse")
    public Object[][] getKeySearches() throws Exception {
        return ExcelUtils.getTableArray("test_data\\WarehouseSearch.xlsx", "Warehouse", 1, 6, 1);

    }

    @AfterSuite
    @Override
    public void afterSuite() {
        super.afterSuite();
        try {
            if (testCaseList.size() > 0) {
                ExcelUtils.writeExcel("output\\WarehouseTestCaseResult.xlsx", "TestCase", testCaseList);
            }
            if (testcaseSearchList.size() > 0) {
                ExcelUtils.writeExcel("test_data\\WarehouseSearch.xlsx", "Warehouse", "output\\WarehouseSearchResult.xlsx", testcaseSearchList, 7);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
