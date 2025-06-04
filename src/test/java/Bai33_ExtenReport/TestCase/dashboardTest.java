package Bai33_ExtenReport.TestCase;

import Bai33_ExtenReport.Pages.loginPage;
import Common.BaseTest;
import org.testng.annotations.Test;

public class dashboardTest extends BaseTest {
    Bai33_ExtenReport.Pages.loginPage loginPage;
    Bai33_ExtenReport.Pages.dashboardPage dashboardPage;


    @Test
    public void checkTotalInvoicesAwaitingPayment() {
        loginPage = new loginPage();
        //loginPage.loginCRM("https://crm.anhtester.com/admin/authentication", "admin@example.com", "123456");
        //dashboardPage = new dashboardPage(driver);
        dashboardPage = loginPage.loginCRM();
        dashboardPage.verifytotalInvoicesAwaitingPayment("0 / 2");
    }

    @Test
    public void checkTotalConvertedLeads() {
        loginPage = new loginPage();
        //loginPage.loginCRM("https://crm.anhtester.com/admin/authentication", "admin@example.com", "123456");
        //dashboardPage = new dashboardPage(driver);
        dashboardPage = loginPage.loginCRM();
        dashboardPage.verifytotalConvertedLeads("1 / 1");
    }

}
