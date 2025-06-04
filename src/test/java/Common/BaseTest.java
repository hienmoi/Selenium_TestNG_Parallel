package Common;

import driver.DriverManager;
import helpers.PropertiesHelper;
import listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;
@Listeners(TestListener.class)
public class BaseTest {

    @BeforeSuite
    public void setupEnviroment(){
        PropertiesHelper.loadAllFiles();
    }
    @BeforeMethod
    @Parameters("browser")
    public void createDriver(@Optional ("chrome") String browser){
        WebDriver driver;


        if (PropertiesHelper.getValue("browser").isEmpty() || PropertiesHelper.getValue("browser").isBlank()){
            browser = browser;
        } else {
            browser = PropertiesHelper.getValue("browser");
        }

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
