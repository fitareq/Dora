package com.youthfireit.dora.network;

import com.youthfireit.dora.constants.ConstantResources;

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
