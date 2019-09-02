package com.example.bms2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bms2.model.AccessTokenLdap;
import com.example.bms2.model.Login;
import com.example.bms2.services.ApiRetrofit;
import com.example.bms2.services.ClientLdap;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_singin2;
    private EditText edt_Username, edt_Password;

    //token
    private String token;

    //private static final String EMAIL_ADDRESS = "@mncgroup.com"
    //private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_Username = (EditText) findViewById(R.id.edt_username);
        edt_Password = (EditText) findViewById(R.id.edt_password);

        btn_singin2 = (Button) findViewById(R.id.btn_singin2);

        findViewById(R.id.btn_singin2).setOnClickListener(LoginActivity.this);


    }

    //method login
    private void userLogin() {
        String username = edt_Username.getText().toString().trim();
        String password = edt_Password.getText().toString().trim();

        if (username.isEmpty()) {
            edt_Username.setError("Username is required");
            edt_Username.requestFocus();
            return;
        }

        /*
        //email
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches)
        {
            edt_Username.setError("Enter a valid email");
            edt_Username.requestFocus();
        }


        //username
        if (!Pattern.compile(USERNAME_PATTERN).matcher(username).matches()) {
            edt_Username.setError("Enter a valid username");
            edt_Username.requestFocus();
        }
        */

        //password
        if (password.isEmpty()) {
            edt_Password.setError("Password is required");
            edt_Password.requestFocus();
        }

        /*
        //validasi
        if (password.length() > 6){
            edt_Password.setError("Password should be atleast 6 character long");
            edt_Password.requestFocus();
        }
        */

        //call class interface and class Apiretrofit
        Call<Login> call = ApiRetrofit
                .getInstance()
                .getApiClien()
                .userLogin(username, password);

        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {

                if(response.isSuccessful())
                {
                    String token = response.body().toString();
                    Log.e("TOKEN", token);
                    Toast.makeText(LoginActivity.this, response.body().getGagal(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                }
                else {

                    Toast.makeText(LoginActivity.this, response.body().getGagal(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {

            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_singin2:
                userLogin();
                break;
//            case R.id.btn_singUp:
//                userSignUp();
//                break;
        }

    }
}
