package com.youthfireit.dora.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.youthfireit.dora.models.BannerData;
import com.youthfireit.dora.models.Categories;
import com.youthfireit.dora.models.CategoriesDao;
import com.youthfireit.dora.models.CategoriesData;
import com.youthfireit.dora.models.LocalDatabase;
import com.youthfireit.dora.models.allproducts.ProductData;
import com.youthfireit.dora.models.allproducts.Products;
import com.youthfireit.dora.network.APIInstance;
import com.youthfireit.dora.models.ProductDao;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeRepository {


    private int page = 1;
    private ProductDao productDao;
    private CategoriesDao categoriesDao;
    private LiveData<List<ProductData>> products;
    private LiveData<List<CategoriesData>> categories;



    public HomeRepository(Application application) {

        LocalDatabase database = LocalDatabase.getINSTANCE(application);
        productDao = database.productDao();
        products = productDao.getAllProducts();
        categoriesDao = database.categoriesDao();
        categories = categoriesDao.getAllCategories();
        fetchAllProductFromRemote();
        fetchCategoriesDataFromRemote();
    }



    public LiveData<List<CategoriesData>> getCategories() {

        return categories;
    }



    public LiveData<List<ProductData>> getProducts() {

        return products;
    }



    void fetchCategoriesDataFromRemote()
    {
        APIInstance
                .getInstance()
                .api()
                .getAllCategories()
                .enqueue(new Callback<Categories>() {
                    @Override
                    public void onResponse(Call<Categories> call, Response<Categories> response) {
                        if (response.isSuccessful())
                            if (response.body()!=null)
                                if (response.body().getIsSuccess().equalsIgnoreCase("true"))
                                {
                                    LocalDatabase
                                            .databaseWriteExecutors
                                            .execute(()-> {
                                                categoriesDao.insertAllCategories(response.body().getCategoriesData());
                                            });
                                }
                    }



                    @Override
                    public void onFailure(Call<Categories> call, Throwable t) {

                    }
                });
    }

    void fetchAllProductFromRemote() {

        APIInstance
                .getInstance()
                .api()
                .getAllProductData(page)
                .enqueue(new Callback<Products>() {
                    @Override
                    public void onResponse(Call<Products> call, Response<Products> response) {

                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                if (response.body().getIsSuccess().equalsIgnoreCase("true")) {
                                    LocalDatabase
                                            .databaseWriteExecutors
                                            .execute(() -> productDao.insertAllProduct(response.body().getProductData())
                                            );
                                }
                                ++page;
                                fetchAllProductFromRemote();
                            }
                        }
                    }



                    @Override
                    public void onFailure(Call<Products> call, Throwable t) {

                    }
                });
    }




}
