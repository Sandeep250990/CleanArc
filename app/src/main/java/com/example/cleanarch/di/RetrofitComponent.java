package com.example.cleanarch.di;

import com.example.cleanarch.data.repository.LoginRepository;
import com.example.cleanarch.data.repository.UserRepository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RetrofitModule.class})
public interface RetrofitComponent {
     void injectLogin(LoginRepository loginRepository);
     void injectUsers(UserRepository userRepository);

}
