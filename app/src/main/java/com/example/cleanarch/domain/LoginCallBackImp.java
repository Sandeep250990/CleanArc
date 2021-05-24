package com.example.cleanarch.domain;

import com.example.cleanarch.data.model.LoginRequest;
import com.example.cleanarch.data.model.LoginSuccessfullResponse;
import com.example.cleanarch.data.repository.LoginRepository;

import retrofit2.Call;

public class LoginCallBackImp implements LoginCallBackFunction {
    LoginRepository loginRepository;
    Call<LoginSuccessfullResponse> responseCall;
    LoginRequest loginRequest;

    public LoginCallBackImp(LoginRequest loginRequest){
        this.loginRequest=loginRequest;
        loginRepository=new LoginRepository();

    }
    @Override
    public Call<LoginSuccessfullResponse> getLoginResponse() {
        responseCall=loginRepository.loginSuccessfullResponseCall(loginRequest);
        return responseCall;
    }


}
