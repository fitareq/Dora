package com.youthfireit.dora.room.roommodels;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;


public class LocalProducts {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private  String productId;


    @ColumnInfo(name = "name")
    private  String productsName;


    @ColumnInfo(name = "thumbnail_image")
    private  String productsThumbnailImage;

    @ColumnInfo(name = "base_price")
    private  String productsBasePrice;

    @ColumnInfo(name = "base_discounted_price")
    private  String productsBaseDiscountedPrice;

    @ColumnInfo(name = "todays_deal")
    private  String isToDaysDeal;

    @ColumnInfo(name = "featured")
    private  String isFeatured;

    @ColumnInfo(name = "unit")
    private  String productsUnit;

    @ColumnInfo(name = "discount")
    private  String productsDiscount;

    @ColumnInfo(name = "discount_type")
    private  String productsDiscountType;

    @ColumnInfo(name = "rating")
    private  String productsRating;

    @ColumnInfo(name = "sales")
    private  String productsSold;


}
