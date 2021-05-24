package com.example.cleanarch.presentation.view;

import com.example.cleanarch.data.repository.UserRepository;
import com.example.cleanarch.domain.UserCallBackImp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.lenient;

@RunWith(MockitoJUnitRunner.class)
public class UserActivityTest {

    @Mock
    UserCallBackImp callBackImp;


    UserRepository userRepository;

    @Before
    public void setUp() {

        userRepository=new UserRepository();
    }

    @Test
    public void checkNetworkData(){
        lenient().when(callBackImp.callBackResponse()).thenReturn(userRepository.getUserResponseCall());
    }

    @After
    public void tearDown() {
    }
}