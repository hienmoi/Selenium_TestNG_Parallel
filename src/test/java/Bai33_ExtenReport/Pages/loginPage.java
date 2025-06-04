package Bai33_ExtenReport.Pages;

import Keyword.WebUI;
import driver.DriverManager;
import helpers.PropertiesHelper;
import org.openqa.selenium.By;
import org.testng.Assert;


public class loginPage {

    //Khai báo cục bộ các element dạng đối tượng By (phương thức tìm kiếm)
    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//div[contains(@class, 'alert-dange')]");


    private void setEmail(String email) {
        //driver.findElement(inputEmail).sendKeys(email);
        WebUI.setText(inputEmail,email );
    }

    private void setPassword(String password) {
        //driver.findElement(inputPassword).sendKeys(password);
        WebUI.setText(inputPassword, password);
    }

    private void clickLoginButton() {
        //driver.findElement(buttonLogin).click();
        WebUI.clickElement(buttonLogin);
    }

    public void verifyLoginSuccess() {
        //Assert.assertFalse(driver.getCurrentUrl().contains("authentication"), "FAIL. Vẫn đang ở trang Login");
        WebUI.assertNotContains(WebUI.getCurrentUrl(), "authentication", "FAIL. Vẫn đang ở trang Login");
    }

    public void verifyLoginFail() {
        //Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
        WebUI.assertContains(WebUI.getCurrentUrl(), "authentication", "FAIL. Không còn ở trang Login");
        //Assert.assertTrue(WebUI.isElementDisplayed(errorMessage), "Error message NOT displays");

        //Assert.assertEquals(WebUI.getElementText(errorMessage), "Invalid email or password", "Content of error massage NOT match.");
        WebUI.assertEquals(WebUI.getElementText(errorMessage), "Invalid email or password", "Content of error massage NOT match.");
    }
    public void verifyLoginFail(String message) {
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
        Assert.assertTrue(WebUI.isElementDisplayed(errorMessage), message);
        Assert.assertEquals(WebUI.getElementText(errorMessage), message, "Content of error massage NOT match.");
    }


    //Các hàm xử lý cho chính trang này
    //Hàm login chỉ phục vụ trang Login
    public void loginCRM(String url, String email, String password) {
        WebUI.openURL(url);
        WebUI.waitForPageLoaded();
        WebUI.setText(inputEmail, email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
    }

    public void loginCRM( String email, String password) {
        WebUI.openURL("https://crm.anhtester.com/admin/authentication");
        WebUI.waitForPageLoaded();
        WebUI.setText(inputEmail, email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
    }


    //Hàm login liên kết với trang Dashboard
    public dashboardPage loginCRM() {
        WebUI.openURL(PropertiesHelper.getValue("url"));
        setEmail("admin@example.com");
        setPassword("123456");
        clickLoginButton();
        verifyLoginSuccess();
        return new dashboardPage();
    }

}
