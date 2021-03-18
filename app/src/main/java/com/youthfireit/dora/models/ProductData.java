package com.youthfireit.dora.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ProductData {
    // data links meta success status

    @SerializedName("data")
    private List<Products> productData;

    @SerializedName("links")
    private PageLinks productLink;

    @SerializedName("meta")
    private PageMetaData productMetaData;

    @SerializedName("success")
    private String isSuccess;

    @SerializedName("status")
    private Integer responseStatusCode;



    public ProductData(List<Products> productData, /*String productLink, String productMetaData,*/ String isSuccess,
                       Integer responseStatusCode) {

        this.productData = productData;
        /*this.productLink = productLink;*/
        /*this.productMetaData = productMetaData;*/
        this.isSuccess = isSuccess;
        this.responseStatusCode = responseStatusCode;
    }



    public List<Products> getProductData() {

        return productData;
    }



    public void setProductData(List<Products> productData) {

        this.productData = productData;
    }



  /*  public String getProductLink() {

        return productLink;
    }*/



    /*public void setProductLink(String productLink) {

        this.productLink = productLink;
    }*/



  /*  public String getProductMetaData() {

        return productMetaData;
    }*/



/*    public void setProductMetaData(String productMetaData) {

        this.productMetaData = productMetaData;
    }*/



    public String getIsSuccess() {

        return isSuccess;
    }



    public void setIsSuccess(String isSuccess) {

        this.isSuccess = isSuccess;
    }



    public Integer getResponseStatusCode() {

        return responseStatusCode;
    }



    public void setResponseStatusCode(Integer responseStatusCode) {

        this.responseStatusCode = responseStatusCode;
    }




}
