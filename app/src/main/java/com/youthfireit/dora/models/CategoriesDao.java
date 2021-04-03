package com.youthfireit.dora.models;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;


@Dao
public interface CategoriesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllCategories(List<CategoriesData> categoriesData);

    @Query("SELECT * FROM categories")
    LiveData<List<CategoriesData>> getAllCategories();
}
