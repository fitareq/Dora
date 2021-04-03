package com.youthfireit.dora.models.allproducts;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "products")
public class ProductData {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private  String productId;


    @ColumnInfo(name = "name")
    @SerializedName("name")
    private  String productsName;

    @ColumnInfo(name = "category_id")
    @SerializedName("category_id")
    private String categoryId;


    @Ignore
    @SerializedName("photos")
    private  List<String> productsPhotos;

    @ColumnInfo(name = "thumbnail_image")
    @SerializedName("thumbnail_image")
    private  String productsThumbnailImage;

    @ColumnInfo(name = "base_price")
    @SerializedName("base_price")
    private  String productsBasePrice;

    @ColumnInfo(name = "base_discounted_price")
    @SerializedName("base_discounted_price")
    private  String productsBaseDiscountedPrice;

    @ColumnInfo(name = "todays_deal")
    @SerializedName("todays_deal")
    private  String isToDaysDeal;

    @ColumnInfo(name = "featured")
    @SerializedName("featured")
    private  String isFeatured;

    @ColumnInfo(name = "unit")
    @SerializedName("unit")
    private  String productsUnit;

    @ColumnInfo(name = "discount")
    @SerializedName("discount")
    private  String productsDiscount;

    @ColumnInfo(name = "discount_type")
    @SerializedName("discount_type")
    private  String productsDiscountType;

    @ColumnInfo(name = "rating")
    @SerializedName("rating")
    private  String productsRating;

    @ColumnInfo(name = "sales")
    @SerializedName("sales")
    private  String productsSold;

    @Ignore
    @SerializedName("links")
    private  ProductDataLinks productsLinks;



    @NonNull
    public String getProductId() {

        return productId;
    }



    public void setProductId(@NonNull String productId) {

        this.productId = productId;
    }



    public String getProductsName() {

        return productsName;
    }



    public void setProductsName(String productsName) {

        this.productsName = productsName;
    }



    public String getCategoryId() {

        return categoryId;
    }



    public void setCategoryId(String categoryId) {

        this.categoryId = categoryId;
    }



    public List<String> getProductsPhotos() {

        return productsPhotos;
    }



    public void setProductsPhotos(List<String> productsPhotos) {

        this.productsPhotos = productsPhotos;
    }



    public String getProductsThumbnailImage() {

        return productsThumbnailImage;
    }



    public void setProductsThumbnailImage(String productsThumbnailImage) {

        this.productsThumbnailImage = productsThumbnailImage;
    }



    public String getProductsBasePrice() {

        return productsBasePrice;
    }



    public void setProductsBasePrice(String productsBasePrice) {

        this.productsBasePrice = productsBasePrice;
    }



    public String getProductsBaseDiscountedPrice() {

        return productsBaseDiscountedPrice;
    }



    public void setProductsBaseDiscountedPrice(String productsBaseDiscountedPrice) {

        this.productsBaseDiscountedPrice = productsBaseDiscountedPrice;
    }



    public String getIsToDaysDeal() {

        return isToDaysDeal;
    }



    public void setIsToDaysDeal(String isToDaysDeal) {

        this.isToDaysDeal = isToDaysDeal;
    }



    public String getIsFeatured() {

        return isFeatured;
    }



    public void setIsFeatured(String isFeatured) {

        this.isFeatured = isFeatured;
    }



    public String getProductsUnit() {

        return productsUnit;
    }



    public void setProductsUnit(String productsUnit) {

        this.productsUnit = productsUnit;
    }



    public String getProductsDiscount() {

        return productsDiscount;
    }



    public void setProductsDiscount(String productsDiscount) {

        this.productsDiscount = productsDiscount;
    }



    public String getProductsDiscountType() {

        return productsDiscountType;
    }



    public void setProductsDiscountType(String productsDiscountType) {

        this.productsDiscountType = productsDiscountType;
    }



    public String getProductsRating() {

        return productsRating;
    }



    public void setProductsRating(String productsRating) {

        this.productsRating = productsRating;
    }



    public String getProductsSold() {

        return productsSold;
    }



    public void setProductsSold(String productsSold) {

        this.productsSold = productsSold;
    }



    public ProductDataLinks getProductsLinks() {

        return productsLinks;
    }



    public void setProductsLinks(ProductDataLinks productsLinks) {

        this.productsLinks = productsLinks;
    }




}
