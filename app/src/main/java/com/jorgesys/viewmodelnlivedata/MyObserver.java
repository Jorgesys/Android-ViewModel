package com.jorgesys.viewmodelnlivedata;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

public class MyObserver implements LifecycleObserver {

    private static final String TAG = "MyObserver";
    public MyObserver(LifecycleOwner lifecycleOwner) {
        Log.i(TAG, "Constructor create MyObserver instance");
        lifecycleOwner.getLifecycle().addObserver(this);
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){
        Log.d(TAG, "onCreate()");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(){
        Log.d(TAG, "onStart()");
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void connectListener() {
        Log.d(TAG, "connectListener()");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void disconnectListener() {
        Log.d(TAG, "ON_PAUSE disconnectListener()");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        Log.w(TAG, "onStop()");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Log.w(TAG, "onDestroy()");
    }

}
