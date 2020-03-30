package com.globant.web.data;

import org.testng.annotations.DataProvider;

public class Data {

    @DataProvider(name = "dataProviderClass")
    public Object[][] inputData() {
        return new Object[][] {{"dataClass1"}, {"dataClass2"}, {"dataClass3"}};
    }
}
