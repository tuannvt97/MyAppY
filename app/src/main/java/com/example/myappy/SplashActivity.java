package com.example.myappy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean result  = checklogin();
                if (result) {
                    Intent intent = new Intent(SplashActivity.this, List_deviceFragment.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        },1000);
    }

    private boolean checklogin() {
        boolean checklogin = false;
        SharedPreferences share = getSharedPreferences("mydatabase", MODE_PRIVATE);
        String email = share.getString("email","");
        String password = share.getString("password","");
        if(!email.equals("") || !password.equals("")){
            checklogin = true;
        }
        return checklogin;
    }
}
