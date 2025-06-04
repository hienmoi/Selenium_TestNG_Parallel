package Bai26_ParallelExcutionPOM.Pages;

import Keyword.WebUI;
import driver.DriverManager;
import helpers.ExcelHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class customerPage extends basePage {

    //Khai báo cục bộ các element dạng đối tượng By (phương thức tìm kiếm)

    private By menuCustomer = By.xpath("//span[normalize-space() = 'Customers']");
    private By headerCustomer = By.xpath("//span[normalize-space() = 'Customers Summary']");
    private By AddNewCustomer =By.xpath("//a[normalize-space() = 'New Customer']");
    private By searchCustomer =By.xpath("//div[@id = 'clients_filter']//input");
    private By inputCompany =By.xpath("//input[@id='company']");
    private By inputVAT =By.xpath("//input[@id='vat']");
    private By inputPhone =By.xpath("//input[@id='phonenumber']");
    private By inputWebsite =By.xpath("//input[@id='website']");
    private By dropdownGroup =By.xpath("//button[@data-id = 'groups_in[]']");
    private By inputSearchGroup =By.xpath("//button[@data-id = 'groups_in[]']/following-sibling::div//input");
    private By optionVIP =By.xpath("//span[normalize-space()= 'VIP']");
    private By dropdownLanguage =By.xpath("//button[@data-id = 'default_language']");
    private By optionVietnamese =By.xpath("//span[normalize-space()= 'Vietnamese']");
    private By inputAddress =By.xpath("//textarea[@id = 'address']");
    private By inputCity =By.xpath("//input[@id = 'city']");
    private By inputState =By.xpath("//input[@id = 'state']");
    private By inputZipCode =By.xpath("//input[@id = 'zip']");
    private By dropdownCountry =By.xpath("//button[@data-id = 'country']");
    private By inputSearchCountry =By.xpath("//button[@data-id = 'country']/following-sibling::div//input");
    private By optionVietnam =By.xpath("//span[normalize-space()= 'Vietnam']");
    private By buttonSave =By.xpath("//div[@id = 'profile-save-section']/button[normalize-space() = 'Save']");
    private By searchListCustomer =By.xpath("//div[@id = 'clients_filter']//input[@type = 'search']");
    private By itemCustomerFirst =By.xpath("(//table[@id = 'clients']//tr/td[3]/a)[1]");
    //6 chỉ số thống kê
    private By totalCustomer = By.xpath("//span[normalize-space() = 'Total Customers']/preceding-sibling::span");

    //Các hàm xử lý trang Customer
    private boolean checkElementExits(By by){
        //sử dụng try ... catch để bẫy/đón lỗi
        try {
            DriverManager.getDriver().findElement(by).isDisplayed();
            return true;
        } catch (NoSuchElementException e){
            return false; //Không bắn lỗi noSuchemlemnt mà sẽ trả ra false
        }

    };

    public void verifyNavigationCustomerPage(){
        Assert.assertTrue(checkElementExits(headerCustomer), "Can not find element header Customer");
        Assert.assertEquals(WebUI.getElementText(headerCustomer), "Customers Summary", "The Customer title not match" );

    }

    public void clickButtonAddnewCustomer(){
        WebUI.clickElement(AddNewCustomer);
    }

    public void submitNewCustomer(String customerName){
        WebUI.setText(inputCompany, customerName);
        WebUI.setText(inputPhone,"123456789" );
        WebUI.setText(inputVAT, "09876543");
        WebUI.setText(inputWebsite, "https://crm.anhtester.com/admin/clients/client");
        WebUI.clickElement(dropdownGroup);
        WebUI.setText(inputSearchGroup, "VIP" );
        WebUI.clickElement(optionVIP);
        WebUI.clickElement(dropdownGroup);
        WebUI.clickElement(dropdownLanguage);
        WebUI.clickElement(optionVietnamese);
        WebUI.setText(inputAddress, "Hà Nội" );
        WebUI.setText(inputCity, "HN" );
        WebUI.setText(inputState, "Vui vẻ" );
        WebUI.setText(inputZipCode, "12345678" );
        WebUI.clickElement(dropdownCountry);
        WebUI.setText(inputSearchCountry, "Vietnam" );
        WebUI.clickElement(optionVietnam);
        WebUI.clickElement(buttonSave);
    }

    public void verifysubmitNewCustomer(String customerName) {
        //Assert.assertEquals(driver.findElement(inputCompany).getAttribute("value"), customerName, "The company name not match");
        WebUI.assertEquals(WebUI.getElementAttribute(inputCompany, "value"), customerName, "The company name not match");
        //Assert.assertEquals(driver.findElement(inputPhone).getAttribute("value"), "123456789", "Them phone not match");
        WebUI.assertEquals(WebUI.getElementAttribute(inputPhone, "value"), "123456789", "Them phone not match");
        //Assert.assertEquals(driver.findElement(inputVAT).getAttribute("value"), "09876543");
        WebUI.assertEquals(WebUI.getElementAttribute(inputVAT, "value"), "09876543", "Them VAT not match");
        //Assert.assertEquals(driver.findElement(inputWebsite).getAttribute("value"), "https://crm.anhtester.com/admin/clients/client");
        WebUI.assertEquals(WebUI.getElementAttribute(inputWebsite,"value"), "https://crm.anhtester.com/admin/clients/client", "Them Website not match");
    }

    public void searchAndCheckCustomerInTable(String customerName) throws InterruptedException {
        WebUI.clickElement(menuCustomer);
        WebUI.setText(searchListCustomer, customerName );
        WebUI.sleep(5);
        String customerNameInTable =  WebUI.getElementText(itemCustomerFirst);
        System.out.println(customerNameInTable);
        Assert.assertEquals(customerNameInTable,customerName, "The customer name in table not match" );
    }

    public void clickFirstCustomeInTable(){
        WebUI.clickElement(itemCustomerFirst);
    }

    public int getCustomerTotal(){
        int totalCus = Integer.parseInt(WebUI.getElementText(totalCustomer));
        System.out.println("Total Custome is: " + totalCus);
        return totalCus;
    }
}
