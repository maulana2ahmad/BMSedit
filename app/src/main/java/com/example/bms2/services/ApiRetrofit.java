package com.example.bms2.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRetrofit {

    //private static Retrofit retrofit = null;

    private String token;

    private static Retrofit retrofit = null;
    private static String BASE_URL = "http://portal-bams.mncgroup.com:8008/";

    private static  ApiRetrofit mIntence;

    public static ClientLdap getServices()
    {
        if (retrofit == null)
        {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(ClientLdap.class);
    }

}