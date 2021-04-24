package com.youthfireit.dora.models.productdetails;

import com.google.gson.annotations.SerializedName;
import com.youthfireit.dora.models.allproducts.ProductData;

import java.util.List;


public class RelatedProducts {

  /*  links: {
        reviews: "https://youthfireit.com/dora/api/v1/reviews/product/93",
                         related: "https://youthfireit.com/dora/api/v1/products/related/93",
    },*/



    @SerializedName("data")
    private List<ProductData> productData;

    @SerializedName("success")
    private String isSuccess;

    @SerializedName("status")
    private String responseStatus;



    public RelatedProducts(List<ProductData> productData, String isSuccess, String responseStatus) {

        this.productData = productData;
        this.isSuccess = isSuccess;
        this.responseStatus = responseStatus;
    }



    public List<ProductData> getProductData() {

        return productData;
    }



    public String getIsSuccess() {

        return isSuccess;
    }



    public String getResponseStatus() {

        return responseStatus;
    }




}
