package com.automation.web.data;

public class User {
    private String name = "Francisco";
    private String lastName = "Pinedo";
    private String email = "test@mail.cm";
    private String password = "Lima2019";

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return getRandomNumber()+email;
    }

    public String getPassword() {
        return password;
    }

    private String getRandomNumber(){
        String number = String.valueOf(Math.floor(Math.random() * 100000+1 ));
        return number;
    }


}
