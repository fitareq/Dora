package com.youthfireit.dora.models;

import com.google.gson.annotations.SerializedName;


public class ProductUser {

    // name email avatar avatar_original shop_name shop_logo shop_link
    @SerializedName("name")
    private String productUserName;

    @SerializedName("email")
    private String productUserEmail;

    @SerializedName("avatar")
    private String productUserAvatar;

    @SerializedName("avatar_original")
    private String productUserAvatarOriginal;

    @SerializedName("shop_name")
    private String productUserShopName;

    @SerializedName("shop_logo")
    private String productUserShopLogo;

    @SerializedName("shop_link")
    private String productUserShopLink;



    public ProductUser(String productUserName, String productUserEmail, String productUserAvatar,
                       String productUserAvatarOriginal, String productUserShopName,
                       String productUserShopLogo, String productUserShopLink) {

        this.productUserName = productUserName;
        this.productUserEmail = productUserEmail;
        this.productUserAvatar = productUserAvatar;
        this.productUserAvatarOriginal = productUserAvatarOriginal;
        this.productUserShopName = productUserShopName;
        this.productUserShopLogo = productUserShopLogo;
        this.productUserShopLink = productUserShopLink;
    }



    public String getProductUserName() {

        return productUserName;
    }



    public String getProductUserEmail() {

        return productUserEmail;
    }



    public String getProductUserAvatar() {

        return productUserAvatar;
    }



    public String getProductUserAvatarOriginal() {

        return productUserAvatarOriginal;
    }



    public String getProductUserShopName() {

        return productUserShopName;
    }



    public String getProductUserShopLogo() {

        return productUserShopLogo;
    }



    public String getProductUserShopLink() {

        return productUserShopLink;
    }




}
