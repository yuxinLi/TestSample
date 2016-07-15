package com.example.testsample.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * 作者：lyx on 2016/7/14 17:48
 */
public class CalculatorTest {

    private static final String TAG = "CalculatorTest" ;
    Calculator c ;

    @BeforeClass
    public static void setUpClass(){
        System.out.println("setUpClass");
    }

    @Before
    public void setUp() {
        c = new Calculator();
        System.out.println( "setUp");
    }

    @After
    public void after(){
        System.out.println( "after");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println( "after");
    }

    @Test
    public void testAdd() throws Exception {
        int add = c.add(1, 3);
        Assert.assertEquals(4 , add);
    }

    @Test
    public void testMultiply() throws Exception {
        int multiply = c.multiply(2, 3);
        Assert.assertEquals(6 , multiply);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivide() throws Exception {
        c.divide(4 , 0);
    }

    @Test
    @Ignore
    public void notImpl(){
        System.out.println("not impl");
    }
}