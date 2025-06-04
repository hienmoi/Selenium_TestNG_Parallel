package Bai35_Handle_Uploadfile;

import Common.BaseTest;
import Keyword.WebUI;
import driver.DriverManager;
import helpers.SystemHelper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadFile extends BaseTest {
    @Test
    public void testUploadFileWithSendKeys() throws InterruptedException {

        WebUI.openURL("https://the-internet.herokuapp.com/upload");
        WebUI.sleep(2);
        By inputFileUpload = By.xpath("//input[@id='file-upload']");
        String filePath = SystemHelper.getCurrentDir() + "src\\test\\resources\\Datatest\\anh1.png";
        WebUI.setText(inputFileUpload, filePath );
        WebUI.sleep(2);
    }
    @Test
    public void testUploadFileWithRobotClass() throws InterruptedException {

        WebUI.openURL("https://files.fm/");
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);

        By textOnPage = By.xpath("//div[@id='file_select_dragndrop_text']");
        By divFileUpload = By.xpath("//div[@id='uploadifive-file_upload']");
        By inputFileUpload = By.xpath("//div[@id='file_select_button']//input[@id='file_upload']");

        String filePath = SystemHelper.getCurrentDir() + "src\\test\\resources\\Datatest\\anh1.png";
        WebUI.uploadFileWithRobotClass(inputFileUpload, filePath );

    }

}
