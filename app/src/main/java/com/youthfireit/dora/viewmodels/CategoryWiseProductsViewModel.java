package com.youthfireit.dora.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.youthfireit.dora.models.allproducts.ProductData;
import com.youthfireit.dora.repository.CategoryWiseProductsRepository;

import java.util.List;


public class CategoryWiseProductsViewModel extends AndroidViewModel {


    private CategoryWiseProductsRepository repository;
    private Application application;

    private LiveData<List<ProductData>> products;
    public CategoryWiseProductsViewModel(@NonNull Application application) {

        super(application);
        this.application = application;

    }

    public void initializeRepo(String categoryId)
    {
        repository = new CategoryWiseProductsRepository(application,categoryId);
        products = repository.getProduct();
    }



    public LiveData<List<ProductData>> getProducts() {

        return products;
    }




}
