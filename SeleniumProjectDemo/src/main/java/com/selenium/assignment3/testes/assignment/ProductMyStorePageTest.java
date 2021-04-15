package com.selenium.assignment3.testes.assignment;

import com.selenium.assignment3.core.BaseTest;
import com.selenium.assignment3.core.ExcelUtils;
import com.selenium.assignment3.core.TestCase;
import com.selenium.assignment3.core.TestListener;
import com.selenium.assignment3.pages.assignment.ProductMyStorePage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Listeners({TestListener.class})
public class ProductMyStorePageTest extends BaseTest {
    public static final String fileInput = "test_data\\ProductsMyStore.xlsx";
    public static final String sheetName = "Products";
    public static List<TestCase> listTestcase = new ArrayList<>();

    @Test(dataProvider = "test-data")
    public void testProductPage(String productTitle, String productPrice) {
        ProductMyStorePage productPage = new ProductMyStorePage(getDriver());
        productPage.navigateToProductPage("http://automationpractice.com/index.php");
        productPage.search("Faded Short Sleeve T-shirts");
        try {
            productPage.clickSearchBtn();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            productPage.clickFirstResult();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (productPage.verify(productTitle, productPrice)) {
            listTestcase.add(new TestCase("", "", "PASSED"));
        } else {
            listTestcase.add(new TestCase("", "", "FAILED"));
            Assert.fail("Fail");
        }
        try {
            productPage.clickAddToCartBtn();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(productPage.verifyText("There is 1 item in your cart."), true, "Fail to verify Text add to cart");
        productPage.navigateToProductPage("http://automationpractice.com/index.php?controller=order");
        Assert.assertEquals(productPage.verifyCart(), true, "Fail to verify Cart");
    }

    @DataProvider(name = "test-data")
    public Object[][] getData() throws Exception {
        return ExcelUtils.getTableArray(fileInput, sheetName, 1, 2);
    }

    @AfterSuite
    @Override
    public void afterSuite() {
        super.afterSuite();
        try {
            if (listTestcase.size() > 0) {
                ExcelUtils.writeExcel(listTestcase, fileInput, sheetName, 3, "output\\ProductsMyStore.xlsx");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
