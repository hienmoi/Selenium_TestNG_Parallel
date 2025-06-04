package Bai26_ParallelExcutionPOM.TestCase;

import Bai26_ParallelExcutionPOM.Pages.loginPage;
import Common.BaseTest;
import helpers.PropertiesHelper;
import org.testng.annotations.Test;

public class loginTest extends BaseTest {

    Bai26_ParallelExcutionPOM.Pages.loginPage loginPage;

    @Test
    public void loginSuccess() {
        loginPage = new loginPage();
        loginPage.loginCRM("https://crm.anhtester.com/admin/authentication", "admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        PropertiesHelper.setValue("email", "admin@example.com", "src/test/resources/configs/data.properties" );
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
