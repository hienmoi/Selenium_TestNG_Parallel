package Bai34_AllureReport.Pages;

import Keyword.WebUI;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;

public class dashboardPage {

    //Khai báo cục bộ các element dạng đối tượng By (phương thức tìm kiếm)
    private By totalInvoicesAwaitingPayment = By.xpath("( //span[normalize-space()='Invoices Awaiting Payment']/parent::div)/following-sibling::span");
    private By totalConvertedLeads = By.xpath("( //span[normalize-space()='Converted Leads']/parent::div)/following-sibling::span");

    public void verifytotalInvoicesAwaitingPayment(String total){
        Assert.assertTrue(DriverManager.getDriver().findElement(totalInvoicesAwaitingPayment).isDisplayed(), "The Invoices Awaiting Payment not display");
        Assert.assertEquals(WebUI.getElementText(totalInvoicesAwaitingPayment), total, "The Invoices Awaiting Payment not match");
    }

    public void verifytotalConvertedLeads(String total){
        Assert.assertTrue(DriverManager.getDriver().findElement(totalConvertedLeads).isDisplayed(), "The Converted Leads not display");
        Assert.assertEquals(WebUI.getElementText(totalConvertedLeads), total, "The Converted Leads not match");
    }

}
