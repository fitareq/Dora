package com.youthfireit.dora.models;

import com.google.gson.annotations.SerializedName;


public class PageMetaData {

//current_page from last_page path per_page to total

    @SerializedName("current_page")
    private final String currentPage;

    @SerializedName("from")
    private final String previousPage;

    @SerializedName("last_page")
    private final String lastPage;

    @SerializedName("path")
    private final String productsPath;

    @SerializedName("per_page")
    private final String productPerPage;

    @SerializedName("to")
    private final String productTo;

    @SerializedName("total")
    private final String totalProduct;



    public PageMetaData(String currentPage, String previousPage, String lastPage, String productsPath, String productPerPage, String productTo, String totalProduct) {

        this.currentPage = currentPage;
        this.previousPage = previousPage;
        this.lastPage = lastPage;
        this.productsPath = productsPath;
        this.productPerPage = productPerPage;
        this.productTo = productTo;
        this.totalProduct = totalProduct;
    }



    public String getCurrentPage() {

        return currentPage;
    }



    public String getPreviousPage() {

        return previousPage;
    }



    public String getLastPage() {

        return lastPage;
    }



    public String getProductsPath() {

        return productsPath;
    }



    public String getProductPerPage() {

        return productPerPage;
    }



    public String getProductTo() {

        return productTo;
    }



    public String getTotalProduct() {

        return totalProduct;
    }




}
