package com.example.testsample;

import android.app.Application;

import com.example.testsample.dagger2.AppComponent;
import com.example.testsample.dagger2.AppModule;
import com.example.testsample.dagger2.ComponentHolder;
import com.example.testsample.dagger2.DaggerAppComponent;

/**
 * 作者：lyx on 2016/7/15 15:55
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        AppComponent appCom = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        ComponentHolder.setAppComponent(appCom);
    }
}
