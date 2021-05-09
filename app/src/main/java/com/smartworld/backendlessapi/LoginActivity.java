package com.smartworld.backendlessapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class LoginActivity extends AppCompatActivity {

    Button loginBtn,registerBtn;
    EditText etMail,etPassword;
    TextView tvreset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = findViewById(R.id.loginBtn);
        registerBtn = findViewById(R.id.registerBtn);

        etMail = findViewById(R.id.etMail);
        etPassword = findViewById(R.id.etPassword);
        tvreset = findViewById(R.id.tvreset);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etMail.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty()){
                    Toast.makeText(LoginActivity.this, "All fields required.", Toast.LENGTH_SHORT).show();
                } else {
                    String email = etMail.getText().toString().trim();
                    String password = etPassword.getText().toString().trim();

                    Backendless.UserService.login(email, password, new AsyncCallback<BackendlessUser>() {
                        @Override
                        public void handleResponse(BackendlessUser response) {
                            Toast.makeText(LoginActivity.this, "Logged in successfully!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                            LoginActivity.this.finish();
                        }

                        @Override
                        public void handleFault(BackendlessFault fault) {
                            Toast.makeText(LoginActivity.this, "Error: "+ fault.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }, true);
                }
            }
        });
        tvreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etMail.getText().toString().isEmpty()){
                    Toast.makeText(LoginActivity.this, "Please enter email field", Toast.LENGTH_SHORT).show();
                } else {
                    String email = etMail.getText().toString().trim();

//                    showProgress(true);
                    Backendless.UserService.restorePassword(email, new AsyncCallback<Void>() {
                        @Override
                        public void handleResponse(Void response) {
                            Toast.makeText(LoginActivity.this, "Reset instructions sent to your Email address!", Toast.LENGTH_SHORT).show();
//                                showProgress(false);
                        }

                        @Override
                        public void handleFault(BackendlessFault fault) {
                            Toast.makeText(LoginActivity.this, "Error: "+ fault.getMessage(), Toast.LENGTH_SHORT).show();
//                                showProgress(false);
                        }
                    });
                }
            }
        });

    }
}