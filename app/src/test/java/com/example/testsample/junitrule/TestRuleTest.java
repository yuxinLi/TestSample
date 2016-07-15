package com.example.testsample.junitrule;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

/**
 * 作者：lyx on 2016/7/15 18:08
 */
public class TestRuleTest {

    @Rule
    public MethodNameExample m = new MethodNameExample();

    @Test
    public void add(){
        Assert.assertEquals(2 , 2);
    }
}
