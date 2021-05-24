package com.example.cleanarch.data.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    static String BASE_URL="https://reqres.in";
    static Retrofit retrofit=null;

    public static Retrofit getClient(){
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient= new OkHttpClient().newBuilder().addInterceptor(httpLoggingInterceptor).build();
        retrofit=new Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }

    public static ApiInterface getApiInterface(){
        return getClient().create(ApiInterface.class);
    }


}
