package Bai34_AllureReport.TestCase;

import Bai34_AllureReport.Pages.loginPage;
import Common.BaseTest;
import DataProviderFactory.DataProviderFactory;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class loginTest extends BaseTest {

    Bai34_AllureReport.Pages.loginPage loginPage;

    @Feature("Regression")
    @Owner("Hien")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "Data_Provider_Login_Success", dataProviderClass = DataProviderFactory.class)
    public void loginSuccess( String email, String password) {
        loginPage = new loginPage();
        loginPage.loginCRM(email, password);
        loginPage.verifyLoginSuccess();
    }

    @Feature("Regression")
    @Owner("Hien")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "data_provider_login_excel", dataProviderClass = DataProviderFactory.class)
    public void loginSuccessFromDataProvider( String email, String password) {
        loginPage = new loginPage();
        loginPage.loginCRM(email, password);
        loginPage.verifyLoginSuccess();
    }


    @Feature("Regression")
    @Owner("Huyen")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "data_provider_login_excel_hashtable", dataProviderClass = DataProviderFactory.class)
    public void loginSuccessFromDataProviderHashTable(Hashtable<String, String> data) {
        loginPage = new loginPage();
        loginPage.loginCRM(data.get("Email"), data.get("Password"));
        loginPage.verifyLoginSuccess();
    }


    @Feature("Regression")
    @Owner("Huyen")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void loginfail_emailInvalid() {
        loginPage = new loginPage();
        loginPage.loginCRM("https://crm.anhtester.com/admin/authentication", "bdmin@example.com", "123456");
        loginPage.verifyLoginFail();
    }


    @Feature("Regression")
    @Owner("Hien")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void loginfail_passwordNull() {
        loginPage = new loginPage();
        loginPage.loginCRM("https://crm.anhtester.com/admin/authentication", "admin@example.com", "");
        loginPage.verifyLoginFail("The Password field is required.");
    }

    @Feature("Regression")
    @Owner("Linh")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void loginfail_emailNull()  {
        loginPage = new loginPage();
        loginPage.loginCRM("https://crm.anhtester.com/admin/authentication", "", "123456");
        loginPage.verifyLoginFail("The Email Address field is required.");
    }
}
