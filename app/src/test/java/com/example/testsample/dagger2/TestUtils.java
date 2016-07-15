package com.example.testsample.dagger2;

import org.robolectric.RuntimeEnvironment;

import static org.mockito.Mockito.spy;

/**
 * 作者：lyx on 2016/7/15 16:21
 */
public class TestUtils {
    public static final AppModule appModule = spy(new AppModule(RuntimeEnvironment.application));

    public static void setupDagger(){
        AppComponent appComponent = DaggerAppComponent.builder().appModule(appModule).build();
        ComponentHolder.setAppComponent(appComponent);
    }
}
