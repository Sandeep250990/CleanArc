package com.example.cleanarch.presentation.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.cleanarch.R;
import com.example.cleanarch.data.model.LoginSuccessfullResponse;
import com.example.cleanarch.databinding.ActivityLoginBinding;
import com.example.cleanarch.presentation.util.Utility;
import com.example.cleanarch.presentation.viewModel.LoginViewModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding activityLoginBinding;
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    public void init(){
        activityLoginBinding= DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginViewModel=new LoginViewModel();
        activityLoginBinding.setLoginViewModel(loginViewModel);
        LiveData<Call<LoginSuccessfullResponse>>loginCallBackImpLiveData=loginViewModel.callBackImpMutableLiveData;
        loginCallBackImpLiveData.observe(this, new Observer<Call<LoginSuccessfullResponse>>() {
            @Override
            public void onChanged(Call<LoginSuccessfullResponse> loginCallBackImp) {
                getLoginInfo(loginCallBackImp);
            }
        });
    }

    public void getLoginInfo(Call<LoginSuccessfullResponse> loginSuccessfullResponseCall){


        loginSuccessfullResponseCall.enqueue(new Callback<LoginSuccessfullResponse>() {
            @Override
            public void onResponse(Call<LoginSuccessfullResponse> call, Response<LoginSuccessfullResponse> response) {

                if(!response.isSuccessful()){
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        String message=jObjError.get("error").toString();
                        Utility.showToast(message);
                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                    }
                    return;
                }
                callNextActivity();
            }

            @Override
            public void onFailure(Call<LoginSuccessfullResponse> call, Throwable t) {

            }
        });
    }

    private void callNextActivity(){
        Intent intent=new Intent(this, UserActivity.class);
        startActivity(intent);
        finish();
    }

}
