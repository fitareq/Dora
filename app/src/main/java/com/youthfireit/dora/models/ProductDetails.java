package com.youthfireit.dora.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ProductDetails {

   // data success status

    @SerializedName("data")
    private List<ProductDetailsData> ProductData;

    @SerializedName("success")
    private String isSuccess;

    @SerializedName("status")
    private String responseStatus;



    public ProductDetails(List<ProductDetailsData> productData, String isSuccess, String responseStatus) {

        ProductData = productData;
        this.isSuccess = isSuccess;
        this.responseStatus = responseStatus;
    }



    public List<ProductDetailsData> getProductData() {

        return ProductData;
    }



    public String getIsSuccess() {

        return isSuccess;
    }



    public String getResponseStatus() {

        return responseStatus;
    }




}