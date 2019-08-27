package com.example.bms2.model;

import com.google.gson.annotations.SerializedName;

public class AccessTokenLdap {


    @SerializedName("token")
    private String token;


    public AccessTokenLdap(String token) {

        this.token = token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

}
