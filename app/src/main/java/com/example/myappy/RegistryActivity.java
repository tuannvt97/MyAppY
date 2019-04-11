package com.example.myappy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistryActivity extends AppCompatActivity {
    private EditText edtName, edtPhone, edtEmail, edtPass, edtNhaplaiPass, edtAdress;
    private Button btnRegistry;
    private TextView loginLink;
    private static final String TAG = "SignupActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry);
        AnhXa();
        btnRegistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();

            }
        });
        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void signup(){
        Log.d(TAG, "Sigup");
        if(!validate()){
            onSignupFailed();
            return;
        }
        btnRegistry.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(RegistryActivity.this,
                R.style.ThemeOverlay_MaterialComponents_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        onSignupSuccess();
                        progressDialog.dismiss();
                    }
                }, 1000);
    }
    public void onSignupSuccess() {
        btnRegistry.setEnabled(true);
        SharedPreferences sharedPreferences = getSharedPreferences("mydatabase", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", edtEmail.getText().toString());
        editor.putString("password", edtPass.getText().toString());
        editor.putString("phone",edtPhone.getText().toString());
        editor.putString("name", edtName.getText().toString());
        editor.putString("adress", edtAdress.getText().toString());
        editor.commit();
        Intent it = new Intent(this, LoginActivity.class);
        setResult(100, it);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        btnRegistry.setEnabled(true);
    }
    public boolean validate(){
        boolean valid = true;
        String name  = edtName.getText().toString();
        String phone = edtPhone.getText().toString();
        String email = edtEmail.getText().toString();
        String password  = edtPass.getText().toString();
        String reEnterPassword = edtNhaplaiPass.getText().toString();
        if(name.isEmpty() || name.length() < 3){
            edtName.setError("at least 3 characters");
            valid = false;
        }else {
            edtName.setError(null);
        }
        if(phone.isEmpty() || phone.length() !=10){
            edtPhone.setError("enter a valid mobile number");
        }
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtEmail.setError("enter a valid email address");
            valid = false;
        } else {
            edtEmail.setError(null);
        }
        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            edtPass.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            edtPass.setError(null);
        }
        if (reEnterPassword.isEmpty() || reEnterPassword.length() < 4 || reEnterPassword.length() > 10 || !(reEnterPassword.equals(password))) {
            edtNhaplaiPass.setError("Password Do not match");
            valid = false;
        } else {
            edtNhaplaiPass.setError(null);
        }
        return valid;
    }

    private void AnhXa() {
        edtName = (EditText) findViewById(R.id.input_name);
        edtPhone = (EditText) findViewById(R.id.input_mobile);
        edtAdress = (EditText) findViewById(R.id.input_address);
        edtEmail = (EditText) findViewById(R.id.input_emailsigup);
        edtPass  = (EditText) findViewById(R.id.input_password);
        edtNhaplaiPass = (EditText) findViewById(R.id.input_reEnterPassword);
        btnRegistry = (Button) findViewById(R.id.btn_signup);
        loginLink = (TextView) findViewById(R.id.link_login);
    }
}
