package com.jorgesys.viewmodelnlivedata;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MyViewModel";
    private MyViewModel model;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);
        model = ViewModelProviders.of(this).get(MyViewModel.class);
        //MainActivityViewModel model = new ViewModelProvider(this).get(MainActivityViewModel.class);

        //Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.getUsersList(getApplicationContext()).observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> usersList) {
                // update UI
                //ArrayAdapter<User> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, usersList);
                MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(getApplicationContext(), usersList);

                //Configure RecyclerView
                final RecyclerView listView = (RecyclerView) findViewById(R.id.listUsers);
                LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
                llm.setOrientation(LinearLayoutManager.VERTICAL);
                listView.setLayoutManager(llm);
                //Assign adapter to ListView.
                listView.setAdapter(adapter);
                //Hide the progress bar.
                progressBar.setVisibility(View.GONE);
            }
        });

    }



    @Override
    public void onPause() {
        super.onPause();

        Log.i(TAG, "hasObservers(): " + model.getUsersList(getApplicationContext()).hasObservers());
        Log.i(TAG, "hasActiveObservers(): " + model.getUsersList(getApplicationContext()).hasActiveObservers());
        model.getUsersList(getApplicationContext()).removeObservers(this);
    }


}