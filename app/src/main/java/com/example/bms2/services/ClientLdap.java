package com.example.bms2.services;

import com.example.bms2.model.AccessTokenLdap;
import com.example.bms2.model.Login;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ClientLdap {

    @FormUrlEncoded
    @POST("api")
    Call<Login> userLogin(@Field("username") String username,
                          @Field("password") String password);

    @POST("token")
    @FormUrlEncoded
    Call<ResponseBody> getToken(@Header("Authorization") String authToken);
}