package com.youthfireit.dora.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Categories {
    //data success status
    @SerializedName("data")
    private List<CategoriesData> categoriesData;

    @SerializedName("success")
    private String isSuccess;

    @SerializedName("status")
    private String responseStatus;



    public Categories(List<CategoriesData> categoriesData, String isSuccess, String responseStatus) {

        this.categoriesData = categoriesData;
        this.isSuccess = isSuccess;
        this.responseStatus = responseStatus;
    }



    public List<CategoriesData> getCategoriesData() {

        return categoriesData;
    }



    public String getIsSuccess() {

        return isSuccess;
    }



    public String getResponseStatus() {

        return responseStatus;
    }




}
