package com.example.cleanarch.data.network;

import com.example.cleanarch.data.model.LoginRequest;
import com.example.cleanarch.data.model.LoginSuccessfullResponse;
import com.example.cleanarch.data.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("/api/login")
    Call<LoginSuccessfullResponse> getLoginSuccessfullData(@Body LoginRequest loginRequest);

    @GET("/api/users?page=2")
    Call<UserResponse>getUserData();


}
