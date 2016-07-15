package com.example.testsample.junitrule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.robolectric.RuntimeEnvironment;

/**
 * 作者：lyx on 2016/7/15 18:02
 */
public class ContextRule implements TestRule {

    @Override
    public Statement apply(Statement base, Description description) {
        ContextHolder.set(RuntimeEnvironment.application);
        return base;
    }
}
