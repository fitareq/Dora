package com.youthfireit.dora.models;

import com.google.gson.annotations.SerializedName;


public class Banners {

    //photo url position

    @SerializedName("photo")
    private String bannerPhoto;

    @SerializedName("url")
    private String bannerUrl;

    @SerializedName("position")
    private String bannerPosition;



    public Banners(String bannerPhoto, String bannerUrl, String bannerPosition) {

        this.bannerPhoto = bannerPhoto;
        this.bannerUrl = bannerUrl;
        this.bannerPosition = bannerPosition;
    }



    public String getBannerPhoto() {

        return bannerPhoto;
    }



    public String getBannerUrl() {

        return bannerUrl;
    }



    public String getBannerPosition() {

        return bannerPosition;
    }




}
