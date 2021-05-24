package com.example.cleanarch.presentation.view;

import com.example.cleanarch.data.model.LoginRequest;
import com.example.cleanarch.data.model.LoginSuccessfullResponse;
import com.example.cleanarch.data.network.ApiClient;
import com.example.cleanarch.data.network.ApiInterface;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import retrofit2.Response;

import static org.junit.Assert.*;

public class LoginActivityTest {

    LoginRequest loginRequest;

    @Before
    public void setUp() {
        loginRequest=new LoginRequest();
    }

    @Test
    public void checkSuccessfullApiResponse() throws IOException {
        loginRequest.setEmail("eve.holt@reqres.in");
        loginRequest.setPassword("cityslicka");
        assertNotNull(loginRequest);
        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);
        Response<LoginSuccessfullResponse> response=apiInterface.getLoginSuccessfullData(loginRequest).execute();
        assertTrue(response.isSuccessful());
    }

    @Test
    public void checkUnSuccessfullApiResponse() throws IOException {
        loginRequest.setEmail("eve.holt@reqres.com");
        loginRequest.setPassword("eve@898");
        assertNotNull(loginRequest);
        ApiInterface apiInterface=ApiClient.getClient().create(ApiInterface.class);
        Response<LoginSuccessfullResponse>response=apiInterface.getLoginSuccessfullData(loginRequest).execute();
        assertFalse(response.isSuccessful());
    }

}