package com.example.testsample.what;

import org.junit.Assert;
import org.junit.Test;

/**
 * 作者：lyx on 2016/7/14 17:42
 */
public class CalculatorTest {

    @Test
    public void testAdd() throws Exception {
        Calculator c = new Calculator();
        int add = c.add(1, 2);
        Assert.assertEquals(3 , add);
    }
}