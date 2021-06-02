package com.example.cleanarch.data.repository;

import com.example.cleanarch.data.model.UserResponse;
import com.example.cleanarch.di.RetroServiceInterface;

import javax.inject.Inject;

import retrofit2.Call;

public class UserRepository {

    RetroServiceInterface retroServiceInterface;
    Call<UserResponse> userResponseCall;

    @Inject
    public UserRepository(RetroServiceInterface retroServiceInterface){
        this.retroServiceInterface=retroServiceInterface;
    }

    public Call<UserResponse> getUserResponseCall() {
        userResponseCall=retroServiceInterface.getUserData();
        return userResponseCall;
    }
}
