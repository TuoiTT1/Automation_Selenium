package com.selenium.assignment3.testes.assignment;

import com.selenium.assignment3.core.BaseTest;
import com.selenium.assignment3.core.ExcelUtils;
import com.selenium.assignment3.core.TestCase;
import com.selenium.assignment3.core.TestListener;
import com.selenium.assignment3.pages.assignment.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Listeners(TestListener.class)
public class LoginPageTest extends BaseTest {

    public static final String fileInputPath = "test_data\\Accounts.xlsx";
    public static final String sheetName = "Accounts";
    public static List<TestCase> testCaseList = new ArrayList<>();

    @Test(dataProvider = "data-test")
    public void testLoginPage(String testID, String email, String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigate("http://automationpractice.com/index.php?controller=authentication");
        loginPage.login(email, password);
        loginPage.clickLogin();
        if (loginPage.verify()) {
            testCaseList.add(new TestCase("", "", "PASSED"));
        } else {
            testCaseList.add(new TestCase("", "", "FAILED"));
            Assert.fail("Fail");
        }
    }

    @DataProvider(name = "data-test")
    public Object[][] getData() throws Exception {
        return ExcelUtils.getTableArray(fileInputPath, sheetName, 0, 3);
    }

    @AfterSuite
    @Override
    public void afterSuite() {
        super.afterSuite();
        try {
            ExcelUtils.writeExcel(testCaseList, fileInputPath, sheetName, 3, "output\\LoginPageTest.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
