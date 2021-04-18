package com.selenium.assignment3.testes.assignment;

import com.selenium.assignment3.core.BaseTest;
import com.selenium.assignment3.core.ExcelUtils;
import com.selenium.assignment3.core.TestCase;
import com.selenium.assignment3.core.TestListener;
import com.selenium.assignment3.pages.assignment.ProductAmazonPage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Listeners({TestListener.class})
public class ProductAmazonPageTest extends BaseTest {

    public static final String fileInput = "test_data\\Products.xlsx";
    public static final String sheetName = "Products";
    public static List<TestCase> listTestcase = new ArrayList<>();

    @Test(dataProvider = "test-data")
    public void testProductPage(String searchKey, String productTitle) throws InterruptedException {
        ProductAmazonPage productPage = new ProductAmazonPage(getDriver());
        productPage.navigateToProductPage("https://www.amazon.com/");
        productPage.selectCategory("Books");
        productPage.inputSearchKey(searchKey);
        productPage.clickGo();
        productPage.clickFirstResult();
        if (productPage.verify(productTitle)) {
            listTestcase.add(new TestCase("", "", "PASSED"));
        } else {
            listTestcase.add(new TestCase("", "", "FAILED"));
            Assert.fail("Fail");
        }

    }

    @DataProvider(name = "test-data")
    public Object[][] getData() throws Exception {
        return ExcelUtils.getTableArray(fileInput, sheetName, 2, 2);
    }

    @AfterSuite
    @Override
    public void afterSuite() {
        super.afterSuite();
        try {
            if (listTestcase.size() > 0)
                ExcelUtils.writeExcel(listTestcase, fileInput, sheetName, 4, "output\\ProductPageTest.xlsx");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
