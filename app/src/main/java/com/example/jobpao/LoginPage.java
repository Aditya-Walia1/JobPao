package com.example.jobpao;

import static com.example.jobpao.R.id.progressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {

    EditText memail,mpassword;
    Button mLoginBtn;
    TextView mcreateBtn;
    ProgressBar progressBar;

    FirebaseAuth fAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        memail = findViewById(R.id.email);
        mpassword = findViewById(R.id.password);
        mLoginBtn = findViewById(R.id.RegisterBtn);
        mcreateBtn = findViewById(R.id.createText);
        progressBar = findViewById(R.id.progressBar);


        mcreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }



        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = memail.getText().toString().trim();
                String password = mpassword.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    memail.setError("Email is Required");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    mpassword.setError("Password is Required");
                    return;
                }
                if (password.length() < 8) {
                    mpassword.setError("Password Must Be >= 8 Letters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginPage.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // User registration successful
                                    Toast.makeText(LoginPage.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                    // You can add code here to navigate to another activity or perform other actions
                                    startActivity(new Intent(getApplicationContext(), home.class));

                                } else {
                                    // User registration failed
                                    Toast.makeText(LoginPage.this, "Registration Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }

                               progressBar.setVisibility(View.GONE);

                            }
                        });
            }
        });
    }
}