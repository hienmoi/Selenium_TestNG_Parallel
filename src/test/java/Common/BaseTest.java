package Common;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    @BeforeMethod
    @Parameters("browser")
    public void createDriver(@Optional ("chrome") String browser){
        WebDriver driver;

        switch (browser){

            case "chrome":
                driver = new ChromeDriver();
                System.out.println("Khởi chạy trình duyệt Chrome...");
                break;
            case "edge":
                driver = new EdgeDriver();
                System.out.println("Khởi chạy trình duyệt Edge...");
                break;
            default:
                driver = new FirefoxDriver();
                System.out.println("Khởi chạy trình duyệt Firefox...");
                break;
        }
        DriverManager.setDriver(driver);//Set giá trị driver vào trong threadLocal

        DriverManager.getDriver().manage().window().maximize();

        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    };

    @AfterMethod
    public void closeDriver(){
        if (DriverManager.getDriver() !=null){
            DriverManager.quit();
        }
    }


}
