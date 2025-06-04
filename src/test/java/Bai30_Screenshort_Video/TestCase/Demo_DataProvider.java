package Bai30_Screenshort_Video.TestCase;

import DataProviderFactory.DataProviderFactory;
import org.testng.annotations.Test;

public class Demo_DataProvider {

    @Test(dataProvider = "Data_Provider_01", dataProviderClass = DataProviderFactory.class)
    public void testDataProvider1(String param1, String param2, String param3) {
        System.out.println(param1 + "++" + param1 + "++" + param3);
    }



    @Test(dataProvider = "Data_Provider_02", dataProviderClass = DataProviderFactory.class)
    public void testDataProvider2(String param1, String param2, String param3) {
        System.out.println(param1 + "++" + param1 + "++" + param3);
    }



    @Test(dataProvider = "Data_Provider_03", dataProviderClass = DataProviderFactory.class)
    public void testDataProvider3(String param1, int param2, int param3) {
        System.out.println(param1 + "++" + param2 + "++" + param3);
    }
}