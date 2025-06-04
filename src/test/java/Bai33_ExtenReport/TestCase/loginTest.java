package Bai33_ExtenReport.TestCase;

import Bai33_ExtenReport.Pages.loginPage;
import Common.BaseTest;
import DataProviderFactory.DataProviderFactory;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class loginTest extends BaseTest {

    Bai33_ExtenReport.Pages.loginPage loginPage;

    @Test(dataProvider = "Data_Provider_Login_Success", dataProviderClass = DataProviderFactory.class)
    public void loginSuccess( String email, String password) {
        loginPage = new loginPage();
        loginPage.loginCRM(email, password);
        loginPage.verifyLoginSuccess();
    }
    @Test(dataProvider = "data_provider_login_excel", dataProviderClass = DataProviderFactory.class)
    public void loginSuccessFromDataProvider( String email, String password) {
        loginPage = new loginPage();
        loginPage.loginCRM(email, password);
        loginPage.verifyLoginSuccess();
    }

    @Test(dataProvider = "data_provider_login_excel_hashtable", dataProviderClass = DataProviderFactory.class)
    public void loginSuccessFromDataProviderHashTable(Hashtable<String, String> data) {
        loginPage = new loginPage();
        loginPage.loginCRM(data.get("Email"), data.get("Password"));
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void loginfail_emailInvalid() {
        loginPage = new loginPage();
        loginPage.loginCRM("https://crm.anhtester.com/admin/authentication", "bdmin@example.com", "123456");
        loginPage.verifyLoginFail();
    }

    @Test
    public void loginfail_passwordNull() {
        loginPage = new loginPage();
        loginPage.loginCRM("https://crm.anhtester.com/admin/authentication", "admin@example.com", "");
        loginPage.verifyLoginFail("The Password field is required.");
    }
    @Test
    public void loginfail_emailNull()  {
        loginPage = new loginPage();
        loginPage.loginCRM("https://crm.anhtester.com/admin/authentication", "", "123456");
        loginPage.verifyLoginFail("The Email Address field is required.");
    }
}
