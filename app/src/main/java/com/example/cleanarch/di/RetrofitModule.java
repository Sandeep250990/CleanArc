package com.example.cleanarch.di;

import com.example.cleanarch.data.model.LoginRequest;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    private String BASE_URL="https://reqres.in";

    @Singleton
    @Provides
    public RetroServiceInterface retroServiceInterface(Retrofit retrofit){
        return retrofit.create(RetroServiceInterface.class);
    }

    @Singleton
    @Provides
    public Retrofit getRetrofitInstance(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }

}
