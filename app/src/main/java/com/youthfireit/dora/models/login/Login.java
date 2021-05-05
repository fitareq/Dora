package com.youthfireit.dora.models.login;

public class Login {


    private String email;
    private String password;
    private boolean remember_me;



    public Login(String email, String password, boolean remember_me) {

        this.email = email;
        this.password = password;
        this.remember_me = remember_me;
    }



    public String getEmail() {

        return email;
    }



    public String getPassword() {

        return password;
    }



    public boolean isRemember_me() {

        return remember_me;
    }




}
