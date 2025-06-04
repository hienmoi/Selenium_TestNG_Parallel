package Bai28_Excel_File_Data.TestCase;

import Bai26_ParallelExcutionPOM.Pages.loginPage;
import Common.BaseTest;
import org.testng.annotations.Test;

public class dashboardTest extends BaseTest {
    Bai26_ParallelExcutionPOM.Pages.loginPage loginPage;
    Bai26_ParallelExcutionPOM.Pages.dashboardPage dashboardPage;


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
