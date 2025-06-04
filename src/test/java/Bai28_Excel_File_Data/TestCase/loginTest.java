package Bai28_Excel_File_Data.TestCase;

import Bai26_ParallelExcutionPOM.Pages.loginPage;
import Common.BaseTest;
import helpers.ExcelHelper;
import org.testng.annotations.Test;

public class loginTest extends BaseTest {

    Bai26_ParallelExcutionPOM.Pages.loginPage loginPage;

    @Test
    public void loginSuccess() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/Datatest/crm_datatest.xlsx", "Login");

        loginPage = new loginPage();
        loginPage.loginCRM(
                excelHelper.getCellData("Email", 1),
                excelHelper.getCellData("Password", 1)
        );
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void loginfail_emailInvalid() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/Datatest/crm_datatest.xlsx", "Login");

        loginPage = new loginPage();
        loginPage.loginCRM(
                excelHelper.getCellData("Email", 2),
                excelHelper.getCellData("Password", 2)
        );
        loginPage.verifyLoginFail();
    }

    @Test
    public void loginfail_passwordNull() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/Datatest/crm_datatest.xlsx", "Login");

        loginPage = new loginPage();
        loginPage.loginCRM(
                excelHelper.getCellData("Email", 3),
                excelHelper.getCellData("Password", 3)
        );
        loginPage.verifyLoginFail("The Password field is required.");
    }
    @Test
    public void loginfail_emailNull()  {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/Datatest/crm_datatest.xlsx", "Login");

        loginPage = new loginPage();
        loginPage.loginCRM(
                excelHelper.getCellData("Email", 4),
                excelHelper.getCellData("Password", 4)
        );
        loginPage.verifyLoginFail("The Email Address field is required.");
    }

}
