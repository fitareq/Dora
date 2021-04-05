package com.youthfireit.dora.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ProductDetailsData {
    //name added_by user category sub_category brand photos thumbnail_image tags price_lower price_higher
    // choice_options colors todays_deal featured current_stock unit discount discount_type tax tax_type
    // shipping_type shipping_cost number_of_sales rating rating_count description links

    @SerializedName("id")
    private String productId;

    @SerializedName("name")
    private String productName;

    @SerializedName("added_by")
    private String productAddedBy;

    @SerializedName("user")
    private ProductUser userData;

    /*@SerializedName("category")   
    private String productCategory;

    @SerializedName("sub_category")
    private String productSubCategory;

    @SerializedName("brand")
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

    @SerializedName("choice_options")
    private List<String> productChoiceOptions;

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



    public String getProductId() {

        return productId;
    }



    public void setProductId(String productId) {

        this.productId = productId;
    }



    public String getProductName() {

        return productName;
    }



    public void setProductName(String productName) {

        this.productName = productName;
    }



    public String getProductAddedBy() {

        return productAddedBy;
    }



    public void setProductAddedBy(String productAddedBy) {

        this.productAddedBy = productAddedBy;
    }



    public ProductUser getUserData() {

        return userData;
    }



    public void setUserData(ProductUser userData) {

        this.userData = userData;
    }



    public List<String> getProductPhotos() {

        return productPhotos;
    }



    public void setProductPhotos(List<String> productPhotos) {

        this.productPhotos = productPhotos;
    }



    public String getProductThumbnailImage() {

        return productThumbnailImage;
    }



    public void setProductThumbnailImage(String productThumbnailImage) {

        this.productThumbnailImage = productThumbnailImage;
    }



    public List<String> getProductTags() {

        return productTags;
    }



    public void setProductTags(List<String> productTags) {

        this.productTags = productTags;
    }



    public String getProductPriceLower() {

        return productPriceLower;
    }



    public void setProductPriceLower(String productPriceLower) {

        this.productPriceLower = productPriceLower;
    }



    public String getProductPriceHigher() {

        return productPriceHigher;
    }



    public void setProductPriceHigher(String productPriceHigher) {

        this.productPriceHigher = productPriceHigher;
    }



    public List<String> getProductChoiceOptions() {

        return productChoiceOptions;
    }



    public void setProductChoiceOptions(List<String> productChoiceOptions) {

        this.productChoiceOptions = productChoiceOptions;
    }



    public List<String> getProductColors() {

        return productColors;
    }



    public void setProductColors(List<String> productColors) {

        this.productColors = productColors;
    }



    public String getIsTodayDeal() {

        return isTodayDeal;
    }



    public void setIsTodayDeal(String isTodayDeal) {

        this.isTodayDeal = isTodayDeal;
    }



    public String getIsFeatured() {

        return isFeatured;
    }



    public void setIsFeatured(String isFeatured) {

        this.isFeatured = isFeatured;
    }



    public String getAvailableStock() {

        return availableStock;
    }



    public void setAvailableStock(String availableStock) {

        this.availableStock = availableStock;
    }



    public String getUnitMeasurement() {

        return unitMeasurement;
    }



    public void setUnitMeasurement(String unitMeasurement) {

        this.unitMeasurement = unitMeasurement;
    }



    public String getProductDiscount() {

        return productDiscount;
    }



    public void setProductDiscount(String productDiscount) {

        this.productDiscount = productDiscount;
    }



    public String getProductDiscountType() {

        return productDiscountType;
    }



    public void setProductDiscountType(String productDiscountType) {

        this.productDiscountType = productDiscountType;
    }



    public String getProductTax() {

        return productTax;
    }



    public void setProductTax(String productTax) {

        this.productTax = productTax;
    }



    public String getProductTaxType() {

        return productTaxType;
    }



    public void setProductTaxType(String productTaxType) {

        this.productTaxType = productTaxType;
    }



    public String getProductShippingType() {

        return productShippingType;
    }



    public void setProductShippingType(String productShippingType) {

        this.productShippingType = productShippingType;
    }



    public String getProductShippingCost() {

        return productShippingCost;
    }



    public void setProductShippingCost(String productShippingCost) {

        this.productShippingCost = productShippingCost;
    }



    public String getNumberOfSoldProduct() {

        return numberOfSoldProduct;
    }



    public void setNumberOfSoldProduct(String numberOfSoldProduct) {

        this.numberOfSoldProduct = numberOfSoldProduct;
    }



    public String getProductRating() {

        return productRating;
    }



    public void setProductRating(String productRating) {

        this.productRating = productRating;
    }



    public String getTotalRating() {

        return totalRating;
    }



    public void setTotalRating(String totalRating) {

        this.totalRating = totalRating;
    }



    public String getProductDescription() {

        return productDescription;
    }



    public void setProductDescription(String productDescription) {

        this.productDescription = productDescription;
    }




}
