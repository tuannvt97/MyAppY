package com.example.myappy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmail , edtPass;
    private Button btnLogin;
    private TextView signupLink, forgotpassword;

    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        anhxa();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        signupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), RegistryActivity.class);
                startActivityForResult(it, REQUEST_SIGNUP);

            }
        });
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_SIGNUP){
            if(resultCode == 100){
                this.finish();
            }
        }
    }

    public void login(){
        Log.d(TAG,"Login");
        if(!validate()){
            onLoginFailed();
            return;
        }
        btnLogin.setEnabled(false);
        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.ThemeOverlay_MaterialComponents_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String email = edtEmail.getText().toString();
        String password = edtPass.getText().toString();

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onLoginSuccess();
                progressDialog.dismiss();
            }
        },1000);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    public boolean validate(){
        boolean valid = true;
        String email = edtEmail.getText().toString();
        String password = edtPass.getText().toString();
        if(email.isEmpty() || Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            edtEmail.setError("Enter a valid email address");
            valid = false;
        }else {
            edtEmail.setError(null);
        }
        if(password.isEmpty() || password.length() < 4 || password.length() >10){
            edtPass.setError("between 4 and 10 alphanumeric characters");
        }else {
            edtPass.setError(null);
        }
        return valid;

    }
    public void  onLoginFailed(){
        Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
        btnLogin.setEnabled(true);
    }
    public void onLoginSuccess(){
        btnLogin.setEnabled(true);
        SharedPreferences sharedPreferences = getSharedPreferences("mydatabase", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", edtEmail.getText().toString());
        editor.putString("password", edtPass.getText().toString());
        editor.commit();
        Intent intent = new Intent(this, List_deviceFragment.class);
        startActivity(intent);

    }
    private void anhxa() {
        edtEmail = (EditText) findViewById(R.id.input_email);
        edtPass = (EditText) findViewById(R.id.input_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        signupLink = (TextView) findViewById(R.id.link_signup);
        forgotpassword = (TextView) findViewById(R.id.link_forgotpassword);
    }
}
