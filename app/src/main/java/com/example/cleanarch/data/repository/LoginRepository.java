package com.example.cleanarch.data.repository;

import com.example.cleanarch.data.model.LoginRequest;
import com.example.cleanarch.data.model.LoginSuccessfullResponse;
import com.example.cleanarch.di.RetroServiceInterface;
import com.example.cleanarch.presentation.MyApplication;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Retrofit;

public class LoginRepository {

    public LoginRepository(){
        ((MyApplication)MyApplication.getContext()).getRetrofitComponent().injectLogin(LoginRepository.this);
    }

    @Inject
    RetroServiceInterface retroServiceInterface;

    Call<LoginSuccessfullResponse> getLoginResponse;

    public Call<LoginSuccessfullResponse> loginSuccessfullResponseCall(LoginRequest loginRequest){
        getLoginResponse=retroServiceInterface.getLoginSuccessfullData(loginRequest);
        return getLoginResponse;

    }

}
