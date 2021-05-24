package com.example.cleanarch.presentation.util;

import android.widget.Toast;

import com.example.cleanarch.presentation.MyApplication;

public class Utility {

    public static void showToast(String message){
        Toast.makeText(MyApplication.getContext(),message,Toast.LENGTH_LONG).show();
    }

}
