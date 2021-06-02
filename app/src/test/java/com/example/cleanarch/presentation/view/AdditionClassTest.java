package com.example.cleanarch.presentation.view;

import org.junit.Test;

import static org.junit.Assert.*;

public class AdditionClassTest {

    @Test
    public void testAdd(){
        int totalVal=AdditionClass.add(2,2);
        assertNotNull(totalVal);
        assertEquals(4,totalVal);
    }

}