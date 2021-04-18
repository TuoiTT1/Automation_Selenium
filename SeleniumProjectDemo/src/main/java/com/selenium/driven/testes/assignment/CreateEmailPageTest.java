package com.selenium.assignment3.testes.assignment;

import com.selenium.assignment3.core.BaseTest;
import com.selenium.assignment3.core.ExcelUtils;
import com.selenium.assignment3.core.TestCase;
import com.selenium.assignment3.core.TestListener;
import com.selenium.assignment3.pages.assignment.CreateEmailPage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Listeners(TestListener.class)
public class CreateEmailPageTest extends BaseTest {
    public static final String fileInputPath = "test_data\\Accounts.xlsx";
    public static final String sheetName = "Accounts";
    public static List<TestCase> testCaseList = new ArrayList<>();

    @Test(dataProvider = "data-test")
    public void testCreateEmailPage(String tcid, String email){
        CreateEmailPage createEmailPage = new CreateEmailPage(getDriver());
        createEmailPage.navigate("http://automationpractice.com/index.php?controller=authentication");
        createEmailPage.inputEmail(email);
        try {
            createEmailPage.clickBtn();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(createEmailPage.verify()){
            testCaseList.add(new TestCase("", "", "PASSED"));
        }else{
            testCaseList.add(new TestCase("", "", "FAIL"));
            Assert.fail("Fail");
        }
    }

    @DataProvider(name = "data-test")
    public Object[][] getData() throws Exception {
        return ExcelUtils.getTableArray(fileInputPath, sheetName, 0, 2);
    }

    @AfterSuite
    @Override
    public void afterSuite() {
        super.afterSuite();
        try {
            ExcelUtils.writeExcel(testCaseList, fileInputPath, sheetName, 3, "output\\CreateEmailPageTest.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
