package com.example.cleanarch.domain;

import com.example.cleanarch.data.model.LoginSuccessfullResponse;

import retrofit2.Call;

public interface LoginCallBackFunction {

    Call<LoginSuccessfullResponse> getLoginResponse();
}
