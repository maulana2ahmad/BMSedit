package com.example.bms2.storage;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {

    private String TOKEN = "token";
    private String NAME = "name";
    private String PASSWORD = "password";

    SharedPreferences sp;
    SharedPreferences.Editor speditor;

    public SharedPrefManager(Context context)
    {
        sp = context.getSharedPreferences(TOKEN, Context.MODE_PRIVATE);
        speditor = sp.edit();
    }



}
