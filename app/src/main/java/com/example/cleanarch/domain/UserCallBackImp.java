package com.example.cleanarch.domain;

import com.example.cleanarch.data.model.UserResponse;
import com.example.cleanarch.data.repository.UserRepository;

import javax.inject.Inject;

import retrofit2.Call;

public class UserCallBackImp implements UserCallBackFunction {

    UserRepository userRepository;
    Call<UserResponse>userResponseCall;

    @Inject
    public UserCallBackImp(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public Call<UserResponse> callBackResponse() {
        userResponseCall=userRepository.getUserResponseCall();
        return userResponseCall;
    }
}
