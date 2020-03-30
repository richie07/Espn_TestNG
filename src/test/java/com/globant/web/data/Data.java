package com.globant.web.data;

import org.testng.annotations.DataProvider;

public class Data {

    @DataProvider(name = "countries")
    public Object[][] inputData() {
        return new Object[][] {{"Colombia"}, {"Brazil"}, {"Peru"}};
    }
}
