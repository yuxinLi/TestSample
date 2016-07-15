package com.example.testsample.dagger2;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 作者：lyx on 2016/7/15 15:30
 */
@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {

    LoginPresenter loginPresenter();
    void inject(LoginActivity loginActivity);
}
