package com.youthfireit.dora.network;

import com.youthfireit.dora.models.ProductDetails;
import com.youthfireit.dora.models.allproducts.Products;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface DoraAPI {

    @GET("products")
    Call<Products> getAllProductData(@Query("page") int page);


    @GET("products/single/{id}")
    Call<ProductDetails> getSingleProducts(@Path("id") String id);

}
