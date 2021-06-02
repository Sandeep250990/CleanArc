package com.example.cleanarch.presentation.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.test.rule.ActivityTestRule;

import com.example.cleanarch.data.model.LoginRequest;
import com.example.cleanarch.data.model.LoginSuccessfullResponse;
import com.example.cleanarch.di.RetroServiceInterface;
import com.example.cleanarch.domain.LoginCallBackImp;
import com.example.cleanarch.presentation.validation.EmailValidator;
import com.example.cleanarch.presentation.validation.PasswordValidator;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginViewModelTest {

    LoginRequest loginRequest;

    LoginSuccessfullResponse loginSuccessfullResponse;

    LoginCallBackImp loginCallBackImp=Mockito.mock(LoginCallBackImp.class);

    @Mock
    Call<LoginSuccessfullResponse> loginSuccessfullResponseCall;

    @Mock
    MutableLiveData<Call<LoginSuccessfullResponse>> callBackImpMutableLiveData=new MutableLiveData<>();

    @Mock
    LoginViewModel loginViewModel;

    String email;
    String password;

    @Before
    public void setUp() {
        email="test@gmail.com";
        password="Test@1234";
        loginRequest=new LoginRequest();
        loginSuccessfullResponse=new LoginSuccessfullResponse();
        loginSuccessfullResponse.setToken("fghfhgsds");

    }

    @Test
    public void testonLoginClick() {

        assertNotNull(email);
        assertTrue(!email.isEmpty());
        assertNotNull(password);
        assertTrue(!password.isEmpty());
        loginViewModel.onLoginClick(email,password);

    }

    @Test
    public void testcheckValidation() throws IOException {
        assertNotNull(email);
        assertTrue(!email.isEmpty());
        assertTrue(EmailValidator.isValidEmail(email));
        assertNotNull(password);
        assertTrue(!password.isEmpty());
        assertTrue(PasswordValidator.isPasswordValidMethod(password));

        loginRequest.setEmail(email);
        loginRequest.setPassword(password);
        assertNotNull(loginRequest);
        when(loginCallBackImp.getLoginResponse().execute().body()).thenReturn(loginSuccessfullResponse);
        assertNotNull(loginSuccessfullResponse);
        callBackImpMutableLiveData.postValue(loginSuccessfullResponseCall);


    }

    public void testLoginREsponse(){

    }

    @After
    public void tearDown() throws Exception {
    }
}