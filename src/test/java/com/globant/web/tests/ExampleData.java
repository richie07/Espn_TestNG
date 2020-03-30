package com.globant.web.tests;

import com.globant.web.data.Data;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ExampleData {

    @DataProvider(name = "dataProvider")
    public Object[][] inputData() {
        return new Object[][] {{"data1"}, {"data2"}, {"data3"}};
    }

    public Logger log = Logger.getLogger(ExampleData.class);

    @Parameters({"string1", "string2"})
    @Test(description = "example use of parameters", groups = {"group1"})
    public void testWithParameters(String param1, String param2) {
        log.info(param1);
        log.info(param2);
    }

    @Test(description = "example data provider", dataProvider = "dataProvider", groups = {"group1", "group2"})
    public void testWithDataProvider(String data) {
        log.info(data);
    }

    @Test(description = "example data provider class", dataProviderClass = Data.class, dataProvider = "dataProviderClass", groups = {"group1", "group2"})
    public void testWithDaraProviderClass(String data) {
        log.info(data);
    }
}
