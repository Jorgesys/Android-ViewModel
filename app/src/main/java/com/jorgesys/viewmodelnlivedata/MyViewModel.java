package com.jorgesys.viewmodelnlivedata;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class MyViewModel extends ViewModel {

    private String TAG = MyViewModel.class.getSimpleName();

    private MutableLiveData<List<User>> usersList;


    LiveData<List<User>> getUsersList(Context context) {
        Log.i(TAG, "getUsersList() called!.");
        if (usersList == null) {
            Log.i(TAG, "getUsersList() usersList == null then call loadUsers().");
            usersList = new MutableLiveData<>();
            loadUsers(context);
        }
        return usersList;
    }

    private void loadUsers(final Context context) {
        Log.i(TAG, "loadUsers() called!.");

        final Handler myHandler = new Handler();
        myHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "loadUsers() loading Users! :: " + Utils.millisecToTime(System.currentTimeMillis()));
                List<User> usersStringList = new ArrayList<>();
                for(int i = 0; i< 100; i++){
                    //Add users
                    usersStringList.add(Utils.getRandomUser(context));
                }
                long seed = System.nanoTime();
                Collections.shuffle(usersStringList, new Random(seed));

                usersList.setValue(usersStringList);

                myHandler.postDelayed(this, 10000);
            }
        }, 500);


    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.w(TAG, "onCleared() called!.. bye");
    }

}