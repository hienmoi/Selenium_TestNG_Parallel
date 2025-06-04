package Bai33_ExtenReport.TestCase;

import Bai33_ExtenReport.Pages.customerPage;
import Bai33_ExtenReport.Pages.loginPage;
import Common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class customerTest extends BaseTest {
    Bai33_ExtenReport.Pages.loginPage loginPage;
    Bai33_ExtenReport.Pages.customerPage customerPage;
    @Test
    public void addNewCustomer() throws InterruptedException {
        loginPage = new loginPage();
        loginPage.loginCRM("https://crm.anhtester.com/admin/authentication", "admin@example.com", "123456");
        customerPage = new customerPage();
        customerPage.clickMenuCustomer();
        customerPage.verifyNavigationCustomerPage();
        int beforeTotal = customerPage.getCustomerTotal();
        customerPage.clickButtonAddnewCustomer();
        String customerName = "13052025 06:24";
        customerPage.submitNewCustomer(customerName);
        customerPage.searchAndCheckCustomerInTable(customerName);
        customerPage.clickFirstCustomeInTable();
        customerPage.verifysubmitNewCustomer(customerName);
        customerPage.clickMenuCustomer();
        customerPage.verifyNavigationCustomerPage();
        int afterTotal = customerPage.getCustomerTotal();
        Assert.assertEquals(afterTotal, beforeTotal + 1, "The total customer before and after not match");



    }

}
