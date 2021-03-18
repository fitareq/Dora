package com.youthfireit.dora.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class BannerData {

    //data success status
    @SerializedName("data")
    private List<Banners> bannersList;

    @SerializedName("success")
    private String isSuccess;

    @SerializedName("status")
    private String statusCode;



    public BannerData(List<Banners> bannersList, String isSuccess, String statusCode) {

        this.bannersList = bannersList;
        this.isSuccess = isSuccess;
        this.statusCode = statusCode;
    }



    public List<Banners> getBannersList() {

        return bannersList;
    }



    public String getIsSuccess() {

        return isSuccess;
    }



    public String getStatusCode() {

        return statusCode;
    }




}
