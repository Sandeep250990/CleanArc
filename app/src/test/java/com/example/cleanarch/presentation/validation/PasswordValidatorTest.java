package com.example.cleanarch.presentation.validation;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordValidatorTest {

    @Test
    public void testPasswordValidate(){
        boolean isValidPassword=PasswordValidator.isPasswordValidMethod("Test@123");
        assertTrue(isValidPassword);
    }


}