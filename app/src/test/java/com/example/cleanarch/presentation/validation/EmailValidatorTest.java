package com.example.cleanarch.presentation.validation;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmailValidatorTest {

    @Test
    public void testEmailValidation(){
        boolean isValidEmail=EmailValidator.isValidEmail("adam@test.com");
        assertTrue(isValidEmail);

    }

}