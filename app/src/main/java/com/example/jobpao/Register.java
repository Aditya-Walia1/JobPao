package com.example.jobpao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Register extends AppCompatActivity {


    public static final String Tag ="Tag";
    EditText mFullName,mEmail,mPassword,mPhone;
    Button mRegisterButton;
    TextView mLoginBtn;
    ProgressBar mProgressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFullName = findViewById(R.id.FullName);
        mEmail=findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mPhone=findViewById(R.id.PhoneNumber);
        mRegisterButton = findViewById(R.id.RegisterBtn);
        mLoginBtn =findViewById(R.id.createText);
        mProgressBar=findViewById(R.id.progressBar);



        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Register.this , LoginPage.class);
            }




        });

         mRegisterButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 final String email = mEmail.getText().toString().trim();
                 String password = mPassword.getText().toString().trim();
                 final String fullName = mFullName.getText().toString();
                 final String phoneNumber = mPhone.getText().toString();

                 if(TextUtils.isEmpty(email))
                 {
                     mEmail.setError("Email is Required");
                     return;
                 }
                 if(TextUtils.isEmpty(password))
                 {
                     mEmail.setError("Password is Required");
                     return;
                 }
                 if(password.length() < 8)
                 {
                     mPassword.setError("Password Must Be >= 8 Letters");
                     return;
                 }

                 mProgressBar.setVisibility(View.VISIBLE);

             }
         });

    }
}