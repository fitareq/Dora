package com.youthfireit.dora.models;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.youthfireit.dora.models.allproducts.ProductData;

import java.util.List;


@Dao
public interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllProduct(List<ProductData> productData);

    @Query("SELECT * FROM products")
    LiveData<List<ProductData>> getAllProducts();
}
