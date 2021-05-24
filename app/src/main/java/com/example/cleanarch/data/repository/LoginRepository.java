package com.example.cleanarch.data.repository;

import com.example.cleanarch.data.model.LoginRequest;
import com.example.cleanarch.data.model.LoginSuccessfullResponse;
import com.example.cleanarch.data.network.ApiClient;
import com.example.cleanarch.data.network.ApiInterface;

import retrofit2.Call;

public class LoginRepository {

    ApiInterface apiClientInterface;
    Call<LoginSuccessfullResponse> getLoginResponse;

    public Call<LoginSuccessfullResponse> loginSuccessfullResponseCall(LoginRequest loginRequest){
        apiClientInterface=ApiClient.getApiInterface();
        getLoginResponse=apiClientInterface.getLoginSuccessfullData(loginRequest);
        return getLoginResponse;

    }

}
