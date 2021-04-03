package com.youthfireit.dora.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "categories")
public class CategoriesData {
    // id name banner icon

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private String categoriesId;

    @ColumnInfo(name = "name")
    @SerializedName("name")
    private String categoriesName;

    @ColumnInfo(name = "banner")
    @SerializedName("banner")
    private String categoriesBanner;

    @ColumnInfo(name = "icon")
    @SerializedName("icon")
    private String categoriesIcon;



    public String getCategoriesId() {

        return categoriesId;
    }



    public void setCategoriesId(String categoriesId) {

        this.categoriesId = categoriesId;
    }



    public String getCategoriesName() {

        return categoriesName;
    }



    public void setCategoriesName(String categoriesName) {

        this.categoriesName = categoriesName;
    }



    public String getCategoriesBanner() {

        return categoriesBanner;
    }



    public void setCategoriesBanner(String categoriesBanner) {

        this.categoriesBanner = categoriesBanner;
    }



    public String getCategoriesIcon() {

        return categoriesIcon;
    }



    public void setCategoriesIcon(String categoriesIcon) {

        this.categoriesIcon = categoriesIcon;
    }




}
