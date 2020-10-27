package com.automation.web.data;

import org.testng.annotations.DataProvider;

/**
 * Data provider class.
 * @author juan.montes
 */
public class Data {

//    @DataProvider(name = "dataLogin")
//    public Object[][] inputData() {
//        User user = new User();
//        return new Object[][] {
//                {user.getName(),user.getLastName(),user.getEmail(),user.getPassword()}
//        };
//    }

    @DataProvider(name = "dataLogin")
    public Object[][] inputDataLogout() {
        User user = new User();
        return new Object[][] {
                {user.getName(),user.getLastName(),user.getEmail(),user.getPassword()}
        };
    }
//
//    @DataProvider(name = "dataDisable")
//    public Object[][] inputDataDisable() {
//        User user = new User();
//        return new Object[][] {
//                {user.getName(),user.getLastName(),user.getEmail(),user.getPassword()}
//        };
//    }

    private String getRandomNumber(){
        String number = String.valueOf(Math.floor(Math.random() * 100000+1 ));
        return number;
    }


}
