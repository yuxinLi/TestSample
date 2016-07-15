package com.example.testsample.dagger2;

import android.content.Context;

import com.example.testsample.mockito.PasswordValidator;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：lyx on 2016/7/15 15:30
 */
@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    public LoginPresenter providePresenter(UserManager userManager, PasswordValidator passwordValidator){
        return new LoginPresenter(userManager, passwordValidator);
    }

    @Provides
    public UserManager provideUserManager(){
        return new UserManager();
    }

    @Provides
    public PasswordValidator providePv(){
        return new PasswordValidator();
    }
}
