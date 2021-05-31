package com.example.cleanarch.presentation;

import android.app.Application;
import android.content.Context;

import com.example.cleanarch.di.DaggerRetrofitComponent;
import com.example.cleanarch.di.RetrofitComponent;
import com.example.cleanarch.di.RetrofitModule;

public class MyApplication extends Application {

    private static Context sContext;
    private RetrofitComponent retrofitComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        retrofitComponent=DaggerRetrofitComponent.builder().retrofitModule(new RetrofitModule()).build();
    }

    public static Context getContext() {
        return sContext;
    }
    public RetrofitComponent getRetrofitComponent(){

        return retrofitComponent;
    }
}
