package com.example.bms2;

import android.content.SharedPreferences;

import com.example.bms2.model.AccessTokenLdap;

public class TokenManager {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    private static TokenManager INTENCE = null;

    private TokenManager(SharedPreferences pref) {
        this.pref = pref;
        this.editor = editor;
    }


    static synchronized TokenManager getInstance(SharedPreferences pref){

        if (INTENCE == null) {
            INTENCE = new TokenManager(pref);
        }

        return INTENCE;
    }

    public void SaveToken (AccessTokenLdap tokenLdap) {
        editor.putString("ACCESS_TOKEN", tokenLdap.getToken()).commit();
        //editor.putString("REFRESH_TOKEN", tokenLdap.getToken()).commit();
    }

    public void deleteToken(){
        editor.remove("ACCESS_TOKEN");
    }

    /*
    public void AccessToken getToken()
    {

    }
    */
}
