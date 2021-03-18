package com.youthfireit.dora.network;

import com.youthfireit.dora.models.ProductData;

import retrofit2.Call;
import retrofit2.http.GET;


public interface DoraAPI {

    @GET("products")
    Call<ProductData> getAllProductData();

}
