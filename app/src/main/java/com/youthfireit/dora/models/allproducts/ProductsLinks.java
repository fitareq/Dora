package com.youthfireit.dora.models.allproducts;

import com.google.gson.annotations.SerializedName;


public class ProductsLinks {
// first last prev next

    @SerializedName("first")
    private final String firstPage;

    @SerializedName("last")
    private final String lastPage;

    @SerializedName("prev")
    private final String previousPage;

    @SerializedName("next")
    private final String nextPage;



    public ProductsLinks(String firstPage, String lastPage, String previousPage, String nextPage) {

        this.firstPage = firstPage;
        this.lastPage = lastPage;
        this.previousPage = previousPage;
        this.nextPage = nextPage;
    }



    public String getFirstPage() {

        return firstPage;
    }



    public String getLastPage() {

        return lastPage;
    }



    public String getPreviousPage() {

        return previousPage;
    }



    public String getNextPage() {

        return nextPage;
    }




}
