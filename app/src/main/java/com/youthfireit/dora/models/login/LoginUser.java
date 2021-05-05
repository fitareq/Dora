package com.youthfireit.dora.models.login;

public class LoginUser {

    private String id;
    private String type;
    private String name;
    private String email;
    private String avatar;
    private String avatar_original;
    private String address;
    private String country;
    private String city;
    private String postal_code;
    private String phone;



    public LoginUser(String id, String type, String name, String email, String avatar, String avatar_original,
                     String address, String country, String city, String postal_code, String phone) {

        this.id = id;
        this.type = type;
        this.name = name;
        this.email = email;
        this.avatar = avatar;
        this.avatar_original = avatar_original;
        this.address = address;
        this.country = country;
        this.city = city;
        this.postal_code = postal_code;
        this.phone = phone;
    }



    public String getId() {

        return id;
    }



    public String getType() {

        return type;
    }



    public String getName() {

        return name;
    }



    public String getEmail() {

        return email;
    }



    public String getAvatar() {

        return avatar;
    }



    public String getAvatar_original() {

        return avatar_original;
    }



    public String getAddress() {

        return address;
    }



    public String getCountry() {

        return country;
    }



    public String getCity() {

        return city;
    }



    public String getPostal_code() {

        return postal_code;
    }



    public String getPhone() {

        return phone;
    }




}
