package com.example.cleanarch.data.repository;

import com.example.cleanarch.data.model.UserResponse;
import com.example.cleanarch.di.RetroServiceInterface;
import com.example.cleanarch.presentation.MyApplication;

import javax.inject.Inject;

import retrofit2.Call;

public class UserRepository {

    public UserRepository(){
        ((MyApplication)MyApplication.getContext()).getRetrofitComponent().injectUsers(UserRepository.this);
    }

    @Inject
    RetroServiceInterface retroServiceInterface;

    Call<UserResponse> userResponseCall;

    public Call<UserResponse> getUserResponseCall() {
        userResponseCall=retroServiceInterface.getUserData();
        return userResponseCall;
    }
}
