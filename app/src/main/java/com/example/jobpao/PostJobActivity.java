package com.example.jobpao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PostJobActivity extends AppCompatActivity {

    BottomNavigationView bnView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_job);

        bnView.findViewById(R.id.bnView);


        bnView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id =item.getItemId();
                if(id==R.id.jobs)
                {
                  loadFrag(new jobsFragment(),false);
                    
                } else if (id==R.id.myApplies) {
                    loadFrag(new myAppliesFragment(),false);
                    
                } else if (id==R.id.inbox) {
                    loadFrag(new inboxFragment(),false);
                    
                } else{
                    loadFrag(new profileFragment(),true);

                }
                return true;
            }
        });

        bnView.setSelectedItemId(R.id.profile);

    }

    public void loadFrag(Fragment fragment,boolean flag){
        FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag)
        ft.add(R.id.containerr,fragment);
        else
            ft.replace(R.id.containerr,fragment);
        ft.commit();
    }
}