package com.youthfireit.dora.models.allproducts;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Products {
    // data links meta success status

    @SerializedName("data")
    private List<ProductData> productData;

    @SerializedName("links")
    private ProductsLinks productLink;

    @SerializedName("meta")
    private ProductsMetaData productsMetaData;

    @SerializedName("success")
    private String isSuccess;

    @SerializedName("status")
    private Integer responseStatusCode;



    public Products(List<ProductData> productData, ProductsLinks productLink, ProductsMetaData productsMetaData,
                    String isSuccess, Integer responseStatusCode) {

        this.productData = productData;
        this.productLink = productLink;
        this.productsMetaData = productsMetaData;
        this.isSuccess = isSuccess;
        this.responseStatusCode = responseStatusCode;
    }



    public List<ProductData> getProductData() {

        return productData;
    }



    public ProductsLinks getProductLink() {

        return productLink;
    }



    public ProductsMetaData getProductsMetaData() {

        return productsMetaData;
    }



    public String getIsSuccess() {

        return isSuccess;
    }



    public Integer getResponseStatusCode() {

        return responseStatusCode;
    }




}
