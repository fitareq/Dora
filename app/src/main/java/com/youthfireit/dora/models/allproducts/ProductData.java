package com.youthfireit.dora.models.allproducts;

import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "products")
public class ProductData {


    @SerializedName("name")
    private final String productsName;

    @SerializedName("photos")
    private final List<String> productsPhotos;

    @SerializedName("thumbnail_image")
    private final String productsThumbnailImage;

    @SerializedName("base_price")
    private final String productsBasePrice;

    @SerializedName("base_discounted_price")
    private final String productsBaseDiscountedPrice;

    @SerializedName("todays_deal")
    private final String isToDaysDeal;

    @SerializedName("featured")
    private final String isFeatured;

    @SerializedName("unit")
    private final String productsUnit;

    @SerializedName("discount")
    private final String productsDiscount;

    @SerializedName("discount_type")
    private final String productsDiscountType;

    @SerializedName("rating")
    private final String productsRating;

    @SerializedName("sales")
    private final String productsSold;

    @SerializedName("links")
    private final ProductDataLinks productsLinks;



    public ProductData(String productsName, List<String> productsPhotos, String productsThumbnailImage,
                       String productsBasePrice, String productsBaseDiscountedPrice, String isToDaysDeal,
                       String isFeatured, String productsUnit, String productsDiscount, String productsDiscountType,
                       String productsRating, String productsSold, ProductDataLinks productsLinks) {

        this.productsName = productsName;
        this.productsPhotos = productsPhotos;
        this.productsThumbnailImage = productsThumbnailImage;
        this.productsBasePrice = productsBasePrice;
        this.productsBaseDiscountedPrice = productsBaseDiscountedPrice;
        this.isToDaysDeal = isToDaysDeal;
        this.isFeatured = isFeatured;
        this.productsUnit = productsUnit;
        this.productsDiscount = productsDiscount;
        this.productsDiscountType = productsDiscountType;
        this.productsRating = productsRating;
        this.productsSold = productsSold;
        this.productsLinks = productsLinks;
    }



    public String getProductsName() {

        return productsName;
    }



    public List<String> getProductsPhotos() {

        return productsPhotos;
    }



    public String getProductsThumbnailImage() {

        return productsThumbnailImage;
    }



    public String getProductsBasePrice() {

        return productsBasePrice;
    }



    public String getProductsBaseDiscountedPrice() {

        return productsBaseDiscountedPrice;
    }



    public String getIsToDaysDeal() {

        return isToDaysDeal;
    }



    public String getIsFeatured() {

        return isFeatured;
    }



    public String getProductsUnit() {

        return productsUnit;
    }



    public String getProductsDiscount() {

        return productsDiscount;
    }



    public String getProductsDiscountType() {

        return productsDiscountType;
    }



    public String getProductsRating() {

        return productsRating;
    }



    public String getProductsSold() {

        return productsSold;
    }



    public ProductDataLinks getProductsLinks() {

        return productsLinks;
    }




}
