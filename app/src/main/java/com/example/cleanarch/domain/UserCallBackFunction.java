package com.example.cleanarch.domain;

import com.example.cleanarch.data.model.UserResponse;

import retrofit2.Call;

public interface UserCallBackFunction {

    Call<UserResponse> callBackResponse();
}
