package com.youthfireit.dora.models;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.youthfireit.dora.models.allproducts.ProductData;

import java.util.List;


@Dao
public interface CategoryWiseProductDao {

    @Query("SELECT * FROM products WHERE category_id=:ID")
    LiveData<List<ProductData>> getCategoryWiseProducts(String ID);
}
