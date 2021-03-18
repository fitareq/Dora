package com.youthfireit.dora.models;

import com.google.gson.annotations.SerializedName;


public class ProductLinks {
    //details reviews related top_from_seller

    @SerializedName("details")
    private final String productDetails;

    @SerializedName("reviews")
    private final String productReviews;

    @SerializedName("related")
    private final String relatedProducts;

    @SerializedName("top_from_seller")
    private final String topProductsFromSeller;



    public ProductLinks(String productDetails, String productReviews, String relatedProducts, String topProductsFromSeller) {

        this.productDetails = productDetails;
        this.productReviews = productReviews;
        this.relatedProducts = relatedProducts;
        this.topProductsFromSeller = topProductsFromSeller;
    }



    public String getProductDetails() {

        return productDetails;
    }



    public String getProductReviews() {

        return productReviews;
    }



    public String getRelatedProducts() {

        return relatedProducts;
    }



    public String getTopProductsFromSeller() {

        return topProductsFromSeller;
    }




}
