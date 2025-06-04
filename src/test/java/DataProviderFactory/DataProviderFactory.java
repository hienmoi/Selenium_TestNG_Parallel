package DataProviderFactory;

import helpers.ExcelHelper;
import helpers.SystemHelper;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {
//Data demo
    @DataProvider(name = "Data_Provider_01")
    public Object[][] dataProvider01() {
        return new Object[][]{{"Value1", "Value2", "Value3"}, {"Value5", "Value6", "Value7"}};
    }
    @DataProvider(name = "Data_Provider_02")
    public Object[][] dataProvider02() {
        return new Object[][]{{"Value7", "Value8", "Value9"}, {"Value5", "Value6", "Value7"}, {"Value1", "Value2", "Value3"}};
    }
    @DataProvider(name = "Data_Provider_03")
    public Object[][] dataProvider03() {
        return new Object[][]{{"Value1", 5, 10}};
    }
//Data Login Test
    @DataProvider(name = "Data_Provider_Login_Success", parallel = true)
    public Object[][] dataProviderLoginSuccess() {
        return new Object[][]{{"admin@example.com", "123456"}, {"admin@example.com", "123456"}};
    }

    @DataProvider(name = "data_provider_login_excel")
    public Object[][] dataLoginHRMFromExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelDataProvider(SystemHelper.getCurrentDir() + "src/test/resources/Datatest/crm_datatest.xlsx", "LoginDataProvider");
        System.out.println("Login Data from Excel: " + data);
        return data;
    }
    @DataProvider(name = "data_provider_login_excel_hashtable")
    public Object[][] dataLoginFromExcelHashtable() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.geExcelDataHashTable(SystemHelper.getCurrentDir() + "src/test/resources/Datatest/crm_datatest.xlsx", "LoginDataProviderHashtable", 2, 3);
        System.out.println("Login Data from Excel: " + data);
        return data;
    }

}
