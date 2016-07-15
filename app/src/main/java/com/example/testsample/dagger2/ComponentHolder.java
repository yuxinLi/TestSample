package com.example.testsample.dagger2;

/**
 * 作者：lyx on 2016/7/15 15:47
 */
public class ComponentHolder {

    private static AppComponent sAppComponent;

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }

    public static void setAppComponent(AppComponent sAppComponent) {
        ComponentHolder.sAppComponent = sAppComponent;
    }
}
