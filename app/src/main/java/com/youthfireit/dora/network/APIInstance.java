package com.youthfireit.dora.network;

import com.youthfireit.dora.constants.ConstantResources;
import com.youthfireit.dora.models.allproducts.Products;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class APIInstance {


    private Retrofit retrofit;
    private static APIInstance mInstance;
    private APIInstance()
    {
        retrofit =  new Retrofit.Builder()
                       .baseUrl(ConstantResources.BASE_URL)
                       .addConverterFactory(GsonConverterFactory.create())
                       .build();

         }

    public static synchronized APIInstance getInstance()
    {
        if (mInstance==null)
            mInstance = new APIInstance();

        return mInstance;
    }

    public DoraAPI api()
    {
        return retrofit.create(DoraAPI.class);
    }
}
