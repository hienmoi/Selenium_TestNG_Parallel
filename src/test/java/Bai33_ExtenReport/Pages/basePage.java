//Class này để chứa các element và hàm xử lý chung xuất hiện ở nhiều page
package Bai33_ExtenReport.Pages;

import Keyword.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class basePage {
    private WebDriver driver;

    public By menuDashboard = By.xpath("//span[normalize-space() = 'Dashboard']");
    public By menuCustomer = By.xpath("//span[normalize-space() = 'Customers']");
    public By menuTasks = By.xpath("//span[normalize-space() = 'Tasks']");

    //Viết hàm xử lý chung
    public void clickMenuCustomer(){
        WebUI.waitForElementVisible(menuCustomer, 5);
        WebUI.clickElement(menuCustomer);
    }



}
