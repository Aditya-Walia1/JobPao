package com.example.jobpao;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class InsertJobPostActivity extends AppCompatActivity {

    private EditText job_Title;
    private EditText job_Description;
    private EditText job_Skills;
    private EditText job_Salary;

    private Button post_Button_Job;

    //Firebase
    private FirebaseAuth mAuth;
    private DatabaseReference mJobPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_job_post);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Post Job");

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser mUser = mAuth.getCurrentUser();
        String uId = mUser.getUid();

        mJobPost = FirebaseDatabase.getInstance().getReference().child("Job Post").child(uId);

        InsertJob();
    }

    private void InsertJob() {
        job_Title = findViewById(R.id.jobTitle);
        job_Description = findViewById(R.id.jobDescription);
        job_Skills = findViewById(R.id.jobSkills);
        job_Salary = findViewById(R.id.jobSalary);

        post_Button_Job = findViewById(R.id.btnjobPost);

        post_Button_Job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = job_Title.getText().toString().trim();
                String description = job_Description.getText().toString().trim();
                String skills = job_Skills.getText().toString().trim();
                String salary = job_Salary.getText().toString().trim();

                if (TextUtils.isEmpty(title)) {
                    job_Title.setError("Required Field..");
                    return;
                }

                if (TextUtils.isEmpty(description)) {
                    job_Description.setError("Required Field..");
                    return;
                }
                if (TextUtils.isEmpty(skills)) {
                    job_Skills.setError("Required Field..");
                    return;
                }
                if (TextUtils.isEmpty(salary)) {
                    job_Salary.setError("Required Field");
                    return;
                }

                // Create a new JobPost object and push it to the database
                String id = mJobPost.push().getKey();
                JobPost jobPost = new JobPost(id, title, description, skills, salary);
                mJobPost.child(id).setValue(jobPost);
                // You may also want to show a success message or navigate back to the previous activity here.

                Toast.makeText(getApplicationContext(),"Successfull",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),PostJobActivity.class));


            }
        });
    }
}
