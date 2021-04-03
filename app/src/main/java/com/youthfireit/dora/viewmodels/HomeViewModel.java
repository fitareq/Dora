package com.youthfireit.dora.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.youthfireit.dora.models.CategoriesData;
import com.youthfireit.dora.models.allproducts.ProductData;
import com.youthfireit.dora.repository.HomeRepository;

import java.util.List;


public class HomeViewModel extends AndroidViewModel {


    private HomeRepository repository;
    private LiveData<List<ProductData>> products;
    private LiveData<List<CategoriesData>> categories;
    public HomeViewModel(@NonNull Application application) {

        super(application);
        repository = new HomeRepository(application);
        products = repository.getProducts();
        categories = repository.getCategories();
    }



    public LiveData<List<ProductData>> getProducts() {

        return products;
    }



    public LiveData<List<CategoriesData>> getCategories() {

        return categories;
    }




}
