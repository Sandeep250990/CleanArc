package com.example.cleanarch.presentation.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cleanarch.R;
import com.example.cleanarch.data.model.LoginRequest;
import com.example.cleanarch.data.model.LoginSuccessfullResponse;
import com.example.cleanarch.domain.LoginCallBackImp;
import com.example.cleanarch.presentation.util.Utility;
import com.example.cleanarch.presentation.validation.EmailValidator;

import retrofit2.Call;

import static com.example.cleanarch.presentation.MyApplication.getContext;

public class LoginViewModel extends ViewModel {

    public LoginCallBackImp loginCallBackImp;
    LoginRequest loginRequest;
    public Call<LoginSuccessfullResponse> loginSuccessfullResponseCall;
    public MutableLiveData<Call<LoginSuccessfullResponse>> callBackImpMutableLiveData=new MutableLiveData<>();

    public LoginViewModel(){
        loginRequest=new LoginRequest();

    }
    public void onLoginClick(String email, String password){
        checkValidation(email,password);
    }
    public void checkValidation(String email, String password) {
        if(email.trim().length()==0){
            Utility.showToast(getContext().getResources().getString(R.string.error_enter_email));
        }else if(!EmailValidator.isValidEmail(email)){
            Utility.showToast(getContext().getResources().getString(R.string.error_inavlid_email));
        }else if(password.trim().length()==0){
            Utility.showToast(getContext().getResources().getString(R.string.error_enter_pwd));
        }
//        else if(!PasswordValidator.isPasswordValidMethod(password)){
//            Utility.showToast(getContext().getResources().getString(R.string.error_invalid_pwd));
//        }
        else{
            loginRequest.setEmail(email);
            loginRequest.setPassword(password);
            loginCallBackImp=new LoginCallBackImp(loginRequest);
            loginSuccessfullResponseCall=loginCallBackImp.getLoginResponse();
            callBackImpMutableLiveData.postValue(loginSuccessfullResponseCall);
        }
    }
}
