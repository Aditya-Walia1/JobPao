package com.example.jobpao;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

public class InsertJobPostActivity extends AppCompatActivity {

    private EditText job_Title;
    private EditText job_Description;
    private EditText job_Skills;
    private EditText job_Salary;

    private Button post_Button_Job;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_job_post);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Post Job");

        InsertJob();


    }

    private void InsertJob()
    {
        job_Title=findViewById(R.id.jobTitle);
        job_Description=findViewById(R.id.jobDescription);
        job_Skills=findViewById(R.id.jobSkills);
        job_Salary=findViewById(R.id.jobSalary);

        post_Button_Job=findViewById(R.id.btnjobPost);

        post_Button_Job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
