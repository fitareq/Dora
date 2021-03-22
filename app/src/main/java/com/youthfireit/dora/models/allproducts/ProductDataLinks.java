package com.youthfireit.dora.models.allproducts;

import com.google.gson.annotations.SerializedName;


public class ProductDataLinks {
    //details reviews related top_from_seller

    @SerializedName("details")
    private final String productDetails;

    @SerializedName("reviews")
    private final String productReviews;

    @SerializedName("related")
    private final String relatedProducts;

    @SerializedName("top_from_seller")
    private final String topProductsFromSeller;



    public ProductDataLinks(String productDetails, String productReviews, String relatedProducts, String topProductsFromSeller) {

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
