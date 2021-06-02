package com.example.cleanarch.presentation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import com.example.cleanarch.R;
import com.example.cleanarch.data.model.UserResponse;
import com.example.cleanarch.databinding.ActivityMainBinding;
import com.example.cleanarch.presentation.MyApplication;
import com.example.cleanarch.presentation.adapter.UsersAdapter;

import com.example.cleanarch.presentation.util.Utility;
import com.example.cleanarch.presentation.viewModel.UserViewModel;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {

    @Inject
    UserViewModel userViewModel;

    ActivityMainBinding activityMainBinding;
    UsersAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        ((MyApplication)MyApplication.getContext()).getRetrofitComponent().injectUsers(this);
        getData();
    }
    public void getData(){
        userViewModel.userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
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
                else if(response.body().getData().size()==0){
                    Utility.showToast(response.body().getSupport().getText());
                    return;
                }
                setAdapter(response);
            }
            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                System.out.print(t.getMessage());
            }
        });
    }
    public void setAdapter(Response<UserResponse> response){
        adapter=new UsersAdapter(response.body().getData(), UserActivity.this);
        activityMainBinding.recyclerview.setAdapter(adapter);

    }
}