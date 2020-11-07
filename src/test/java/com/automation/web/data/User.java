package com.automation.web.data;

public class User {
    private String name ;
    private String lastName ;
    private String email ;
    private String password ;

    public User() {
        this.name = "Francisco";
        this.lastName = "Pinedo";
        this.email = getRandomNumber()+"test@mail.cm";
        this.password = "Lima2019";
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    private String getRandomNumber(){
        String number = String.valueOf(Math.floor(Math.random() * 100000+1 ));
        return number;
    }


}
