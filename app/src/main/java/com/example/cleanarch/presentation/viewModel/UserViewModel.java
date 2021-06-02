package com.example.cleanarch.presentation.viewModel;

import androidx.lifecycle.ViewModel;

import com.example.cleanarch.data.model.UserResponse;
import com.example.cleanarch.domain.UserCallBackImp;

import javax.inject.Inject;

import retrofit2.Call;

public class UserViewModel extends ViewModel {

    private UserCallBackImp callBackImp;
    public Call<UserResponse>userResponseCall;

    @Inject
    public UserViewModel(UserCallBackImp callBackImp){
        this.callBackImp=callBackImp;
        userResponseCall=callBackImp.callBackResponse();
    }



}
