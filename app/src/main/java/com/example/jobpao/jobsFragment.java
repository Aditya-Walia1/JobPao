package com.example.jobpao;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class jobsFragment extends Fragment {

    // Rest of your fragment code

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jobs, container, false);

        // Initialize the FloatingActionButton
        FloatingActionButton floatingActionButton = view.findViewById(R.id.fabadd);
        // Set click listener for the FloatingActionButton
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform your desired action here when the FloatingActionButton is clicked

                // Create an Intent to go to the NextActivity
                Intent intent = new Intent(getActivity(), InsertJobPostActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
