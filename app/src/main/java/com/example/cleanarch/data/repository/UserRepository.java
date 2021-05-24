package com.example.cleanarch.data.repository;

import com.example.cleanarch.data.model.UserResponse;
import com.example.cleanarch.data.network.ApiClient;
import com.example.cleanarch.data.network.ApiInterface;

import retrofit2.Call;

public class UserRepository {

    ApiInterface apiInterface;
    Call<UserResponse> userResponseCall;

    public Call<UserResponse> getUserResponseCall() {
        apiInterface= ApiClient.getApiInterface();
        userResponseCall=apiInterface.getUserData();
        return userResponseCall;
    }
}
