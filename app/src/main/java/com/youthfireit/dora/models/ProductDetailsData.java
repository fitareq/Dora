package com.youthfireit.dora.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ProductDetailsData {
    //name added_by user category sub_category brand photos thumbnail_image tags price_lower price_higher
    // choice_options colors todays_deal featured current_stock unit discount discount_type tax tax_type
    // shipping_type shipping_cost number_of_sales rating rating_count description links

    @SerializedName("name")
    private String productName;

    @SerializedName("added_by")
    private String productAddedBy;

    /*@SerializedName("user")
    private String userData;*/

    /*@SerializedName("category")
    private String productCategory;*/

    /*@SerializedName("sub_category")
    private String productSubCategory;*/

   /* @SerializedName("brand")
    private String productBrand;*/

    @SerializedName("photos")
    private List<String> productPhotos;

    @SerializedName("thumbnail_image")
    private String productThumbnailImage;

    @SerializedName("tags")
    private List<String> productTags;

    @SerializedName("price_lower")
    private String productPriceLower;

    @SerializedName("price_higher")
    private String productPriceHigher;

   /* @SerializedName("choice_options")
    private String productChoiceOptions;*/

    @SerializedName("colors")
    private List<String> productColors;

    @SerializedName("todays_deal")
    private String isTodayDeal;

    @SerializedName("featured")
    private String isFeatured;

    @SerializedName("current_stock")
    private String availableStock;

    @SerializedName("unit")
    private String unitMeasurement;

    @SerializedName("discount")
    private String productDiscount;

    @SerializedName("discount_type")
    private String productDiscountType;

    @SerializedName("tax")
    private String productTax;

    @SerializedName("tax_type")
    private String productTaxType;

    @SerializedName("shipping_type")
    private String productShippingType;

    @SerializedName("shipping_cost")
    private String productShippingCost;

    @SerializedName("number_of_sales")
    private String numberOfSoldProduct;

    @SerializedName("rating")
    private String productRating;

    @SerializedName("rating_count")
    private String totalRating;

    @SerializedName("description")
    private String productDescription;

    /*@SerializedName("links")
    private String productLinks;*/



    public ProductDetailsData(String productName, String productAddedBy, List<String> productPhotos,
                              String productThumbnailImage, List<String> productTags, String productPriceLower,
                              String productPriceHigher, List<String> productColors, String isTodayDeal,
                              String isFeatured, String availableStock, String unitMeasurement,
                              String productDiscount, String productDiscountType, String productTax,
                              String productTaxType, String productShippingType, String productShippingCost,
                              String numberOfSoldProduct, String productRating, String totalRating,
                              String productDescription) {

        this.productName = productName;
        this.productAddedBy = productAddedBy;
        this.productPhotos = productPhotos;
        this.productThumbnailImage = productThumbnailImage;
        this.productTags = productTags;
        this.productPriceLower = productPriceLower;
        this.productPriceHigher = productPriceHigher;
        this.productColors = productColors;
        this.isTodayDeal = isTodayDeal;
        this.isFeatured = isFeatured;
        this.availableStock = availableStock;
        this.unitMeasurement = unitMeasurement;
        this.productDiscount = productDiscount;
        this.productDiscountType = productDiscountType;
        this.productTax = productTax;
        this.productTaxType = productTaxType;
        this.productShippingType = productShippingType;
        this.productShippingCost = productShippingCost;
        this.numberOfSoldProduct = numberOfSoldProduct;
        this.productRating = productRating;
        this.totalRating = totalRating;
        this.productDescription = productDescription;
    }



    public String getProductName() {

        return productName;
    }



    public String getProductAddedBy() {

        return productAddedBy;
    }



    public List<String> getProductPhotos() {

        return productPhotos;
    }



    public String getProductThumbnailImage() {

        return productThumbnailImage;
    }



    public List<String> getProductTags() {

        return productTags;
    }



    public String getProductPriceLower() {

        return productPriceLower;
    }



    public String getProductPriceHigher() {

        return productPriceHigher;
    }



    public List<String> getProductColors() {

        return productColors;
    }



    public String getIsTodayDeal() {

        return isTodayDeal;
    }



    public String getIsFeatured() {

        return isFeatured;
    }



    public String getAvailableStock() {

        return availableStock;
    }



    public String getUnitMeasurement() {

        return unitMeasurement;
    }



    public String getProductDiscount() {

        return productDiscount;
    }



    public String getProductDiscountType() {

        return productDiscountType;
    }



    public String getProductTax() {

        return productTax;
    }



    public String getProductTaxType() {

        return productTaxType;
    }



    public String getProductShippingType() {

        return productShippingType;
    }



    public String getProductShippingCost() {

        return productShippingCost;
    }



    public String getNumberOfSoldProduct() {

        return numberOfSoldProduct;
    }



    public String getProductRating() {

        return productRating;
    }



    public String getTotalRating() {

        return totalRating;
    }



    public String getProductDescription() {

        return productDescription;
    }




}
