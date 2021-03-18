package com.youthfireit.dora.network;

import com.youthfireit.dora.constants.ConstantResources;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class APIinstance {
    public static Retrofit retroInstance()
    {
        return new Retrofit.Builder()
                       .baseUrl(ConstantResources.BASE_URL)
                       .addConverterFactory(GsonConverterFactory.create())
                       .build();
    }
}
