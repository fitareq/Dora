package com.youthfireit.dora.models;

public class SignUp {

    private String name;
    private String email;
    private String phone;
    private String password;



    public SignUp(String name, String email, String phone, String password) {

        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }



    public String getName() {

        return name;
    }



    public String getEmail() {

        return email;
    }



    public String getPhone() {

        return phone;
    }



    public String getPassword() {

        return password;
    }




}
