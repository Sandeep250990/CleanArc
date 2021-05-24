package com.example.cleanarch.presentation.viewModel;

import androidx.lifecycle.ViewModel;

import com.example.cleanarch.data.model.UserResponse;
import com.example.cleanarch.domain.UserCallBackImp;

import retrofit2.Call;

public class UserViewModel extends ViewModel {

    private UserCallBackImp callBackImp;
    public Call<UserResponse>userResponseCall;


    public UserViewModel(){
        callBackImp=new UserCallBackImp();
        userResponseCall=callBackImp.callBackResponse();
    }



}
