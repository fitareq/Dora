package com.youthfireit.dora.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.youthfireit.dora.models.CategoryWiseProductDao;
import com.youthfireit.dora.models.LocalDatabase;
import com.youthfireit.dora.models.allproducts.ProductData;

import java.util.List;


public class CategoryWiseProductsRepository {


    private CategoryWiseProductDao categoryWiseProductDao;
    private LiveData<List<ProductData>> product;

    public CategoryWiseProductsRepository(Application application,String categoryId )
    {
        LocalDatabase database = LocalDatabase.getINSTANCE(application);
        categoryWiseProductDao = database.categoryWiseProductDao();
        product = categoryWiseProductDao.getCategoryWiseProducts(categoryId);

    }



    public LiveData<List<ProductData>> getProduct() {

        return product;
    }




}
