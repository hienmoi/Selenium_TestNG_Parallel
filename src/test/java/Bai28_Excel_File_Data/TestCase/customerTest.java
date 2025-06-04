package Bai28_Excel_File_Data.TestCase;

import Bai28_Excel_File_Data.Pages.customerPage;
import Bai28_Excel_File_Data.Pages.loginPage;
import Common.BaseTest;
import helpers.ExcelHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class customerTest extends BaseTest {
    Bai28_Excel_File_Data.Pages.loginPage loginPage;
    Bai28_Excel_File_Data.Pages.customerPage customerPage;
    @Test
    public void addNewCustomer() throws InterruptedException {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/Datatest/crm_datatest.xlsx", "Customer");

        loginPage = new Bai28_Excel_File_Data.Pages.loginPage();
        loginPage.loginCRM();
        customerPage = new Bai28_Excel_File_Data.Pages.customerPage();
        customerPage.clickMenuCustomer();
        customerPage.verifyNavigationCustomerPage();
        int beforeTotal = customerPage.getCustomerTotal();
        customerPage.clickButtonAddnewCustomer();
        customerPage.submitNewCustomer(3);
        customerPage.searchAndCheckCustomerInTable(3);
        customerPage.clickFirstCustomeInTable();
        customerPage.verifysubmitNewCustomer(3);
        customerPage.clickMenuCustomer();
        customerPage.verifyNavigationCustomerPage();
        int afterTotal = customerPage.getCustomerTotal();
        Assert.assertEquals(afterTotal, beforeTotal + 1, "The total customer before and after not match");
        excelHelper.setCellData("Passed", "Status", 3);

    }



}
